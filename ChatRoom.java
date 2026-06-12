import java.util.Scanner;

class User {
    private String username;
    private boolean isOnline;

    User(String username) {
        this.username = username;
        this.isOnline = true;
    }

    String getUsername() {
        return username;
    }

    boolean isOnline() {
        return isOnline;
    }
}

public class ChatRoom {
    public static void main (String [] args){
        
    }
}
class Message {
    private User sender;
    private String content;
    private String timestamp;

    Message(User sender, String content, String timestamp) {
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }

    void display() {
        System.out.println("[" + timestamp + "] " + sender.getUsername() + ": " + content);
    }
}
class ChatRoom {
    private String roomName;
    private Message[] messages;
    private int messageCount;

    ChatRoom(String roomName, int size) {
        this.roomName = roomName;
        messages = new Message[size];
        messageCount = 0;
    }

    void sendMessage(User user, String text) {
        if (messageCount < messages.length) {
            String time = java.time.LocalTime.now().withNano(0).toString();
            messages[messageCount] = new Message(user, text, time);
            messageCount++;
        } else {
            System.out.println("Chat room is full!");
        }
    }

    void displayChat() {
        System.out.println("\n----- Chat History (" + roomName + ") -----");
        for (int i = 0; i < messageCount; i++) {
            messages[i].display();
        }
    }
}

