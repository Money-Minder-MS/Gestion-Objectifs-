FROM eclipse-temurin:17
COPY target/Gestion_Objectif-0.0.1-SNAPSHOT.jar obj.jar
EXPOSE 8087
ENTRYPOINT ["java","-jar","obj.jar"]