package edu.buet.cse.springboot.project4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProject4Application implements CommandLineRunner {

  private Logger logger = LogManager.getLogger(getClass());

  public static void main(String[] args) {
    SpringApplication.run(SpringBootProject4Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
   
  }
}
