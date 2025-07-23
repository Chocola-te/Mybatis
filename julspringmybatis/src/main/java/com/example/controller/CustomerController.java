package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dao.CustomerDao;
import com.example.dto.Book;
import com.example.dto.Customer;
import com.google.gson.Gson;


@Controller
public class CustomerController {

  @Autowired
  CustomerDao dao;

  @GetMapping("/get/info")
  public String info(Model m1, Model m2) {
    List<Book> blist = dao.bookinfo();
    m1.addAttribute("blist", blist);
    List<Customer> clist = dao.customerinfo();
    m2.addAttribute("clist", clist);
    return "emp/info";
  }

  @GetMapping("/get/info/{custid}")
  public String infocustomer(@PathVariable("custid") int id, Model m, Model n, Model t) {
    List<Map<String, Object>> list = dao.info(id);
    m.addAttribute("list", list);

    String name = dao.name(id);
    n.addAttribute("name", name);

    Map<String, Object> total = dao.infocustomer(id);
    t.addAttribute("total", total);

    return "emp/infocustomer";
  }
  

}
