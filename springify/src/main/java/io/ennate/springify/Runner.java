package io.ennate.springify;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext contex=new AnnotationConfigApplicationContext(Application.class);

	Hello h=contex.getBean(Hello.class);
	Hello h1=contex.getBean(Hello.class);
	System.out.println(h==h1);
	
	h.say();
	
	
	
	contex.close();
	}

}
