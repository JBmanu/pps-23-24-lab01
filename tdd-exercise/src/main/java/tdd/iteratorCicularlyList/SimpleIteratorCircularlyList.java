package tdd.iteratorCicularlyList;

import java.util.*;

public class SimpleIteratorCircularlyList implements IteratorCircularlyList {
    private final List<Integer> elements;

    public SimpleIteratorCircularlyList() {
        this.elements = new ArrayList<>();
    }

    @Override
    public void add(int element) {
        this.elements.add(element);
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
    public Iterator<Integer> forwardIterator() {
        return new CircularlyIterator(this.elements);
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        List<Integer> reverseElements = new ArrayList<>(this.elements);
        Collections.reverse(reverseElements);
        return new CircularlyIterator(reverseElements);
    }

    private static class CircularlyIterator implements Iterator<Integer> {
        private static final int INITIAL_INDEX = 0;
        private final List<Integer> iteratorElements;
        private int index;

        public CircularlyIterator(List<Integer> list) {
            this.iteratorElements= new ArrayList<>(list);
            this.index = INITIAL_INDEX;
        }

        @Override
        public boolean hasNext() {
            return !this.iteratorElements.isEmpty();
        }

        @Override
        public Integer next() {
            return this.iteratorElements.get(this.index++ % this.iteratorElements.size());
        }
    }

}

