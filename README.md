# Transmission-Control-Protocol-Chat-Room ✉
This project simulates a chat room using Transmission Control Protocol

# Server Socket
- Created a server socket for the server itself, where I passed the port number (9989 in this case).

# Accept Method
- This method returns a client socket so when we accept the connection we get a socket.

# Constructor
- Here we pass a socket wich will be the client that we are going to deal with
- Initialize in and out streams

# Broadcast Function
- Broadcast if a client entered the chat rooom
- Handle if the client entered a specific command, if not broadcast the message to all other connected clients

# Shut Down 
- Function that shuts down the server or individual connection
- Also broadcast a message if a client left

# Thread Pool
- The server is running in one thread all the time the client connections are short lived so we create a thread pool
- Everytime we add a new connection we execute the handler

# Client
- Here I created 2 threads: one that receives the messages from the server and the other that will receive our console line input
- The socket is set to a local host in this case

# Input Handler
- Ask for new console line inputs

# User input
- Handle if the client left the chat

# Create a thread
- Created a thread this time, not a thread pool, because the handler is one input handler

# Quit command
- We send the quit command to the server
