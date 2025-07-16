package spring.anno;

import jakarta.annotation.PostConstruct;

public class Bar {
  public void doBar() {
    System.out.println("Bar.doBar() 실행");
  }

  @PostConstruct
  public void start() {
    System.out.println("Bar 초기화 메서드 : start");
  }
}
