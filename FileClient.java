import java.io.*;
import java.net.*;

public class FileClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";  // Replace with server IP address if needed
        int port = 5000;  // Port number of the server

        try (Socket socket = new Socket(serverAddress, port)) {
             System.out.println("This program is done by MYTHILY && 221061101185");
	     System.out.println("Connected to the server.");

            // Specify the location of the file you want to send
            File file = new File("C:\\Users\\Rehana\\Documents\\Computer Network\\snd.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            OutputStream outputStream = socket.getOutputStream();

            // Buffer to store file data
            byte[] buffer = new byte[4096];
            int bytesRead;

            // Read the file and send it over the network
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File sent successfully!");

            // Close streams and socket
            fileInputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
