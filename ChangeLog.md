# thesisChat



TODO 25/11 : 

- Keep track of the users that are active in the chat.
- Add the active user list to the chat
    - Change the db user schema cause are most likely to store the state there.
    - Put / Update probably will work just fine, refresh when new user joins. 
- Make the site look acceptable. 
- Delete all the obsolete classes.

TODO 23/11
~~- Known bugs that I tried to fix but ended up making worse : 
    - server was sending server local time instead of timestamp
    - Parse the timestamp from the database to the Message Class
    - Fix all the methods that are using the message Constructor
    - Some of them are using String some of them are using timestamp~~
    
~~- Find out how keep who is logged in : 
    - Alter the schema of the user table by adding also the boolean flag if is he active or not
    - The messageMapping could @SendTo a channel that we are not displaying to the users
    thus we can pass the message along using the simple "return" as we do with the responses to the acfual server.
    then another messageMapping could do the trick?~~
    
    
---
TODO 22/11 : 

- ~~Find out how keep who is logged in~~ We have a slight idea
- ~~Implement the database methods.~~ 
- ~~Create the proper schema for the database~~
- ~~Match said schema with user and messages classes.~~ WIP
- ~~Remove unwanted code on V1__CreateTables.sql~~

