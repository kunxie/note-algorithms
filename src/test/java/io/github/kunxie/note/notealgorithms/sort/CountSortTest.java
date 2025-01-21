package io.github.kunxie.note.notealgorithms.sort;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

class CountSortTest {

    @Test
    void sort() {
        var array = new Integer[]{0, 2, 2, 4, 5, 9, 10, 25};

        var sort = new CountSort();
        sort.sort(array);

        System.out.println(Arrays.toString(array));
    }

    private static Integer[] getRandomArray(final int SIZE) {
        Random random = new Random();
        Integer[] randomArray = new Integer[SIZE];
        for (int i = 0; i < SIZE; i++) {
            randomArray[i] = random.nextInt(1_000); // Random values between 0 and SIZE-1
        }
        return randomArray;
    }
}