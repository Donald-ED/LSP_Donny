package org.howard.edu.lsp.midterm.problem51;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerRangeTest {
    private IntegerRange range;

    @BeforeEach
    void setUp() {
        range = new IntegerRange(1, 10);
    }

    @Test
    void testContains() {
        assertTrue(range.contains(1));
        assertTrue(range.contains(5));
        assertTrue(range.contains(10));
        assertFalse(range.contains(0));
        assertFalse(range.contains(11));
    }

    @Test
    void testOverlaps() throws EmptyRangeException {
        assertTrue(range.overlaps(new IntegerRange(5, 15)));
        assertTrue(range.overlaps(new IntegerRange(0, 10)));
        assertFalse(range.overlaps(new IntegerRange(11, 20)));
        assertThrows(EmptyRangeException.class, () -> range.overlaps(null));
    }

    @Test
    void testSize() {
        assertEquals(10, range.size());
        IntegerRange anotherRange = new IntegerRange(100, 105);
        assertEquals(6, anotherRange.size());
    }
}
