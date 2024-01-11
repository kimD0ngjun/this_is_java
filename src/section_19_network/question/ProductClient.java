package section_19_network.question;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProductClient {
    // 필드
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private Scanner scanner;

    // 메소드
    public void start() throws IOException {
        socket = new Socket("localhost", 10000);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("[client] connected");

        scanner = new Scanner(System.in);
    }

    //메소드: 클라이언트 종료
    public void stop() {
        try {
            socket.close();
            scanner.close();
        } catch (Exception e) {
        }
        System.out.println("[client] disconnected");
    }

    //메소드: 메뉴
    public void menu() throws IOException, ParseException {
        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.println("메뉴: 1.Create | 2.Update | 3.Delete | 4.Exit");
        System.out.print("선택: ");
        String no = scanner.nextLine();
        System.out.println();

        switch (no) {
            case "1" -> create();
            case "2" -> update();
            case "3" -> delete();
            case "4" -> exit();
        }
    }

    //메소드: 상품 목록
    public void list() throws IOException, ParseException {
        //타이틀 및 컬럼명 출력
        System.out.println();
        System.out.println("[상품 목록]");
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-6s%-30s%-15s%-10s\n", "no", "name", "price", "stock");
        System.out.println("---------------------------------------------------------------");

        //상품 목록 요청하기
        JSONObject request = new JSONObject();
        request.put("menu", 0);
        request.put("data", new JSONObject());
        dos.writeUTF(request.toString());
        dos.flush();

        //응답 받기
        JSONParser parser = new JSONParser();
        JSONObject response = (JSONObject) parser.parse(dis.readUTF());

        if (response.get("status").equals("success")) {
            //상품 목록 출력
            JSONArray data = (JSONArray) response.get("data");
            for (int i = 0; i < data.size(); i++) {
                JSONObject product = (JSONObject) data.get(i);
                System.out.printf(
                        "%-6d%-30s%-15d%-10d\n",
                        product.get("no"),
                        product.get("name"),
                        product.get("price"),
                        product.get("stock")
                );
            }
        }

        menu();
    }

    //메소드: 상품 생성
    public void create() throws IOException, ParseException {
        //상품 정보 입력
        System.out.println("[상품 생성]");
        Product product = new Product();
        System.out.print("상품 이름: ");
        product.setName(scanner.nextLine());
        System.out.print("상품 가격: ");
        product.setPrice(Integer.parseInt(scanner.nextLine()));
        System.out.print("상품 재고: ");
        product.setStock(Integer.parseInt(scanner.nextLine()));

        //상품 생성 요청하기
        JSONObject data = new JSONObject();
        data.put("name", product.getName());
        data.put("price", product.getPrice());
        data.put("stock", product.getStock());

        JSONObject request = new JSONObject();
        request.put("menu", 1);
        request.put("data", data);

        dos.writeUTF(request.toString());
        dos.flush();

        //응답 받기
        JSONParser parser = new JSONParser();
        JSONObject response = (JSONObject) parser.parse(dis.readUTF());
        if (response.get("status").equals("success")) {
            list();
        }
    }

    //메소드: 상품 수정
    public void update() throws IOException, ParseException {
        //상품 수정 내용 입력
        System.out.println("[상품 수정]");

        Product product = new Product();
        System.out.print("상품 번호: ");
        product.setNo(Integer.parseInt(scanner.nextLine()));
        System.out.print("이름 변경: ");
        product.setName(scanner.nextLine());
        System.out.print("가격 변경: ");
        product.setPrice(Integer.parseInt(scanner.nextLine()));
        System.out.print("재고 변경: ");
        product.setStock(Integer.parseInt(scanner.nextLine()));

        //상품 수정 요청하기
        JSONObject data = new JSONObject();
        data.put("no", product.getNo());
        data.put("name", product.getName());
        data.put("price", product.getPrice());
        data.put("stock", product.getStock());

        JSONObject request = new JSONObject();
        request.put("menu", 2);
        request.put("data", data);

        dos.writeUTF(request.toString());
        dos.flush();

        //응답 받기
        JSONParser parser = new JSONParser();
        JSONObject response = (JSONObject) parser.parse(dis.readUTF());
        if (response.get("status").equals("success")) {
            list();
        }
    }

    //메소드: 상품 삭제
    public void delete() throws IOException, ParseException {
        //상품 삭제 내용 입력
        System.out.println("[상품 삭제]");
        System.out.print("상품 번호: ");
        int no = Integer.parseInt(scanner.nextLine());

        //상품 수정 요청하기
        JSONObject data = new JSONObject();
        data.put("no", no);

        JSONObject request = new JSONObject();
        request.put("menu", 3);
        request.put("data", data);

        dos.writeUTF(request.toString());
        dos.flush();

        //응답 받기
        JSONParser parser = new JSONParser();
        JSONObject response = (JSONObject) parser.parse(dis.readUTF());
        if (response.get("status").equals("success")) {
            list();
        }
    }

    //메소드: 종료
    public void exit() {
        stop();
    }
}
