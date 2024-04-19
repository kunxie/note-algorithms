package io.github.kunxie.note.notealgorithms.string;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static java.util.Objects.isNull;

/**
 * KeyIndexCounting class implements the key-index counting algorithm
 * for sorting an array of items based on their keys.
 */
@Slf4j
public class KeyIndexCounting {

  /**
   * Runs key-index counting on the given array of items.
   * If the input array is null, it runs key-index counting on exampleData.
   *
   * @param data The array of items to perform key-index counting on. (immutable)
   * @return The sorted array of items.
   */
  public Item[] sort(Item[] data) {
    if (isNull(data)) {
      return sort(exampleData);
    }
    if (data.length == 0) {
      return new Item[0];
    }

    int[] count = new int[6];

    for (var item : data) {
      // store key at count[key+1], making easier to convert to index
      // since the start-index for key is the sum[0...(key-1)]
      count[item.key() + 1]++;
    }
    log.info("step 1: after counted index: {}", Arrays.toString(count));

    for (var i = 1; i < count.length; i++) {
      count[i] += count[i - 1];
    }
    log.info("step 2: after transformed to index: {}", Arrays.toString(count));

    var result = new Item[data.length];
    for (var item : data) {
      result[count[item.key()]++] = item;
    }
    log.info("step 3: after sorted: {}", Arrays.toString(result));
    return result;
  }

  /**
   *
   */
  static final int RADIX = 4;

  /**
   * An array of items used for testing key-index counting by default.
   */
  static Item[] exampleData = new Item[]{
      new Item(2, "Anderson"),
      new Item(3, "Brown"),
      new Item(3, "Davis"),
      new Item(4, "Garcia"),
      new Item(1, "Harris"),
      new Item(3, "Jackson"),
      new Item(4, "Johnson"),
      new Item(3, "Jones"),
      new Item(1, "Martin"),
      new Item(2, "Martinez"),
      new Item(2, "Miller"),
      new Item(1, "Moore"),
      new Item(2, "Robinson"),
      new Item(4, "Smith"),
      new Item(3, "Taylor"),
      new Item(4, "Thomas"),
      new Item(4, "Thompson"),
      new Item(2, "White"),
      new Item(2, "Williams"),
      new Item(4, "Wilson"),
  };
}
