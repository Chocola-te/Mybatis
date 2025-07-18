package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.command.Article;
import com.example.service.ArticleService;

@Controller
@RequestMapping("article/newArticle")
public class NewArticleController {
  
  @Autowired
  ArticleService service;

  @GetMapping
  public String form() {
    return "article/form";
  }

  @PostMapping
  public String submit(Article article) {
    
    // @Data로 toString 오버라이드되어있으니
    // 제대로 값이 출력되는지 확인용
    // submit.html 구축 전이라 입력값이 웹페이지가 아닌 Terminal에 출력됨.
    System.out.println(article);

    // 1. Dispatcher Servelet이 Article객체 생성, 주소값 전달(DS가 일종의 컨테이너라고 생각)
    // 2. Mapping 어노테이션이 파라미터 값을 저장(이름 맞춰서 ex)Article)
    // 3. DS이 생성한 객체는 Model데이터로 추가됨 -> view로 전달
    //    Model의 이름은 Type이름을 소문자로 지정한다.
    //    ex)Article객체 > article model명(submit.html에서 [[${article.}]])
    service.printArticle(article);
    return "article/submit";
  }

  /*
  Model의 이름을 바꾸는 방법
  public String submit(@ModelAttribute("command") Article a) {}
  ModelAttribute를 사용하면 객체명 > 소문자 변환 article이 아닌
  "command"로 지정되어 넘어간다.
  
  이름을 변경하면 submit.html에서 값을 꺼낼 때 article.이 아닌
  command.title, command.content로 변경해야 한다.
  */

  // @PostMapping
  // public String submit2(@ModelAttribute("command") Article a) {
  //   return "article/submit";
  // }

}
