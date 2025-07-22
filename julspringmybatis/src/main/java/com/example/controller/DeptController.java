package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.DeptDao;
import com.example.dto.Dept;
import com.example.service.DeptService;
// import com.google.gson.Gson;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;

// RequestBody는 index에서 공통 경로있을 때 명시
// 화면에 return값을 그대로 표기하는 ResponseBody를 @Controller에서 합쳐 표기하는 RestController
@Controller
public class DeptController {

  @Autowired
  DeptDao dao; // 구현 객체 주입

  @Autowired
  DeptService service;

  @GetMapping("/")
  public String index() {
    return "index";
  }

  /* 
  ResponseBody로 return값 화면에 그대로 출력
  
  @GetMapping("dept")
  @ResponseBody
  public String getMethodName() {
    Gson gson = new Gson();
    List<Dept> dlist = dao.deptAll();
  
  return gson.toJson(dlist);
  }
  */

  @GetMapping("/dept")
  public String getMethodName(Model m) {
    // 1. DB에서 모든 부서 정보 가져와서
    List<Dept> dlist = dao.deptAll();

    // 2. 모델에 추가
    m.addAttribute("dlist", dlist);

    // view에서 출력
    return "dept/list";
  }

  // 부서 추가
  // GET: /insert DeptController form() dept/insert.html
  @GetMapping("/insert")
  public String form() {
    return "dept/insert";
  }

  // POST: /insert DeptController insert() redirect:/dept
  @PostMapping("/insert")
  public String insert(Dept dept) {
    // DB insert 작업
    service.insert(dept);
    return "redirect:/dept";
  }

  // 부서명 클릭 시 해당 부서 근무지 수정
  // GET: /update/{no} DeptController updateForm() dept/update.html :form에 loc
  // 입력(부서번호 hidden)
  @GetMapping("/update/{no}")
  public String updateForm(@PathVariable("no") int deptno, Model m) {
    m.addAttribute("deptno", deptno);
    return "dept/update";
  }

  // PUT: /update DeptController update() redirect:/dept :부서번호와 근무지 받아서 근무지 수정
  @PutMapping("/update")
  public String update(@ModelAttribute("deptno") int deptno, @RequestParam("loc") String loc) {
    dao.update(deptno, loc);
    return "redirect:/dept";
  }

  @DeleteMapping("/delete/{no}")
  public String delete(@PathVariable("no") int deptno) {
    // delete
    return "redirect:/dept";
  }

}
