package spring.di;

public class Foo {
  private Bar bar;
  private Baz baz;

  int i;
  String str;

  public Foo(Bar bar, Baz baz) {
    this.bar = bar;
    this.baz = baz;
  }

    public Foo(Bar bar, Baz baz, int i, String str) {
    this.bar = bar;
    this.baz = baz;
    this.i = i;
    this.str = str;
  }

  public void doFoo() {
    System.out.println("Foo.doFoo() 실행");
    bar.doBar(); // 의존관계
    System.out.println(i + " : " + str);
  }
}
