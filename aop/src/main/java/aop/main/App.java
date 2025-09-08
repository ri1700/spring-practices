package aop.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.domain.Product;
import aop.service.ProductService;

public class App {

	public static void main(String[] args) {
		test01();
	}
	
	public static void test01() {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		ProductService ps = new ProductService();
		Product p = ps.find("TV");
		System.out.println(p);

		((ConfigurableApplicationContext)ac).close();
	}

}