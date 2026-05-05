import org.apache.spark.sql.SparkSession

import org.apache.spark.sql.types.{StructField,StructType,StringType,LongType,Metadata}

import org.apache.spark.sql.Row

import org.apache.spark.sql.functions.{
    window,col,desc,column,max,date_format,expr,lit
    }


import org.apache.spark.ml.feature.{StringIndexer,OneHotEncoder,VectorAssembler}

import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.evaluation.ClusteringEvaluator

object HelloWorld {

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


        df.selectExpr(
            "*", 
            "(dest_country_name = origin_country_name) as withinCountry"
        ).
        show(false)


        //df.selectExpr("dest_country_name as destination", "dest_country_name").show


        df.selectExpr("avg(count)","count(distinct(dest_country_name))").show(false)

        df.select(expr("*"),lit(1).as("ale")).show(false)

        df.withColumn("ale", lit(1)).show(false)


        df.withColumn("withinCountry", expr("dest_country_name == origin_country_name")).show(false)

        val a = df.columns
        a.foreach(println)

        df.withColumnRenamed("DEST_COUNTRY_NAME","ale").show





        
    }
}