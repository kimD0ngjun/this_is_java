# transaction

<span style='font-size: larger; color: #dcffe4;'>기능 처리의 최소 단위</span>

>**최소 단위**란?<br />
><br />
>분리할 수 없는 소작업<br />
>이 **소작업들을 전부 하나로 본다**는 의미
 
>예를 들어서, 계좌 이체는 <span style='color:#dcffe4'>출금 작업</span>과 <span style='color:#dcffe4'>입금 작업</span>으로 구성된
> **트랜잭션**이라고 볼 수 있다.<br />
> <br />
> <span style='color:#dcffe4'>트랜잭션은 소작업들이 전부 성공하거나 실패해야만 한다.</span> 어느 하나만 성공하고 다른 것은 실패하거나
> 어느 하나만 실패하고 다른 것은 성공하는 경우가 발생해서는 안 된다.
> <br />
> <br />
> 계좌 이체의 경우에서도 입금이 실패했는데, 출금이 성공하는 모순적인 상황이 발생할 수는 없는 것을 생각하면 되겠다.

```java
Connection conn = null;

try {
    //트랜잭션 시작
        
    conn.setAutoCommit(false); // 소작업 별도 처리 방지를 위한 자동 커밋 끄

    // 소작업 처리    
        
    conn.commit(); // 소작업들 전부 성공 처리

    //트랜잭션 종료 
} catch (Exception e) {
    try {
        //롤백 -> 모두 실패 처리
        conn.rollback();
    } catch (SQLException e1) {}
} finally {
    if(conn != null) {
        try {
            //원래대로 자동 커밋 기능 켜기
            conn.setAutoCommit(true);
            
            conn.close(); //연결 끊기
        } catch (SQLException e) {}
}
```