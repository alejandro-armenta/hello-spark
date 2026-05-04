error id: file://<WORKSPACE>/src/main/scala/HelloWorld.scala:sort.
file://<WORKSPACE>/src/main/scala/HelloWorld.scala
empty definition using pc, found symbol in pc: sort.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -a/sort.
	 -a/sort#
	 -a/sort().
	 -scala/Predef.a.sort.
	 -scala/Predef.a.sort#
	 -scala/Predef.a.sort().
offset: 687
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

        val a = spark.
        read.
        option("inferSchema","true").
        option("header","true").
        csv("./data/2015-summary.csv")

        //converted to a local array list of rows.
        //a.sort("count").explain()

        spark.conf.set("spark.sql.shuffle.partitions","5")

        //necesitas el take sino no hace nada
        val results = a.sor@@t("count").take(2)

        results.foreach(println)


    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: sort.