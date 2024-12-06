package io.github.kunxie.note.notealgorithms.sort;

import static io.github.kunxie.note.notealgorithms.util.CommonUtils.swap;

public class QuickSort implements Sort<Integer> {

  @Override
  public void sort(Integer[] array) {
    sort(array, 0, array.length - 1);
  }

  private void sort(Integer[] array, int left, int right) {
    if (left >= right) return;

    var pivot = array[left];
    // keep [left+1, j) < pivot
    var j = left + 1;
    for (int i = left + 1; i <= right; ++i) {
      // when array[i] < pivot
      if (array[i].compareTo(pivot) < 0) {
        swap(array, i, j++);
      }
    }
    swap(array, left, j - 1);
    // assert array[left...j-2] <= array[j-1] <= array[j...right]

    sort(array, left, j - 2);
    sort(array, j, right);
  }
}
