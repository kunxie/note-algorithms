package io.github.kunxie.note.notealgorithms.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class UtilityTest {

  @Test
  void isSortByAsc() {
    var unsortedArray = new String[]{"c", "b", "c"};
    assertFalse(Utility.isSortByAsc(unsortedArray));

    var sortedArray = new String[]{"a", "b", "c"};
    assertTrue(Utility.isSortByAsc(sortedArray));
  }
}
