import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class host {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(11000);
        Scanner tastatur = new Scanner(System.in);
        char[] feld1;
        String vomClient;
        int[][] feld = new int[3][3];

        // Wartet hier stumpf, bis der Client sich verbindet
        Socket socket = serverSocket.accept();
        System.out.println("Client verbunden!");

        // Ein- und Ausgänge einrichten
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        while (true) {
            //Nachricht vom Client
            vomClient = in.readLine();
            System.out.println("Client sagt: " + vomClient);
            feld1 = vomClient.toCharArray();


            int index = 0; // Dieser Zähler wandert von 0 bis 8 durch feld1
            for (int j = 0; j < 3; j++) {         // Schleife für die Zeilen
                for (int k = 0; k < 3; k++) {     // Schleife für die Spalten
                    feld[j][k] = feld1[index];    // Wert übertragen
                    index++;                      // Zum nächsten Element im 1D-Array springen
                }
            }
            int index1 = 0; // Dieser Zähler wandert von 0 bis 8 durch feld1
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    feld[i][j] = Character.getNumericValue(feld1[index1]);
                    index1++;
                }
            }
            System.out.println("Dein Spielfeld: " + Arrays.deepToString(feld));


            //Eigene Nachricht über Konsole eingeben und senden
            System.out.print("Deine Antwort an Client: ");
            String antwort = tastatur.nextLine();
            out.println(antwort);


        }
    }
}
