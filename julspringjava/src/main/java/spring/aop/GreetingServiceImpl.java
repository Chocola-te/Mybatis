package spring.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("greeting")
// 공통 로직에 관한 부분을 하나도 볼 수 없다 | 공통 로직 호출 코드 없음
public class GreetingServiceImpl implements GreetingService {

  @Value("안녕")
  private String greeting;

  @Override
  public void sayHello(String name) {
    System.out.println("sayHello : " + greeting + " : " + name);
  }

  public void sayBye(String name) throws Exception {
    System.out.println("sayBye : " + greeting + " : " + name);
    throw new Exception("강제 예외 발생");
  }

  public void setGreeting(String greeting) {
    this.greeting = greeting;
  }

}
