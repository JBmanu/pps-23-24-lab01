import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.iteratorList.IteratorList;
import tdd.iteratorList.SimpleIteratorList;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleIteratorListTest {
    private static final int EMPTY_LIST = 0;
    private static final int INITIAL_VALUE = 0;
    private static final int ONE_ELEMENT = 1;
    private static final int THREE_ELEMENT = 3;

    private static final Optional<Integer> ZERO_OPTIONAL_VALUE = Optional.of(0);
    private static final Optional<Integer> ONE_OPTIONAL_VALUE = Optional.of(1);
    private static final Optional<Integer> TWO_OPTIONAL_VALUE = Optional.of(2);

    private static final List<Optional<Integer>> OPTIONAL_VALUE_LIST_IN_ORDER =
            List.of(ZERO_OPTIONAL_VALUE, ONE_OPTIONAL_VALUE, TWO_OPTIONAL_VALUE);

    private IteratorList iteratorList = new SimpleIteratorList();

    @BeforeEach
    public void canCreateIteratorList() {
        this.iteratorList = new SimpleIteratorList();
    }

    @Test
    public void testEmpty() {
        assertTrue(this.iteratorList.isEmpty());
        assertEquals(EMPTY_LIST, this.iteratorList.size());
    }

    private void addElementsInOrderInList(final int quantity) {
        for (int i = INITIAL_VALUE; i < quantity; i++)
            this.iteratorList.add(i);
    }

    @Test
    public void testAddElementInList() {
        this.addElementsInOrderInList(ONE_ELEMENT);

        assertFalse(this.iteratorList.isEmpty());
        assertEquals(ONE_ELEMENT, this.iteratorList.size());
    }

    @Test
    public void testAddThreeElements() {
        this.addElementsInOrderInList(THREE_ELEMENT);

        assertFalse(this.iteratorList.isEmpty());
        assertEquals(THREE_ELEMENT, this.iteratorList.size());
    }

    @Test
    public void testCanCreateForwardIterator() {
        assertNotEquals(null, this.iteratorList.forwardIterator());
    }

    @Test
    public void testCanCreateBackwardIterator() {
        assertNotEquals(null, this.iteratorList.backwardIterator());
    }

    @Test
    public void testEmptyForwardIterator() {
        final Iterator<Optional<Integer>> forwardIterator = this.iteratorList.forwardIterator();
        assertFalse(forwardIterator.hasNext());
    }

    @Test
    public void testEmptyBackwardIterator() {
        final Iterator<Optional<Integer>> backwardIterator = this.iteratorList.backwardIterator();
        assertFalse(backwardIterator.hasNext());
    }

    @Test
    public void testReadThreeElementOfForwardIterator() {
        OPTIONAL_VALUE_LIST_IN_ORDER.forEach(optionalInteger ->
                optionalInteger.ifPresent(integer -> this.iteratorList.add(integer)));

        final Iterator<Optional<Integer>> fordwardIterator = this.iteratorList.forwardIterator();

        OPTIONAL_VALUE_LIST_IN_ORDER.forEach(optionalInteger -> {
            if (fordwardIterator.hasNext())
                assertEquals(optionalInteger, fordwardIterator.next());
        });
    }

    @Test
    public void testReadThreeElementOfBackwardIterator() {
        OPTIONAL_VALUE_LIST_IN_ORDER.forEach(optionalInteger ->
                optionalInteger.ifPresent(integer -> this.iteratorList.add(integer)));

        final Iterator<Optional<Integer>> backwardIterator = this.iteratorList.backwardIterator();

        final List<Optional<Integer>> reverseOptionalValueListInOrder = new ArrayList<>(OPTIONAL_VALUE_LIST_IN_ORDER);
        Collections.reverse(reverseOptionalValueListInOrder);

        reverseOptionalValueListInOrder.forEach(optionalInteger -> {
            if (backwardIterator.hasNext())
                assertEquals(optionalInteger, backwardIterator.next());
        });
    }


}
