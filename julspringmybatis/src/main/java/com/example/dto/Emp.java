package com.example.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Emp { //(자식 : n)
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private double sal;
	private double comm;
	private int deptno;
	
	private Dept dept;//(부모 : 1)
}

// @Data
// public class Emp {

//   private int empno; // 사원번호
//   private int deptno; // 부서명
//   private String ename; // 사원명
//   private String job; // 직급
//   private String hiredate; // 입사일

// }