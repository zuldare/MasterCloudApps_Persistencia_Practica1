package jh.mastercloud.persistence.relational_persistence;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DatabaseLoader implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("==================================");
		System.out.println("Testing application DatabaseLoader");
		System.out.println("==================================");
	}
}
