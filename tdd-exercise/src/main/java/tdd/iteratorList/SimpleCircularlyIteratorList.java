package tdd.iteratorList;

import java.util.*;

public class SimpleCircularlyIteratorList implements IteratorList {
    private final List<Optional<Integer>> elements;

    public SimpleCircularlyIteratorList() {
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
        return new Iterator<>() {
            private static final int INITIAL_INDEX = 0;
            private final List<Optional<Integer>> forwardElements = new ArrayList<>(SimpleCircularlyIteratorList.this.elements);
            private int index = INITIAL_INDEX;

            @Override
            public boolean hasNext() {
                return !this.forwardElements.isEmpty();
            }

            @Override
            public Optional<Integer> next() {
                return this.forwardElements.get(this.index++ % this.forwardElements.size());
            }
        };
    }

    @Override
    public Iterator<Optional<Integer>> backwardIterator() {
        List<Optional<Integer>> reverseElements = new ArrayList<>(this.elements);
        Collections.reverse(reverseElements);
        return reverseElements.iterator();
    }

}

