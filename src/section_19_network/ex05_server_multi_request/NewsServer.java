package section_19_network.ex05_server_multi_request;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewsServer {
    private static DatagramSocket datagramSocket = null;
    // 10개의 스레드로 요청을 처리하는 스레드풀 생성
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        System.out.println("------------------------------------------------");
        System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter 키를 입력하세요.");
        System.out.println("------------------------------------------------");

        // UDP 서버 시작
        startServer();

        Scanner scanner = new Scanner(System.in);
        while(true) {
            String key = scanner.nextLine();
            if(key.toLowerCase().equals("q")) {
                break;
            }
        }

        scanner.close();

        // TCP 서버 종료
        stopServer();
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

                    // 작업 큐에 처리 작업 넣기
                    // Runnable은 함수형 인터페이스이므로 람다식 표현 가능
                    executorService.execute(() -> {
                        try {
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
                        }
                    });
                } catch (Exception e) {
                    System.out.println("[서버] " + e.getMessage());
                }
            }
        };
        thread.start();
    }

    public static void stopServer() {
        // DatagramSocket을 닫고 Port 언바인딩
        datagramSocket.close();
        System.out.println("[서버] 종료");
    }
}
