From java:8-jre
WORKDIR usr/src
ENV MONGO_DATABASE=userDb
ENV MONGO_USERNAME=root
ENV MONGO_PASSWORD=root
ENV MONGO_PORT=27017
ENV MONGO_HOST=localhost
ENV MONGO_URL=mongodb://localhost:27017/userDb
EXPOSE 8080
ADD ./target/UserService-0.0.1-SNAPSHOT.jar /usr/src/UserService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","UserService-0.0.1-SNAPSHOT.jar"]
