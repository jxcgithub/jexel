package com.gadberry.utility.expression.function;

import java.util.ArrayList;
import java.util.List;

import com.gadberry.utility.FuzzyEquals;
import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.ArgumentCastException;
import com.gadberry.utility.expression.InvalidArgumentsException;
import com.gadberry.utility.expression.function.SinFunction;

import junit.framework.TestCase;

public class SinFunctionTests extends TestCase {

	private SinFunction op = null;

	protected void setUp() throws Exception {
		super.setUp();
		op = new SinFunction();
	}

	protected void tearDown() throws Exception {
		op = null;
		super.tearDown();
	}

	/**
	 * This checks basic sin
	 * 
	 * Test: sin( 90 )
	 */
	public void testResolve1() {
		List<Argument> args = new ArrayList<Argument>();
		args.add(new Argument(new Double(Math.toRadians(90)), null));
		try {
			op.setArguments(args);
			assertEquals(op.resolve(null).toDouble(), 1d, FuzzyEquals.TOLERANCE);
		} catch (InvalidArgumentsException e) {
			e.printStackTrace();
			fail();
		} catch (ArgumentCastException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * This checks a negative number
	 * 
	 * Test: sin( 270 )
	 */
	public void testResolve2() {
		List<Argument> args = new ArrayList<Argument>();
		args.add(new Argument(new Double(Math.toRadians(270)), null));
		try {
			op.setArguments(args);
			assertEquals(op.resolve(null).toDouble(), -1d, FuzzyEquals.TOLERANCE);
		} catch (InvalidArgumentsException e) {
			e.printStackTrace();
			fail();
		} catch (ArgumentCastException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * This checks a negetive sin
	 * 
	 * Test: sin( -90 )
	 */
	public void testResolve3() {
		List<Argument> args = new ArrayList<Argument>();
		args.add(new Argument(new Double(Math.toRadians(-90)), null));
		try {
			op.setArguments(args);
			assertEquals(op.resolve(null).toDouble(), -1d, FuzzyEquals.TOLERANCE);
		} catch (InvalidArgumentsException e) {
			e.printStackTrace();
			fail();
		} catch (ArgumentCastException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * This check one argument. Should not throw an exception.
	 * 
	 * Argument 1: 1
	 */
	public void testCheckArgs1() {
		List<Argument> args = new ArrayList<Argument>();
		args.add(new Argument(new Double(1), null));
		try {
			op.setArguments(args);
		} catch (InvalidArgumentsException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * This check standard arguments. Should throw an exception.
	 * 
	 * Argument 1: 1
	 * 
	 * Argument 2: 1
	 */
	public void testCheckArgs2() {
		List<Argument> args = new ArrayList<Argument>();
		args.add(new Argument(new Double(1), null));
		args.add(new Argument(new Float(1), null));
		try {
			op.setArguments(args);
			fail();
		} catch (InvalidArgumentsException e) {
		}
	}
	
	/**
	 * This checks three arguments. Should throw an exception.
	 * 
	 * Argument 1: 1
	 * 
	 * Argument 2: 1
	 * 
	 * Argument 3: 1
	 */
	public void testCheckArgs3() {
		List<Argument> args = new ArrayList<Argument>();
		args.add(new Argument(new Double(1), null));
		args.add(new Argument(new Float(1), null));
		args.add(new Argument(new Integer(1), null));
		try {
			op.setArguments(args);
			fail();
		} catch (InvalidArgumentsException e) {
		}
	}
	/**
	 * This checks non-double arguments. Should throw an exception for a
	 * non-double argument.
	 * 
	 * Argument 2: abc
	 */
	public void testCheckArgs4() {
		List<Argument> args = new ArrayList<Argument>();
		args.add(new Argument("abc", null));
		try {
			op.setArguments(args);
			fail();
		} catch (InvalidArgumentsException e) {
		}
	}

	/**
	 * Verify the priority
	 */
	public void testGetPriority() {
		assertEquals(op.getPriority(), 20);
	}

}