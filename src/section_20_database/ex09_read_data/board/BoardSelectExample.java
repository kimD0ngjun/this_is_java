package section_20_database.ex09_read_data.board;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardSelectExample {
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

            // 매개변수화된 sql문
            String sql = "" +
                    "SELECT bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata " +
                    "FROM boards " +
                    "WHERE bwriter=?";

            // PrepareStatement 값 얻기
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "winter"); // 값 지정

            // sql statement 실행 후, ResultSet을 통해 데이터 읽기
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // 데이터 행 읽어서 Board 객체에 저장
                Board board = new Board();
                board.setBno(resultSet.getInt("bno"));
                board.setBtitle(resultSet.getString("btitle"));
                board.setBcontent(resultSet.getString("bcontent"));
                board.setBwriter(resultSet.getString("bwriter"));
                board.setBdate(resultSet.getDate("bdate"));
                board.setBfilename(resultSet.getString("bfilename"));
                board.setBfiledata(resultSet.getBlob("bfiledata"));

                System.out.println(board);

                // 파일로 저장
                Blob blob = board.getBfiledata();
                if (blob != null) {
                    InputStream is = blob.getBinaryStream();
                    OutputStream os = new FileOutputStream(
                            "/Users/kimdongjun/Desktop/Etc/temp/section20_BoardSelect/" +
                            board.getBfilename());
                    is.transferTo(os);
                    os.flush();
                    os.close();
                    is.close();
                }
            }

            resultSet.close();

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
    }
}
