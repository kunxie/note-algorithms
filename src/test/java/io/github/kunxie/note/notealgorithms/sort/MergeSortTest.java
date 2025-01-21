package io.github.kunxie.note.notealgorithms.sort;

public class MergeSortTest extends AbstractComparisonSortTest {

    @Override
    protected Sort<Integer> getSortImplementation() {
        return new MergeSort();
    }
}
