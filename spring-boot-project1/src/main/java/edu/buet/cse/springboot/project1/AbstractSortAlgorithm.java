package edu.buet.cse.springboot.project1;

public abstract class AbstractSortAlgorithm implements SortAlgorithm {

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }
}
