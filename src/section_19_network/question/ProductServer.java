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

public class ProductServer {
    ServerSocket serverSocket;
    ExecutorService threadPool = Executors.newFixedThreadPool(100);
    List<SocketClient> products = Collections.synchronizedList(new ArrayList<>());

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
    }
}
