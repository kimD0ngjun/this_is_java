package section_19_network.ex02_ip_address;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ia = InetAddress.getLocalHost();
        System.out.println("내 컵퓨터 호스트 네임 : " + ia.getHostName());
        System.out.println("내 컴퓨터 ip 주소 : " + ia.getHostAddress());

        InetAddress[] iaArray = InetAddress.getAllByName("www.naver.com");
        for(InetAddress remote: iaArray) {
            System.out.println("www.naver.com IP 주소 : " + remote.getHostAddress());
        }
    }
}

// InetAddress.getLocalHost()는 리스트의 맨 처음 인덱스 IP 주소를 반환하기 때문에
// 다중 네트워크 카드를 이용할 경우 이 리스트의 순서가 변경되어 일관성 없는 IP를 반환할 수 있게 되는 문제

// 시스템에서 호스트의 이름을 검색한 다음 해당 이름을 InetAddress로 해석하여 수행