package spring.di;

public class Foo {
  private Bar bar;
  private Baz baz;

  public Foo(Bar bar, Baz baz) {
    this.bar = bar;
    this.baz = baz;
  }

  public void doFoo() {
    System.out.println("Foo.doFoo() 실행");
    bar.doBar(); // 의존관계
  }
}
