import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.filterCircularlyList.FilterCircularlyList;
import tdd.filterCircularlyList.SimpleFilterCircularlyList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilterCircularlyListTest {
    private static final int EMPTY_LIST = 0;

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
}
