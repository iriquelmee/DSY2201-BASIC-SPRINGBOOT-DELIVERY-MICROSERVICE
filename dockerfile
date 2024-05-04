# imagen de java sdk21 con oracle
FROM openjdk:21-ea-24-oracle

# asignando espacio de trabajo app para contenedor
WORKDIR /app

# copiando jar
COPY target/delivery-0.0.1-SNAPSHOT.jar app.jar

#copiando wallet coneccion oracle
COPY Wallet_DSY2201 /app/Wallet_DSY2201

# exponiendo puerto 8080 apra el contenedor
EXPOSE 8080

# comandos para ejecucion app
CMD ["java", "-jar", "app.jar"]