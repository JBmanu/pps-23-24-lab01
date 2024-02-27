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
    private CircularList circularList;


    //TODO: test implementation
    @Disabled
    @Test public void testTodo(){
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
        this.circularList.add(0);

        assertFalse(this.circularList.isEmpty());
        assertEquals(1, this.circularList.size());
        assertEquals(Optional.of(0), this.circularList.next());
    }

    @Test
    public void testAddElementAndReadPrev() {
        this.circularList.add(0);

        assertFalse(this.circularList.isEmpty());
        assertEquals(1, this.circularList.size());
        assertEquals(Optional.of(0), this.circularList.previous());
    }




}
