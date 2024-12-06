package io.github.kunxie.note.notealgorithms.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class QuickSortTest {

  Sort<Integer> sortMethod;

  @BeforeEach
  void init() {
    this.sortMethod = new QuickSort();
  }

  @ParameterizedTest
  @MethodSource("arrayProvider")
  void sort(Integer[] array) {
    logArray("before sort", array);
    sortMethod.sort(array);
    logArray("after sort", array);
    assertTrue(SortUtils.isAscend(array));
  }

  private void logArray(String message, Integer[] array) {
    log.info("{} -- array:{}", message, Arrays.toString(array));
  }

  static Stream<Arguments> arrayProvider() {
    return Stream.of(
        Arguments.of((Object) new Integer[]{1, 2, 3, 4, 5}),
        Arguments.of((Object) new Integer[]{5, 3, 4, 1, 2, 8, 10, 6, 5})
    );
  }
}