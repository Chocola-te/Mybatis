package com.example.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.dto.Book;
import com.example.dto.Customer;

@Mapper
public interface CustomerDao {
  
  @Select("SELECT * FROM book")
  List<Book> bookinfo();

  @Select("SELECT * FROM customer")
  List<Customer> customerinfo();

  @Select("SELECT name FROM customer WHERE custid = #{custid}")
  String name(int custid);

  @Select("SELECT bookname, saleprice, orderdate FROM book natural join customer natural join orders WHERE custid = #{custid}")
  List<Map<String, Object>> info(int custid);

  @Select("select sum(saleprice) as sumprice, count(bookname) as bookcount from book natural join customer natural join orders where custid = #{custid}")
  Map<String, Object> infocustomer(int custid);

}
