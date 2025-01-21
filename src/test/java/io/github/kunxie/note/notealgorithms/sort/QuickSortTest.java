package io.github.kunxie.note.notealgorithms.sort;

class QuickSortTest extends AbstractComparisonSortTest {

    @Override
    protected Sort<Integer> getSortImplementation() {
        return new QuickSort();
    }
}
