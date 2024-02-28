import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.iteratorList.IteratorList;
import tdd.iteratorList.SimpleIteratorList;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleIteratorListTest {
    private static final int EMPTY_LIST = 0;
    private static final int INITIAL_VALUE = 0;
    private static final int ONE_ELEMENT = 1;
    private static final int THREE_ELEMENT = 3;

    private static final Optional<Integer> ZERO_OPTIONAL_VALUE = Optional.of(0);

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

}
