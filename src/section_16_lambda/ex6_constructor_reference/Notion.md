### todtjdwk ckawh
```agsl
(a, b) -> { return new 클래스(a, b); }
```
이걸 생성자 참조(즉, 람다식이 단순하게 객체 생성하고 리턴하게 한다면)로 표현하면...

```agsl
클래스 :: new
```

만약 생성자가 오버로딩 돼서 여러 개 있으면, 컴파일러가 함수형 인터페이스의 추상 메소드와 동일한 매개변수 타입과 개수를 가지고 있는 생성자를 찾아 실행. 이렇게 찾았는데도 만약 없다면 컴파일 오류 발생