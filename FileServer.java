import java.io.*;
import java.net.*;

public class FileServer {
    public static void main(String[] args) {
        int port = 5000;  // Port number for the server

        try (ServerSocket serverSocket = new ServerSocket(port)) {
	    System.out.println("This program is done by MYTHILY && 221061101185");
            System.out.println("Server is waiting for a connection...");

            // Wait for the client to connect
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Input stream to receive the file
            InputStream inputStream = socket.getInputStream();

            // Specify the location to save the received file
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Rehana\\Documents\\Computer Network\\rec.txt");

            // Buffer to store incoming data
            byte[] buffer = new byte[4096];
            int bytesRead;

            // Read the incoming data and write it to the file
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File received successfully!");

            // Close streams and socket
            fileOutputStream.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
