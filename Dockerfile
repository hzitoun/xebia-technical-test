FROM java:8 

#update packages and install maven
RUN apt-get update
RUN apt-get install -y maven

WORKDIR /xtt

# Prepare by downloading dependencies
ADD pom.xml /xtt/pom.xml
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
ADD src /xtt/src
RUN ["mvn", "clean install"]

CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "target/xtt-by-hz.jar"]
