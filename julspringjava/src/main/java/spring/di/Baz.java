package spring.di;

public class Baz {
  public void doBaz() {
    System.out.println(("Baz.doBaz() 실행"));
  }

  public void start() {
    System.out.println("초기화 메서드 : start");
  }
  
  public void stop() {
    System.out.println("소멸 메서드 : stop");
  }
}
