import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import tdd.CircularList;
import tdd.SimpleCircularList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private static final int EMPTY_LIST = 0;
    private static final int INITIAL_VALUE = 0;
    private static final int ONE_ELEMENT = 1;
    private static final int THREE_ELEMENTS = 3;

    private static final int ZERO_VALUE = 0;
    private static final int ONE_VALUE = 1;
    private static final int TWO_VALUE = 2;
    private static final List<Integer> VALUES_LIST_IN_ORDER =
            List.of(ZERO_VALUE, ONE_VALUE, TWO_VALUE);

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

    @Test
    public void testAddElementAndReadNext() {
        this.addElementsInOrderInList(ONE_ELEMENT);

        assertFalse(this.circularList.isEmpty());
        assertEquals(ONE_ELEMENT, this.circularList.size());
        assertEquals(Optional.of(ZERO_VALUE), this.circularList.next());
    }

    @Test
    public void testAddElementAndReadPrevious() {
        this.addElementsInOrderInList(ONE_ELEMENT);

        assertFalse(this.circularList.isEmpty());
        assertEquals(ONE_ELEMENT, this.circularList.size());
        assertEquals(Optional.of(ZERO_VALUE), this.circularList.previous());
    }

    @Test
    public void testAddOneElementAndResetList() {
        this.addElementsInOrderInList(ONE_ELEMENT);

        assertFalse(this.circularList.isEmpty());
        assertEquals(ONE_ELEMENT, this.circularList.size());

        this.circularList.reset();
        assertTrue(this.circularList.isEmpty());
        assertEquals(EMPTY_LIST, this.circularList.size());
    }

    private void addElementsInOrderInList(final int quantity) {
        for (int i = INITIAL_VALUE; i < quantity; i++)
            this.circularList.add(i);
    }

    @Test
    public void testAddThreeElementsAndReadThreeNext() {
        this.addElementsInOrderInList(THREE_ELEMENTS);

        assertEquals(THREE_ELEMENTS, this.circularList.size());
        VALUES_LIST_IN_ORDER.forEach(value ->
                assertEquals(Optional.of(value), this.circularList.next()));
    }

    @Test
    public void testAddThreeElementsAndReadThreePrevious() {
        this.addElementsInOrderInList(THREE_ELEMENTS);

        assertEquals(THREE_ELEMENTS, this.circularList.size());

        final List<Integer> reverseValuesListInOrder = new ArrayList<>(VALUES_LIST_IN_ORDER);
        Collections.reverse(reverseValuesListInOrder);
        reverseValuesListInOrder.forEach(value ->
                assertEquals(Optional.of(value), this.circularList.previous()));
    }

    @Test
    public void testAddThreeElementAndResetList() {
        this.addElementsInOrderInList(THREE_ELEMENTS);

        assertFalse(this.circularList.isEmpty());
        assertEquals(THREE_ELEMENTS, this.circularList.size());

        this.circularList.reset();
        assertTrue(this.circularList.isEmpty());
        assertEquals(EMPTY_LIST, this.circularList.size());
    }

    @Test
    public void testCycleFeatureWithNext() {
        this.addElementsInOrderInList(THREE_ELEMENTS);

        assertEquals(THREE_ELEMENTS, this.circularList.size());
        VALUES_LIST_IN_ORDER.forEach(value ->
                assertEquals(Optional.of(value), this.circularList.next()));
    }

    @Test
    public void testCycleFeatureWithPrevious() {
        this.addElementsInOrderInList(THREE_ELEMENTS);

        assertEquals(THREE_ELEMENTS, this.circularList.size());

        final List<Integer> reverseValuesListInOrder = new ArrayList<>(VALUES_LIST_IN_ORDER);
        Collections.reverse(reverseValuesListInOrder);

        reverseValuesListInOrder.forEach(value ->
                assertEquals(Optional.of(value), this.circularList.previous()));
    }

    @Test
    public void testCycleFeatureUsingTwoNextOnePrevious() {
        this.addElementsInOrderInList(THREE_ELEMENTS);

        assertEquals(THREE_ELEMENTS, this.circularList.size());

        assertEquals(Optional.of(ZERO_VALUE), this.circularList.next());
        assertEquals(Optional.of(ONE_VALUE), this.circularList.next());
        assertEquals(Optional.of(ZERO_VALUE), this.circularList.previous());
    }

}
