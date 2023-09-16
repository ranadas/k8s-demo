#FROM 3.8.7-eclipse-temurin-19 as build
#WORKDIR /app
#COPY pom.xml .
#COPY src/ src/
#RUN mvn -f pom.xml clean package

FROM eclipse-temurin:19 as runner
#WORKDIR /app
#COPY --from=build /app/target/*.jar student-kubernetes-demo.jar
ADD ./target/student-kubernetes-demo.jar student-kubernetes-demo.jar
ENTRYPOINT ["java","-jar","/student-kubernetes-demo.jar"]