package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.dto.Dept;

// Mapper 어노테이션은 메인 클래스가 위치한 패키지나
// 하위 패키지에 있을 때만 구현객체를 생성한다.
// com.example 하위와 같은 위치
// controller / dao / dto / service / JulspringmybatisApplication.java
@Mapper
public interface DeptDao {

  @Select("select * from dept")
  List<Dept> deptAll();
  
}
