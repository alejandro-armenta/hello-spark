import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataTypes,StructField}

object HelloWorld {

    def main(args: Array[String]) : Unit =
    {
        val spark = SparkSession.builder().appName("Hello Spark").master("local[*]").getOrCreate()

        spark.sparkContext.setLogLevel("WARN")

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