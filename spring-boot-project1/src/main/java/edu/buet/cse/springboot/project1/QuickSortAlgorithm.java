package edu.buet.cse.springboot.project1;

import java.util.Arrays;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class QuickSortAlgorithm extends AbstractSortAlgorithm {

  public void sort(int[] numbers) {
    // TODO implement logic for Quick Sort
    Arrays.sort(numbers);
  }
}
