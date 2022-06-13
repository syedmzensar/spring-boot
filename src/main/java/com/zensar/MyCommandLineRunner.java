package com.zensar;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

	public void run(String... args) throws Exception {
		System.out.println(" In Command line runner ");
		
	}

}
