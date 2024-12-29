package io.github.kunxie.note.notealgorithms.util;

/**
 * A utility class that provides common operations.
 */
public class CommonUtils {


  /**
   * Swaps the elements at the specified positions in the specified array.
   *
   * @param <T>   the type of elements in the array
   * @param array the array in which to swap elements
   * @param i     the index of the first element to be swapped
   * @param j     the index of the second element to be swapped
   * @throws IllegalArgumentException if either index is out of bounds
   */
  public static <T> void swap(T[] array, int i, int j) {
    if (i < 0 || i >= array.length || j < 0 || j >= array.length) {
      throw new IllegalArgumentException("Index out of bounds");
    }

    T temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
