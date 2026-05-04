error id: file://<WORKSPACE>/src/main/scala/HelloWorld.scala:appName.
file://<WORKSPACE>/src/main/scala/HelloWorld.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -scala/Predef.
	 -scala/Predef#
	 -scala/Predef().
offset: 449
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
        appName@@("Hello Spark").
        master("local[*]").
        getOrCreate()

        spark.sparkContext.setLogLevel("WARN")

        spark.read.parquet("data/2010-summary.parquet")

        


    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: 