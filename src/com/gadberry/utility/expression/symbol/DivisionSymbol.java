package com.gadberry.utility.expression.symbol;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;

/**
 * @author Aaron Gadberry
 */

public class DivisionSymbol extends TwoDoublesSymbol {

	/**
	 * Create a DivisionSymbol with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public DivisionSymbol(Expression expression) {
		super(expression);
	}

	@Override
	public int getPriority() {
		return 10;
	}

	@Override
	public Argument resolve() {
		double lhs = getArgument(0).toDouble();
		double rhs = getArgument(1).toDouble();
		return new Argument(lhs / rhs, getResolver());
	}

}
