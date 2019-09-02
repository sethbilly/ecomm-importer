FROM openjdk:8-jdk-alpine

VOLUME /tmp

# Make port 8080 available outside this container
EXPOSE 8080

# Add the application's jar file
ARG JAR_FILE=target/ectools-importer-1.0.jar

ADD ${JAR_FILE} ectools-importer.jar

# Run the jar file
ENTRYPOINT ["java", "-Djava.security.edg=file:/dev/./urandom", "-jar", "/ectools-importer.jar"]