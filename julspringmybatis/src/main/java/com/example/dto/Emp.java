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