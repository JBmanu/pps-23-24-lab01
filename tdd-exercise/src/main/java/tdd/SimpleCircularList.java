package tdd;

import java.util.List;
import java.util.Optional;

public class SimpleCircularList implements CircularList {
    private Optional<Integer> element;

    @Override
    public void add(int element) {
        this.element = Optional.of(element);
    }

    @Override
    public int size() {
        return this.element.isPresent() ? 1 : 0;
    }

    @Override
    public boolean isEmpty() {
        return this.element.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        return this.element;
    }

    @Override
    public Optional<Integer> previous() {
        return this.element;
    }

    @Override
    public void reset() {

    }
}
