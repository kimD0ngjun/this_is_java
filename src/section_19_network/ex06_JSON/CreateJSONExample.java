package section_19_network.ex06_JSON;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CreateJSONExample {
    public static void main(String[] args) throws IOException {
        // JSON 객체 생
        JSONObject root = new JSONObject();

        // 속성 추가
        root.put("id", "winter");
        root.put("name", "한겨울");
        root.put("age", 25);
        root.put("student", true);

        // 객체 속성 추가
        JSONObject tel = new JSONObject();
        tel.put("home", "02-123-1234");
        tel.put("mobile", "010-123-1234");
        root.put("tel", tel);

        // 배열 속성 추가
        JSONArray skill = new JSONArray();
        skill.add("java");
        skill.add("c");
        skill.add("c++");
        root.put("skill", skill);

        // JSON 얻기
        String json = root.toString();

        // 콘솔 출력
        System.out.println(json);

        // 파일로 저장
        Writer writer = new FileWriter(
                "/Users/kimdongjun/Desktop/temp/member.json", StandardCharsets.UTF_8);
        writer.write(json); // 출력
        writer.flush(); // 잔류 출력 및 비우기
        writer.close(); // 폐쇄
    }
}

// 이것이 자바다에서 알려준 라이브러리랑 다른 라이브러리임
// 그래서 배열의 경우에는 put() 메소드가 없고 add() 메소드
// 이 부분은 추후에 확인해서 더 적합한 라이브러리 있는지, 있으면 라이브러리 추가할 방법 등 찾아보기