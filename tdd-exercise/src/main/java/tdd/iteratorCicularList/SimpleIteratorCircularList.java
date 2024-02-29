package tdd.iteratorCicularList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class SimpleIteratorCircularList implements IteratorCircularList {
    private final List<Integer> elements;

    public SimpleIteratorCircularList() {
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

    private Iterator<Integer> infiniteFromList(List<Integer> list) {
        if (list.isEmpty()) return Collections.emptyIterator();
        return Stream.generate(() -> Collections.unmodifiableList(list))
                .flatMap(Collection::stream).iterator();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return this.infiniteFromList(this.elements);
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        List<Integer> reverseElements = new ArrayList<>(this.elements);
        Collections.reverse(reverseElements);
        return this.infiniteFromList(reverseElements);
    }

}