import java.net.*;
import java.util.Scanner;

public class Clientudp {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter message to send to server: ");
        String message = scanner.nextLine();

        DatagramPacket sendPacket = new DatagramPacket(message.getBytes(), message.length(), serverAddress, 9876);
        socket.send(sendPacket);
        socket.close();
    }
}
