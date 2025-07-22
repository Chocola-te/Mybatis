package com.example.dao;

import java.util.List;

// Google Mybatis 이전의 이름 - ibatis
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.dto.Dept;

// Mapper 어노테이션은 메인 클래스가 위치한 패키지나
// 하위 패키지에 있을 때만 구현객체를 생성한다.
// com.example 하위에서 같은 위치
// controller / dao / dto / service / JulspringmybatisApplication.java
@Mapper
public interface DeptDao {

  // 인터페이스는 추상메서드만 가져야한다.
  @Select("select * from dept")
  List<Dept> deptAll();

  @Select("SELECT max(deptno) + 10 FROM dept")
  int getNwno();
  
  @Insert("INSERT INTO dept VALUES(#{deptno}, #{dname}, #{loc})")
  // 여러 데이터가 존재하는 DTO
  int insert(Dept dept);
  // 전달받은 값이 DTO라면 SQL문을 #{변수명}으로 인식한다. @Param으로 각각 X
  // 전달받은 값이 Map타입이라면 #{key}로 인식한다.

  @Update("UPDATE dept SET loc = #{loc} WHERE deptno = ${deptno}")
  int update(@Param("deptno") int deptno, @Param("loc") String loc);

  @Delete("DELETE FROM dept WHERE deptno = #{deptno}")
  int delete(int deptno); // 한개만 보내는 경우 이름 필요 없음

}
