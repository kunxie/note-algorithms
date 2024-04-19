package io.github.kunxie.note.notealgorithms.string;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static java.util.Objects.isNull;

@Slf4j
public class MSDSort {

  public String[] sort(String[] data) {
    if (isNull(data)) {
      return sort(exampleData);
    }
    if (data.length == 0) {
      return new String[0];
    }
    var result = Arrays.copyOf(data, data.length);
    log.info("Before sorting: {}", Arrays.toString(result));

    sort(result, 0, result.length - 1, 0);

    log.info("After sorting: {}", Arrays.toString(result));
    return result;
  }

  private void sort(String[] array, int lo, int hi, int d) {
    if (lo >= hi) {
      return;
    }

    int R = 128;
    var count = new int[R + 2];
    var aux = new String[hi - lo + 1];
    // step 1: get the count
    for (var i = lo; i <= hi; ++i) {
      count[charAt(array[i], d) + 2]++;
    }
    // step 2: transform count to start-index
    for (int i = 1; i < R + 1; ++i) {
      count[i] += count[i - 1];
    }
    // step 3: get the sorted result
    for (int i = lo; i <= hi; ++i) {
      aux[count[charAt(array[i], d) + 1]++] = array[i];
    }
    // step 4: copy back
    System.arraycopy(aux, 0, array, lo, aux.length);
    // step 5: recursively sort each partition
    for (int r = 0; r < R; ++r) {
      sort(array, lo + count[r], lo + count[r + 1] - 1, d + 1);
    }
  }

  int charAt(String str, int index) {
    if (index >= str.length()) {
      return -1;
    }
    return str.charAt(index);
  }

  /**
   * An array of string used for testing MSD sort by default.
   */
  static String[] exampleData = new String[]{
      "she",
      "sells",
      "seashells",
      "by",
      "seashore",
      "the",
      "shells",
      "are",
      "surely",
      "seashells"
  };
}
