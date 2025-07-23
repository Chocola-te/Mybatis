package com.example.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.dto.Dept;
import com.example.dto.Emp;

@Mapper
public interface EmpDao {

    @Select({"select empno, dname as 'dept.dname', ename, job, hiredate from"
    ,"emp inner join dept on emp.deptno = dept.deptno"
    ,"where ename like concaT('%', #{parameter}, '%')"})
    // SQL문이 길다면 ""쌍따옴표와 {}중괄호로 배열화하여 나눠서 기재할 수 있다.
    List<Emp> searchName(String name); // 값이 하나라면 매개변수의 이름이 달라도 된다.
    
    // category 1 depth
    @Select("select deptno, dname from dept")
    List<Dept> depts(); 
    
    // category 2 depth
    @Select("select empno, ename from emp where deptno =#{deptno}")
    List<Map<String,Object>> emps(int deptno);
    // Map을 걸어주면 key:컬럼명,  value:값 으로 자동 저장된다.
    // [{empno:7788, ename:"SCOTT"}, {empno:123, ename:"JONES"}, ...]
    // Emp DTO에 있는 모든 컬럼을 사용하기엔 데이터 낭비?
    
    // match category emp search
    @Select("select * from emp where empno = #{empno}")
    Emp empOne(int empno);

}