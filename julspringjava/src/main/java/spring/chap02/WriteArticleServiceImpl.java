package spring.chap02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("writeArticleService")
public class WriteArticleServiceImpl implements WriteArticleService {

  @Autowired
  @Qualifier("Oracle")
  private ArticleDao articleDao;

  /*
  // 생성자를 통해 자손 타입 bean 주입
  public WriteArticleServiceImpl(ArticleDao articleDao) {
    this.articleDao = articleDao;
  }
  */

  public void write(Article article) {
    System.out.println("WriteArticleServiceImpl.write() 메서드 실행");
    articleDao.insert(article); // 오버라이딩 된 메서드(Sub) 실행
  }

}