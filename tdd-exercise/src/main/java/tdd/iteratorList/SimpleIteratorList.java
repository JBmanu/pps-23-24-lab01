package tdd.iteratorList;

import tdd.SimpleCircularList;

import java.util.Iterator;
import java.util.Optional;

public class SimpleIteratorList implements IteratorList {
    private Optional<Integer> element;

    public SimpleIteratorList() {
        this.element = Optional.empty();
    }

    @Override
    public void add(int element) {
        this.element = Optional.of(element);
    }

    @Override
    public int size() {
        return this.element.isEmpty() ? 0 : 1;
    }

    @Override
    public boolean isEmpty() {
        return this.element.isEmpty();
    }

    @Override
    public Iterator forwardIterator() {
        return null;
    }

    @Override
    public Iterator backwardIterator() {
        return null;
    }
}
