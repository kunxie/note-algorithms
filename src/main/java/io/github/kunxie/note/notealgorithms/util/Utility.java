package io.github.kunxie.note.notealgorithms.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Utility class provides common utility methods.
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.NONE)
public class Utility {

  /**
   * Copies the contents of an array of strings.
   *
   * @param array The array of strings to be copied.
   * @return A new array with the same contents as the input array.
   */
  public static String[] copy(String[] array) {
    assert array != null;

    var result = new String[array.length];
    System.arraycopy(array, 0, result, 0, array.length);
    return result;
  }

  /**
   * Checks if an array of strings is sorted in ascending order.
   *
   * @param array The array of strings to be checked.
   * @return {@code true} if the array is sorted in ascending order, {@code false} otherwise.
   */
  public static boolean isSortByAsc(String[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i - 1].compareTo(array[i]) > 0) {
        log.warn("{index: {}, value: {}} > {index: {}, value: {}}", i-1, array[i-1], i, array[i]);
        return false;
      }
    }
    return true;
  }
}
