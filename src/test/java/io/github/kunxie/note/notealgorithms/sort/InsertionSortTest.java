package io.github.kunxie.note.notealgorithms.sort;

public class InsertionSortTest extends AbstractComparisonSortTest {

    @Override
    protected Sort<Integer> getSortImplementation() {
        return new InsertionSort();
    }
}
