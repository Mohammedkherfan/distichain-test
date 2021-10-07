FROM openjdk:8
VOLUME /tmp
COPY test-api/target/test-api-1.0-SNAPSHOT.jar distichain-service-1.0.0.jar
CMD ["java","-XX:CICompilerCount=2","-Dfile.encoding=UTF-8","-Xmx300m","-Xss512K","-jar","/distichain-service-1.0.0.jar"]