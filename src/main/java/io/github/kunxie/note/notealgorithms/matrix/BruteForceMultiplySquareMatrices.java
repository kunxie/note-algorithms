package io.github.kunxie.note.notealgorithms.matrix;

public class BruteForceMultiplySquareMatrices implements MultiplySquareMatrices {

    /**
     * Multiplies two square matrices A and B using the brute force approach and returns the resulting matrix.
     *
     * @param A the first square matrix
     * @param B the second square matrix
     * @return the resulting square matrix obtained by multiplying A and B
     * @throws IllegalArgumentException if either matrix is null, not square, does not have dimensions that are a power of 2, or if the matrices do not have the same dimensions
     */
    @Override
    public int[][] multiply(int[][] A, int[][] B) {
        validateMatrix(A);
        validateMatrix(B);
        validateSameDimensions(A, B);

        final var N = A.length;
        var C = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                for (int i = 0; i < N; i++) {
                    C[r][c] += A[r][i] * B[i][c];
                }
            }
        }

        return C;
    }
}
