package tdd.filterCircularlyList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleFilterCircularlyList implements FilterCircularlyList {
    private final List<Optional<Integer>> elements;

    public SimpleFilterCircularlyList() {
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
    public Optional<Integer> filterNext(int element) {
        return Optional.empty();
    }
}
