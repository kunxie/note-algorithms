package io.github.kunxie.note.notealgorithms.matrix;

public interface MultiplySquareMatrices {


    /**
     * Multiplies two square matrices A and B and returns the resulting matrix.
     *
     * @param A the first square matrix
     * @param B the second square matrix
     * @return the resulting square matrix obtained by multiplying A and B
     */
    int[][] multiply(int[][] A, int[][] B);

    default void validateSameDimensions(int[][] A, int[][] B) {
        // Ensure both matrices are not null
        if (A == null || B == null) {
            throw new IllegalArgumentException("Matrices cannot be null");
        }

        // Ensure both matrices have the same length
        if (A.length != B.length || A[0].length != B[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }
    }

    default void validateMatrix(int[][] A) {
        // Check if A is null
        if (A == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }

        var n = A.length;

        // Verify it is square (non-empty and all rows same length)
        for (var row : A) {
            if (row == null || row.length != n) {
                throw new IllegalArgumentException("Matrix A must be square with equal dimensions");
            }
        }

        // Check if n (size of rows and columns) is a power of 2
        if (!isPowerOfTwo(n)) {
            throw new IllegalArgumentException("Matrix dimensions must be a power of 2");
        }
    }

    /**
     * Checks if the given integer is a power of two.
     *
     * @param n the integer to check
     * @return true if the number is a power of two, false otherwise
     */
    default boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
