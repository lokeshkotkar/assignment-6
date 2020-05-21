From java:8-jre
WORKDIR usr/src
ENV MONGO_DATABASE=noteDb
ENV MONGO_USERNAME=root
ENV MONGO_PASSWORD=root
ENV MONGO_PORT=27017
ENV MONGO_HOST=localhost
ENV MONGO_URL=mongodb://localhost:27017/noteDb
EXPOSE 8082
ADD ./target/NoteService-0.0.1-SNAPSHOT.jar /usr/src/NoteService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","NoteService-0.0.1-SNAPSHOT.jar"]
