package spring.anno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

 // bean으로 생성되기는 하지만 직접 사용하는 것이 아니라
 // bean설정 정보를 담기 위해 있는 클래스(@Bean과 같이 다님)
@Configuration               
public class Baz {

  // Bean 등록이 되는 순간 자동으로 메서드가 실행됨
  @Bean
  public Foo makeFoo() {
    Foo f = new Foo(); // new로 만들면 주입이 안된다.
    System.out.println(f.str); // null
    return f; // 컨테이너에 등록
  }

}
