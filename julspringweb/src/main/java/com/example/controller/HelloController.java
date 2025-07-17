package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  @GetMapping("/hello") // 1. 슬래시 hello라는 요청이 들어오면
  @ResponseBody // 4. response에 담아
  public String hello() { // 2. 메서드 실행해
    return "hello spring!"; // 3. 리턴한 값을
  }

}
