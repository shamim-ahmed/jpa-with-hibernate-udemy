package edu.buet.cse.springboot.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MySpringBootApp {

  private static final Logger logger = LogManager.getLogger(MySpringBootApp.class);

  public static void main(String... args) {
    ApplicationContext appContext = SpringApplication.run(MySpringBootApp.class, args);
    SearchManager searchManager = appContext.getBean(SearchManager.class);

    int[] inputValues = {9, 5, 7, 1, 3};
    int n = 3;
    int index = searchManager.binarySearch(inputValues, n);
    logger.info(String.format("The index for item %d is %d%n", n, index));
  }
}
