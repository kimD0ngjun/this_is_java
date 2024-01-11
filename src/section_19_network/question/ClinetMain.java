package section_19_network.question;

import java.io.IOException;

public class ClinetMain {
    public static void main(String[] args) {
        ProductClient productClient = new ProductClient();
        try {
            productClient.start();
        } catch(IOException e) {
            System.out.println(e.getMessage());
            productClient.stop();
        }
    }
}
