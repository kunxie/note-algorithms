package io.github.kunxie.note.notealgorithms.sort;

import io.github.kunxie.note.notealgorithms.util.SortUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class SortTest {

    @ParameterizedTest
    @MethodSource("sortTestProvider")
    void sort(Sort<Integer> sortMethod, Integer[] inputArray) {
        log.info("Before sort: {} -- array:{}",
            sortMethod.getClass().getName(),
            Arrays.toString(inputArray));

        final var start = System.currentTimeMillis();
        sortMethod.sort(inputArray);
        final var end = System.currentTimeMillis();
        assertTrue(SortUtils.isAscend(inputArray));

        log.info("After sort {} ms: -- array:{}",
            end - start,
            Arrays.toString(inputArray)
        );
    }

    static Stream<Arguments> sortTestProvider() {
        return Stream.of(
            Arguments.of(new InsertionSort(), getRandomArray(10)),
            Arguments.of(new InsertionSort(), getRandomArray(1_000)),
            Arguments.of(new InsertionSort(), getRandomArray(10_000))
        );
    }

    /**
     * return a random generated array based on size. the value will range from 0...size-1.
     *
     * @param SIZE given size of the array.
     * @return the array
     */
    private static Integer[] getRandomArray(final int SIZE) {
        Random random = new Random();
        Integer[] randomArray = new Integer[SIZE];
        for (int i = 0; i < SIZE; i++) {
            // random value between 0 and size (exclusive)
            randomArray[i] = random.nextInt(SIZE);
        }
        return randomArray;
    }
}