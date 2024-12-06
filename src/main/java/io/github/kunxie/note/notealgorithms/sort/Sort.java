package io.github.kunxie.note.notealgorithms.sort;

@FunctionalInterface
public interface Sort<T extends Comparable<T>> {

  /**
   * Sorts the specified array in ascending order based on natural ordering
   * of its elements.
   *
   * @param array the array to be sorted, containing elements that extend
   *              Comparable. The array can be null or empty, in which case
   *              no sorting is required.
   */
  void sort(T[] array);
}
