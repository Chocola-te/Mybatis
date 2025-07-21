package com.example.controller;

import java.util.ArrayList;
import java.util.List;

// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

// @Controller
@RestController
public class GetDataController {

  @GetMapping("/jsondata")
  // @ResponseBody
  public String getData() {
    List<String> list = new ArrayList<>();
    list.add("melon");
    list.add("fig");
    list.add("복숭아");
    list.add("apple");

    Gson gson = new Gson();
    String jtext = gson.toJson(list); // Java Object -> Json Text

    return jtext;
  }

}
