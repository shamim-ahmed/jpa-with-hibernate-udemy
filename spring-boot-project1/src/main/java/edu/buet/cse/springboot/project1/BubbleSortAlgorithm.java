package edu.buet.cse.springboot.project1;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class BubbleSortAlgorithm extends AbstractSortAlgorithm {

  public void sort(int[] numbers) {
    // TODO implement bubble sort algorithm
    Arrays.sort(numbers);
  }
}
