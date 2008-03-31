package com.gadberry.utility.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.gadberry.utility.FuzzyEquals;

/**
 * @author Aaron Gadberry
 *
 */
public class ArgumentTests {

	private Argument arg = null;

	/**
	 * Testing constructor and getObject
	 */
	@Test
	public void testConstructor1() {
		Object o = "abc";
		arg = new Argument(o, new MockResolver());
		assertNotNull(arg);

		assertEquals(arg.getObject(), "abc");
	}

	/**
	 * 
	 */
	@Test
	public void testConstructor2() {
		Object o = new Integer(0);
		arg = new Argument(o, null);
		assertNotNull(arg);

		assertEquals(arg.getObject(), o);
	}

	/**
	 * 
	 */
	@Test
	public void testEquals() {
		Argument arg2;

		arg = new Argument(new Integer(0), new MockResolver());
		arg2 = new Argument(new Integer(0), new MockResolver());
		assertTrue(arg.equals(arg2));

		arg = new Argument(new Double(1.2), new MockResolver());
		arg2 = new Argument(new Double(1.2), new MockResolver());
		assertTrue(arg.equals(arg2));

		arg = new Argument(new Double(1.3), new MockResolver());
		arg2 = new Argument(new Double(1.2), new MockResolver());
		assertFalse(arg.equals(arg2));

		arg = new Argument("abc", new MockResolver());
		arg2 = new Argument("abc", new MockResolver());
		assertTrue(arg.equals(arg2));

		arg = new Argument("abc", new MockResolver());
		arg2 = new Argument("def", new MockResolver());
		assertFalse(arg.equals(arg2));

		arg = new Argument("abc", new MockResolver());
		String s = "abc";
		assertFalse(arg.equals(s));
	}

	/**
	 * 
	 */
	@Test
	public void testIsDouble() {
		arg = new Argument(new Integer(0), new MockResolver());
		assertTrue(arg.isDouble());

		arg = new Argument(new Float(1.1), new MockResolver());
		assertTrue(arg.isDouble());

		arg = new Argument(new Double(1.2), new MockResolver());
		assertTrue(arg.isDouble());

		arg = new Argument("abc", new MockResolver());
		assertFalse(arg.isDouble());
	}

	/**
	 * 
	 */
	@Test
	public void testToBoolean() {
		arg = new Argument(new Boolean(true), new MockResolver());
		assertTrue(arg.toBoolean());

		arg = new Argument(new Boolean(false), new MockResolver());
		assertFalse(arg.toBoolean());

		arg = new Argument(new String("abc"), new MockResolver());
		try {
			arg.toBoolean();
			fail();
		} catch (ArgumentCastException e) {
		}
	}

	/**
	 * 
	 */
	@Test
	public void testToDouble() {
		arg = new Argument(new Integer(0), new MockResolver());
		try {
			assertEquals(arg.toDouble(), 0d, FuzzyEquals.TOLERANCE);
		} catch (ArgumentCastException e) {
			e.printStackTrace();
			fail();
		}

		arg = new Argument(new Long(1), new MockResolver());
		try {
			assertEquals(arg.toDouble(), 1d, FuzzyEquals.TOLERANCE);
		} catch (ArgumentCastException e) {
			e.printStackTrace();
			fail();
		}

		arg = new Argument(new Float(1.1), new MockResolver());
		try {
			assertEquals(arg.toDouble(), 1.1d, FuzzyEquals.TOLERANCE);
		} catch (ArgumentCastException e) {
			e.printStackTrace();
			fail();
		}

		arg = new Argument(new Double(1.2), new MockResolver());
		try {
			assertEquals(arg.toDouble(), 1.2d, FuzzyEquals.TOLERANCE);
		} catch (ArgumentCastException e) {
			e.printStackTrace();
			fail();
		}

		arg = new Argument("123.45", new MockResolver());
		try {
			assertEquals(arg.toDouble(), 123.45d, FuzzyEquals.TOLERANCE);
		} catch (ArgumentCastException e) {
			e.printStackTrace();
			fail();
		}

		arg = new Argument("abc", new MockResolver());
		try {
			arg.toDouble();
			fail();
		} catch (ArgumentCastException e) {
		}
	}

	/**
	 * 
	 */
	@Test
	public void testToInteger() {
		arg = new Argument(new Integer(0), null);
		try {
			assertEquals(arg.toInteger(), 0, FuzzyEquals.TOLERANCE);
		} catch (ArgumentCastException e) {
			e.printStackTrace();
			fail();
		}

		arg = new Argument(new Long(1), null);
		try {
			assertEquals(arg.toInteger(), 1, FuzzyEquals.TOLERANCE);
		} catch (ArgumentCastException e) {
			e.printStackTrace();
			fail();
		}

		arg = new Argument(new Float(1.1), null);
		try {
			assertEquals(arg.toInteger(), 1, FuzzyEquals.TOLERANCE);
		} catch (ArgumentCastException e) {
			e.printStackTrace();
			fail();
		}

		arg = new Argument(new Double(1.2), null);
		try {
			assertEquals(arg.toInteger(), 1, FuzzyEquals.TOLERANCE);
		} catch (ArgumentCastException e) {
			e.printStackTrace();
			fail();
		}

		arg = new Argument("123", new MockResolver());
		try {
			assertEquals(arg.toInteger(), 123, FuzzyEquals.TOLERANCE);
		} catch (ArgumentCastException e) {
			e.printStackTrace();
			fail();
		}

		arg = new Argument("abc", new MockResolver());
		try {
			arg.toInteger();
			fail();
		} catch (ArgumentCastException e) {
		}
	}

	/**
	 * 
	 */
	@Test
	public void testToString() {
		arg = new Argument(new Integer(0), new MockResolver());
		assertEquals(arg.toString(), "0");

		arg = new Argument(new Double(1.2), new MockResolver());
		assertEquals(arg.toString(), "1.2");

		arg = new Argument("abc", new MockResolver());
		assertEquals(arg.toString(), "abc");
	}
}
