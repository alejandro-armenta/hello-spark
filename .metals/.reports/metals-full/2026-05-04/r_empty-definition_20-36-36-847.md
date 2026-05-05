error id: file://<WORKSPACE>/src/main/scala/HelloWorld.scala:StructType.
file://<WORKSPACE>/src/main/scala/HelloWorld.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -org/apache/spark/sql/types/StructType.
	 -org/apache/spark/sql/types/StructType#
	 -org/apache/spark/sql/types/StructType().
	 -spark/implicits/StructType.
	 -spark/implicits/StructType#
	 -spark/implicits/StructType().
	 -StructType.
	 -StructType#
	 -StructType().
	 -scala/Predef.StructType.
	 -scala/Predef.StructType#
	 -scala/Predef.StructType().
offset: 1129
uri: file://<WORKSPACE>/src/main/scala/HelloWorld.scala
text:
```scala
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




        println(
            
        spark.
        read.
        format("json").
        load("./data/flight-data/json/2015-summary.json").schema
        
        )
        
        Struc@@tType(
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

        
        
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: 