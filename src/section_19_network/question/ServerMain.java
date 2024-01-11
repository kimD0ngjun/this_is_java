package section_19_network.question;

import java.io.IOException;

public class ServerMain {
    public static void main(String[] args) throws IOException {
        ProductServer productServer = new ProductServer();
        try {
            productServer.start();
        } catch(IOException e) {
            System.out.println(e.getMessage());
            productServer.stop();
        }
    }
}
