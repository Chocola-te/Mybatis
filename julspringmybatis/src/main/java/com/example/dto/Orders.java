package com.example.dto;

import lombok.Data;

@Data
public class Orders {

  private int orderid;
  private int custid;
  private int bookid;
  private int saleprice;
  private String orderdate;

}
