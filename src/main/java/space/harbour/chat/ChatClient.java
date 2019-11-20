package space.harbour.chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

    private String name;

    public static final int PORT = 8008;

    public ChatClient(final String n,
     final String server,
      final int port) {
        try {

            Socket socket = new Socket(server, port);
            this.name = n;

            DataOutputStream out =
             new DataOutputStream(socket.getOutputStream());
            out.writeUTF(name);
            out.flush();

            new Read(socket, this).start();
            new Write(socket, this).start();

        } catch (UnknownHostException e) {
            System.out.println("Server " + server + " not found");
        } catch (IOException e) {
            System.out.println("Lost connection to server " + server);
        }
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    public static void main(String... args) {
        ChatClient client = new ChatClient(args[0], "127.0.0.1", PORT);
    }
}
