package com.zensar.info.endpoints;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class StudentInfoEndpoint implements InfoContributor {

	@Override
	public void contribute(Builder builder) {

		Map<String, String> studentDetails = new HashMap<>();
		studentDetails.put("Name", "Syed");
		studentDetails.put("Date", "22 June 2022");

//		builder.withDetail("Name", "Syed");
//		builder.withDetail("Date", "22 june 2022");

	}

}
