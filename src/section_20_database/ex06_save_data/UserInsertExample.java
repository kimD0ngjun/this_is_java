package section_20_database.ex06_save_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserInsertExample {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // JDBC 등록
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 연결하기
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thisisjava",
                    "",
                    ""
            );

            // 매개변수화된 SQL 문 작성
//            String sql = "" +
//                    "INSERT INTO users (userid, username, userpassword, userage, useremail) " +
//                    "VALUES(?, ?, ?, ?, ?)";
            String sql = new StringBuilder()
                    .append("INSERT INTO users (userid, username, userpassword, userage, useremail) ")
                    // 사용자 정보 저장하는 INSERT문
                    .append("VALUES(?, ?, ?, ?, ?)")
                    // INSERT문 매개변수화
                    .toString();

            // PreparedStatement 얻기 및 값 지정
            PreparedStatement preparedStatement = connection.prepareStatement(sql); // 매개변수화된 SQL 문을 실행 목

            // 값의 타입에 따라 Setter 메소드를 선택한 후 첫 번째에는 ? 순번, 두 번째에는 값을 지정
            preparedStatement.setString(1, "winter");
            preparedStatement.setString(2, "한겨울");
            preparedStatement.setString(3, "12345");
            preparedStatement.setInt(4, 25);
            preparedStatement.setString(5, "winter@mycompany.com");

            // SQL 문 실행
            int rows = preparedStatement.executeUpdate();
            // 정상적으로 실행되었을 경우 1을 리턴
            System.out.println("저장된 행 수 : " + rows);

            // PreparedStatement가 사용했던 메모리를 해제
            preparedStatement.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    // 연결 끊기
                    connection.close();
                } catch (SQLException ignored) {}
            }
        }
    }
}
