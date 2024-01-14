package section_20_database.ex09_read_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSelectExample {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // JDBC Driver 등록
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 연결하기
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thisisjava",
                    "",
                    ""
            );

            // 매개변수화된 sql문 작성
            String sql = "" +
                    "SELECT userid, username, userpassword, userage, useremail " +
                    "FROM users " +
                    "WHERE userid=?";

            // PreparedStatement 얻기 및 값 지정
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "winter");

            // sql 문 실행 후, ResultSet으로 값 읽기
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getString("userid"));
                user.setUserName(resultSet.getString("username"));
                user.setUserPassword(resultSet.getString("userpassword"));
                user.setUserAge(resultSet.getInt(4)); // 컬럼 순번
                user.setUserEmail(resultSet.getString(5));
                System.out.println(user);
            } else {
                System.out.println("사용자 아이디가 존재하지 않음");
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
    }
}
