package section_19_network.question;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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

    public void receive() {
        Thread thread = new Thread(() -> {
           try {
               while(true) {
                   String json = dis.readUTF();
                   JSONParser parser = new JSONParser();
                   JSONObject root = (JSONObject)  parser.parse(json);

                   int no = (int) root.get("no");
                   String name = (String) root.get("name");
                   int price = (int) root.get("int");
                   int stock = (int) root.get("stock");
                   System.out.println(no + " " + name + " " + price + " " + stock);
               }
           } catch(Exception e) {
               System.out.println("[client] disconnected");
               System.exit(0);
           }
        });
        thread.start();
    }
}
