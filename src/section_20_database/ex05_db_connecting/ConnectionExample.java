package section_20_database.ex05_db_connecting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // JDBC Driver 등록
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 문자열로 주어진 JDBC Driver 클래스를 Build Path에서 찾고, 메모리로 로딩

            // 연결하기
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thisisjava",
                    "java",
                    "mysql"
            );
            //TODO : url 매개변수 = jdbc:mysql://<IP 주소>:<포트>/<DB 이름>

            System.out.println("connection succeed");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    // 연결 끊기
                    connection.close();
                    System.out.println("disconnected");
                } catch (SQLException ignored) {}
            }
        }
    }
}
