From java:8-jre
WORKDIR usr/src
ENV MONGO_DATABASE=reminderDb
ENV MONGO_USERNAME=root
ENV MONGO_PASSWORD=root
ENV MONGO_PORT=27017
ENV MONGO_HOST=localhost
ENV MONGO_URL=mongodb://localhost:27017/reminderDb
EXPOSE 8081
ADD ./target/ReminderService-0.0.1-SNAPSHOT.jar /usr/src/ReminderService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","ReminderService-0.0.1-SNAPSHOT.jar"]
