// Generated from java-escape by ANTLR 4.11.1
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PmmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT_CONSTANT=1, CHAR_CONSTANT=2, REAL_CONSTANT=3, ID=4, ONE_LINE_COMMENT=5, 
		MULTILINE_COMMENT=6, TRASH=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT_CONSTANT", "CHAR_CONSTANT", "REAL_CONSTANT", "FLOATING_POINT", "MANTISSA", 
			"LETTER", "DIGIT", "THREE_APOSTROPHE", "ID", "ONE_LINE_COMMENT", "MULTILINE_COMMENT", 
			"TRASH"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT_CONSTANT", "CHAR_CONSTANT", "REAL_CONSTANT", "ID", "ONE_LINE_COMMENT", 
			"MULTILINE_COMMENT", "TRASH"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public PmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0007}\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u001d\b\u0000"+
		"\n\u0000\f\u0000 \t\u0000\u0003\u0000\"\b\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00010\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0003\u00024\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003?\b\u0003\u0001\u0004\u0001\u0004\u0003\u0004"+
		"C\b\u0004\u0001\u0004\u0001\u0004\u0003\u0004G\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0003\u0005L\b\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0003\bV\b"+
		"\b\u0001\b\u0001\b\u0001\b\u0005\b[\b\b\n\b\f\b^\t\b\u0001\t\u0001\t\u0005"+
		"\tb\b\t\n\t\f\te\t\t\u0001\t\u0003\th\b\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0005\nn\b\n\n\n\f\nq\t\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0004\u000bx\b\u000b\u000b\u000b\f\u000by\u0001\u000b\u0001\u000b\u0002"+
		"co\u0000\f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0000\t\u0000\u000b"+
		"\u0000\r\u0000\u000f\u0000\u0011\u0004\u0013\u0005\u0015\u0006\u0017\u0007"+
		"\u0001\u0000\t\u0001\u000019\u0001\u000009\u0002\u0000nntt\u0002\u0000"+
		"EEee\u0002\u0000++--\u0002\u0000AZaz\u0001\u0000\n\n\u0001\u0001\n\n\u0003"+
		"\u0000\t\n\r\r  \u0087\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0001!\u0001"+
		"\u0000\u0000\u0000\u0003/\u0001\u0000\u0000\u0000\u00053\u0001\u0000\u0000"+
		"\u0000\u0007>\u0001\u0000\u0000\u0000\tB\u0001\u0000\u0000\u0000\u000b"+
		"K\u0001\u0000\u0000\u0000\rM\u0001\u0000\u0000\u0000\u000fO\u0001\u0000"+
		"\u0000\u0000\u0011U\u0001\u0000\u0000\u0000\u0013_\u0001\u0000\u0000\u0000"+
		"\u0015k\u0001\u0000\u0000\u0000\u0017w\u0001\u0000\u0000\u0000\u0019\""+
		"\u00050\u0000\u0000\u001a\u001e\u0007\u0000\u0000\u0000\u001b\u001d\u0007"+
		"\u0001\u0000\u0000\u001c\u001b\u0001\u0000\u0000\u0000\u001d \u0001\u0000"+
		"\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000"+
		"\u0000\u0000\u001f\"\u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000"+
		"\u0000!\u0019\u0001\u0000\u0000\u0000!\u001a\u0001\u0000\u0000\u0000\""+
		"\u0002\u0001\u0000\u0000\u0000#$\u0005\'\u0000\u0000$%\t\u0000\u0000\u0000"+
		"%0\u0005\'\u0000\u0000&\'\u0005\'\u0000\u0000\'(\u0005\\\u0000\u0000("+
		")\u0003\u0001\u0000\u0000)*\u0005\'\u0000\u0000*0\u0001\u0000\u0000\u0000"+
		"+,\u0005\'\u0000\u0000,-\u0005\\\u0000\u0000-.\u0007\u0002\u0000\u0000"+
		".0\u0005\'\u0000\u0000/#\u0001\u0000\u0000\u0000/&\u0001\u0000\u0000\u0000"+
		"/+\u0001\u0000\u0000\u00000\u0004\u0001\u0000\u0000\u000014\u0003\u0007"+
		"\u0003\u000024\u0003\t\u0004\u000031\u0001\u0000\u0000\u000032\u0001\u0000"+
		"\u0000\u00004\u0006\u0001\u0000\u0000\u000056\u0003\u0001\u0000\u0000"+
		"67\u0005.\u0000\u000078\u0003\u0001\u0000\u00008?\u0001\u0000\u0000\u0000"+
		"9:\u0003\u0001\u0000\u0000:;\u0005.\u0000\u0000;?\u0001\u0000\u0000\u0000"+
		"<=\u0005.\u0000\u0000=?\u0003\u0001\u0000\u0000>5\u0001\u0000\u0000\u0000"+
		">9\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000?\b\u0001\u0000\u0000"+
		"\u0000@C\u0003\u0007\u0003\u0000AC\u0003\u0001\u0000\u0000B@\u0001\u0000"+
		"\u0000\u0000BA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DF\u0007"+
		"\u0003\u0000\u0000EG\u0007\u0004\u0000\u0000FE\u0001\u0000\u0000\u0000"+
		"FG\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HI\u0003\u0001\u0000"+
		"\u0000I\n\u0001\u0000\u0000\u0000JL\u0007\u0005\u0000\u0000KJ\u0001\u0000"+
		"\u0000\u0000L\f\u0001\u0000\u0000\u0000MN\u0007\u0001\u0000\u0000N\u000e"+
		"\u0001\u0000\u0000\u0000OP\u0005\"\u0000\u0000PQ\u0005\"\u0000\u0000Q"+
		"R\u0005\"\u0000\u0000R\u0010\u0001\u0000\u0000\u0000SV\u0003\u000b\u0005"+
		"\u0000TV\u0005_\u0000\u0000US\u0001\u0000\u0000\u0000UT\u0001\u0000\u0000"+
		"\u0000V\\\u0001\u0000\u0000\u0000W[\u0003\u000b\u0005\u0000X[\u0003\r"+
		"\u0006\u0000Y[\u0005_\u0000\u0000ZW\u0001\u0000\u0000\u0000ZX\u0001\u0000"+
		"\u0000\u0000ZY\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000\u0000\\Z\u0001"+
		"\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]\u0012\u0001\u0000\u0000"+
		"\u0000^\\\u0001\u0000\u0000\u0000_c\u0005#\u0000\u0000`b\b\u0006\u0000"+
		"\u0000a`\u0001\u0000\u0000\u0000be\u0001\u0000\u0000\u0000cd\u0001\u0000"+
		"\u0000\u0000ca\u0001\u0000\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001"+
		"\u0000\u0000\u0000fh\u0007\u0007\u0000\u0000gf\u0001\u0000\u0000\u0000"+
		"hi\u0001\u0000\u0000\u0000ij\u0006\t\u0000\u0000j\u0014\u0001\u0000\u0000"+
		"\u0000ko\u0003\u000f\u0007\u0000ln\t\u0000\u0000\u0000ml\u0001\u0000\u0000"+
		"\u0000nq\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000om\u0001\u0000"+
		"\u0000\u0000pr\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000rs\u0003"+
		"\u000f\u0007\u0000st\u0001\u0000\u0000\u0000tu\u0006\n\u0000\u0000u\u0016"+
		"\u0001\u0000\u0000\u0000vx\u0007\b\u0000\u0000wv\u0001\u0000\u0000\u0000"+
		"xy\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000"+
		"\u0000z{\u0001\u0000\u0000\u0000{|\u0006\u000b\u0000\u0000|\u0018\u0001"+
		"\u0000\u0000\u0000\u0010\u0000\u001e!/3>BFKUZ\\cgoy\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}