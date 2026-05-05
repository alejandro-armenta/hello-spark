import org.apache.spark.sql.SparkSession

import org.apache.spark.sql.types.{StructField,StructType,StringType,LongType}
import org.apache.spark.sql.types.Metadata

import org.apache.spark.sql.functions.{window,col,desc,column,max,date_format}
import org.apache.spark.ml.feature.{StringIndexer,OneHotEncoder,VectorAssembler}
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.evaluation.ClusteringEvaluator

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

        spark.conf.set("spark.sql.shuffle.partitions","5")

        import spark.implicits._
        
        val myManualSchema = StructType(
            Array(
                StructField("DEST_COUNTRY_NAME", StringType, true),
                StructField("ORIGIN_COUNTRY_NAME", StringType, true),
                StructField(
                    "count", 
                    LongType, 
                    false, 
                    Metadata.fromJson(
                        "{\"hello\":\"world\"}"
                    ),
                )
            )
        )

        val df = spark.
        read.
        format("json").
        schema(myManualSchema).
        load("./data/flight-data/json/2015-summary.json")

        df.printSchema()


        
    }
}