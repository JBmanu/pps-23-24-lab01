package tdd.filterCircularlyList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class SimpleFilterCircularlyList implements FilterCircularlyList {
    public static final int INITIAL_INDEX_VALUE = 0;
    private Optional<Predicate<Integer>> lastPredicate;
    private final List<Integer> elements;
    private int index;

    public SimpleFilterCircularlyList() {
        this.lastPredicate = Optional.empty();
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

    private void resetIndexIfLastPredicateIsDifferent(Predicate<Integer> predicate) {
        final Optional<Predicate<Integer>> optionalPredicate = Optional.of(predicate);

        if (this.lastPredicate.equals(optionalPredicate)) return;
        this.lastPredicate = optionalPredicate;
        this.index = INITIAL_INDEX_VALUE;
    }

    @Override
    public Optional<Integer> filterNext(final Predicate<Integer> predicate) {
        this.resetIndexIfLastPredicateIsDifferent(predicate);
        List<Integer> list = this.elements.stream().filter(predicate).toList();
        return list.isEmpty() ? Optional.empty() : Optional.of(list.get(this.index++ % list.size()));
    }


}
