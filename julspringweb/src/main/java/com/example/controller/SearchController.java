package com.example.controller;
import java.util.ArrayList;
import java.util.List;

/*
GET: /search/main search/main.html
GET: /search/main search/result.html
*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.command.SearchCommand;
import com.example.command.SearchType;

@Controller
@RequestMapping("/search")
public class SearchController {

  // 컨트롤러 요청이 들어올 때마다 컨트롤러 요청처리보다
  // ※ 먼저 ModelAttribute 어노테이션이 붙은 메서드가 수행된다.
  @ModelAttribute("searchTypeList")
  public List<SearchType> getSearchTypeList() {
    List<SearchType> options = new ArrayList<>();
    options.add(new SearchType(1, "전체"));
    options.add(new SearchType(2, "뉴스"));
    options.add(new SearchType(3, "POST"));
    // code = options의 value | text는 보여질 텍스트

    return options;
  }

  @ModelAttribute("popularQueryList")
  public String[] getPopularQueryList() {
    return new String[]{"python", "AI", "spring"};
  }

  @GetMapping("/main")
  public void main() {}

  /* == ↑ 아래처럼 리턴값의 경로가 GET방식의 uri와 같을 경우 void로 간략히 표현가능
  @GetMapping("/main")
  public String main() {
    return "/search/main";
  }
  */

  @GetMapping("/result")
  public void result(@ModelAttribute("search") SearchCommand search, Model m) {
    // 검색어를 사용해 DB select했다고 가정
    m.addAttribute("result1", "검색 결과1");
    m.addAttribute("result2", "검색 결과2");
    m.addAttribute("result3", "검색 결과3");
  }

}
