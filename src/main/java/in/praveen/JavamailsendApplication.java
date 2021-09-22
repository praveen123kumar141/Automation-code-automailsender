package in.praveen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JavamailsendApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavamailsendApplication.class, args);
	}

}
