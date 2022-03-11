package edu.buet.cse.springboot.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootProject1Application {
  private static final Logger logger = LogManager.getLogger(SpringBootProject1Application.class);

  public static void main(String[] args) {
    ApplicationContext appContext =
        SpringApplication.run(SpringBootProject1Application.class, args);

    for (String name : appContext.getBeanDefinitionNames()) {
      logger.info("Bean name is: " + name);
    }
  }
}
