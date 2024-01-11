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
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProductServer {
    // ProductServer 필드
    private ServerSocket serverSocket;
    private ExecutorService threadPool = Executors.newFixedThreadPool(100);
    private List<Product> products = new Vector<>();

    // ProductServer 메소드
    public void start() throws IOException {
        serverSocket = new ServerSocket(10000);
        System.out.println("[server] started");

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
            try {
                this.productServer = productServer;
                this.socket = socket;
                this.dis = new DataInputStream(socket.getInputStream());
                this.dos = new DataOutputStream(socket.getOutputStream());
                receive();
            } catch (IOException e) {
                close();
            }
        }

        //TODO: JSON 받기
        public void receive() {
            productServer.threadPool.execute(() -> {
                try {
                    String receiveJson = dis.readUTF();

                    JSONParser parser = new JSONParser();
                    JSONObject jsonObject = (JSONObject) parser.parse(receiveJson);

                    int menu = (int) jsonObject.get("menu");
                    switch(menu) {
                        case 0:
                            // 그냥 메뉴 조회 case 추가
                        case 1:
                            // 1번 누르면 생성 case 추가
                        case 2:
                            // 2번 누르면 수정 case 추가
                        case 3:
                            // 3번 누르면 삭제 case 추가
                    }

                } catch (IOException | ParseException e) {
                }
            });
        }

        //TODO: case별 메소드
//        public void send(String json) throws IOException {
//            dos.writeUTF(json);
//            dos.flush();
//        }
        public void list(JSONObject request) throws IOException {
            JSONArray data = new JSONArray();
            for(Product p: products) {
                JSONObject product = new JSONObject();
                product.put("no", p.getNo());
                product.put("name", p.getName());
                product.put("price", p.getPrice());
                product.put("stock", p.getStock());
                data.add(product);
            }

            JSONObject response = new JSONObject();
            response.put("status", "success");
            response.put("data", data);
            dos.writeUTF(response.toString());
            dos.flush();
        }

        //TODO: 연결 종료
        public void close() throws IOException {
            socket.close();
        }
    }
}
