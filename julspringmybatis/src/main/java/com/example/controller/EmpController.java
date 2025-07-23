package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.EmpDao;
import com.example.dto.Dept;
import com.example.dto.Emp;
import com.google.gson.Gson;

@Controller
// @RequestMapping("/name")
public class EmpController {

  @Autowired
  EmpDao dao;

  @GetMapping("/name/search")
  public String form() {
    return "emp/search";
  }

  @GetMapping("/name/result1")
  public String result(@ModelAttribute("name") String name, Model m) {

    List<Emp> elist = dao.searchName(name);
    m.addAttribute("elist", elist);
    m.addAttribute("size", elist.size());
    return "emp/result";
  }
  // -------------------------------------------------------------------
  // 나는 view에 들어갈 GET: /search와 List에 담을 GET: /dsearch를 따로 작성했었고
  // return을 redirect나 동일 view를 return했는데 굳이 그럴 필요 없이
  // 애초에 search2 view에 들어갈 때 List에 담아주면 view에서 바로 사용이 가능
  @GetMapping("/select/dept")
  public String depts(Model m) {
      List<Dept> dlist = dao.depts();
      m.addAttribute("dlist", dlist);
      return "emp/search2";
  }

  @GetMapping("/select/emps/{deptno}")
  @ResponseBody
  public String emps(@PathVariable("deptno") int deptno) {
      List<Map<String, Object>> elist = dao.emps(deptno);
      // empno는 int, ename은 String이므로 Map을 Object타입으로 선언해주었다.
      Gson gson = new Gson();

      return gson.toJson(elist);
      // Java Object를 JSON문자열로 변환
  }

  @GetMapping("/select/emp/{empno}")
  @ResponseBody
  public String empOne(@PathVariable("empno") int empno) {
      Emp emp = dao.empOne(empno);
      Gson gson = new Gson();

      return gson.toJson(emp);
      // {변수명:값, 변수명:값, ...}
  }

}