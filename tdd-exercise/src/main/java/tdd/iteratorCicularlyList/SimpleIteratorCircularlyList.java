package tdd.iteratorCicularlyList;

import java.util.*;

public class SimpleIteratorCircularlyList implements IteratorCircularlyList {
    private final List<Optional<Integer>> elements;

    public SimpleIteratorCircularlyList() {
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
        return new CircularlyIterator(this.elements);
    }

    @Override
    public Iterator<Optional<Integer>> backwardIterator() {
        List<Optional<Integer>> reverseElements = new ArrayList<>(this.elements);
        Collections.reverse(reverseElements);
        return new CircularlyIterator(reverseElements);
    }

    private static class CircularlyIterator implements Iterator<Optional<Integer>> {
        private static final int INITIAL_INDEX = 0;
        private final List<Optional<Integer>> iteratorElements;
        private int index;

        public CircularlyIterator(List<Optional<Integer>> list) {
            this.iteratorElements= new ArrayList<>(list);
            this.index = INITIAL_INDEX;
        }

        @Override
        public boolean hasNext() {
            return !this.iteratorElements.isEmpty();
        }

        @Override
        public Optional<Integer> next() {
            return this.iteratorElements.get(this.index++ % this.iteratorElements.size());
        }
    }

}

