import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.iteratorList.IteratorList;
import tdd.iteratorList.SimpleIteratorList;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleIteratorListTest {
    private static final int EMPTY_LIST = 0;

    private static final int ELEMENT_ZERO = 0;
    private static final int ONE_ELEMENT = 1;

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

    @Test
    public void testAddElementInList() {
        this.iteratorList.add(ELEMENT_ZERO);

        assertFalse(this.iteratorList.isEmpty());
        assertEquals(ONE_ELEMENT, this.iteratorList.size());
    }




}
