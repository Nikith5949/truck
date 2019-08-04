package io.ennate.springify;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class Hello {

	public Hello() {
		System.out.println("helllo constructor");
	}
	public void say() {
		System.out.println("helllo");
	}
	
}
