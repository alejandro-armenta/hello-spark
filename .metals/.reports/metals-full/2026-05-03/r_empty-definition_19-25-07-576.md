error id: file://<WORKSPACE>/src/main/scala/HelloWorld.scala:sparkContext.
file://<WORKSPACE>/src/main/scala/HelloWorld.scala
empty definition using pc, found symbol in pc: sparkContext.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -spark/sparkContext.
	 -scala/Predef.spark.sparkContext.
offset: 285
uri: file://<WORKSPACE>/src/main/scala/HelloWorld.scala
text:
```scala
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataTypes,StructField}

object HelloWorld {

    def main(args: Array[String]) : Unit =
    {
        val spark = SparkSession.builder().appName("Hello Spark").master("local[*]").getOrCreate()

        spark.s@@parkContext.setLogLevel("WARN")

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
```


#### Short summary: 

empty definition using pc, found symbol in pc: sparkContext.