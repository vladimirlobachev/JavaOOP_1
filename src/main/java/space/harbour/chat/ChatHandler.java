package space.harbour.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatHandler extends Thread {
    private final ChatServer server;
    private final Socket socket;
    private final DataInputStream in;
    private final DataOutputStream out;

    private final String name;

    public ChatHandler(final ChatServer sv, final Socket sc)
     throws IOException {
        this.server = sv;
        this.socket = sc;

        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        name = in.readUTF();
        server.broadcast("New chat member "
         + name + " from " + socket.getInetAddress());
    }

    /**
     *
     */
    public void run() {
        try (socket; in; out) {
            while (true) {
                if (in.available() > 0) {
                    server.broadcast(name + ": " + in.readUTF());
                }
            }
        } catch (IOException e) {
            System.out.println("Connection to user is lost");
            server.chatDisconnected(this);
        }
    }

    /**
     * @param message
     * sends the message out
     */
    public void sendMessage(final String message) {
        try {
            out.writeUTF(message);
            out.flush();
        } catch (IOException e) {
            System.out.println("Connection to user is lost");
            server.chatDisconnected(this);
        }
    }
}
