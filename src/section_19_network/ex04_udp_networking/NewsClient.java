package section_19_network.ex04_udp_networking;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class NewsClient {
    public static void main(String[] args) {
        try {
            // DatagramSocket 생성
            DatagramSocket datagramSocket = new DatagramSocket();

            // 구독하고 싶은 뉴스 주제 보내기
            String data = "정치";
            byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
            DatagramPacket sendPacket = new DatagramPacket(
                    bytes, bytes.length, new InetSocketAddress("localhost", 50001)
            );
            datagramSocket.send(sendPacket);

            // 서버한테 보내고... 이제 서버로부터 받아서

            while(true) {
                // 뉴스 받기
                DatagramPacket receivePacket = new DatagramPacket(new byte[1024],
                        1024);
                datagramSocket.receive(receivePacket);

                // 문자열로 전환
                String news = new String(receivePacket.getData(), 0,
                        receivePacket.getLength(), StandardCharsets.UTF_8);
                System.out.println(news);

                if(news.contains("뉴스 9")) {
                    break;
                }
            }

            datagramSocket.close();

        } catch (Exception e) {
            // ignore
        }
    }
}
