#sbt clean
sbt package

if [ $? -eq 0 ]; then
  echo "Compilation Succeeded!"
  spark-submit ./target/scala-2.13/hellospark_2.13-1.0.jar
else
  echo "Compilation Failed!"
  exit 1
fi


#if [ -f "./target/scala-2.13/hellospark_2.13-1.0.jar" ]; then
#    echo "File exists."
    #spark-submit --packages org.apache.spark:spark-avro_2.13:4.1.1 ./target/scala-2.13/hellospark_2.13-1.0.jar

#else 
#    echo "File doesn't exist."
#fi


