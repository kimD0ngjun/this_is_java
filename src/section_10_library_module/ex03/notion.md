1. 모듈 간 의존성 설정을 해주면 모듈 디스크립터(module-info.java)를 작성하지 않아도 import가 가능하다

2. 이에 대한 챗지피티의 답변(사실 챗지피티를 잘 믿지는 않지만) : 
   IntelliJ IDEA에서 모듈 간에 의존성을 직접 설정하면 모듈 디스크립터인 module-info.java 파일을 작성하지 않아도 됩니다. IntelliJ IDEA는 모듈 간의 의존성을 프로젝트 설정에서 관리할 수 있으며, 이를 통해 모듈 간의 패키지를 import할 수 있습니다.
모듈 디스크립터를 작성하지 않고 IntelliJ IDEA에서 모듈 간 의존성을 설정하는 경우, IntelliJ는 이러한 의존성을 내부적으로 처리하여 컴파일 및 실행 시에 필요한 클래스 경로를 생성합니다. 이는 편의성을 제공하고 모듈 시스템의 복잡성을 숨기는 역할을 합니다.
하지만 이 방식은 프로젝트를 IDE에 종속적으로 만들 수 있고, 모듈 시스템의 기능을 모두 활용하지 않게 될 수 있습니다. 만약 모듈 시스템의 이점을 더 활용하고 싶다면, module-info.java 파일을 명시적으로 작성하여 모듈 시스템을 활성화하는 것이 좋습니다.
즉, IntelliJ IDEA의 간편한 모듈 의존성 설정은 편리하게 사용할 수 있지만, 프로젝트의 특성에 따라 명시적인 모듈 디스크립터를 작성하는 것이 좋을 수 있습니다.

3. 디스크립터 작성 예시
```java
module module_a { // module 모듈 이름
    exports pack1; // exports 모듈 보유 패키지명
    exports pack2;

    requires module_b; // requires 외부 기타 모듈
    requires module_c;
} 

// 디스크립터 위치는 src 파일 바깥에 하는듯? 그래야 Main 클래스에서 작동되더라고
```

4. 참조 링크
>https://whitepaek.tistory.com/47 : 모듈 생성
> https://velog.io/@dbswns1101/%EC%9E%90%EB%B0%94-%EC%8A%A4%ED%84%B0%EB%94%94-8%EC%A3%BC%EC%B0%A8-10%EC%9E%A5-%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC%EC%99%80-%EB%AA%A8%EB%93%88#2-%EB%AA%A8%EB%93%88 : 디스크립터 관련