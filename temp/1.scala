import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataTypes,StructField}

object HelloWorld {

    def main(args: Array[String]) : Unit =
    {
        val spark = SparkSession.builder().appName("Hello Spark").master("local[*]").getOrCreate()

        println("Using apache spark " + spark.version)

        val schema = DataTypes.createStructType(
            Array[StructField](
                DataTypes.createStructField("id", DataTypes.IntegerType, false),
                DataTypes.createStructField("authorId", DataTypes.IntegerType, true),
                DataTypes.createStructField("bookTitle", DataTypes.StringType, false),
                DataTypes.createStructField("releaseDate", DataTypes.DateType, true),
                DataTypes.createStructField("url", DataTypes.StringType, false),
            )
        )

        val df = spark.
        read.
        format("csv").
        option("header","true").
        option("multiline", true).
        option("sep",";").
        option("dateFormat","MM/dd/yyyy").
        option("quote","*").
        schema(schema).
        load("data/books.csv")

        df.show(30,25,false)
        df.printSchema()


    }
}