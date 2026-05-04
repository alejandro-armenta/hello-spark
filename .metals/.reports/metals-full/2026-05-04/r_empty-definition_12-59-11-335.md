error id: file://<WORKSPACE>/src/main/scala/HelloWorld.scala:count.
file://<WORKSPACE>/src/main/scala/HelloWorld.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -scala/Predef.
	 -scala/Predef#
	 -scala/Predef().
offset: 1580
uri: file://<WORKSPACE>/src/main/scala/HelloWorld.scala
text:
```scala
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataTypes,StructField}

import org.apache.spark.sql.functions.max
import org.apache.spark.sql.functions.desc

object HelloWorld {

    def main(args: Array[String]) : Unit =
    {
        val spark = SparkSession.
        builder().
        appName("Hello Spark").
        master("local[*]").
        getOrCreate()

        spark.sparkContext.setLogLevel("WARN")

        val flightData2015 = spark.
        read.
        option("inferSchema","true").
        option("header","true").
        csv("./data/2015-summary.csv")

        //converted to a local array list of rows.
        //a.sort("count").explain()

        //spark.conf.set("spark.sql.shuffle.partitions","5")

        //necesitas el take sino no hace nada
        //val results = flightData2015.sort("count").take(2)


        
        /*  
        val results = spark.sql("""
        select dest_country_name, count(1) as ale
        from flight_data_2015
        group by dest_country_name
        order by ale desc
        """).take(10)


        val dataFrameWay = flightData2015.
        groupBy("DEST_COUNTRY_NAME").
        count().
        take(10)
        

        dataFrameWay.foreach(println)


        flightData2015.createOrReplaceTempView("flight_data_2015")

        val a = spark.sql("select max(count) from flight_data_2015").take(1)

        a.foreach(println)

        val b = flightData2015.select(max("count")).take(1)

        b.foreach(println)

        */

        flightData2015.groupBy("dest_country_name").count@@().show()


    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: 