import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import tdd.CircularList;
import tdd.SimpleCircularList;

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

    private static final Optional<Integer> ZERO_VAlUE = Optional.of(0);
    private static final Optional<Integer> ONE_VAlUE = Optional.of(1);
    private static final Optional<Integer> TWO_VAlUE = Optional.of(2);

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
    public void testAddElementAndReadNext() {
        this.addElementsInOrderInList(ONE_ELEMENT);

        assertFalse(this.circularList.isEmpty());
        assertEquals(ONE_ELEMENT, this.circularList.size());
        assertEquals(ZERO_VAlUE, this.circularList.next());
    }

    @Test
    public void testAddElementAndReadPrevious() {
        this.addElementsInOrderInList(ONE_ELEMENT);

        assertFalse(this.circularList.isEmpty());
        assertEquals(ONE_ELEMENT, this.circularList.size());
        assertEquals(ZERO_VAlUE, this.circularList.previous());
    }

    @Test
    public void testResetList() {
        this.addElementsInOrderInList(ONE_ELEMENT);

        assertFalse(this.circularList.isEmpty());
        assertEquals(ONE_ELEMENT, this.circularList.size());

        this.circularList.reset();
        assertTrue(this.circularList.isEmpty());
        assertEquals(EMPTY_LIST, this.circularList.size());
    }

    private void addElementsInOrderInList(final int countElements) {
        for (int i = INITIAL_VALUE; i < countElements; i++)
            this.circularList.add(i);
    }

    @Test
    public void testAddThreeElementsAndReadThreeNext() {
        this.addElementsInOrderInList(THREE_ELEMENTS);

        assertEquals(THREE_ELEMENTS, this.circularList.size());
        assertEquals(ZERO_VAlUE, this.circularList.next());
        assertEquals(ONE_VAlUE, this.circularList.next());
        assertEquals(TWO_VAlUE, this.circularList.next());
    }

    @Test
    public void testAddThreeElementsAndReadThreePrevious() {
        this.addElementsInOrderInList(THREE_ELEMENTS);

        assertEquals(THREE_ELEMENTS, this.circularList.size());
        assertEquals(TWO_VAlUE, this.circularList.previous());
        assertEquals(ONE_VAlUE, this.circularList.previous());
        assertEquals(ZERO_VAlUE, this.circularList.previous());
    }

    @Test
    public void testCycleFeatureWithNext() {
        this.addElementsInOrderInList(THREE_ELEMENTS);

        assertEquals(THREE_ELEMENTS, this.circularList.size());
        assertEquals(ZERO_VAlUE, this.circularList.next());
        assertEquals(ONE_VAlUE, this.circularList.next());
        assertEquals(TWO_VAlUE, this.circularList.next());
        assertEquals(ZERO_VAlUE, this.circularList.next());
    }

    @Test
    public void testCycleFeatureWithPrevious() {
        this.addElementsInOrderInList(THREE_ELEMENTS);

        assertEquals(THREE_ELEMENTS, this.circularList.size());
        assertEquals(TWO_VAlUE, this.circularList.previous());
        assertEquals(ONE_VAlUE, this.circularList.previous());
        assertEquals(ZERO_VAlUE, this.circularList.previous());
        assertEquals(TWO_VAlUE, this.circularList.previous());
    }

}
