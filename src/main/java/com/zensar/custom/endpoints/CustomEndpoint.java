package com.zensar.custom.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Endpoint(id = "custom")
@Component
public class CustomEndpoint {

	List<String> javaVersion = new ArrayList<String>();

	public CustomEndpoint() {

		javaVersion.add("Java 1.8");
		javaVersion.add("Java 8");
		javaVersion.add("Java 11");
		javaVersion.add("Java 17");
	}

	@ReadOperation
	public List<String> getJavaVersion() {

		return javaVersion;
	}

	@WriteOperation
	public List<String> setJavaVersion(@Selector String version) {
		javaVersion.add(version);
		return javaVersion;
	}

	@DeleteOperation
	public List<String> deleteJavaVersion(@Selector int index) {
		javaVersion.remove(index);
		return javaVersion;
	}
}
