package tdd.filterCircularlyList;

import java.util.Optional;
import java.util.function.Predicate;

public interface FilterCircularlyList {

    void add(final int element);

    int size();

    boolean isEmpty();

    Optional<Integer> filterNext(final Predicate<Integer> predicate);
}
