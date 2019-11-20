package space.harbour.chat;

import java.io.Console;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.OutputStream;
import java.io.IOException;

public class Write extends Thread {
    private PrintWriter writer;
    private Socket socket;
    private ChatClient client;

    public Write(final Socket sc, final ChatClient cl) {
        this.socket = sc;
        this.client = cl;

        try {
            OutputStream out = socket.getOutputStream();
            writer = new PrintWriter(out, true);
        } catch (IOException e) {
            System.out.println("Error getting outputstream");
        }
    }

    /**
     * writes messages.
     */
    public void run() {
        Console console = System.console();

        String output;

        do {
            output = console.readLine();
            writer.println(output);
        } while (!output.equals("bye"));

        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Error writing to server");
        }
    }

}
