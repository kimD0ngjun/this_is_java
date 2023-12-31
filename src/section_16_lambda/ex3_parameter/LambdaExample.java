package section_16_lambda.ex3_parameter;

public class LambdaExample {
    public static void main(String[] args) {
        Person person = new Person();

        // 매개변수 두 개
        person.action1((name, job) -> {
            System.out.print(name + "이(가) ");
            System.out.println(job + "을 합니다.");
        });

        // 매개변수 한 개
        person.action2(word -> {
            System.out.print("\"" + word + "\"");
            System.out.println("라고 말합니다");
        });
        person.action2(word -> System.out.println("\"" + word + "\"라고 외칩니다."));
    }
}
