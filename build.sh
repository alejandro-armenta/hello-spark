sbt clean
sbt package

if [ -f "./target/scala-2.13/hellospark_2.13-1.0.jar" ]; then
    echo "File exists."
    spark-submit ./target/scala-2.13/hellospark_2.13-1.0.jar
else 
    echo "File doesn't exist."
fi


