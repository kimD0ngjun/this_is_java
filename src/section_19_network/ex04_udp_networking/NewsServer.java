package section_19_network.ex04_udp_networking;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;

public class NewsServer {
    private static DatagramSocket datagramSocket = null;

    public static void main(String[] args) {
        System.out.println("------------------------------------------------");
        System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter 키를 입력하세요.");
        System.out.println("------------------------------------------------");

        // UDP 서버 시작
    }

    public static void startServer() {
        // 작업 스레드 정의
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    // DatagramSocket 생성 및 Port 바인딩
                    datagramSocket = new DatagramSocket(50001);
                    System.out.println("[서버] 시작됨");

                    while(true) {
                        // 클라이언트가 구독하고 싶은 뉴스 주제 얻기
                        DatagramPacket receivePacket = new DatagramPacket(
                                new byte[1024], 1024
                        );
                        datagramSocket.receive(receivePacket);

                        // receive() 메소드 실행 후 수신된 데이터 얻기
                        String newsKind = new String(receivePacket.getData(), 0,
                                receivePacket.getLength(), StandardCharsets.UTF_8);

                        // 클라이언트의 IP와 Port 얻어서 클라이언트에게 처리 내용 보내기
                        SocketAddress socketAddress = receivePacket.getSocketAddress();

                        for(int i=0; i<10; i++) {
                            String data = newsKind + " : 뉴스 " + i;
                            byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
                            DatagramPacket sendPacket =
                                    new DatagramPacket(
                                            bytes, 0, bytes.length, socketAddress
                                    ); // 클라이언트로 보내기
                            datagramSocket.send(sendPacket);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("[서버] " + e.getMessage());
                }
            }
        };
        thread.start();
    }
}
