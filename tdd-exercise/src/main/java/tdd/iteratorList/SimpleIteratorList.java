package tdd.iteratorList;

import tdd.SimpleCircularList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class SimpleIteratorList implements IteratorList {
    private final List<Optional<Integer>> elements;

    public SimpleIteratorList() {
        this.elements = new ArrayList<>();
    }

    @Override
    public void add(int element) {
        this.elements.add(Optional.of(element));
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override
    public Iterator<Optional<Integer>> forwardIterator() {
        return this.elements.stream().iterator();
    }

    @Override
    public Iterator<Optional<Integer>> backwardIterator() {
        return this.elements.stream().iterator();
    }
}
