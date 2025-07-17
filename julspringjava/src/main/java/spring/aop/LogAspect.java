package spring.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
// @Aspect
public class LogAspect {

  @Pointcut("execution(public * sayHello(..))")
  private void pointcut() {} // 메서드이름으로 ↑ 상단 annotation 객체를 가리킨다.

  @Before("pointcut()")
  public void beforeLogging() {
    System.out.println("**메서드 호출 전**");
  }

  @AfterReturning(pointcut = "pointcut()", returning = "returnValue")
  public void afterLogging(Object returnValue) {
    System.out.println("**메서드 호출 후**");
  }

  @AfterThrowing(pointcut = "pointcut()", throwing = "ex")
  public void throwingLogging(Exception ex) {
    System.out.println("**예외 발생 : " + ex.getMessage() + "**");
  }

  @After("execution(public * *Bye(..))")
  public void alwaysLogging() {
    System.out.println("**항상 실행**");
  }

}
