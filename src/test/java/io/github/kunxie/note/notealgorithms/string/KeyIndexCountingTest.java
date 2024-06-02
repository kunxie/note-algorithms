package io.github.kunxie.note.notealgorithms.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class KeyIndexCountingTest {

  KeyIndexCounting keyIndexCounting;

  @BeforeEach
  void setUp() {
    keyIndexCounting = new KeyIndexCounting();
  }

  @Test
  void sort_exampleData() {
    assertTrue(sortedItemArray(keyIndexCounting.sort(null)), "The result array is not sorted");
  }

  /**
   * Checks if the given array of items is sorted in ascending order based on their key value.
   *
   * @param data The array of items to be checked. (immutable)
   * @return {@code true} if the array is sorted in ascending order, {@code false} otherwise.
   */
  boolean sortedItemArray(Item[] data) {
    for (var i = 1; i < data.length; i++) {
      if (data[i - 1].key() > data[i].key()) {
        return false;
      }
    }
    return true;
  }
}
