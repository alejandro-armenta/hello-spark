error id: file://<WORKSPACE>/src/main/scala/HelloWorld.scala:OneHotEncoder#
file://<WORKSPACE>/src/main/scala/HelloWorld.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -org/apache/spark/ml/feature/OneHotEncoder#
	 -spark/implicits/OneHotEncoder#
	 -OneHotEncoder#
	 -scala/Predef.OneHotEncoder#
offset: 1594
uri: file://<WORKSPACE>/src/main/scala/HelloWorld.scala
text:
```scala
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataTypes,StructField}
import org.apache.spark.sql.functions.{window,col,desc,column,max,date_format}
import org.apache.spark.ml.feature.{StringIndexer,OneHotEncoder}

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
        
        val staticDataFrame = spark.read.
        format("csv").
        option("header","true").
        option("inferSchema","true").
        load("data/retail-data/by-day/*.csv")

        staticDataFrame.createOrReplaceTempView("retail_data")
        val staticSchema = staticDataFrame.schema

        staticDataFrame.printSchema()

        val a = staticDataFrame.
        na.
        fill(0).
        withColumn(
            "day_of_week",
            date_format($"InvoiceDate","EEEE")
        ).
        coalesce(5)

        val trainDataFrame = a.where("InvoiceDate < '2011-07-01'")
        
        val testDataFrame = a.where("InvoiceDate >= '2011-07-01'")

        println(trainDataFrame.count(),testDataFrame.count())

        val indexer = new StringIndexer().
        setInputCol("day_of_week").
        setOutputCol("day_of_week_index")

        new OneHo@@tEncoder().
        setInputCol("day_of_week_index").
        setOutputCol("day_of_week_encoded")




        

        
        


        
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: 