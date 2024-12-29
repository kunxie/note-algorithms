package io.github.kunxie.note.notealgorithms.util;

public class SortUtils {

  private SortUtils() {
  }

  /**
   * Checks if the elements of the given array are in ascending order.
   *
   * @param array the array of elements to be checked, can be null or empty
   * @return true if the array is null, has less than two elements, or all elements are in ascending order;
   * false otherwise
   */
  public static <T extends Comparable<T>> boolean isAscend(T[] array) {
    if (array == null || array.length < 2) {
      return true;
    }

    for (var i = 1; i < array.length; i++) {
      if (array[i - 1].compareTo(array[i]) > 0) {
        return false;
      }
    }
    return true;
  }
}
