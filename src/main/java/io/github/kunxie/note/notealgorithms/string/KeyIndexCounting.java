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
  public Item[] run(Item[] data) {
    if (isNull(data)) {
      return run(exampleData);
    }
    if (data.length == 0) {
      return new Item[0];
    }

    int[] count = new int[6];

    for (Item item : data) {
      // store key at count[key+1], making it convenient for step 2
      count[item.key()+1]++;
    }
    log.info("step 1: after counted index: {}", Arrays.toString(count));

    for (int i = 1; i < count.length; i++) {
      count[i] += count[i-1];
    }
    log.info("step 2: after transformed to index: {}", Arrays.toString(count));

    Item[] result = new Item[data.length];
    for (Item item : data) {
      result[count[item.key()]++] = item;
    }
    log.info("step3: after sorted: {}", Arrays.toString(result));
    return result;
  }

  /**
   * An array of items used for testing key-index counting by default.
   */
  static Item[] exampleData = new Item[]{
      new Item("Anderson", 2),
      new Item("Brown", 3),
      new Item("Davis", 3),
      new Item("Garcia", 4),
      new Item("Harris", 1),
      new Item("Jackson", 3),
      new Item("Johnson", 4),
      new Item("Jones", 3),
      new Item("Martin", 1),
      new Item("Martinez", 2),
      new Item("Miller", 2),
      new Item("Moore", 1),
      new Item("Robinson", 2),
      new Item("Smith", 4),
      new Item("Taylor", 3),
      new Item("Thomas", 4),
      new Item("Thompson", 4),
      new Item("White", 2),
      new Item("Williams", 2),
      new Item("Wilson", 4),
  };
}
