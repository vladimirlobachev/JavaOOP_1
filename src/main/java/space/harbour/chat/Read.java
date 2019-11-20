package space.harbour.chat;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class Read extends Thread {
    private BufferedReader reader;
    private Socket socket;
    private ChatClient client;

    public Read(final Socket sc, final ChatClient cl) {
        this.socket = sc;
        this.client = cl;

        try {
            InputStream in = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));
        } catch (IOException e) {
            System.out.println("Error getting inputstream");
        }
    }

    /**
     * reads messages.
     */
    public void run() {
        while (true) {
            try {
                String input = reader.readLine();
                System.out.println(client.getName() + ":" + input);
            } catch (IOException e) {
                System.out.println("Error getting inputstream");
                break;
            }
        }
    }

}
