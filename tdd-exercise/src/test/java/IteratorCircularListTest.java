import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.iteratorCicularList.IteratorCircularList;
import tdd.iteratorCicularList.SimpleIteratorCircularList;

import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class IteratorCircularListTest {
    private static final int EMPTY_LIST = 0;
    private static final int ONE_ELEMENT = 1;
    private static final int THREE_ELEMENT = 3;

    private static final int ZERO_VALUE = 0;
    private static final int ONE_VALUE = 1;
    private static final int TWO_VALUE = 2;
    private static final List<Integer> VALUES_LIST_IN_ORDER = IntStream.range(ZERO_VALUE, THREE_ELEMENT).boxed().toList();
    private static final List<Integer> REVERSE_VALUES_LIST_IN_ORDER = IntStream.iterate(TWO_VALUE, i -> i - ONE_VALUE)
            .limit(VALUES_LIST_IN_ORDER.size())
            .boxed()
            .toList();

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
        IntStream.range(ZERO_VALUE, quantity).forEach(value -> this.iteratorList.add(value));
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
        assertNotNull(this.iteratorList.forwardIterator());
    }

    @Test
    public void testCanCreateBackwardIterator() {
        assertNotNull(this.iteratorList.backwardIterator());
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
        VALUES_LIST_IN_ORDER.forEach(value -> {
            if (fordwardIterator.hasNext())
                assertEquals(value, fordwardIterator.next());
        });
    }

    @Test
    public void testReadThreeElementOfBackwardIterator() {
        VALUES_LIST_IN_ORDER.forEach(value -> this.iteratorList.add(value));
        final Iterator<Integer> backwardIterator = this.iteratorList.backwardIterator();

        REVERSE_VALUES_LIST_IN_ORDER.forEach(value -> {
            if (backwardIterator.hasNext())
                assertEquals(value, backwardIterator.next());
        });
    }

    @Test
    public void testFeatureCircularlyForwardIterator() {
        VALUES_LIST_IN_ORDER.forEach(value -> this.iteratorList.add(value));
        final Iterator<Integer> fordwardIterator = this.iteratorList.forwardIterator();

        VALUES_LIST_IN_ORDER.forEach(value -> {
            if (fordwardIterator.hasNext())
                assertEquals(value, fordwardIterator.next());
        });
        assertEquals(ZERO_VALUE, fordwardIterator.next());
    }

    @Test
    public void testFeatureCircularlyBackwardIterator() {
        VALUES_LIST_IN_ORDER.forEach(value -> this.iteratorList.add(value));
        final Iterator<Integer> backwardIterator = this.iteratorList.backwardIterator();

        REVERSE_VALUES_LIST_IN_ORDER.forEach(value -> {
            if (backwardIterator.hasNext())
                assertEquals(value, backwardIterator.next());
        });
        assertEquals(TWO_VALUE, backwardIterator.next());
    }

    @Test
    public void testTogetherForwardAndBackwardIterators() {
        VALUES_LIST_IN_ORDER.forEach(value -> this.iteratorList.add(value));

        final Iterator<Integer> fordwardIterator = this.iteratorList.forwardIterator();
        final Iterator<Integer> backwardIterator = this.iteratorList.backwardIterator();

        VALUES_LIST_IN_ORDER.forEach(value -> {
            if (fordwardIterator.hasNext())
                assertEquals(value, fordwardIterator.next());
        });

        REVERSE_VALUES_LIST_IN_ORDER.forEach(value -> {
            if (backwardIterator.hasNext())
                assertEquals(value, backwardIterator.next());
        });
    }

    @Test
    public void testFeatureCircularlyWithSingleElementInForwardIterator() {
        this.addElementsInOrderInList(ONE_ELEMENT);
        final Iterator<Integer> forwardIterator = this.iteratorList.forwardIterator();

        IntStream.range(ZERO_VALUE, THREE_ELEMENT).forEach(value ->
                assertEquals(ZERO_VALUE, forwardIterator.next()));
    }

    @Test
    public void testFeatureCircularlyWithSingleElementInBackwardIterator() {
        this.addElementsInOrderInList(ONE_ELEMENT);
        final Iterator<Integer> backwardIterator = this.iteratorList.backwardIterator();

        IntStream.range(ZERO_VALUE, THREE_ELEMENT).forEach(value ->
                assertEquals(ZERO_VALUE, backwardIterator.next()));
    }
}