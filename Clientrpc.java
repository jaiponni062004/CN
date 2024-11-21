import java.io.*;
import java.net.*;

class Clientrpc {
    public static void main(String[] args) throws Exception {
        // Display author information
        System.out.println("Program is done by: MYTHILY && 221061101185");
        
        // Create a socket to connect to the server on localhost, port 3000
        Socket sock = new Socket("127.0.0.1", 3000);

        // Reader for reading from the console
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));

        // Stream to send data to the server
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);

        // Stream to receive data from the server
        InputStream istream = sock.getInputStream();
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

        System.out.println("Client ready, type and press Enter key");

        String receiveMessage, sendMessage, temp;

        // Infinite loop to keep client running
        while (true) {
            // Get the operation type from the user
            System.out.println("\nEnter operation to perform (add, sub, mul, div): ");
            temp = keyRead.readLine();
            sendMessage = temp.toLowerCase(); // Convert operation to lowercase
            pwrite.println(sendMessage); // Send operation to the server

            // Get the first parameter from the user
            System.out.println("Enter first parameter: ");
            sendMessage = keyRead.readLine();
            pwrite.println(sendMessage); // Send first parameter to the server

            // Get the second parameter from the user
            System.out.println("Enter second parameter: ");
            sendMessage = keyRead.readLine();
            pwrite.println(sendMessage); // Send second parameter to the server

            // Flush the stream to ensure data is sent
            pwrite.flush();

            // Read the result from the server and display it
            if ((receiveMessage = receiveRead.readLine()) != null) {
                System.out.println(receiveMessage);
            }
        }
    }
}
