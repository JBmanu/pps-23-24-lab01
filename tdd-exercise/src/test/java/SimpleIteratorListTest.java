import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.iteratorList.IteratorList;
import tdd.iteratorList.SimpleIteratorList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleIteratorListTest {
    private IteratorList iteratorList = new SimpleIteratorList();

    @BeforeEach
    public void canCreateIteratorList() {
        this.iteratorList = new SimpleIteratorList();
    }

    @Test
    public void testEmpty() {
        assertTrue(this.iteratorList.isEmpty());
        assertEquals(0, this.iteratorList.size());
    }




}
