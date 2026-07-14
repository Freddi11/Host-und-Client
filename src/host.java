import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class host {
    public static void main(String[] args) throws IOException {
            ServerSocket serverSocket = new ServerSocket(11000);

            // Wartet hier stumpf, bis der Client sich verbindet
            Socket socket = serverSocket.accept();
            System.out.println("Client verbunden!");

            // Ein- und Ausgänge einrichten
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner tastatur = new Scanner(System.in);


            while (true) {
                //Nachricht vom Client
                String clientEingabe = in.readLine();
                System.out.println("Client sagt: " + clientEingabe);

                // 2. Eigene Nachricht über Konsole eingeben und senden
                System.out.print("Deine Antwort an Client: ");
                String antwort = tastatur.nextLine();
                out.println(antwort);
            }
    }
}
