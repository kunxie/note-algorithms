package io.github.kunxie.note.notealgorithms.sort;

public class InsertionSortTest extends AbstractSortTest {

    @Override
    protected Sort<Integer> getSortImplementation() {
        return new InsertionSort();
    }
}
