package io.github.kunxie.note.notealgorithms.sort;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class SortUtilsTest {

  @ParameterizedTest
  @MethodSource("arrayProvider")
  void testIsAscend(Integer[] array, boolean expected) {
    assertEquals(expected, SortUtils.isAscend(array));
  }

  static Stream<Arguments> arrayProvider() {
    return Stream.of(
        Arguments.of(new Integer[]{}, true),
        Arguments.of(new Integer[]{1}, true),
        Arguments.of(new Integer[]{1, 2, 3, 4, 5}, true),
        Arguments.of(new Integer[]{5, 3, 4, 1, 2}, false)
    );
  }
}