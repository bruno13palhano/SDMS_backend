FROM eclipse-temurin:17-jdk-alpine
COPY --from=builder /usr/src/java-code/build/libs/*.jar ./app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080