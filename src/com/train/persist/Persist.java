package com.train.persist;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/*
	Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence,
	which is the number of times you must multiply the digits in num until you reach a single digit.
	For example:
	persistence(39) == 3 // because 3*9 = 27, 2*7 = 14, 1*4=4
	persistence(999) == 4 // because 9*9*9 = 729, 7*2*9 = 126,
	persistence(4) == 0 // because 4 is already a one-digit number
*/

/**
	@author: Uíres
*/
class Persist {

	public static int persistence(int n) {

		if (isSingleDigit(n)) {

			return 0;
		}

		long aux = 0;
		int cont = 0;
		int vezes = 0;
		while (true) {

			if (cont > 0) {

				int[] inteirosRelativos = transformAValueIntoAnArray(aux);
				String expressaoMatematica = formatAMathExpressionByTheArray(inteirosRelativos);

				try {

					aux = solveMathExpressionProviderByString(expressaoMatematica);
				} catch (ScriptException e) {

					e.printStackTrace();
				}
				vezes++;
				if (isSingleDigit(aux)) {

					return vezes;
				} else {

					continue;
				}
			}

			int[] inteirosRelativos = transformAValueIntoAnArray((long) n);
			String expressaoMatematica = formatAMathExpressionByTheArray(inteirosRelativos);

			try {

				aux = solveMathExpressionProviderByString(expressaoMatematica);
			} catch (ScriptException e) {

				e.printStackTrace();
			}
			vezes++;
			if (isSingleDigit(aux)) {

				return vezes;
			}
			cont++;
		}
	}

	private static String formatAMathExpressionByTheArray(int[] valores) {

		StringBuilder builder = new StringBuilder();

		for (int i : valores) {

			builder.append(i + "*");
		}

		String fieldName = builder.substring(0, builder.length() - 1);
		return fieldName;
	}

	private static int[] transformAValueIntoAnArray(Long value) {

		return Long.toString(value).chars().map(c -> c - '0').toArray();
	}

	private static boolean isSingleDigit(long value) {

		return value < 10 && value >= 0;
	}

	private static int solveMathExpressionProviderByString(String expressaoMatematica) throws ScriptException {

		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");

		return (int) engine.eval(expressaoMatematica);
	}
}