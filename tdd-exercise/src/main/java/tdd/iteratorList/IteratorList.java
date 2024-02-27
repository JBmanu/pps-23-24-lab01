package tdd.iteratorList;

import java.util.Iterator;

public interface IteratorList {

    void add (final int element);

    int size();

    boolean isEmpty();

    Iterator forwardIterator();

    Iterator backwardIterator();


}
