error id: file://<WORKSPACE>/src/main/scala/HelloWorld.scala:format.
file://<WORKSPACE>/src/main/scala/HelloWorld.scala
empty definition using pc, found symbol in pc: format.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -spark/read/format.
	 -spark/read/format#
	 -spark/read/format().
	 -scala/Predef.spark.read.format.
	 -scala/Predef.spark.read.format#
	 -scala/Predef.spark.read.format().
offset: 301
uri: file://<WORKSPACE>/src/main/scala/HelloWorld.scala
text:
```scala
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataTypes,StructField}

object HelloWorld {

    def main(args: Array[String]) : Unit =
    {
        val spark = SparkSession.builder().appName("Hello Spark").master("local[*]").getOrCreate()

        val df = spark.read.for@@mat("avro").load("data/")

        df.show()

        df.printSchema

        //big data files need to be splitaable


    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: format.