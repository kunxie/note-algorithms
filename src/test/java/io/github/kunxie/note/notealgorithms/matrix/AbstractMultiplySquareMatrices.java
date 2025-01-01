package io.github.kunxie.note.notealgorithms.matrix;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@Slf4j
public abstract class AbstractMultiplySquareMatrices {

    protected abstract MultiplySquareMatrices getMultiplySquareMatricesImplementation();

    @ParameterizedTest
    @MethodSource("multiplySquareMatricesProvider")
    void multiply(int[][] A, int[][] B, int[][] C) {
        var multiplySquareMatrices = getMultiplySquareMatricesImplementation();

        var result = multiplySquareMatrices.multiply(A, B);
        assertArrayEquals(C, result, "Matrix multiplication result is incorrect");
    }

    static Stream<Arguments> multiplySquareMatricesProvider() {
        return Stream.of(
            Arguments.of(
                new int[][]{{2}}, new int[][]{{3}}, new int[][]{{6}}
            ),
            Arguments.arguments(
                new int[][] {
                    {1, 2},
                    {3, 4}
                },
                new int[][] {
                    {5, 6},
                    {7, 8}
                },
                new int[][] {
                    {19, 22},
                    {43, 50}
                }
            )
        );
    }
}
