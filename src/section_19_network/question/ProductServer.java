package section_19_network.question;

import java.net.ServerSocket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductServer {
    ServerSocket serverSocket;
    ExecutorService threadPool = Executors.newFixedThreadPool(100);
    Map<String, SocketClient> shopRoom = Collections.synchronizedMap(new HashMap<>());

    class SocketClient {

    }
}
