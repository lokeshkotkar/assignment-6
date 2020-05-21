From java:8-jre
WORKDIR usr/src
ENV MONGO_DATABASE=categoryDb
ENV MONGO_USERNAME=root
ENV MONGO_PASSWORD=root
ENV MONGO_PORT=27017
ENV MONGO_HOST=localhost
ENV MONGO_URL=mongodb://localhost:27017/categoryDb
EXPOSE 8083
ADD ./target/CategoryService-0.0.1-SNAPSHOT.jar /usr/src/CategoryService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","CategoryService-0.0.1-SNAPSHOT.jar"]
