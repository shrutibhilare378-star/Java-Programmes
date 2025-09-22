import java.util.LinkedList;
import java.util.Queue;

class ChatRoom {
private final Queue<String> messages = new LinkedList<>();
private boolean hasNewMessage = false;

// Send message to chat room
public synchronized void sendMessage(String message) {
messages.add(message);
hasNewMessage = true;
notify(); // Notify waiting thread
}

// Receive message from chat room
public synchronized String receiveMessage() {

while (!hasNewMessage) {
try {
wait(); // Wait until a new message is sent
} catch (InterruptedException e) {
System.out.println("Receive interrupted");
}
}
hasNewMessage = false;
return messages.poll();
}
}

class User extends Thread {
private final ChatRoom chatRoom;
private final String userName;
private boolean running = true;
private boolean suspended = false;

public User(String name, ChatRoom room) {
this.userName = name;
this.chatRoom = room;
}

// Simulate suspension
public synchronized void suspendUser() {
suspended = true;
}

// Simulate resumption
public synchronized void resumeUser() {
suspended = false;
notify();
}

// Simulate stopping
public void stopUser() {
running = false;
this.interrupt();
}

@Override
public void run() {
int count = 1;
while (running) {
synchronized (this) {
while (suspended) {
try {
wait();
} catch (InterruptedException e) {
System.out.println(userName + " interrupted while suspended.");
}
}
}

String message = userName + " says hello " + count++;
chatRoom.sendMessage(message);

System.out.println(userName + " sent: " + message);

String received = chatRoom.receiveMessage();
if (received != null) {
System.out.println(userName + " received: " + received);
}

try {
sleep(1000); // simulate delay
} catch (InterruptedException e) {
System.out.println(userName + " interrupted during sleep.");
}
}
System.out.println(userName + " has stopped.");
}
}

public class MultiThreadedChat {
public static void main(String[] args) {
ChatRoom room = new ChatRoom();

User user1 = new User("Alice", room);
User user2 = new User("Bob", room);

// Set priorities
user1.setPriority(Thread.MAX_PRIORITY); // High priority for Alice
user2.setPriority(Thread.NORM_PRIORITY);

// Start users
user1.start();
user2.start();

// Synchronize using join and monitor threads
try {
Thread.sleep(3000);

// Suspend Bob
System.out.println("\nSuspending Bob...\n");
user2.suspendUser();

Thread.sleep(3000);

// Resume Bob
System.out.println("\nResuming Bob...\n");
user2.resumeUser();

Thread.sleep(3000);

// Stop both users
System.out.println("\nStopping both users...\n");
user1.stopUser();
user2.stopUser();

// Wait for threads to finish
user1.join();
user2.join();

} catch (InterruptedException e) {
System.out.println("Main thread interrupted.");
}

// Check thread status
System.out.println("\nThread status:");
System.out.println("Alice alive? " + user1.isAlive());
System.out.println("Bob alive? " + user2.isAlive());
}
}