package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// RequstMapping, GetMapping 모두 Controller 어노테이션이 있어야 작동
@Controller
// RequestMapping 앞 경로 (공통적으로 겹치는 부분)
// GetMapping 뒤 경로
@RequestMapping("/test")
public class HelloController {

  @GetMapping("/hello") // 1. /hello라는 요청이 들어오면
  @ResponseBody // 4. ResponseBody에 담아 그대로 출력
  public String hello() { // 2. 메서드 실행해 (메서드 명은 상관없음)
    return "hello 스프링!"; // 3. 리턴한 값을
  }

  // @GetMapping 괄호가 없으면 RequestMapping("/test")의 /test 경로에서 동작한다.
  @GetMapping("/hello2")
  // @ResponseBody // 리턴값을 응답정보에 담아 바로 client에 전달
                   // ResponseBody가 없으면 리턴값은 view name이 된다.
  public String hello2(Model m) {
    m.addAttribute("name", "김자바");
    
     // view name - templates하위 폴더부터 파일명까지 입력
     // 해당 view 파일 찾아가서 실행
    return "view/hello2";
  }

}
