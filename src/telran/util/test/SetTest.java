package telran.util.test;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import telran.util.*;

public abstract class SetTest extends CollectionTest {

	@Override
	@Test
	void addTest() {
		assertFalse(collection.add(10));
		runArrayTest(numbers, collection.toArray(new Integer[0]));
	}
	@Test
	void getPatternTest() {
		assertEquals(numbers[1], ((Set<Integer>)collection).get(numbers[1]));
		assertNull(((Set<Integer>)collection).get(100000));
	}

}
