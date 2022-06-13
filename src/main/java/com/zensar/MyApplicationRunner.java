package com.zensar;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {

	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println(" In Application runner ");
		
	}

}
