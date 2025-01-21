package io.github.kunxie.note.notealgorithms.sort;

public class HeapSortTest extends AbstractComparisonSortTest {

    @Override
    protected Sort<Integer> getSortImplementation() {
        return new HeapSort();
    }
}
