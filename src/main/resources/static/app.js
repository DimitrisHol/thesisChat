
// For event listener
var usernameForm = document.querySelector("#usernameForm");
var messageForm = document.querySelector("#messageForm");

// Hide - unhide
var usernameInput = document.querySelector("#username-page-container");
var chatArea = document.querySelector("#chat-page");
var connectingElement = document.querySelector('.connecting');
var flag = 0;

// Message area

var chat = document.querySelector("#messageArea");



function connect (event) {

    // Get the name from the user.
    username = document.querySelector("#name").value.trim();

    // Switch from login to chat
    usernameInput.style.display = "none";
    chatArea.style.display = "block";

    // Create the connection with websocket
    var socket = new SockJS('http://localhost:8080/gs-guide-websocket');
    stompClient = Stomp.over(socket);

    // Connect to the websocket.
    stompClient.connect({} , onConnected , onError)

    // Prevent the page from reloading, (we bypass the default form action)
    event.preventDefault();

}

// Successful connection
function onConnected (){

    // Send the username to the server, to add you to the Active Users list.
    loginContent = {username : username}
    stompClient.send("/app/login" , {} , JSON.stringify(loginContent))
    stompClient.send("/app/chatlogrequest" , {} , JSON.stringify(loginContent))


    // Subscribe to  /topic/chatLog for the past messages and "/topic/greetings" for new messages
    stompClient.subscribe('/topic/chatlogresponse', onPastLogsReceived);
    stompClient.subscribe('/topic/greetings', onMessageReceived);
}

// Something went wrong
function onError (error) {
    console.log(error);
    connectingElement.textContent = error;
    connectingElement.style.color = "red";
}

// Handling when the user sends the messages
function sendMessage (event) {

    // Get the message content
    var message = document.querySelector("#message").value.trim();

    // Bundle up the info of author , and message text
    messageContent = {authorName : username, message : message }
    document.querySelector("#message").value = ""
    stompClient.send("/app/hello" , {} , JSON.stringify(messageContent))

    console.log("We are sending" , messageContent);

// Prevent the page from reloading, (we bypass the default form action)
    event.preventDefault();
}

function onPastLogsReceived(payload){



    console.log("Hello something is here ");
    if (flag == 0){


        message = JSON.parse(payload.body);

        message.forEach(element => {

                    authorName = element.authorName;
                    message = element.message;
                    timeSent = element.timeSent;

                    time = timeSent.slice(11 , 16)

                    toAdd = authorName + " : " +  message + " at " + time;

                    // Create a list item
                    var messageElement = document.createElement("li");
                    var messageText = document.createTextNode(toAdd);

                    messageElement.appendChild(messageText);

                    chat.appendChild(messageElement);
                });
        flag = 1;
    }


}

// Handling when something is posted on the subscribed channel
function onMessageReceived(payload){

//    console.log(payload.body);
    message = JSON.parse(payload.body);

    time = message.timeSent.slice(11 , 16)
    toAdd = message.authorName + " : " +  message.message + " at " + time;

        // Create a list item
    var messageElement = document.createElement("li");
    var messageText = document.createTextNode(toAdd);

    messageElement.appendChild(messageText);

    chat.appendChild(messageElement);

}



usernameForm.addEventListener("submit" , connect , true)
messageForm.addEventListener("submit" , sendMessage , true)



/*

Timeline of javascript : 

1) get the referrence with the querySelector of the login form. 

2) add the event listened to the submition of the username.

3) when the user enters the username and submits, we trigger the connect function 

Connect function get's the name , connects to the websocket.


*/