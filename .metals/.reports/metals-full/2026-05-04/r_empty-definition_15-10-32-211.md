error id: file://<WORKSPACE>/src/main/scala/HelloWorld.scala:read.
file://<WORKSPACE>/src/main/scala/HelloWorld.scala
empty definition using pc, found symbol in pc: read.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -spark/read.
	 -scala/Predef.spark.read.
offset: 641
uri: file://<WORKSPACE>/src/main/scala/HelloWorld.scala
text:
```scala
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
        

        val a = spark.read@@.
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
```


#### Short summary: 

empty definition using pc, found symbol in pc: read.