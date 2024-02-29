package tdd.iteratorCicularList;

import java.util.Iterator;

public interface IteratorCircularList {

    void add (final int element);

    int size();

    boolean isEmpty();

    Iterator<Integer> forwardIterator();

    Iterator<Integer> backwardIterator();


}
