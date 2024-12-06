package io.github.kunxie.note.notealgorithms.sort;

public class MergeSort implements Sort<Integer> {

  @Override
  public void sort(Integer[] array) {
    var helpArray = new Integer[array.length];
    sort(array, 0, array.length - 1, helpArray);
  }

  private void sort(Integer[] array, int left, int right, Integer[] helpArray) {
    if (left >= right) return;

    var mid = (right - left) / 2 + left;
    sort(array, left, mid, helpArray);
    sort(array, mid + 1, right, helpArray);

    var i = left;
    var j = mid + 1;
    var x = left;
    while (i <= mid || j <= right) {
      if (i > mid) {
        helpArray[x++] = array[j++];
      } else if (j > right) {
        helpArray[x++] = array[i++];
      } else if (array[i].compareTo(array[j]) < 0) {
        helpArray[x++] = array[i++];
      } else {
        helpArray[x++] = array[j++];
      }
    }
    assert i == mid + 1;
    assert j == right + 1;
    assert x == right + 1;

    System.arraycopy(helpArray, left, array, left, right + 1 - left);
  }
}
