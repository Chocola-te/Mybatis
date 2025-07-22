package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dao.EmpDao;
import com.example.dto.Emp;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/name")
public class EmpController {

    @Autowired
    EmpDao dao;

    @GetMapping("/search")
    public String form() {
        return "emp/search";
    }
    
    @GetMapping("/result1")
    public String result(@ModelAttribute("name") String name, Model m ) {
        
        List<Emp> elist = dao.searchName(name);
        m.addAttribute("elist", elist);
        m.addAttribute("size", elist.size());
        return "emp/result";
    }

    @GetMapping("/searchE")
    public String search() {
        return "emp/searchE";
    }
    
    

}

// @Controller
// @RequestMapping("/name")
// public class EmpController {

//   @Autowired
//   EmpDao dao;

//   @GetMapping("/search")
//   public String form() {
//     return "emp/search";
//   }

//   @GetMapping("/result1")
//   public String result(String name, Model m) {
//     List<Emp> elist = dao.search("name");
//     m.addAttribute("elist", elist);
//     return "emp/result";
//   }

// }
