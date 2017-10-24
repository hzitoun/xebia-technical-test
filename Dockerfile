FROM openjdk:8

#update packages
RUN apt-get update

WORKDIR /xtt

#Adding source
ADD pom.xml /xtt/pom.xml
ADD src /xtt/src
ADD .mvn /xtt/.mvn
ADD mvnw /xtt/mvnw

#compile and package into a fat jar
RUN ./mvnw clean install

CMD ["java", "-jar", "target/xtt-by-hz.jar", "./data/input.txt"]
