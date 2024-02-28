package tdd.iteratorList;

import java.util.*;

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
        return this.elements.iterator();
    }

    @Override
    public Iterator<Optional<Integer>> backwardIterator() {
        List<Optional<Integer>> reverseElements = new ArrayList<>(this.elements);
        Collections.reverse(reverseElements);
        return reverseElements.iterator();
    }
}
