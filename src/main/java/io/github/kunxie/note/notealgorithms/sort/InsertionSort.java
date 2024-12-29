package io.github.kunxie.note.notealgorithms.sort;

public class InsertionSort implements Sort<Integer> {

    @Override
    public void sort(Integer[] array) {
        for (int i = 1; i < array.length; ++i) {
            var key = array[i];
            int j = i - 1;
            // ensure array[0:i-1] is sorted.
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j -= 1;
            }
            // assert array[0:j] <= key
            array[j + 1] = key;
        }
    }
}
