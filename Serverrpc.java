import java.io.*;
import java.net.*;

class Serverrpc {
    public static void main(String[] args) throws Exception {
        // Display author information
        System.out.println("Program is done by: MYTHILY && 221061101185");
        System.out.println("Server ready");

        // Create a server socket listening on port 3000
        ServerSocket sersock = new ServerSocket(3000);

        // Accept incoming client connections
        Socket sock = sersock.accept();

        // Reader for reading from console
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));

        // Stream to send data to the client
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);

        // Stream to receive data from the client
        InputStream istream = sock.getInputStream();
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

        String receiveMessage, sendMessage, fun;
        int a, b, c;

        // Infinite loop to keep server running
        while (true) {
            // Read the operation type from the client
            fun = receiveRead.readLine();
            if (fun != null) {
                System.out.println("Operation : " + fun);

                // Read the first parameter
                a = Integer.parseInt(receiveRead.readLine());
                System.out.println("Parameter 1 : " + a);

                // Read the second parameter
                b = Integer.parseInt(receiveRead.readLine());
                System.out.println("Parameter 2 : " + b);

                // Perform the requested operation
                if (fun.equals("add")) {
                    c = a + b;
                    System.out.println("Addition = " + c);
                    pwrite.println("Addition " + c);
                } else if (fun.equals("sub")) {
                    c = a - b;
                    System.out.println("Subtraction = " + c);
                    pwrite.println("Subtraction " + c);
                } else if (fun.equals("mul")) {
                    c = a * b;
                    System.out.println("Multiplication = " + c);
                    pwrite.println("Multiplication " + c);
                } else if (fun.equals("div")) {
                    c = a / b;
                    System.out.println("Division = " + c);
                    pwrite.println("Division " + c);
                }
            }

            pwrite.flush();
        }
    }
}
