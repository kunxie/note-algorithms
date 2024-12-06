package io.github.kunxie.note.notealgorithms.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Utility class provides common utility methods.
 */
public class Utility {


  public static <T> void swap(T[] array, int i, int j) {
    if (i < 0 || i >= array.length || j < 0 || j >= array.length) {
      throw new IllegalArgumentException("Index out of bounds");
    }

    T temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
