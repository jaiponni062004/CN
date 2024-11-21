import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.*;
import java.nio.file.*;

public class  HTTPClient {
    public static void main(String[] args) {
	System.out.println("This program is done by Nowshath && 221061101195");
        String imageUrl = "";  
        String destinationFile = "";  

        try {
           
            HttpClient client = HttpClient.newHttpClient();
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(imageUrl))
                    .build();
            
            HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

            // Check if the response is successful (status 200)
            if (response.statusCode() == 200) {
                
                Files.write(Paths.get(destinationFile), response.body());
                System.out.println("Image downloaded successfully as " + destinationFile);
            } else {
                System.out.println("Failed to download image. Server responded with: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
