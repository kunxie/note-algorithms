package io.github.kunxie.note.notealgorithms.sort;

public class CountSort implements Sort<Integer> {
    /**
     * assume val in array is in small range 0...k
     *
     * @param array the array to be sorted, containing elements that extend
     *              Comparable. The array can be null or empty, in which case
     *              no sorting is required.
     */
    @Override
    public void sort(Integer[] array) {
        var max = findMax(array);
        var countArray = new int[max + 1];
        var newArray = new Integer[array.length];

        for (var v: array) {
            countArray[v] += 1;
        }
        for (var i = 1; i <= max; i++) { // preSum array
            countArray[i] += countArray[i - 1];
        }

        for (Integer val : array) {
            var index = countArray[val] - 1; // index start at 0.
            newArray[index] = val;
            countArray[val] -= 1;
        }

        System.arraycopy(newArray, 0, array, 0, array.length);
    }

    private int findMax(Integer[] array) {
        var result = array[0];
        for (var v: array) {
            result = Math.max(result, v);
        }
        return result;
    }
}
