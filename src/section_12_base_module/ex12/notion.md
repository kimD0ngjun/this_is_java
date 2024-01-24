## 어노테이션 개념

### 어노테이션(annotation) 목적

- 컴파일 시 사용하는 정보 전달
- 빌드 툴이 코드를 자동으로 생성할 때 사용하는 정보 전달
- 실행 시 특정 기능을 처리할 때 사용하는 정보 전달

놀랍게도(?) 어노테이션 역시 하나의 타입이라서 어노테이션 사용하려면 먼저 정의부터 해야 함

```java
public @inteface AnnotationName {
}
```
이렇게 정의한 어노테이션은...

```java
@AnnotationName
```

이런 식으로 쓰인다

### 속성을 가지는 어노테이션

```java
public @interface AnnotationName {
    String prop1(); // 기본값은 없고 속성만 추가
    int prop2() default 1; // 기본값으로 1을 배정(default 키워드 사용)
}
```
속성을 추가한 어노테이션은
```java
@AnnotationName(prop1 = "값"); // 기본값 설정 안한 속성은 반드시 값 기술 필요
@AnnotationName(prop1 = "값", prop2 = 3); // 기본값 설정해도 값 기술 가능
```
이런 식으로 쓰인다

### 어노테이션의 기본 속성 value()

```java
public @interface AnnotationName {
    String value(); 
    // value 속성을 가진 어노테이션은 코드에서 사용할 때 값만 기술할 수 있다.
    int prop2() default 1;
}
```
```java
@AnnotationName("값");
// value 속성에 자동으로 대입

@Annotationname(value="값", prop2=3);
// value 속성과 다른 속성 값을 동시에 주려면 value 속성 이름 언급 필요
```

## 어노테이션 적용과 유지

>적용 대상 종류 `ElementType` 열거 상수
>- TYPE : 클래스, 인터페이스, 열거 타입
>- ANNOTATION_TYPE : 어노테이션
>- FIELD : 필드
>- CONSTRUCTOR : 생성자
>- METHOD : 메소드
>- LOCAL_VARIABLE : 로컬 변수
>- PACKAGE : 패키지

>유지 정책 종류 `RetentionPolicy` 열거 상수
>- SOURCE : 컴파일할 때 적용해서 컴파일된 후에 제거
>- CLASS : 메모리 로딩할 때 적용해서 메모리 로딩 끝나고 제거
>- RUNTIME : 실행할 때 적용해서 얘는 계속 유지됨