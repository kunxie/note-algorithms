package io.github.kunxie.note.notealgorithms.sort;

import static io.github.kunxie.note.notealgorithms.util.CommonUtils.swap;

/**
 * parent: i, left-child: 2i+1, right-child: 2i+2
 * child i: parent: (i-1) / 2
 *
 *
 */
public class HeapSort implements Sort<Integer> {

  @Override
  public void sort(Integer[] array) {
    // step 1. build max-heap
    for (int i = 1; i < array.length; i++) {
      bubbleUp(array, i);
    }
    // assert array is a max-heap

    // step 2. remove from max-heap
    // assume (i...Len-1] is ascending
    var i = array.length-1;
    while (i >= 0) {
      swap(array, 0, i--);
      bubbleDown(array, 0, i);
    }
    // assert array is sorted.
  }

  // for max-heap
  private void bubbleUp(Integer[] array, int index) {
    int parent = getParent(index);

    if (parent >= 0 && array[parent] < array[index]) {
      swap(array, parent, index);
      bubbleUp(array, parent);
    }
  }

  // bound is inclusive.
  private void bubbleDown(Integer[] arr, int index, int bound) {
    var largest = index;
    var left = getLeftChild(index);
    if (left <= bound && arr[left] > arr[largest]) {
      largest = left;
    }
    var right = getRightChild(index);
    if (right <= bound && arr[right] > arr[largest]) {
      largest = right;
    }

    if (largest != index) {
      swap(arr, largest, index);
      bubbleDown(arr, largest, bound);
    }
  }

  private int getParent(int child) {
    return (child - 1) / 2;
  }

  private int getLeftChild(int parent) {
    return 2 * parent + 1;
  }

  private int getRightChild(int parent) {
    return 2 * parent + 2;
  }
}
