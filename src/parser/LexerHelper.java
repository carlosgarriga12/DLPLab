package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

    public static char lexemeToChar(String text) {

		char c = text.charAt(1);

		if (c == '\\') {
			if (text.charAt(2)=='n') return '\n';
			if (text.charAt(2)=='t') return '\t';

			String numberString = text.substring(2, text.length() - 1);

			try {
				int number = Integer.parseInt(numberString);
				return (char) number;
			} catch(NumberFormatException e) {
				System.out.println(e);
			}
		} else {
			return c;
		}

		return Character.MIN_VALUE;
	}

	public static double lexemeToReal(String text) {
		try {
			return Double.parseDouble(text);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}
}
