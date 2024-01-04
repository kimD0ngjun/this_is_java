### 외부 반복자
개발자가 직접 흐름을 제어하는 코드를 작성해야 됨
```java
List<String> list = Arrays.asList("A", "B", "C");

// 외부 반복자 사용 (명시적인 제어 흐름 추가)
Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    String element = iterator.next();
    System.out.println(element);

    // 명시적인 제어 흐름: 요소에 대한 추가 작업
    if (element.equals("B")) {
        // 어떠한 추가 작업 수행
    }
}
```

### 내부 반복자
내부 반복자는 컬렉션의 요소를 처리하는 작업을 컬렉션 자체에 위임. 개발자는 단순히 처리해야 하는 작업을 정의하고, 컬렉션은 이 작업을 내부적으로 처리. 내부 반복자는 보통 함수형 인터페이스(예: 람다 표현식)를 활용하여 작업을 전달.

```java
List<String> list = Arrays.asList("A", "B", "C");

// 내부 반복자 사용
list.forEach(element -> System.out.println(element));
```