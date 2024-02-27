package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleCircularList implements CircularList {
    private static final int EMPTY_LIST = 0;
    private static final int START_INDEX = -1;
    private static final int ZERO_INDEX = 0;

    private final List<Optional<Integer>> elements;
    private int index;

    public SimpleCircularList() {
        this.elements = new ArrayList<>();
        this.index = START_INDEX;
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
        if (this.size() == EMPTY_LIST) return Optional.empty();
        this.index = ++this.index % this.size();
        return this.elements.get(this.index);
    }

    @Override
    public Optional<Integer> previous() {
        if (this.size() == EMPTY_LIST) return Optional.empty();
        if (this.index == START_INDEX || this.index == ZERO_INDEX)
            this.index = this.size();
        this.index = --this.index % this.size();
        return this.elements.get(this.index);
    }

    @Override
    public void reset() {
        this.elements.clear();
    }
}
