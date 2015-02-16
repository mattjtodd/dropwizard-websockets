# dropwizard-websockets

A simple application demonstrating a dropwizard app with web socket support provided by Atmosphere

## To use

* install java8, maven
* run `mvn package`
* run `java -jar target/dropwizard-websockets-0.1.0-SNAPSHOT.jar server`
* install npm
* run `npm install wscat -g`
* run `wscat -c "ws://127.0.0.1:8080/chat"` (on multiple machines / terminals to have some multi-person-chat-fun)
* get chatty - `{"author":"Cyril", "message":"Hello world!"}`
