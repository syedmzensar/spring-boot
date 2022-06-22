
package com.zensar.health.endpoints;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class StudentHealthIndicator implements HealthIndicator {
	private final String message_key = "Student working";

	@Override
	public Health health() {
		if (!isRunningStudent()) {
			return Health.down().withDetail(message_key, "Not Available").build();
		}
		return Health.up().withDetail(message_key, "Available").build();
	}

	private Boolean isRunningStudent() {
		Boolean isRunning = true;
		// Logic Skipped

		return isRunning;
	}

	/*
	 * @Override public Health health() { Random random = new Random();
	 * 
	 * int number = random.nextInt(100);
	 * 
	 * if (number % 2 == 0) { Health.up().build(); } else { Health.down().build(); }
	 * 
	 * return null; }
	 */

}
