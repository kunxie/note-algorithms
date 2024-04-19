package io.github.kunxie.note.notealgorithms.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {

  @Test
  void copy() {
    var testArray = new String[]{"a", "b", "c"};
    var copiedArray = Utility.copy(testArray);

    // not the same array
    assertNotSame(testArray, copiedArray);
    // but same content
    assertArrayEquals(testArray, copiedArray);
  }

  @Test
  void isSortByAsc() {
    var unsortedArray = new String[]{"c", "b", "c"};
    assertFalse(Utility.isSortByAsc(unsortedArray));

    var sortedArray = new String[]{"a", "b", "c"};
    assertTrue(Utility.isSortByAsc(sortedArray));
  }
}
