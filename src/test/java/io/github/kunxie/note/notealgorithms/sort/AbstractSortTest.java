package io.github.kunxie.note.notealgorithms.sort;

import io.github.kunxie.note.notealgorithms.util.SortUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Abstract test class for evaluating the correctness and performance of
 * sorting algorithms. This class provides a framework for testing multiple
 * sorting implementations with varying input sizes.
 * <p>
 * The tests are executed in parallel to improve efficiency and assess
 * performance under different conditions. The class leverages JUnit's
 * parameterized tests for testing different input arrays and logs the
 * sort duration with additional details for analysis.
 */
@Slf4j
// Ensures parallel execution
@Execution(ExecutionMode.CONCURRENT)
public abstract class AbstractSortTest {

    /**
     * Provide the specific sort implementation to be tested.
     */
    protected abstract Sort<Integer> getSortImplementation();

    /**
     * Test method that verifies sorting correctness for a generated array across multiple input sizes.
     *
     * @param inputArray the array to test sorting on.
     */
    @ParameterizedTest
    @MethodSource("sortTestProvider")
    void testSort(Integer[] inputArray) {
        Sort<Integer> sortMethod = getSortImplementation();

        final var start = System.currentTimeMillis();
        sortMethod.sort(inputArray);
        final var end = System.currentTimeMillis();

        log.info("For {} with size {} array for {} ms: -- array:{}",
            sortMethod.getClass().getSimpleName(),
            inputArray.length,
            end - start,
            strWithLimit(Arrays.toString(inputArray), 1_000)
        );

        assertTrue(SortUtils.isAscend(inputArray));
    }

    /**
     * Shared parameter provider for all sort implementations.
     */
    static Stream<Arguments> sortTestProvider() {
        return Stream.of(
            Arguments.of((Object) getRandomArray(10)),
            Arguments.of((Object) getRandomArray(1_00)),
            Arguments.of((Object) getRandomArray(1_000)),
            Arguments.of((Object) getRandomArray(10_000)),
            Arguments.of((Object) getRandomArray(100_000))
        );
    }

    /**
     * Helper to generate a random array of given size.
     */
    private static Integer[] getRandomArray(final int SIZE) {
        Random random = new Random();
        Integer[] randomArray = new Integer[SIZE];
        for (int i = 0; i < SIZE; i++) {
            randomArray[i] = random.nextInt(SIZE); // Random values between 0 and SIZE-1
        }
        return randomArray;
    }

    /**
     * Helper to limit the length of logged strings.
     */
    protected String strWithLimit(String str, final int limit) {
        assert str != null;
        assert limit > 0;

        return str.length() > limit ? str.substring(0, limit) + "..." : str;
    }

    @BeforeAll
    public static void setup() {
        log.info("Starting sort tests...");
    }

    @AfterAll
    public static void cleanup() {
        log.info("Completed all sort tests.");
    }
}
