package tdd.iteratorList;

import java.util.Iterator;
import java.util.Optional;

public interface IteratorList {

    void add (final int element);

    int size();

    boolean isEmpty();

    Iterator<Optional<Integer>> forwardIterator();

    Iterator<Optional<Integer>> backwardIterator();


}
