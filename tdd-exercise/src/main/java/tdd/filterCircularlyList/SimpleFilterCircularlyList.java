package tdd.filterCircularlyList;

import java.util.Optional;

public class SimpleFilterCircularlyList implements FilterCircularlyList {
    @Override
    public void add(int element) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Optional<Integer> filterNext(int element) {
        return Optional.empty();
    }
}
