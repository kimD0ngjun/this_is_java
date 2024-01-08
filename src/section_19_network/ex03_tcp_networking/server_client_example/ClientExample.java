package section_19_network.ex03_tcp_networking.server_client_example;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample {
    public static void main(String[] args) {
        try {
            // Socket 생성과 동시에 포트 연결 요청
            Socket socket = new Socket("localhost", 50001);

            System.out.println("[클라이언트] 연결 성공");

            // Socket 닫기
            socket.close();
            System.out.println("[클라이언트] 연결 끊음");
        } catch (UnknownHostException e) {
            // ignore
        } catch (IOException e) {
            // ignore
        }
    }
}
