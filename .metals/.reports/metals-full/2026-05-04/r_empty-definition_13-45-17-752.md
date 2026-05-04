error id: file://<WORKSPACE>/src/main/scala/HelloWorld.scala:show.
file://<WORKSPACE>/src/main/scala/HelloWorld.scala
empty definition using pc, found symbol in pc: show.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -spark/implicits/flightDF/show.
	 -spark/implicits/flightDF/show#
	 -spark/implicits/flightDF/show().
	 -flightDF/show.
	 -flightDF/show#
	 -flightDF/show().
	 -scala/Predef.flightDF.show.
	 -scala/Predef.flightDF.show#
	 -scala/Predef.flightDF.show().
offset: 683
uri: file://<WORKSPACE>/src/main/scala/HelloWorld.scala
text:
```scala
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

        flightDF.@@show()

        import spark.implicits._

        val flights = flightDF.as[Flight]

        flights.
        filter(flight_row => flight_row.origin_country_name == "Canada").show()


    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: show.