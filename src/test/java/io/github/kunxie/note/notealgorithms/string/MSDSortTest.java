package io.github.kunxie.note.notealgorithms.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.github.kunxie.note.notealgorithms.util.Utility.isSortByAsc;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MSDSortTest {

  MSDSort msdSort = new MSDSort();

  @BeforeEach
  void init() {
    this.msdSort = new MSDSort();
  }

  @Test
  void sort_exampleData() {
    assertTrue(isSortByAsc(msdSort.sort(null)), "The result array is not sorted");
  }
}
