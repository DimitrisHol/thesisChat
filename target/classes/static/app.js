
// For event listener
var usernameForm = document.querySelector("#usernameForm");
var messageForm = document.querySelector("#messageForm");

// Hide - unhide
var usernameInput = document.querySelector("#username-page-container");
var chatArea = document.querySelector("#chat-page");
var connectingElement = document.querySelector('.connecting');

// Message area

var chat = document.querySelector("#messageArea");



function connect (event) {
    
    // Get the name from the user.
    username = document.querySelector("#name").value.trim();

    // Swicth from login to chat
    usernameInput.style.display = "none";
    connectingElement.style.display = "block";

    // Create the connection with websocket
    var socket = new SockJS('http://localhost:8080/gs-guide-websocket');
    stompClient = Stomp.over(socket);

    // Switch to the chat.
    // setTimeout(function() {
    //     connectingElement.style.display = "none";
    //     chatArea.style.display = "block";

    //     // Connect to the websocket.
    //     stompClient.connect({} , onConnected , onError)
    // } , 500)

    connectingElement.style.display = "none";
    chatArea.style.display = "block";

    // Connect to the websocket.
    stompClient.connect({} , onConnected , onError)


    

    

    // Prevent the page from reloading, (we bypass the default form action)
    event.preventDefault();

    
}

// Successful connection
function onConnected (){

    // Subscribe to "/topic/public"
    stompClient.subscribe('/topic/greetings', onMessageReceived);


    // Tell your username to the server.
    // stompClient.send

}

// Something went wrong
function onError (error) {

    console.log(error);
    

    connectingElement.textContent = error;
    connectingElement.style.color = "red";

    

}

function sendMessage (event) {

    var message = document.querySelector("#message").value.trim();

    content = {authorName : username, message : message }

    document.querySelector("#message").value = ""



    console.log("We are sending" , content);
    

    stompClient.send("/app/hello" , {} , JSON.stringify(content))




    event.preventDefault();
}

function onMessageReceived(payload){

    console.log(payload.body);
    message = JSON.parse(payload.body);

    toAdd = message.authorName + " : " +  message.message + " at " + message.timeSent;


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