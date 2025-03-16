To compile project (JDK 21):
$ git clone https://github.com/Mbsqd/analyzer
$ cd analyzer
$ mvn clean package
Execute program:
java -jar ./target/analyzer-1.0-SNAPSHOT.jar <min> <max> <start> <end> <step> <sampling>
