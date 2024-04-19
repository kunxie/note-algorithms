package io.github.kunxie.note.notealgorithms.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LSDSortTest {

  LSDSort lsdSort;

  @BeforeEach
  void init() {
    this.lsdSort = new LSDSort();
  }

  @Test
  void sort_exampleData() {
    assertTrue(isSorted(lsdSort.sort(null)), "The result array is not sorted");
  }

  /**
   * Checks if an array of strings is sorted in ascending order.
   *
   * @param data The array of strings to be checked.
   * @return {@code true} if the array is sorted in ascending order, {@code false} otherwise.
   */
  boolean isSorted(String[] data) {
    for (int i = 1; i < data.length; i++) {
      if (data[i-1].compareTo(data[i]) > 0) {
        return false;
      }
    }
    return true;
  }
}