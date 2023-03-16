package org.howard.edu.hw5;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class IntergerSetTest {
	
	@Test
	@DisplayName("Test case for clear")
	public void testClear() {
		IntegerSet set = new IntegerSet();
		set.add(1);
		set.add(2);
		set.add(3);
		set.clear();
		assertEquals(0, set.length());
	}
	
	@Test
	@DisplayName("Test case for length")
	public void testLength() {
		IntegerSet set = new IntegerSet();
		assertEquals(0, set.length());
		set.add(1);
		set.add(2);
		assertEquals(2, set.length());
	}
	
	@Test
	@DisplayName("Test case for equals")
	public void testEquals() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set2.add(2);
		set2.add(1);
		assertTrue(set1.equals(set2));
		set2.add(3);
		assertFalse(set1.equals(set2));
	}
	
	@Test
	@DisplayName("Test case for contains")
	public void testContains() {
		IntegerSet set = new IntegerSet();
		set.add(1);
		set.add(2);
		assertTrue(set.contains(1));
		assertFalse(set.contains(3));
	}
	
	@Test
	@DisplayName("Test case for largest with empty set")
	public void testLargestWithEmptySet() {
		IntegerSet set = new IntegerSet();
		Assertions.assertThrows(IntegerSetException.class, () -> set.largest());
	}
	
	@Test
	@DisplayName("Test case for smallest with empty set")
	public void testSmallestWithEmptySet() {
		IntegerSet set = new IntegerSet();
		Assertions.assertThrows(IntegerSetException.class, () -> set.smallest());
	}
	
	@Test
	@DisplayName("Test case for add")
	public void testAdd() {
		IntegerSet set = new IntegerSet();
		set.add(1);
		set.add(2);
		assertEquals(2, set.length());
		set.add(2);
		assertEquals(2, set.length());
	}
	
	@Test
	@DisplayName("Test case for remove")
	public void testRemove() {
		IntegerSet set = new IntegerSet();
		set.add(1);
		set.add(2);
		set.remove(2);
		assertEquals(1, set.length());
		assertFalse(set.contains(2));
		set.remove(2);
		assertEquals(1, set.length());
	}
	
	@Test
	@DisplayName("Test case for union")
	public void testUnion() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set2.add(2);
		set2.add(3);
		set1.union(set2);
		assertEquals(3, set1.length());
		assertTrue(set1.contains(1));
	}
	  @Test
	  @DisplayName("Test case for intersect")
	  public void testIntersect() {
	    IntegerSet set1 = new IntegerSet();
	    set1.add(1);
	    set1.add(2);
	    set1.add(3);
	    
	    IntegerSet set2 = new IntegerSet();
	    set2.add(2);
	    set2.add(3);
	    set2.add(4);
	    
	    set1.intersect(set2);
	    assertEquals("(2,3)", set1.toString());
	  }
	  
	  @Test
	  @DisplayName("Test case for diff")
	  public void testDiff() {
	    IntegerSet set1 = new IntegerSet();
	    set1.add(1);
	    set1.add(2);
	    set1.add(3);
	    
	    IntegerSet set2 = new IntegerSet();
	    set2.add(2);
	    set2.add(3);
	    set2.add(4);
	    
	    set2.diff(set1);
	    assertEquals("(4)", set2.toString());
	  }
	  
	  @Test
	  @DisplayName("Test case for isEmpty")
	  public void testIsEmpty() {
	    IntegerSet set1 = new IntegerSet();
	    assertTrue(set1.isEmpty());
	    
	    set1.add(1);
	    assertFalse(set1.isEmpty());
	    
	    set1.remove(1);
	    assertTrue(set1.isEmpty());
	  }
	  
	  @Test
	  @DisplayName("Test case for toString")
	  public void testToString() {
	    IntegerSet set1 = new IntegerSet();
	    set1.add(1);
	    set1.add(2);
	    set1.add(3);
	    
	    assertEquals("(1,2,3)", set1.toString());
	  }
	  @Test
	  @DisplayName("Test case for smallest when set contains multiple elements")
	  public void testSmallestMultiElementSet() {
	      IntegerSet set = new IntegerSet();
	      set.add(5);
	      set.add(10);
	      set.add(1);
	      try {
	          assertEquals(1, set.smallest());
	      } catch (Exception e) {
	          fail("Exception should not have been thrown");
	      }
	  }

	  @Test
	  @DisplayName("Test case for largest when set contains multiple elements")
	  public void testLargestMultiElementSet() {
	      IntegerSet set = new IntegerSet();
	      set.add(5);
	      set.add(10);
	      set.add(1);
	      try {
	          assertEquals(10, set.largest());
	      } catch (Exception e) {
	          fail("Exception should not have been thrown");
	      }
	  }
	}




