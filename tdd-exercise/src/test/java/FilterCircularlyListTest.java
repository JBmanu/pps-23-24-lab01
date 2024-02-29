import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.filterCircularlyList.FilterCircularlyList;
import tdd.filterCircularlyList.SimpleFilterCircularlyList;

import java.util.Optional;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class FilterCircularlyListTest {
    private static final int EMPTY_LIST = 0;
    private static final int INITIAL_VALUE_OF_FOR = 0;
    private static final int ONE_ELEMENT = 1;
    private static final int THREE_ELEMENT = 3;
    private static final int EIGHT_ELEMENT = 8;
    private static final int ZERO_VALUE = 0;

    private FilterCircularlyList filterCircularlyList;

    @BeforeEach
    public void canCreateFilterCircularlyTest() {
        this.filterCircularlyList = new SimpleFilterCircularlyList();
    }

    @Test
    public void testEmptyList() {
        assertTrue(this.filterCircularlyList.isEmpty());
        assertEquals(EMPTY_LIST, this.filterCircularlyList.size());
    }

    private void addElementInOrderInList(final int quantity) {
        for (int i = INITIAL_VALUE_OF_FOR; i < quantity; i++)
            this.filterCircularlyList.add(i);
    }

    @Test
    public void testAddOneElement() {
        this.addElementInOrderInList(ONE_ELEMENT);

        assertFalse(this.filterCircularlyList.isEmpty());
        assertEquals(ONE_ELEMENT, this.filterCircularlyList.size());
    }

    @Test
    public void testAddThreeElements() {
        this.addElementInOrderInList(THREE_ELEMENT);
        assertEquals(THREE_ELEMENT, this.filterCircularlyList.size());
    }

    @Test
    public void testFilterNextWhereListContainElement() {
        this.addElementInOrderInList(THREE_ELEMENT);
        final int elementZero = 0;
        final Predicate<Integer> predicate = element -> element.equals(elementZero);

        assertEquals(Optional.of(0), this.filterCircularlyList.filterNext(predicate));
    }

    @Test
    public void testFilterNextWhereListNotContainElement() {
        this.addElementInOrderInList(THREE_ELEMENT);
        final int elementFive = 5;
        final Predicate<Integer> predicate = element -> element.equals(elementFive);

        assertEquals(Optional.empty(), this.filterCircularlyList.filterNext(predicate));
    }

    @Test
    public void testFilterNextForMultipleOfTwo() {
        this.addElementInOrderInList(EIGHT_ELEMENT);

        final int multiple = 2;
        final int trueMultiple = 0;
        final Predicate<Integer> predicate = element -> (element % multiple) == trueMultiple;

        for (int i = INITIAL_VALUE_OF_FOR; i < THREE_ELEMENT; i++)
            assertEquals(Optional.of(i * multiple), this.filterCircularlyList.filterNext(predicate));
    }

    @Test
    public void testTwoDifferentFilterNextInOrder() {
        this.addElementInOrderInList(EIGHT_ELEMENT);

        final int multipleOfTwo = 2;
        final int trueMultiple = 0;
        final Predicate<Integer> firstPredicate = element -> (element % multipleOfTwo) == trueMultiple;

        for (int i = INITIAL_VALUE_OF_FOR; i < THREE_ELEMENT; i++)
            assertEquals(Optional.of(i * multipleOfTwo),
                    this.filterCircularlyList.filterNext(firstPredicate));

        final int multipleOfThree = 3;
        final Predicate<Integer> secondPredicate = element -> (element % multipleOfThree) == trueMultiple;

        for (int i = INITIAL_VALUE_OF_FOR; i < THREE_ELEMENT; i++) {
            assertEquals(Optional.of(i * multipleOfThree),
                    this.filterCircularlyList.filterNext(secondPredicate));
        }
    }

    @Test
    public void testTwoDifferentFilterNextInDisorder() {
        this.addElementInOrderInList(EIGHT_ELEMENT);

        final int multipleOfTwo = 2;
        final int trueMultiple = 0;
        final Predicate<Integer> firstPredicate = element -> (element % multipleOfTwo) == trueMultiple;

        final int multipleOfThree = 3;
        final Predicate<Integer> secondPredicate = element -> (element % multipleOfThree) == trueMultiple;

        assertEquals(Optional.of(ZERO_VALUE), this.filterCircularlyList.filterNext(firstPredicate));
        assertEquals(Optional.of(ZERO_VALUE), this.filterCircularlyList.filterNext(secondPredicate));
    }

}
