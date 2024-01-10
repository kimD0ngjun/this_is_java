package section_19_network.ex05_server_multi_request;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
    private static ServerSocket serverSocket = null;
    // 10개의 스레드로 요청을 처리하는 스레드풀 생성
    private static ExecutorService executorService =
            Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        System.out.println("------------------------------------------------");
        System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter 키를 입력하세요.");
        System.out.println("------------------------------------------------");

        // TCP 서버 시작
        startServer();

        // 키보드 입력
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String key = scanner.nextLine();
            if(key.toLowerCase().equals("q")) {
                break;
            }
        } // q 입력 전까지는 무한히 돌아갈 것
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
                    // ServerSocket 생성 및 Port 바인딩
                    serverSocket = new ServerSocket(50001);
                    System.out.println("[서버] 시작됨");

                    // 연결 수락 및 데이터 통신
                    while(true) {
                        System.out.println("\n[서버] 연결 요청을 기다림\n");
                        // 연결 수락
                        Socket socket = serverSocket.accept();

                        // 작업 큐에 처리 작업 넣기
                        // Runnable은 함수형 인터페이스라서 람다식 대체 표현 가능
                        executorService.execute(() -> {
                            try {
                                // 연결된 클라이언트 정보 얻기
                                InetSocketAddress isa =
                                        (InetSocketAddress) socket.getRemoteSocketAddress();
                                System.out.println(
                                        "[서버] " + isa.getHostName() + " 의 연결 요청을 수락함"
                                );
                                System.out.println(
                                        "[서버] 접속자 IP 주소 : " + isa.getAddress().getHostAddress()
                                );

                                // 데이터 받기
                                DataInputStream dis = new DataInputStream(socket.getInputStream());
                                String message = dis.readUTF();

                                // 데이터 보내기
                                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                                dos.writeUTF(message);
                                dos.flush();
                                System.out.println("[서버] 받은 데이터를 다시 보냄 : " + message);

                                // 연결 끊기
                                socket.close();
                                System.out.println("[서버] " + isa.getHostName() + " 의 연결 종료");
                            } catch(IOException e) {
                                // ignore
                            }
                        });

                    }
                } catch (IOException e) {
                    System.out.println("[서버] " + e.getMessage());
                }
            }
        };

        // 스레드 시작
        thread.start();
    }

    public static void stopServer() {
        try {
            // ServerSocket을 닫고 Port 언바인딩
            serverSocket.close();
            // 스레드풀 종료 추가
            executorService.shutdownNow();
            System.out.println("\n[서버] 종료됨");
        } catch (IOException e) {
            System.out.println("[서버] 비정상적 종료, " + e.getMessage());
        }
    }
}
