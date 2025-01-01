package io.github.kunxie.note.notealgorithms.matrix;

public class BruteForce extends AbstractMultiplySquareMatrices{
    @Override
    protected MultiplySquareMatrices getMultiplySquareMatricesImplementation() {
        return new BruteForceMultiplySquareMatrices();
    }
}
