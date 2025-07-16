package spring.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import jakarta.annotation.PreDestroy;

public class Foo {
  @Autowired
  Bar bar;

  @Value("Hello") // 기본형, 문자열 변수에 값 저장
  String str;

  public void doFoo() {
    System.out.println("Foo.doFoo() 실행");
    bar.doBar();
    System.out.println("str : " + str);
  }

  @PreDestroy
  public void stop() {
    System.out.println("Foo 소멸 메서드 : stop");
  }
}
