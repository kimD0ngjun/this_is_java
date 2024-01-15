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

            // Board 객체에 담아서 조회
            while(resultSet.next()) {
                Board board = new Board();

                board.setBno(resultSet.getInt("bno"));
                board.setBtitle(resultSet.getString("btitle"));
                board.setBcontent(resultSet.getString("bcontent"));
                board.setBwriter(resultSet.getString("bwriter"));
                board.setBdate(resultSet.getDate("bdate"));

                System.out.printf("%-6s%-12s%-16s%-40s \n",
                        board.getBno(),
                        board.getBwriter(),
                        board.getBdate(),
                        board.getBtitle()
                );
            }

            resultSet.close();
            preparedStatement.close();

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
//        System.out.println("create");
        // 작성한 게시글 담을 Board 객체
        Board board = new Board();

        // 입력 받기
        System.out.println("[새 게시물 입력]");

        System.out.print("제목: ");
        board.setBtitle(scanner.nextLine());

        System.out.print("내용: ");
        board.setBcontent(scanner.nextLine());

        System.out.print("작성자: ");
        board.setBwriter(scanner.nextLine());

        // 보조 메뉴 선택창
        System.out.println("-------------------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();

        if (menuNo.equals("1")) {
            // boards 테이블에 게시물 정보 저장
            try {
                String sql = "" +
                        "INSERT INTO boards (btitle, bcontent, bwriter, bdate) " +
                        "VALUES (?, ?, ?, now())";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, board.getBtitle());
                preparedStatement.setString(2, board.getBcontent());
                preparedStatement.setString(3, board.getBwriter());

                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
                exit();
            }
        }

        list();
    }

    public void read() {
//        System.out.println("read");
        System.out.println("[게시물 읽기]");
        System.out.print("bno: ");
        int bno = Integer.parseInt(scanner.nextLine());

        // boards 테이블에서 해당 게시물을 가져와 출력
        try {
            String sql = "" +
                    "SELECT bno, btitle, bcontent, bwriter, bdate " +
                    "FROM boards " +
                    "WHERE bno=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bno);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Board board = new Board();

                board.setBno(resultSet.getInt("bno"));
                board.setBtitle(resultSet.getString("btitle"));
                board.setBcontent(resultSet.getString("bcontent"));
                board.setBwriter(resultSet.getString("bwriter"));
                board.setBdate(resultSet.getDate("bdate"));

                System.out.println("#############");
                System.out.println("번호: " + board.getBno());
                System.out.println("제목: " + board.getBtitle());
                System.out.println("내용: " + board.getBcontent());
                System.out.println("작성자: " + board.getBwriter());
                System.out.println("날짜: " + board.getBdate());

                // 보조 메뉴 출력(삭제, 수정 기능 추가)
                System. out.println("----------------------");
                System. out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
                System. out.print("메뉴 선택: ");
                String menuNumber = scanner.nextLine();
                System. out.println();

                if (menuNumber.equals("1")) {
                    update(board);
                } else if (menuNumber.equals("2")) {
                    delete(board);
                }

                System.out.println("#############");
            }

            resultSet.close();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
            exit();
        }

        list();
    }

    // 수정
    public void update(Board board) {
        // 수정 내용 입력 받기
        System.out.println("[수정 내용 입력]");
        System.out.print("제목: ");
        board.setBtitle(scanner.nextLine());
        System.out.print("내용: ");
        board.setBcontent(scanner.nextLine());
        System.out.print("작성자: ");
        board.setBwriter(scanner.nextLine());

        // 보조 메뉴 출력
        System.out.println("------------------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String menuNumber = scanner.nextLine();

        if (menuNumber.equals("1")) {
            try {
                String sql = "" +
                    "UPDATE boards SET btitle= ?, bcontent= ?, bwriter=? " +
                    "WHERE bno=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, board.getBtitle());
                preparedStatement.setString(2, board.getBcontent());
                preparedStatement.setString(3, board.getBwriter());
                preparedStatement.setInt(4, board.getBno());

                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
                exit();
            }
        }
        list();
    }

    // 삭제
    public void delete(Board board) {
        try {
            String sql = "DELETE FROM boards WHERE bno=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, board.getBno());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
            exit();
        }

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
