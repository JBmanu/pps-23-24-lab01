import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.filterCircularlyList.FilterCircularlyList;
import tdd.filterCircularlyList.SimpleFilterCircularlyList;

import static org.junit.jupiter.api.Assertions.*;

public class FilterCircularlyListTest {
    private static final int EMPTY_LIST = 0;
    private static final int INITIAL_FOR_VALUE = 0;
    private static final int ONE_ELEMENT = 1;
    private static final int THREE_ELEMENT = 3;

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
        for (int i = INITIAL_FOR_VALUE; i < quantity; i++)
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







}
