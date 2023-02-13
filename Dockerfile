FROM amazoncorretto:17-alpine-jdk 
MAINTAINER MJOS
COPY  target/mjos-0.0.1-SNAPSHOT.jar mjos-app.jar   
ENTRYPOINT ["java","-jar","/mjos-app.jar"]
