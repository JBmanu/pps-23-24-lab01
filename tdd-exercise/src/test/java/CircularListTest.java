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
    private static final int ONE_ELEMENT = 1;
    private static final int THREE_ELEMENTS = 3;

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
        assertEquals(0, this.circularList.size());
    }

    @Test
    public void testAddElementAndReadNext() {
        this.addElementsInOrderInList(ONE_ELEMENT);

        assertFalse(this.circularList.isEmpty());
        assertEquals(1, this.circularList.size());
        assertEquals(Optional.of(0), this.circularList.next());
    }

    @Test
    public void testAddElementAndReadPrevious() {
        this.addElementsInOrderInList(ONE_ELEMENT);

        assertFalse(this.circularList.isEmpty());
        assertEquals(1, this.circularList.size());
        assertEquals(Optional.of(0), this.circularList.previous());
    }

    @Test
    public void testResetList() {
        this.addElementsInOrderInList(ONE_ELEMENT);

        assertFalse(this.circularList.isEmpty());
        assertEquals(1, this.circularList.size());

        this.circularList.reset();
        assertTrue(this.circularList.isEmpty());
        assertEquals(0, this.circularList.size());
    }

    private void addElementsInOrderInList(final int countElements) {
        for (int i = 0; i < countElements; i++)
            this.circularList.add(i);
    }

    @Test
    public void testAddThreeElementsAndReadThreeNext() {
        this.addElementsInOrderInList(THREE_ELEMENTS);

        assertEquals(THREE_ELEMENTS, this.circularList.size());
        assertEquals(Optional.of(0), this.circularList.next());
        assertEquals(Optional.of(1), this.circularList.next());
        assertEquals(Optional.of(2), this.circularList.next());
    }

    @Test
    public void testAddThreeElementsAndReadThreePrevious() {
        this.addElementsInOrderInList(THREE_ELEMENTS);

        assertEquals(THREE_ELEMENTS, this.circularList.size());
        assertEquals(Optional.of(2), this.circularList.previous());
        assertEquals(Optional.of(1), this.circularList.previous());
        assertEquals(Optional.of(0), this.circularList.previous());
    }


}
