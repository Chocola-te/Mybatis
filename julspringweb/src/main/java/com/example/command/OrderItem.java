package com.example.command;

import lombok.Data;

@Data
public class OrderItem { // 여러개 주문을 위해 List로 저장

  private Integer itemId; // 물건번호
  private Integer number; // 물건개수?
  private String remark; // 주의사항
  
}