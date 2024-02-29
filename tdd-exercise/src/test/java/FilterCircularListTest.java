import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.filterCircularList.FilterCircularList;
import tdd.filterCircularList.SimpleFilterCircularList;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class FilterCircularListTest {
    private static final int EMPTY_LIST = 0;
    private static final int ONE_ELEMENT = 1;
    private static final int THREE_ELEMENT = 3;
    private static final int EIGHT_ELEMENT = 8;
    private static final int ZERO_VALUE = 0;

    private FilterCircularList filterCircularList;

    @BeforeEach
    public void canCreateFilterCircularlyTest() {
        this.filterCircularList = new SimpleFilterCircularList();
    }

    @Test
    public void testEmptyList() {
        assertTrue(this.filterCircularList.isEmpty());
        assertEquals(EMPTY_LIST, this.filterCircularList.size());
    }

    private void addElementInOrderInList(final int quantity) {
        IntStream.range(ZERO_VALUE, quantity).forEach(value -> this.filterCircularList.add(value));
    }

    @Test
    public void testAddOneElement() {
        this.addElementInOrderInList(ONE_ELEMENT);

        assertFalse(this.filterCircularList.isEmpty());
        assertEquals(ONE_ELEMENT, this.filterCircularList.size());
    }

    @Test
    public void testAddThreeElements() {
        this.addElementInOrderInList(THREE_ELEMENT);

        assertFalse(this.filterCircularList.isEmpty());
        assertEquals(THREE_ELEMENT, this.filterCircularList.size());
    }

    @Test
    public void testFilterNextWhereListContainElement() {
        this.addElementInOrderInList(THREE_ELEMENT);
        final int elementZero = 0;
        final Predicate<Integer> predicate = element -> element.equals(elementZero);

        assertEquals(Optional.of(ZERO_VALUE), this.filterCircularList.filterNext(predicate));
    }

    @Test
    public void testFilterNextWhereListNotContainElement() {
        this.addElementInOrderInList(THREE_ELEMENT);
        final int elementFive = 5;
        final Predicate<Integer> predicate = element -> element.equals(elementFive);

        assertEquals(Optional.empty(), this.filterCircularList.filterNext(predicate));
    }

    @Test
    public void testFilterNextForMultipleOfTwo() {
        this.addElementInOrderInList(EIGHT_ELEMENT);

        final int multiple = 2;
        final int trueMultiple = 0;
        final Predicate<Integer> predicate = element -> (element % multiple) == trueMultiple;

        IntStream.range(ZERO_VALUE, THREE_ELEMENT)
                .map(value -> value * multiple)
                .forEach(value -> assertEquals(Optional.of(value), this.filterCircularList.filterNext(predicate)));
    }

    @Test
    public void testTwoDifferentFilterNextInOrder() {
        this.addElementInOrderInList(EIGHT_ELEMENT);

        final int multipleOfThree = 3;
        final int multipleOfTwo = 2;
        final int trueMultiple = 0;
        final Predicate<Integer> firstPredicate = element -> (element % multipleOfTwo) == trueMultiple;
        final Predicate<Integer> secondPredicate = element -> (element % multipleOfThree) == trueMultiple;

        IntStream.range(ZERO_VALUE, THREE_ELEMENT)
                .map(value -> value * multipleOfTwo)
                .forEach(value -> assertEquals(Optional.of(value), this.filterCircularList.filterNext(firstPredicate)));

        IntStream.range(ZERO_VALUE, THREE_ELEMENT)
                .map(value -> value * multipleOfThree)
                .forEach(value -> assertEquals(Optional.of(value), this.filterCircularList.filterNext(secondPredicate)));
    }

    @Test
    public void testTwoDifferentFilterNextInDisorder() {
        this.addElementInOrderInList(EIGHT_ELEMENT);

        final int multipleOfThree = 3;
        final int multipleOfTwo = 2;
        final int trueMultiple = 0;
        final Predicate<Integer> firstPredicate = element -> (element % multipleOfTwo) == trueMultiple;
        final Predicate<Integer> secondPredicate = element -> (element % multipleOfThree) == trueMultiple;

        assertEquals(Optional.of(ZERO_VALUE), this.filterCircularList.filterNext(firstPredicate));
        assertEquals(Optional.of(ZERO_VALUE), this.filterCircularList.filterNext(secondPredicate));
    }

    @Test
    public void testPassNullPredicate() {
        this.addElementInOrderInList(THREE_ELEMENT);

        assertThrows(IllegalArgumentException.class, () ->
                this.filterCircularList.filterNext(null));
    }
}