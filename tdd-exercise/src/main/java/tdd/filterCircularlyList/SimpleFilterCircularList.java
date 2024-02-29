package tdd.filterCircularlyList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class SimpleFilterCircularList implements FilterCircularList {
    public static final int INITIAL_INDEX_VALUE = 0;
    private Predicate<Integer> lastPredicate;
    private final List<Integer> elements;
    private int index;

    public SimpleFilterCircularList() {
        this.elements = new ArrayList<>();
        this.index = INITIAL_INDEX_VALUE;
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

    private void resetIndexIfLastPredicateIsDifferent(final Predicate<Integer> predicate) {
        if (predicate.equals(this.lastPredicate)) return;
        this.index = INITIAL_INDEX_VALUE;
        this.lastPredicate = predicate;
    }

    @Override
    public Optional<Integer> filterNext(final Predicate<Integer> predicate) {
        this.resetIndexIfLastPredicateIsDifferent(predicate);
        List<Integer> list = this.elements.stream().filter(predicate).toList();
        return list.isEmpty() ? Optional.empty() : Optional.of(list.get(this.index++ % list.size()));
    }


}
