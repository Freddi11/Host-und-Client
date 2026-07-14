import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException {

        // Verbindet sich sofort mit dem localhost
            Socket socket = new Socket("192.168.180.158", 11000);
            System.out.println("verbunden");

            // Ein- und Ausgänge einrichten
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner tastatur = new Scanner(System.in);

            while (true) {
                // Nachricht eingeben und an Host senden
                System.out.print("Deine Nachricht:");
                String nachricht = tastatur.nextLine();
                out.println(nachricht);

                // 2. Auf Antwort vom Host warten (Programm pausiert hier)
                String vomHost = in.readLine();
                System.out.println("Host sagt: " + vomHost);
            }
    }
}