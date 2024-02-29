import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.iteratorCicularlyList.IteratorCircularList;
import tdd.iteratorCicularlyList.SimpleIteratorCircularList;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IteratorCircularListTest {
    private static final int EMPTY_LIST = 0;
    private static final int INITIAL_VALUE_OF_FOR = 0;
    private static final int ONE_ELEMENT = 1;
    private static final int THREE_ELEMENT = 3;

    private static final int ZERO_VALUE = 0;
    private static final int ONE_VALUE = 1;
    private static final int TWO_VALUE = 2;
    private static final List<Integer> VALUES_LIST_IN_ORDER =
            List.of(ZERO_VALUE, ONE_VALUE, TWO_VALUE);
    private static final List<Integer> REVERSE_VALUES_LIST_IN_ORDER =
            List.of(TWO_VALUE, ONE_VALUE, ZERO_VALUE);

    private IteratorCircularList iteratorList = new SimpleIteratorCircularList();

    @BeforeEach
    public void canCreateIteratorList() {
        this.iteratorList = new SimpleIteratorCircularList();
    }

    @Test
    public void testEmpty() {
        assertTrue(this.iteratorList.isEmpty());
        assertEquals(EMPTY_LIST, this.iteratorList.size());
    }

    private void addElementsInOrderInList(final int quantity) {
        for (int i = INITIAL_VALUE_OF_FOR; i < quantity; i++)
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
        final Iterator<Integer> forwardIterator = this.iteratorList.forwardIterator();
        assertFalse(forwardIterator.hasNext());
    }

    @Test
    public void testEmptyBackwardIterator() {
        final Iterator<Integer> backwardIterator = this.iteratorList.backwardIterator();
        assertFalse(backwardIterator.hasNext());
    }

    @Test
    public void testReadThreeElementOfForwardIterator() {
        VALUES_LIST_IN_ORDER.forEach(value -> this.iteratorList.add(value));
        final Iterator<Integer> fordwardIterator = this.iteratorList.forwardIterator();

        VALUES_LIST_IN_ORDER.forEach(optionalInteger -> {
            if (fordwardIterator.hasNext())
                assertEquals(optionalInteger, fordwardIterator.next());
        });
    }

    @Test
    public void testReadThreeElementOfBackwardIterator() {
        VALUES_LIST_IN_ORDER.forEach(value -> this.iteratorList.add(value));
        final Iterator<Integer> backwardIterator = this.iteratorList.backwardIterator();

        REVERSE_VALUES_LIST_IN_ORDER.forEach(optionalInteger -> {
            if (backwardIterator.hasNext())
                assertEquals(optionalInteger, backwardIterator.next());
        });
    }

    @Test
    public void testFeatureCircularlyForwardIterator() {
        VALUES_LIST_IN_ORDER.forEach(value -> this.iteratorList.add(value));
        final Iterator<Integer> fordwardIterator = this.iteratorList.forwardIterator();

        VALUES_LIST_IN_ORDER.forEach(optionalInteger -> {
            if (fordwardIterator.hasNext())
                assertEquals(optionalInteger, fordwardIterator.next());
        });
        assertEquals(ZERO_VALUE, fordwardIterator.next());
    }

    @Test
    public void testFeatureCircularlyBackwardIterator() {
        VALUES_LIST_IN_ORDER.forEach(value -> this.iteratorList.add(value));
        final Iterator<Integer> backwardIterator = this.iteratorList.backwardIterator();

        REVERSE_VALUES_LIST_IN_ORDER.forEach(optionalInteger -> {
            if (backwardIterator.hasNext())
                assertEquals(optionalInteger, backwardIterator.next());
        });
        assertEquals(TWO_VALUE, backwardIterator.next());
    }

    @Test
    public void testTogetherForwardAndBackwardIterators() {
        VALUES_LIST_IN_ORDER.forEach(value -> this.iteratorList.add(value));

        final Iterator<Integer> fordwardIterator = this.iteratorList.forwardIterator();
        final Iterator<Integer> backwardIterator = this.iteratorList.backwardIterator();

        VALUES_LIST_IN_ORDER.forEach(optionalInteger -> {
            if (fordwardIterator.hasNext())
                assertEquals(optionalInteger, fordwardIterator.next());
        });

        REVERSE_VALUES_LIST_IN_ORDER.forEach(optionalInteger -> {
            if (backwardIterator.hasNext())
                assertEquals(optionalInteger, backwardIterator.next());
        });
    }

    @Test
    public void testFeatureCircularlyWithSingleElementInForwardIterator() {
        this.addElementsInOrderInList(ONE_ELEMENT);
        final Iterator<Integer> forwardIterator = this.iteratorList.forwardIterator();

        for (int i = INITIAL_VALUE_OF_FOR; i < THREE_ELEMENT; i++)
            assertEquals(ZERO_VALUE, forwardIterator.next());
    }

    @Test
    public void testFeatureCircularlyWithSingleElementInBackwardIterator() {
        this.addElementsInOrderInList(ONE_ELEMENT);
        final Iterator<Integer> forwardIterator = this.iteratorList.backwardIterator();

        for (int i = INITIAL_VALUE_OF_FOR; i < THREE_ELEMENT; i++)
            assertEquals(ZERO_VALUE, forwardIterator.next());
    }
}