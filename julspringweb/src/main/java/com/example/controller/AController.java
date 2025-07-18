package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// GET: /a AController - a() -a/a.html
// 화면에 a.html문서 실행중 출력

@Controller
public class AController {

  @GetMapping("/a")
  public String a() {
    return "a/a";
  }

}
