package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleCircularList implements CircularList {
    private static final int EMPTY_LIST = 0;

    private final List<Optional<Integer>> elements;
    private int index;

    public SimpleCircularList() {
        this.elements = new ArrayList<>();
        this.index = 0;
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
        return this.size() == EMPTY_LIST;
    }

    @Override
    public Optional<Integer> next() {
        this.index = this.index % this.size();
        return this.elements.get(this.index++);
    }

    @Override
    public Optional<Integer> previous() {
        this.index = this.index == 0 ? this.size() : this.index;
        this.index = (this.index - 1) % this.size();
        System.out.println("index: " + this.index);
        return this.elements.get(this.index);
    }

    @Override
    public void reset() {
        this.elements.clear();
    }
}
