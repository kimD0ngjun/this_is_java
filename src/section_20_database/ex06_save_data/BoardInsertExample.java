package section_20_database.ex06_save_data;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BoardInsertExample {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // JDBC Driver 등록
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 연결하기
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thisisjava",
                    "root",
                    "sonic30810@"
            );

            // 매개변수화된 SQL 문 작성
            String sql = new StringBuilder()
                    .append("INSERT INTO boards (btitle, bcontent, bwriter, bdate, bfilename, bfiledata) ")
                    .append("VALUES (?, ?, ?, now(), ?, ?)")
                    .toString();

            // PreparedStatement 얻기 및 값 지정
            PreparedStatement preparedStatement = connection.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS
            ); // 두 번째 매개값 : INSERT 문이 실행 후 가져올 키 (자동 증가된 bno 값)
            // SQL 문이 실행된 후에 bno 컬럼에 실제로 저장된 값을 얻는 것

            preparedStatement.setString(1, "눈 오는 날");
            preparedStatement.setString(2, "함박눈이 내려요.");
            preparedStatement.setString(3, "winter");
            preparedStatement.setString(4, "snow.jpg");
            preparedStatement.setBlob(5,
                    new FileInputStream("/Users/kimdongjun/Desktop/Etc/temp/sec06/snow.jpg"));

            int rows = preparedStatement.executeUpdate(); // SQL 문 실행
            System.out.println("저장된 행 수: " + rows);

            if (rows == 1) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                // new String[] { "bno" }에 기술된 컬럼 값을 가져옴

                if (resultSet.next()) {
                    int bno = resultSet.getInt(1);
                    // 값이 있다면 new String[] { "bno" }의 첫 번째 항목 bno 컬럼 값을 읽음
                    System.out.println("저장된 bno: " + bno);
                }

                resultSet.close(); // ResultSet이 사용한 메모리 해제
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignored) {}
            }
        }
    }
}
