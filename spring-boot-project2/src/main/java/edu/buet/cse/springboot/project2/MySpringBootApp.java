package edu.buet.cse.springboot.project2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MySpringBootApp {

  public static void main(String[] args) {
    ApplicationContext appContext = SpringApplication.run(MySpringBootApp.class, args);

    for (String name : appContext.getBeanDefinitionNames()) {
      System.out.println(name);
    }
  }
}
