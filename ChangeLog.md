# thesisChat

TODO 24/11
- Known bugs that I tried to fix but ended up making worse : 
    - server was sending server local time instead of timestamp
    - Parse the timestamp from the database to the Message Class
    - Fix all the methods that are using the message Constructor
    - Some of them are using String some of them are using timestamp
    
- Find out how keep who is logged in : 
    - Alter the schema of the user table by adding also the boolean flag if is he active or not
    - The messageMapping could @SendTo a channel that we are not displaying to the users
    thus we can pass the message along using the simple "return" as we do with the responses to the acfual server.
    then another messageMapping could do the trick?
    
    
---
TODO 23/11 : 

- ~~Find out how keep who is logged in~~ We have a slight idea
- ~~Implement the database methods.~~ 
- ~~Create the proper schema for the database~~
- ~~Match said schema with user and messages classes.~~ WIP
- ~~Remove unwanted code on V1__CreateTables.sql~~

