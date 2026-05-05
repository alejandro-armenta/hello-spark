error id: file://<WORKSPACE>/src/main/scala/HelloWorld.scala:where.
file://<WORKSPACE>/src/main/scala/HelloWorld.scala
empty definition using pc, found symbol in pc: where.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -spark/implicits/a/where.
	 -spark/implicits/a/where#
	 -spark/implicits/a/where().
	 -a/where.
	 -a/where#
	 -a/where().
	 -scala/Predef.a.where.
	 -scala/Predef.a.where#
	 -scala/Predef.a.where().
offset: 1195
uri: file://<WORKSPACE>/src/main/scala/HelloWorld.scala
text:
```scala
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataTypes,StructField}
import org.apache.spark.sql.functions.{window,col,desc,column,max,date_format}


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

        import spark.implicits._
        
        val staticDataFrame = spark.read.
        format("csv").
        option("header","true").
        option("inferSchema","true").
        load("data/retail-data/by-day/*.csv")

        staticDataFrame.createOrReplaceTempView("retail_data")
        val staticSchema = staticDataFrame.schema

        staticDataFrame.printSchema()

        val a = staticDataFrame.
        na.
        fill(0).
        withColumn(
            "day_of_week",
            date_format($"InvoiceDate","EEEE")
        ).
        coalesce(5)

        a.w@@here("InvoiceDate < '2011-07-01'").show()


        

        
        


        
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: where.