package io.github.kunxie.note.notealgorithms.sort;

class QuickSortTest extends AbstractSortTest {

    @Override
    protected Sort<Integer> getSortImplementation() {
        return new QuickSort();
    }
}
