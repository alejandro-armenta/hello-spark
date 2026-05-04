error id: file://<WORKSPACE>/src/main/scala/HelloWorld.scala:createOrReplaceTempView.
file://<WORKSPACE>/src/main/scala/HelloWorld.scala
empty definition using pc, found symbol in pc: createOrReplaceTempView.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -flightData2015/createOrReplaceTempView.
	 -flightData2015/createOrReplaceTempView#
	 -flightData2015/createOrReplaceTempView().
	 -scala/Predef.flightData2015.createOrReplaceTempView.
	 -scala/Predef.flightData2015.createOrReplaceTempView#
	 -scala/Predef.flightData2015.createOrReplaceTempView().
offset: 802
uri: file://<WORKSPACE>/src/main/scala/HelloWorld.scala
text:
```scala
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataTypes,StructField}

object HelloWorld {

    def main(args: Array[String]) : Unit =
    {
        val spark = SparkSession.builder().appName("Hello Spark").master("local[*]").getOrCreate()

        spark.sparkContext.setLogLevel("WARN")

        val flightData2015 = spark.
        read.
        option("inferSchema","true").
        option("header","true").
        csv("./data/2015-summary.csv")

        //converted to a local array list of rows.
        //a.sort("count").explain()

        spark.conf.set("spark.sql.shuffle.partitions","5")

        //necesitas el take sino no hace nada
        val results = flightData2015.sort("count").take(2)

        results.foreach(println)

        flightData2015.createOrRepl@@aceTempView("flight_data_2015")
        

    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: createOrReplaceTempView.