package section_19_network.question;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProductServer {
    // ProductServer 필드
    ServerSocket serverSocket;
    ExecutorService threadPool = Executors.newFixedThreadPool(100);
    List<SocketClient> products = Collections.synchronizedList(new ArrayList<>());

    // ProductServer 메소드
    public void start() throws IOException {
        serverSocket = new ServerSocket(10000);
        System.out.println("[server] start");

        Thread thread = new Thread(() -> {
            try {
                while(true) {
                    Socket socket = serverSocket.accept();
                    SocketClient sc = new SocketClient(this, socket);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
    }

    class SocketClient {
        ProductServer productServer;
        Socket socket;
        DataInputStream dis;
        DataOutputStream dos;

        public SocketClient(ProductServer productServer, Socket socket) throws IOException {
            this.productServer = productServer;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
        }

        //TODO: JSON 받기
        public void receive() {
            productServer.threadPool.execute(() -> {
                try {
                    String receiveJson = dis.readUTF();

                    JSONParser parser = new JSONParser();
                    JSONObject jsonObject = (JSONObject) parser.parse(receiveJson);

                    String menu = (String) jsonObject.get("menu");
                    switch(menu) {
                        case "1":
                            // case 추가
                        case "2":
                            // case 추가
                        case "3":
                            // case 추가
                        case "4":
                            // case 추가
                    }

                } catch (IOException | ParseException e) {
                }
            });
        }

        //TODO: JSON 보내기
        public void send(String json) throws IOException {
            dos.writeUTF(json);
            dos.flush();
        }

        //TODO: 연결 종료
        public void close() throws IOException {
            socket.close();
        }
    }
}
