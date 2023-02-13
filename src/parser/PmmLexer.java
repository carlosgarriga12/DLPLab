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
		INT_CONSTANT=1, CHAR_CONSTANT=2, REAL_CONSTANT=3, TRASH=4;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT_CONSTANT", "CHAR_CONSTANT", "REAL_CONSTANT", "TRASH"
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
			null, "INT_CONSTANT", "CHAR_CONSTANT", "REAL_CONSTANT", "TRASH"
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
		"\u0004\u0000\u00044\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u0000\r\b\u0000\n\u0000\f\u0000\u0010\t"+
		"\u0000\u0003\u0000\u0012\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001$\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002/\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0000"+
		"\u0000\u0004\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\u0001\u0000"+
		"\u0003\u0001\u000019\u0001\u000009\u0002\u0000\t\n\r\r:\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0001\u0011\u0001"+
		"\u0000\u0000\u0000\u0003#\u0001\u0000\u0000\u0000\u0005.\u0001\u0000\u0000"+
		"\u0000\u00070\u0001\u0000\u0000\u0000\t\u0012\u00050\u0000\u0000\n\u000e"+
		"\u0007\u0000\u0000\u0000\u000b\r\u0007\u0001\u0000\u0000\f\u000b\u0001"+
		"\u0000\u0000\u0000\r\u0010\u0001\u0000\u0000\u0000\u000e\f\u0001\u0000"+
		"\u0000\u0000\u000e\u000f\u0001\u0000\u0000\u0000\u000f\u0012\u0001\u0000"+
		"\u0000\u0000\u0010\u000e\u0001\u0000\u0000\u0000\u0011\t\u0001\u0000\u0000"+
		"\u0000\u0011\n\u0001\u0000\u0000\u0000\u0012\u0002\u0001\u0000\u0000\u0000"+
		"\u0013\u0014\u0005\'\u0000\u0000\u0014\u0015\t\u0000\u0000\u0000\u0015"+
		"$\u0005\'\u0000\u0000\u0016\u0017\u0005\'\u0000\u0000\u0017\u0018\u0005"+
		"\\\u0000\u0000\u0018\u0019\u0003\u0001\u0000\u0000\u0019\u001a\u0005\'"+
		"\u0000\u0000\u001a$\u0001\u0000\u0000\u0000\u001b\u001c\u0005\'\u0000"+
		"\u0000\u001c\u001d\u0005\\\u0000\u0000\u001d\u001e\u0005n\u0000\u0000"+
		"\u001e$\u0005\'\u0000\u0000\u001f \u0005\'\u0000\u0000 !\u0005\\\u0000"+
		"\u0000!\"\u0005t\u0000\u0000\"$\u0005\'\u0000\u0000#\u0013\u0001\u0000"+
		"\u0000\u0000#\u0016\u0001\u0000\u0000\u0000#\u001b\u0001\u0000\u0000\u0000"+
		"#\u001f\u0001\u0000\u0000\u0000$\u0004\u0001\u0000\u0000\u0000%&\u0003"+
		"\u0001\u0000\u0000&\'\u0005.\u0000\u0000\'(\u0003\u0001\u0000\u0000(/"+
		"\u0001\u0000\u0000\u0000)*\u0003\u0001\u0000\u0000*+\u0005.\u0000\u0000"+
		"+/\u0001\u0000\u0000\u0000,-\u0005.\u0000\u0000-/\u0003\u0001\u0000\u0000"+
		".%\u0001\u0000\u0000\u0000.)\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000"+
		"\u0000/\u0006\u0001\u0000\u0000\u000001\u0007\u0002\u0000\u000012\u0001"+
		"\u0000\u0000\u000023\u0006\u0003\u0000\u00003\b\u0001\u0000\u0000\u0000"+
		"\u0005\u0000\u000e\u0011#.\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}