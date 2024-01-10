package section_19_network.ex06_JSON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseJSONExample {
    public static void main(String[] args) throws IOException, ParseException {
        // 파일로부터 JSON 읽기
        BufferedReader br = new BufferedReader(
                new FileReader("/Users/kimdongjun/Desktop/temp/member.json", StandardCharsets.UTF_8)
        );
        String json = br.readLine();
        br.close();

        // JSON 파싱(이것이 자바다 내용과 다름)
        JSONParser parser = new JSONParser();
        JSONObject root = (JSONObject) parser.parse(json);

        // 속성 정보 읽기
        System.out.println("id : " + root.get("id"));
        System.out.println("name : " + root.get("name"));
        System.out.println("age : " + root.get("age"));
        System.out.println("student : " + root.get("student"));

        // 객체 속성 정보 읽기
        JSONObject tel = (JSONObject) root.get("tel");
        System.out.println("home : " + tel.get("home"));
        System.out.println("mobile : " + tel.get("mobile"));

        // 배열 속성 정보 읽기
        JSONArray skill = (JSONArray) root.get("skill");
        System.out.print("skill : ");
        for(int i = 0; i < skill.size(); i++) {
            System.out.print(skill.get(i) + ", ");
        }
        // JSONArray 클래스가 java.util.List 인터페이스를 구현하고 있음.
        // 따라서 배열 요소의 개수를 구하는 메서드로 size()를 사용
    }
}
