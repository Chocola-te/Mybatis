package spring.chap01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
    // 컨테이너 만들기 -> xml에 찾아가 bean 생성
		ApplicationContext beanFactory = new GenericXmlApplicationContext("applicationContext.xml");
		WriteArticleService articleService = (WriteArticleService) beanFactory.getBean("writeArticleService");
		articleService.write(new Article());
	}
}