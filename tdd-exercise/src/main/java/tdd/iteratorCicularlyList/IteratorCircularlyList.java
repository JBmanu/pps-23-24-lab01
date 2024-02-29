package tdd.iteratorCicularlyList;

import java.util.Iterator;

public interface IteratorCircularlyList {

    void add (final int element);

    int size();

    boolean isEmpty();

    Iterator<Integer> forwardIterator();

    Iterator<Integer> backwardIterator();


}
