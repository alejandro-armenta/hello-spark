import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataTypes,StructField}

object HelloWorld {

    def main(args: Array[String]) : Unit =
    {
        val spark = SparkSession.builder().appName("Hello Spark").master("local[*]").getOrCreate()

        spark.sparkContext.setLogLevel("WARN")

        val myRange = spark.range(1000).toDF("number")

        myRange.show()


        val a = myRange.where("number % 2 = 0")

        a.show()

        //shuffle count 

        //and collect to scala object
        
        println(a.count())

        //pipelining 

        //shuffles no se puede tiene que haber escrituras a disk

        //big data files need to be splitaable


    }
}

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataTypes,StructField}

import org.apache.spark.sql.functions.max
import org.apache.spark.sql.functions.desc

object HelloWorld {

    case class Flight(
        dest_country_name: String,
        origin_country_name: String,
        count: BigInt
    )

    def main(args: Array[String]) : Unit =
    {
        val spark = SparkSession.
        builder().
        appName("Hello Spark").
        master("local[*]").
        getOrCreate()

        spark.sparkContext.setLogLevel("WARN")

        val flightDF = spark.read.
        parquet("data/flight-data/parquet/2010-summary.parquet/")

        import spark.implicits._

        val flights = flightDF.as[Flight]

        flights.
        filter(flight_row => flight_row.origin_country_name == "Canada").
        map(flight_row => flight_row).
        show()

        val a = flights.take(5).
        map(
            fr => Flight(fr.dest_country_name, fr.origin_country_name, fr.count + 5)
        )

        a.foreach(println)



    }
}



import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataTypes,StructField}
import org.apache.spark.sql.functions.{window,col,desc,column,max}


object HelloWorld {

    case class Flight(
        dest_country_name: String,
        origin_country_name: String,
        count: BigInt
    )

    def main(args: Array[String]) : Unit =
    {
        val spark = SparkSession.
        builder().
        appName("Hello Spark").
        master("local[*]").
        getOrCreate()

        spark.sparkContext.setLogLevel("WARN")

        spark.conf.set("spark.sql.shuffle.partitions","5")
        

        val a = spark.read.
        format("csv").
        option("header","true").
        option("inferSchema","true").
        load("data/retail-data/by-day/*.csv")

        a.createOrReplaceTempView("retail_data")

        a.
        
        selectExpr(
            "CustomerId",
            "(UnitPrice * Quantity) as total_cost",
            "InvoiceDate"
        ).

        groupBy(
            col("CustomerId"), 
            window(col("InvoiceDate"), "1 day")
        ).

        sum("total_cost").

        sort(
            col("CustomerId").desc, 
            col("window.start").asc
        ).
        
        show()

        
        //println(a.count())
    }
}


import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataTypes,StructField}
import org.apache.spark.sql.functions.{window,col,desc,column,max}


object HelloWorld {

    case class Flight(
        dest_country_name: String,
        origin_country_name: String,
        count: BigInt
    )

    def main(args: Array[String]) : Unit =
    {
        val spark = SparkSession.
        builder().
        appName("Hello Spark").
        master("local[*]").
        getOrCreate()

        spark.sparkContext.setLogLevel("WARN")

        spark.conf.set("spark.sql.shuffle.partitions","5")
        
        val staticDataFrame = spark.read.
        format("csv").
        option("header","true").
        option("inferSchema","true").
        load("data/retail-data/by-day/*.csv")

        staticDataFrame.createOrReplaceTempView("retail_data")
        val staticSchema = staticDataFrame.schema

        val streamingDataFrame = spark.readStream.
        schema(staticSchema).
        option("maxFilesPerTrigger",1).
        format("csv").
        option("header","true").
        load("data/retail-data/by-day/*.csv")

        println(streamingDataFrame.isStreaming)

        val purchaseByCustomerPerHour = streamingDataFrame.

        selectExpr(
            "CustomerId",
            "(UnitPrice * Quantity) as total_cost",
            "InvoiceDate"
        ).

        groupBy(
            col("CustomerId"), 
            window(col("InvoiceDate"), "1 day")
        ).

        sum("total_cost").

        sort(
            col("sum(total_cost)").desc
        )

        val query = purchaseByCustomerPerHour.
        writeStream.
        format("console").
        queryName("customer_purchases").
        outputMode("complete").
        start()

        query.awaitTermination()


        /* 
        Thread.sleep(5000) 

        spark.sql("""
        select * 
        from customer_purchases
        order by 'sum(total_cost)' desc
        """).
        show()
         */
        


        //println(a.count())
    }
}