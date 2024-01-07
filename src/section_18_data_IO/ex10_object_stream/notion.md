### Serializable 인터페이스

자바는 `Serializable` 인터페이스를 구현한 클래스만 클래스만 직렬화할 수 있도록 제한하고 있다.<br />

객체가 직렬화할 때, 인스턴스 필드값은 직렬화 대상이지만, 정적 필드값과 `transient` 로 선언된 필드값은 직렬화에서 제외되므로 출력되지 않는다.

```java
public class 클래스 implements Serializable {
    public int field1; // 직렬화 가능
    protected int field2; // 가능
    int field3; // 가능
    private int field4; // 가능
    
    public static int field5; // 직렬화 제외
    transient int field6; // 직렬화 제외
}
```

### serialVersionUID 필드

직렬화할 때 사용된 클래스와 역직렬화할 때 사용된 클래스는 기본적으로 동일한 클래스여야 한다. 만약 클래스의 이름이 같아도 클래스의 내용이 다르면 역직렬화에 실패한다. <br />

다만 클래스 내용이 다르다 할지라도 직렬화된 필드를 공통으로 포함하고 있다면 역직렬화할 수 있는 방법이 있다. 두 직렬화가 동일한 `serialVersionUID` 상수값을 가지고 있으면 된다.<br />

인텔리제이에서 `serialVersionUID` 자동 생성하려면 `Serializable` 인스턴스를 구현한 클래스의 클래스명에 마우스 가져다대고 create 어쩌고... 클릭하면 자동으로 `serialVersionUID` 필드가 생성된다.<br />

https://androowl.tistory.com/50 참조