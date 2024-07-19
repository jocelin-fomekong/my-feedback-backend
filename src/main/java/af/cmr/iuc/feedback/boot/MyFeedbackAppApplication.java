package af.cmr.iuc.feedback.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"af.cmr.iuc.feedback.entities"})
@EnableJpaRepositories(basePackages = {"af.cmr.iuc.feedback.repository"})
@ComponentScan(basePackages = {"af.cmr.iuc.feedback"})
public class MyFeedbackAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFeedbackAppApplication.class, args);
	}

}
