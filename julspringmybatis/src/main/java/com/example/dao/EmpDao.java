package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.dto.Emp;

@Mapper
public interface EmpDao {
    @Select({"select empno, dname as 'dept.dname', ename, job, hiredate from"
    ,"emp inner join dept on emp.deptno = dept.deptno"
    ,"where ename like concaT('%', #{parameter}, '%')"})
    // SQL문이 길다면 ""쌍따옴표와 {}중괄호로 배열화하여 나눠서 기재할 수 있다.
    List<Emp> searchName(String name); // 값이 하나라면 매개변수의 이름이 달라도 된다.
}

// @Mapper
// public interface EmpDao {

//   @Select("SELECT * FROM emp NATURAL JOIN dept WHERE ename LIKE concat('%', #{name}, '%')")
//   List<Emp> search(String name);

// }
