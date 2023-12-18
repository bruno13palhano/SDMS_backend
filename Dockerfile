FROM eclipse-temurin:17-jdk-alpine
COPY --from=builder /target/shopdani_stock_management-0.0.1-SNAPSHOT.jar shopdani_stock_management.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080