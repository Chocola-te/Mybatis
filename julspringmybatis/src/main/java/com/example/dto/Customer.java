package com.example.dto;

import lombok.Data;

@Data
public class Customer {

  private int custid;
  private String name;
  private String address;
  private String phone;

  private Orders orders;
  private Book book;
}
