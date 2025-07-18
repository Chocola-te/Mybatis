package com.example.command;

import java.util.List;

/* 
GET : article/newArticle -> form화면 출력
                            form에 데이터 입력 후 전송 버튼 클릭
                            post 방식으로 데이터 전송
                            article/newArticle 요청
                                  ↓
POST : article / newArticle : 파라미터 저장
                              view에서 출력
*/

// command 객체 : form 데이터 [저장 공간] 객체

import lombok.Data;

@Data
public class Article {

  // 변수명과 form name 값이 일치 -> 자동 저장
  private String title;
  private String content;

  // 파라미터는 String이지만 기본형 타입은 자동 변환된다.
  private int id;

  // 배열 또는 List로 선언
  // private List<String> pet;
  private String[] pet;

}
