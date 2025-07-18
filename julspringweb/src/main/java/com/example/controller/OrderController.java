package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.command.OrderCommand;

@Controller
@RequestMapping("/order/order")
public class OrderController {

  @GetMapping
  public String form() {
    return "order/orderForm";
  }

  @PostMapping
  public String submit(@ModelAttribute("order") OrderCommand order) {
    return "order/submit";
  }
  
}