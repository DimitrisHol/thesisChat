# Thesis Chat

### General TODO :

- **Convert this into a microservice architecture.**
    - One service could be the database
    - One service could be the authentication/login server.
    - One service could be the Spring Application
    
    Port them to laptop so I can show it to prof
    
    
- Make the application more feature-rich.
    - **MEDIUM**Implement checking who is online.
    - **EASY** Load more messages (Click to get older messages.)
    - **HARD** Implement peer-to-peer chat - could be just another topic, although primary
    key with a boolean value to determine if it is a private chat, normal topics would
    have this boolean false, can foreign key be a primary key?
    - **HARD** Implement topics - user has to add the channel(topic) name 
    together with his username to log into the chat. 
    Only the previous chat from given topic is returned. Message schema in db has 
    also add the topic column. New table topic : topic name , topic id, inner join that shit. 
    - **EASY** Last time a user has logged on. - This can be a db column
    
    
- **MAYBE** Rabbit MQ : 
        - Check when the user received the message
         




TODO 25/11 : 

- Keep track of the users that are active in the chat.
- Add the active user list to the chat
    - Change the db user schema cause are most likely to store the state there.
    - Put / Update probably will work just fine, refresh when new user joins. 
- Make the site look acceptable.
- ~~Delete all the obsolete classes.~~ **FIXED**


- Bug : When user sends a message with more than 50 characters, it's not a good time.
- ~~Bug : When user joins, message of "User joined" is displayed before the past messages.~~ **FIXED**
- ~~improvement : Format should be : "user.username : message.content - time.sent" (replace "at" with dash.)~~ **FIXED**


TODO 23/11
**FIXED**
- ~~Known bugs that I tried to fix but ended up making worse :~~  
    - ~~server was sending server local time instead of timestamp~~
    - ~~Parse the timestamp from the database to the Message Class~~
    - ~~Fix all the methods that are using the message Constructor~~
    - ~~Some of them are using String some of them are using timestamp~~
    
- Find out how keep who is logged in : **Use POST / PUT** 
    - ~~Alter the schema of the user table by adding also the boolean flag if is he active or not~~
    - ~~The messageMapping could @SendTo a channel that we are not displaying to the users
    thus we can pass the message along using the simple "return" as we do with the responses to the acfual server.
    then another messageMapping could do the trick?~~
    
    
---
TODO 22/11 : 
**FIXED**
- ~~Find out how keep who is logged in~~ We have a slight idea
- ~~Implement the database methods.~~ 
- ~~Create the proper schema for the database~~
- ~~Match said schema with user and messages classes.~~ WIP
- ~~Remove unwanted code on V1__CreateTables.sql~~

