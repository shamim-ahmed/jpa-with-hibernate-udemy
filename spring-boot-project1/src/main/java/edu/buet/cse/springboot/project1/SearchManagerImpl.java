package edu.buet.cse.springboot.project1;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchManagerImpl implements SearchManager {
  private final Logger logger = LogManager.getLogger(SearchManagerImpl.class);

  @Autowired
  private SortAlgorithm sortAlgorithm;

  @Override
  public int binarySearch(int[] numbers, int numberToSearchFor) {
    logger.info("The sort algorithm being used is " + sortAlgorithm);
    
    // sort the numbers and then perform binary search
    sortAlgorithm.sort(numbers);
    int index = Arrays.binarySearch(numbers, numberToSearchFor);

    return index;
  }

}
