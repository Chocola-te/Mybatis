package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.DeptDao;
import com.example.dto.Dept;
import com.google.gson.Gson;


@Controller
public class DeptController {

  @Autowired
  DeptDao dao; // 구현 객체 주입

  @GetMapping("/")
  public String index() {
      return "index";
  }  

  @GetMapping("dept")
  @ResponseBody
  public String getMethodName() {
    Gson gson = new Gson();
    List<Dept> dlist = dao.deptAll();

    return gson.toJson(dlist);
  }

}
