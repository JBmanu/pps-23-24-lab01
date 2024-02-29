import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import tdd.CircularList;
import tdd.SimpleCircularList;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private static final int EMPTY_LIST = 0;
    private static final int ONE_ELEMENT = 1;
    private static final int THREE_ELEMENTS = 3;

    private static final int ZERO_VALUE = 0;
    private static final int ONE_VALUE = 1;
    private static final int TWO_VALUE = 2;
    private static final List<Integer> VALUES_LIST_IN_ORDER = IntStream.rangeClosed(ZERO_VALUE, TWO_VALUE).boxed().toList();
    private static final List<Integer> REVERSE_VALUES_LIST_IN_ORDER = IntStream.iterate(TWO_VALUE, i -> i - ONE_VALUE)
            .limit(VALUES_LIST_IN_ORDER.size())
            .boxed()
            .toList();

    private CircularList circularList;

    //TODO: test implementation
    @Disabled
    @Test
    public void testTodo() {
        Assertions.fail();
    }

    @BeforeEach
    public void createCircularList() {
        this.circularList = new SimpleCircularList();
    }

    @Test
    public void testEmptyListAndSizeZero() {
        assertTrue(this.circularList.isEmpty());
        assertEquals(EMPTY_LIST, this.circularList.size());
    }

    @Test
    public void testNextWhenEmptyList() {
        assertEquals(Optional.empty(), this.circularList.next());
    }

    @Test
    public void testPreviousEmptyList() {
        assertEquals(Optional.empty(), this.circularList.previous());
    }

    private void addElementsInOrderInList(final int quantity) {
        IntStream.range(ZERO_VALUE, quantity).forEach(value -> this.circularList.add(value));
    }

    @Test
    public void testAddElement() {
        this.addElementsInOrderInList(ONE_ELEMENT);

        assertFalse(this.circularList.isEmpty());
        assertEquals(ONE_ELEMENT, this.circularList.size());
    }

    @Test
    public void testAddThreeElement() {
        this.addElementsInOrderInList(THREE_ELEMENTS);

        assertFalse(this.circularList.isEmpty());
        assertEquals(THREE_ELEMENTS, this.circularList.size());
    }

    @Test
    public void testAddElementAndReadNext() {
        this.addElementsInOrderInList(ONE_ELEMENT);
        assertEquals(Optional.of(ZERO_VALUE), this.circularList.next());
    }

    @Test
    public void testAddElementAndReadPrevious() {
        this.addElementsInOrderInList(ONE_ELEMENT);
        assertEquals(Optional.of(ZERO_VALUE), this.circularList.previous());
    }

    @Test
    public void testAddOneElementAndResetList() {
        this.addElementsInOrderInList(ONE_ELEMENT);
        this.circularList.reset();

        assertEquals(EMPTY_LIST, this.circularList.size());
    }

    @Test
    public void testAddThreeElementsAndReadThreeNext() {
        this.addElementsInOrderInList(VALUES_LIST_IN_ORDER.size());

        VALUES_LIST_IN_ORDER.forEach(value ->
                assertEquals(Optional.of(value), this.circularList.next()));
    }

    @Test
    public void testAddThreeElementsAndReadThreePrevious() {
        this.addElementsInOrderInList(REVERSE_VALUES_LIST_IN_ORDER.size());

        REVERSE_VALUES_LIST_IN_ORDER.forEach(value ->
                assertEquals(Optional.of(value), this.circularList.previous()));
    }

    @Test
    public void testAddThreeElementAndResetList() {
        this.addElementsInOrderInList(THREE_ELEMENTS);
        this.circularList.reset();

        assertEquals(EMPTY_LIST, this.circularList.size());
    }

    @Test
    public void testCycleFeatureWithNext() {
        this.addElementsInOrderInList(VALUES_LIST_IN_ORDER.size());

        VALUES_LIST_IN_ORDER.forEach(value ->
                assertEquals(Optional.of(value), this.circularList.next()));
        assertEquals(Optional.of(ZERO_VALUE), this.circularList.next());
    }

    @Test
    public void testCycleFeatureWithPrevious() {
        this.addElementsInOrderInList(REVERSE_VALUES_LIST_IN_ORDER.size());

        REVERSE_VALUES_LIST_IN_ORDER.forEach(value ->
                assertEquals(Optional.of(value), this.circularList.previous()));
        assertEquals(Optional.of(TWO_VALUE), this.circularList.previous());
    }

    @Test
    public void testCycleFeatureUsingTwoNextAndPrevious() {
        this.addElementsInOrderInList(VALUES_LIST_IN_ORDER.size());

        assertEquals(Optional.of(ZERO_VALUE), this.circularList.next());
        assertEquals(Optional.of(ONE_VALUE), this.circularList.next());
        assertEquals(Optional.of(ZERO_VALUE), this.circularList.previous());
        assertEquals(Optional.of(TWO_VALUE), this.circularList.previous());
    }
}