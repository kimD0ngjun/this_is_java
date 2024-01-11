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
    private int sequence;

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
                        case 0: list();
                            // 그냥 메뉴 조회 case 추가
                        case 1: create(jsonObject);
                            // 1번 누르면 생성 case 추가
                        case 2: update(jsonObject);
                            // 2번 누르면 수정 case 추가
                        case 3: delete(jsonObject);
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
        // 0번 케이스
        public void list() throws IOException {
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

        // 1번 케이스
        public void create(JSONObject request) throws IOException {
            // 요청 처리
            JSONObject data = (JSONObject) request.get("data");
            Product product = new Product();
            product.setNo(++sequence);
            product.setName((String) data.get("name"));
            product.setPrice((int) data.get("price"));
            product.setStock((int) data.get("stock"));

            // 응답 보내기
            JSONObject response = new JSONObject();
            response.put("status", "success");
            response.put("data", new JSONObject());
            dos.writeUTF(response.toString());
            dos.flush();
        }

        // 2번 케이스
        public void update(JSONObject request) throws IOException {
            // 요청 처리하기
            JSONObject data = (JSONObject) request.get("data");

            for(Product product: products) {
                if(product.getNo() == (int) data.get("no")) {
                    product.setNo((int) data.get("no"));
                    product.setName((String) data.get("name"));
                    product.setPrice((int) data.get("price"));
                    product.setStock((int) data.get("stock"));
                }
            }

            // 응답 보내기
            JSONObject response = new JSONObject();
            response.put("status", "success");
            response.put("data", new JSONObject());
            dos.writeUTF(response.toString());
            dos.flush();
        }

        // 3반 케이스
        public void delete(JSONObject request) throws IOException {
            // 요청 처리하기
            JSONObject data = (JSONObject) request.get("data");

            for(Product product: products) {
                if(product.getNo() == (int) data.get("no")) {
                    products.remove(product);
                }
            }

            // 응답 보내기
            JSONObject response = new JSONObject();
            response.put("status", "success");
            response.put("data", new JSONObject());
            dos.writeUTF(response.toString());
            dos.flush();
        }

        //TODO: 연결 종료
        public void close() throws IOException {
            socket.close();
        }
    }
}
