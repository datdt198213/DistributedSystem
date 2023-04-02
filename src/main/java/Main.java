import com.hust.soict.dangdat.client_server.Client;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        boolean b = true;
        Client client = new Client();
        client.startConnection("127.0.0.1", 6666);
        String response = client.receiveMessage();
        System.out.println("Server: " + response);
        Scanner scanner = new Scanner(System.in);
        while (b) {
            System.out.print("Enter your message: ");
            String message = scanner.nextLine();
            client.sendMessage(message);
            response = client.receiveMessage();
            System.out.println("Server: " + response);

            if (message.equals("")) b = false;
        }

        client.stopConnection();
    }
}
