package io.github.kunxie.note.notealgorithms.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Utility class provides common utility methods.
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.NONE)
public class Utility {

  /**
   * Checks if an array of strings is sorted in ascending order.
   *
   * @param array The array of Comparable objects to be checked.
   * @return {@code true} if the array is sorted in ascending order, {@code false} otherwise.
   */
  public static <T extends Comparable<T>> boolean isSortByAsc(T[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i - 1].compareTo(array[i]) > 0) {
        log.warn("{index: {}, value: {}} > {index: {}, value: {}}", i - 1, array[i - 1], i, array[i]);
        return false;
      }
    }
    return true;
  }
}
