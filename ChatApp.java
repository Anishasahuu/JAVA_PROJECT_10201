import java.util.Scanner;

// 1. User Class
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

// 2. Message Class
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

// 3. ChatRoom Class
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

// 4. Main Application Class
public class ChatApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ChatRoom room = new ChatRoom("General", 100);

        System.out.print("Enter number of users: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        User[] users = new User[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter username " + (i + 1) + ": ");
            String name = sc.nextLine();
            users[i] = new User(name);
        }

        String choice = ""; 

        do {
            System.out.print("\nSelect user (1 to " + n + "): ");
            int userIndex = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (userIndex < 1 || userIndex > n) {
                System.out.println("Invalid user!");
                continue;
            }

            System.out.print("Enter message: ");
            String msg = sc.nextLine();

            room.sendMessage(users[userIndex - 1], msg);

            System.out.print("Send another message? (yes/no): ");
            choice = sc.nextLine();

        } while (choice.equalsIgnoreCase("yes"));

        room.displayChat();

        sc.close();
    }
}