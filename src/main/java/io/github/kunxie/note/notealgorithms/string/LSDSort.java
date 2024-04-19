package io.github.kunxie.note.notealgorithms.string;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static java.util.Objects.isNull;

/**
 * Least-Significant-digit first (LSD) String sort
 * <p>
 * for Strings with same length
 */
@Slf4j
public class LSDSort {

  public String[] sort(String[] data) {
    if (isNull(data)) {
      return sort(exampleData);
    }
    if (data.length == 0) {
      return new String[0];
    }

    var result = Arrays.copyOf(data, data.length);
    log.info("Before LSD sort: {}", Arrays.toString(result));

    var count = new int[128 + 1]; // assume using ASCII 128 chars (0~127)
    var aux = new String[data.length]; // used for storing the result in the middle

    // sort by char from right to left
    for (var i = data[0].length() - 1; i >= 0; --i) {
      // step 1: get the count
      for (var item : result) {
        count[item.charAt(i) + 1]++;
      }
      // step 2: transfer count to start-index
      for (var j = 1; j < count.length; ++j) {
        count[j] += count[j - 1];
      }
      // step 3: sort with start-index
      for (var item : result) {
        aux[count[item.charAt(i)]++] = item;
      }
      // prepare for next iteration
      System.arraycopy(aux, 0, result, 0, aux.length);
      Arrays.fill(count, 0);
    }
    log.info("After LSD sort: {}", Arrays.toString(result));
    return result;
  }

  /**
   * An array of string used for testing LSD sort by default.
   */
  static String[] exampleData = new String[]{
      "4PGC938",
      "2IYE230",
      "3CI0720",
      "1ICK750",
      "4JZY524",
      "1ICK750",
      "3CI0720",
      "10HV845",
      "10HV845",
      "2RLA629",
      "2RLA629",
      "3ATW723"};
}
