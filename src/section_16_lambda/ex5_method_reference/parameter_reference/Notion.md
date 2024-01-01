### 람다식 매개변수가 메소드를 참조하는 경우
 ```java
(a, b) -> { a.instanceMethod(b); }
```

아마 이런 경우가 있을 건데 이런 경우에는 이렇게 작성한다.
```agsl
a의 클래스 :: instanceMethod
```