package section_20_database.ex07_update_data;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BoardUpdateExample {
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

            // 매개변수화된 SQL 문 작성
            String sql = new StringBuilder()
                    .append("UPDATE boards SET ")
                    .append("btitle=?, ")
                    .append("bcontent=?, ")
                    .append("bfilename=?, ")
                    .append("bfiledata=? ")
                    .append("WHERE bno=?")
                    .toString();

            // PreparedStatement 얻기 및 값 지정
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, "눈사람");
            preparedStatement.setString(2, "눈으로 만든 사람");
            preparedStatement.setString(3, "snowman.jpg");
            preparedStatement.setBlob(4,
                    new FileInputStream("/Users/kimdongjun/Desktop/Etc/temp/sec07/snowman.jpg"));
            preparedStatement.setInt(5, 3); // boards 테이블에 있는 게시물 번호(bno) 지정

            int rows = preparedStatement.executeUpdate(); // SQL 문 실행
            System.out.println("수정된 행 수: " + rows);

            preparedStatement.close();

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
