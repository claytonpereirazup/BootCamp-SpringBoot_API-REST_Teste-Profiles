FROM openjdk:11
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Xmx512m","-Dserver.port=${PORT}","-jar","/app.jar"]

### COMANDO PARA GERAR A IMAGEM DOCKER ###
#docker build -t alura/forum

### COMANDO PARA SUBIR O CONTAINERS  DOCKER ###
#docker run –p 8080:8080 -e SPRING_PROFILES_ACTIVE=’prod’
#–e FORUM_DATABASE_URL=’jdbc:h2:mem:alura-forum 
#-e FORUM_DATA_BASE_USERNAME='sa'
#-e FORUM_DATA_BASE_PASSWORD=''
#-e FORUM_JWT_SECRET='123456'