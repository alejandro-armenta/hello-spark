import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataTypes,StructField}

object HelloWorld {

    def main(args: Array[String]) : Unit =
    {
        val spark = SparkSession.builder().appName("Hello Spark").master("local[*]").getOrCreate()

        val df = spark.
        read.
        format("com.databricks.spark.xml").
        option("rowTag","row").
        load("data/nasa-patents.xml")

        df.show()

        df.printSchema



    }
}