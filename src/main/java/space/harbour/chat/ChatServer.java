package space.harbour.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ChatServer {
    private Set<ChatHandler> chats = ConcurrentHashMap.newKeySet();
    private static final int PORT = 8008;

    public ChatServer(final int port) {
        try (ServerSocket s = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            while (true) {
                ChatHandler chat = new ChatHandler(this, s.accept());
                chats.add(chat);
                chat.start();
            }
        } catch (IOException e) {
            System.out.println("Server failed on port " + port);
        }
    }

    /**
     * @param message
     * broadcasts messages for every user.
     */
    public synchronized void broadcast(final String message) {
        System.out.println("New message -> " + message);
        for (ChatHandler chat: chats) {
            chat.sendMessage(message);
        }
    }

    /**
     * @param chat
     * to remove chat if the user is disconnected
     */
    public void chatDisconnected(final ChatHandler chat) {
        chats.remove(chat);
        broadcast("Chat member " + chat.getName() + " left");
    }

    public static void main(String[] args) {
        new ChatServer(PORT);
    }
}
