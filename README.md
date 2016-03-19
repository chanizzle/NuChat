# NuChat
A simple chatting system that will allow 2 users to chat with each other on the same host.

### Compile & Run
In order to test this out manually, have 2 terminals and do the following in each terminal:

Go to src and Run this script: ./compileNuChat.sh to compile and run the program

### GUI
GUI is all in JSwing just because for the limited time it was the easiest to mock out a simple GUI for a user to interact with.

The first input which is defaulted to 8877 is the port where the current Thread is listening for any new activities on. The second input indicates which host the Thread will connect on, and the third input indicates the port where the message is sent to. The last input on the top is where the user indicates their usedName, and user will then hit the login button to start the Thread listening to the particular host and port.

The big uneditable text area is where the chat will be, and the input field at the bottom is the message the user wants to send. 

### Implementation
All of the implementation is within the src/nuchat directory.

In the networking directory it holds all the implementation for setting up the Send and receive messages. In both cases, the send and receive will both extend the Thread class, and will both use sockets to get the communication.

MessageListener is going be implementing the receive message functionality. If you go to src/MainMessageScreen.java, you can see when MessageListener is going to be initialized. Once the user hits the login button, I set up the MessageListener so that it connects to the receive port text field, and fill in the loginUser. “this” represents the WriteableGUI interface. MainMessageScreen implements write function from that interface, and it is being called within the MessageListener. This basically writes the message that the socket/inputstream receives from the host and port that it is listening to.

MessageTransmitter implements the send message functionality. Note that this gets initialized after the send button gets clicked, and before going through the transmitter logic, I append the current message that the user wants to send in the chat text area, and after the text gets transmitter to the targetPort, I clear the messageTextField. Then, the transmitter.start initializes the run method where it has the socket that connects to the target host and port, and sends the message to that socket.

### Improvements
There were some things that weren’t included in this phase that was talked about during the design. I focused more on the sending/receiving aspect of the chat system due to the time constraints. However, for the next phase I would include a way where you have a list of users that are signed into the chat, and you would be able to select which user you want to chat with. Also, I should have a validation of having no duplicate userNames in the same chat. I would probably use a HashSet to hold all the unique users in it and when a new user logins, I would check if it exists in the set or not. 

Also, we can include the time the message is sent within the MessageTransmitter and the MessageListener, and have that displayed within the chat area.

For now, this project shows how Thread/Sockets work within the chat system.




# NuChat
