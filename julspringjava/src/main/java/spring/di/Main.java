package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
  public static void main(String[] args) {
    // 컨테이너 생성 및 설정 파일 수행
    ApplicationContext container = new GenericXmlApplicationContext("ditest.xml");
    
    // bean 가져와서 메서드 실행
    // getBean -> Object 타입으로 꺼내옴 -> Object내의 객체만 사용 가능 -> ("foo", Foo.class)명시로 foo타입의 객체로 꺼내옴.
    Foo f = container.getBean("foo", Foo.class);
    f.doFoo();
  }
}
