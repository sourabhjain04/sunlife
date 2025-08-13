# ---- build stage ----
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app
COPY . .
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# ---- run stage ----
FROM eclipse-temurin:21-jre
WORKDIR /
# copy the exact jar produced by your build
COPY --from=builder /app/target/SpringMongoDBAtlas1-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
