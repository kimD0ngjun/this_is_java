package section_19_network.question;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ProductClient {
    // 필드
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;

    // 메소드
    public void connect() throws IOException {
        socket = new Socket("localhost", 10000);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("[client] connected");
    }
}
