# dropwizard-websockets

A simple application demonstrating a dropwizard app with web socket support

## To use

* install java8, maven
* run `mvn package`
* run `java -jar target/dropwizard-websockets-0.1.0-SNAPSHOT.jar server`
* install npm
* run `npm install wscat -g`
* run `wscat -c "ws://127.0.0.1:8080/chat"` (on multiple machine to have some chat-fun)
* get chatty - `{"author":"Matt", "message":"This is amazeballs}`
