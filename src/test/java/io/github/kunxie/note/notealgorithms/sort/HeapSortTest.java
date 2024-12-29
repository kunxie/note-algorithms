package io.github.kunxie.note.notealgorithms.sort;

public class HeapSortTest extends AbstractSortTest {

    @Override
    protected Sort<Integer> getSortImplementation() {
        return new HeapSort();
    }
}
