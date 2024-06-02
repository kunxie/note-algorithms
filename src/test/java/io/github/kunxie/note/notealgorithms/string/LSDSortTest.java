package io.github.kunxie.note.notealgorithms.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.github.kunxie.note.notealgorithms.util.Utility.isSortByAsc;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LSDSortTest {

  LSDSort lsdSort;

  @BeforeEach
  void init() {
    this.lsdSort = new LSDSort();
  }

  @Test
  void sort_exampleData() {
    assertTrue(isSortByAsc(lsdSort.sort(null)), "The result array is not sorted");
  }
}
