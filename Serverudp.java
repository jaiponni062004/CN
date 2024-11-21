import java.net.*;

public class Serverudp {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9876); // Server listens on port 9876
        byte[] receiveData = new byte[1024];

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from client: " + message);
        }
    }
}
