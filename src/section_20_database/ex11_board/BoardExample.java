package section_20_database.ex11_board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BoardExample {
    // TODO : field
    private Scanner scanner = new Scanner(System.in);
    private Connection connection;

    // TODO : constructor
    public BoardExample() {
        try {
            // JDBC 드라이버 등록
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 연결하기
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thisisjava",
                    "",
                    ""
            );
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            exit();
        }
    }

    // TODO : method
    // 게시물 리스트
    public void list() {
        System.out.println();
        System.out.println("[게시물 목록]");
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
        System.out.println("-------------------------------------------------------");
//        System.out.printf("%-6s%-12s%-16s%-40s \n", "1", "winter", "2022.01.27", "게시판에 오신 것을 환영합니다.");
//        System.out.printf("%-6s%-12s%-16s%-40s \n", "2", "winter", "2022.01.27", "올 겨울은 많이 춥습니다.");

        // boards 테이블에서 게시물 정보 가지고 오기
        try {
            String sql = "" +
                    "SELECT bno, btitle, bcontent, bwriter, bdate " +
                    "FROM boards " +
                    "ORDER BY bno DESC"; // SQL 쿼리 표현

            // PreparedStatement를 사용하여 SQL 인젝션 공격을 방지
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // 쿼리 실행
            ResultSet resultSet = preparedStatement.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
            exit();
        }

        mainMenu();
    }

    // 메인 메뉴 프레임
    public void mainMenu() {
        System.out.println();
        System.out.println("-------------------------------------------------------");
        System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
        System.out.print("메뉴 선택: ");
        String menuNumber = scanner.nextLine();
        System.out.println();

        switch (menuNumber) {
            case "1" -> create();
            case "2" -> read();
            case "3" -> clear();
            case "4" -> exit();
        }
    }

    public void create() {
        System.out.println("create");
        list();
    }

    public void read() {
        System.out.println("read");
        list();
    }

    public void clear() {
        System.out.println("clear");
        list();
    }

    public void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        BoardExample boardExample = new BoardExample();
        boardExample.list();
    }
}
