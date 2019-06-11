#pull base image
FROM openjdk:8-jdk-alpine


#expose port 8080
EXPOSE 8080

#default command
CMD java -jar /data/simple-rest-apis-0.0.1-SNAPSHOT.jar

#copy simple-rest-api to docker image
ADD ./data/simple-rest-apis-0.0.1-SNAPSHOT.jar /data/simple-rest-apis-0.0.1-SNAPSHOT.jar