error id: file://<WORKSPACE>/src/main/scala/HelloWorld.scala:window.
file://<WORKSPACE>/src/main/scala/HelloWorld.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -org/apache/spark/sql/functions/window.
	 -org/apache/spark/sql/functions/window#
	 -org/apache/spark/sql/functions/window().
	 -window.
	 -window#
	 -window().
	 -scala/Predef.window.
	 -scala/Predef.window#
	 -scala/Predef.window().
offset: 226
uri: file://<WORKSPACE>/src/main/scala/HelloWorld.scala
text:
```scala
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataTypes,StructField}

import org.apache.spark.sql.functions.max
import org.apache.spark.sql.functions.desc
import org.apache.spark.sql.functions.{wi@@ndow,col,desc,column}

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

        val a = spark.read.
        format("csv").
        option("header","true").
        option("inferSchema","true").
        load("data/retail-data/by-day/*.csv")

        a.createOrReplaceTempView("retail_data")

        a.selectExpr(
            "CustomerId",
            "(UnitPrice * Quantity) as total_cost",
            "InvoiceDate"
        ).
        groupBy(
            col("CustomerId"), 
            window(col("InvoiceDate"), "1 day")
        ).
        sum("total_cost").
        show()

        //println(a.count())
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: 