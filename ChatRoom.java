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

