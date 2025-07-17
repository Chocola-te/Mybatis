package spring.aop;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

  @Pointcut("execution(* spring.aop.GreetingService.*(..))")
  private void pointcut() {}

  @Around("pointcut()")
  public Object timeCheck(ProceedingJoinPoint joinPoint) {

    Signature s = joinPoint.getSignature();
    String methodName = s.getName();
    long start = System.nanoTime();
    long end = System.nanoTime();

    System.out.println("METHOD before : " + methodName + " time check start");

    Object obj = null;

    try {
      obj = joinPoint.proceed(); // 호출한 핵심 로직 메서드 실행
                                 // 끝나면 돌아와서 남은 작업 수행
    } catch (Throwable e) {
      System.out.println("METHOD error : " + methodName);
    }
    
    System.out.println("METHOD after : " + methodName + " time check end");
    System.out.println("METHOD " + methodName + "processing time is " + (end - start) + "ns");
    
    return obj;
  }
}
