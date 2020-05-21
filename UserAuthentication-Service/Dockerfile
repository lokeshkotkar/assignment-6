From java:8-jre
WORKDIR usr/src
ENV MYSQL_DATABASE=userDb
ENV MYSQL_USER=app-root
ENV MYSQL_PASSWORD=root
ENV MYSQL_HOST=localhost
ENV MYSQL_URL=jdbc:mysql://localhost:3306/userDb
EXPOSE 8089
ADD ./target/UserAuthentication-Service-0.0.1-SNAPSHOT.jar /usr/src/UserAuthentication-Service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","UserAuthentication-Service-0.0.1-SNAPSHOT.jar"]
