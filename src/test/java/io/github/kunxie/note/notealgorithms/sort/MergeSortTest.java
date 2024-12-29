package io.github.kunxie.note.notealgorithms.sort;

import io.github.kunxie.note.notealgorithms.util.SortUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class MergeSortTest {

  List<Sort<Integer>> sortMethods;

  @BeforeEach
  void init() {
    this.sortMethods = List.of(
        new QuickSort(),
        new MergeSort(),
        new HeapSort()
    );
  }

  @ParameterizedTest
  @MethodSource("arrayProvider")
  void sort(Integer[] array) {
    for (Sort<Integer> sortMethod : sortMethods) {
      logArray(sortMethod.getClass().getName() + " - before sort", array);
      sortMethod.sort(array);
      logArray(sortMethod.getClass().getName() + " - after sort", array);
      assertTrue(SortUtils.isAscend(array));
    }
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