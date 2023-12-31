package section_15_collection.map.properties;

import java.util.Properties;

// .properties 파일을 읽기 위한, HashTable의 자식 클래스
// 설정 정보를 멀티 스레드 환경에서 안전하게 다루기 위해서
public class PropertiesExample {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();

        properties.load(PropertiesExample.class.getResourceAsStream(
                "database.properties"));

        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String userName = properties.getProperty("username");
        String password = properties.getProperty("password");
        String admin = properties.getProperty("admin");

        System.out.println("driver : " + driver);
        System.out.println("url : " + url);
        System.out.println("userName : " + userName);
        System.out.println("password : " + password);
        System.out.println("admin : " + admin);
    }
}
