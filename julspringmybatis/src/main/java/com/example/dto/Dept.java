package com.example.dto;

import lombok.Data;

@Data
public class Dept {

  // 컬럼명 == 변수명
  private int deptno;
  private String dname;
  private String loc;

}
