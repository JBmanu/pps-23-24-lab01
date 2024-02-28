package tdd.filterCircularlyList;

import java.util.Optional;

public interface FilterCircularlyList {

    void add(final int element);

    int size();

    boolean isEmpty();

    Optional<Integer> filterNext(final int element);
}
