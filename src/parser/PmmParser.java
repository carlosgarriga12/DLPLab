// Generated from java-escape by ANTLR 4.11.1
package parser;

    import ast.definition.*;
    import ast.expression.*;
    import ast.statement.*;
    import ast.type.*;
    import parser.LexerHelper;
    import ast.*;
    import java.util.stream.Collectors;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, INT_CONSTANT=38, 
		CHAR_CONSTANT=39, REAL_CONSTANT=40, ID=41, ONE_LINE_COMMENT=42, MULTILINE_COMMENT=43, 
		TRASH=44;
	public static final int
		RULE_program = 0, RULE_main_function = 1, RULE_definition = 2, RULE_varDefinition = 3, 
		RULE_functionDefinition = 4, RULE_parameters = 5, RULE_parameter = 6, 
		RULE_built_in_type = 7, RULE_type = 8, RULE_recordField = 9, RULE_expression = 10, 
		RULE_statement = 11, RULE_body = 12, RULE_expressions = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main_function", "definition", "varDefinition", "functionDefinition", 
			"parameters", "parameter", "built_in_type", "type", "recordField", "expression", 
			"statement", "body", "expressions"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'def'", "'main'", "'('", "')'", "':'", "'{'", "'}'", "','", "';'", 
			"'int'", "'char'", "'double'", "'['", "']'", "'struct'", "'.'", "'-'", 
			"'!'", "'*'", "'/'", "'%'", "'+'", "'<'", "'<='", "'=='", "'>='", "'>'", 
			"'!='", "'&&'", "'||'", "'while'", "'if'", "'else'", "'='", "'return'", 
			"'print'", "'input'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "INT_CONSTANT", "CHAR_CONSTANT", "REAL_CONSTANT", "ID", "ONE_LINE_COMMENT", 
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

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public List<Definition> aux = new ArrayList<>();
		public DefinitionContext definition;
		public Main_functionContext main_function;
		public Main_functionContext main_function() {
			return getRuleContext(Main_functionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PmmParser.EOF, 0); }
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(28);
					((ProgramContext)_localctx).definition = definition();
					_localctx.aux.addAll(((ProgramContext)_localctx).definition.ast);
					}
					} 
				}
				setState(35);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(36);
			((ProgramContext)_localctx).main_function = main_function();
			_localctx.aux.add(((ProgramContext)_localctx).main_function.ast);
			setState(38);
			match(EOF);
			((ProgramContext)_localctx).ast =  new Program(0,0, _localctx.aux);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Main_functionContext extends ParserRuleContext {
		public Definition ast;
		public List<Statement> statements = new ArrayList<>();
		public Token START;
		public VarDefinitionContext varDefinition;
		public StatementContext statement;
		public List<VarDefinitionContext> varDefinition() {
			return getRuleContexts(VarDefinitionContext.class);
		}
		public VarDefinitionContext varDefinition(int i) {
			return getRuleContext(VarDefinitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Main_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitMain_function(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Main_functionContext main_function() throws RecognitionException {
		Main_functionContext _localctx = new Main_functionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main_function);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			((Main_functionContext)_localctx).START = match(T__0);
			setState(42);
			match(T__1);
			setState(43);
			match(T__2);
			setState(44);
			match(T__3);
			setState(45);
			match(T__4);
			setState(46);
			match(T__5);
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(47);
					((Main_functionContext)_localctx).varDefinition = varDefinition();
					_localctx.statements.addAll(((Main_functionContext)_localctx).varDefinition.ast);
					}
					} 
				}
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4370129616904L) != 0) {
				{
				{
				setState(55);
				((Main_functionContext)_localctx).statement = statement();
				_localctx.statements.add(((Main_functionContext)_localctx).statement.ast);
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
			match(T__6);

			                    ((Main_functionContext)_localctx).ast =  new FunctionDefinition(
			                               ((Main_functionContext)_localctx).START.getLine(),
			                               ((Main_functionContext)_localctx).START.getCharPositionInLine() + 1,
			                               new FunctionType(0, 0, new ArrayList<>(), VoidType.getInstance()),
			                               "main",
			                               _localctx.statements
			                           );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<>();
		public VarDefinitionContext varDefinition;
		public FunctionDefinitionContext functionDefinition;
		public VarDefinitionContext varDefinition() {
			return getRuleContext(VarDefinitionContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(66);
				((DefinitionContext)_localctx).varDefinition = varDefinition();
				_localctx.ast.addAll(((DefinitionContext)_localctx).varDefinition.ast);
				}
				break;
			case T__0:
				{
				setState(69);
				((DefinitionContext)_localctx).functionDefinition = functionDefinition();
				_localctx.ast.add(((DefinitionContext)_localctx).functionDefinition.ast); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDefinitionContext extends ParserRuleContext {
		public List<VariableDefinition> ast = new ArrayList<>();
		public List<Token> aux = new ArrayList<>();
		public Token ID1;
		public Token ID2;
		public TypeContext type;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public VarDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitVarDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefinitionContext varDefinition() throws RecognitionException {
		VarDefinitionContext _localctx = new VarDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			((VarDefinitionContext)_localctx).ID1 = match(ID);
			 _localctx.aux.add(((VarDefinitionContext)_localctx).ID1);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(76);
				match(T__7);
				setState(77);
				((VarDefinitionContext)_localctx).ID2 = match(ID);
				 _localctx.aux.add(((VarDefinitionContext)_localctx).ID2);
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			match(T__4);
			setState(85);
			((VarDefinitionContext)_localctx).type = type();
			setState(86);
			match(T__8);
			_localctx.aux.forEach(token -> _localctx.ast.add(new VariableDefinition(
			                token.getLine(),
			                token.getCharPositionInLine() + 1,
			                ((VarDefinitionContext)_localctx).type.ast,
			                token.getText()
			        )));

			                for(int i = 0; i < _localctx.aux.size() - 1; i++) {
			                    VariableDefinition varDef = _localctx.ast.get(i);
			                    for(int j = i + 1; j < _localctx.aux.size(); j++) {
			                        if (varDef.getName().equals(_localctx.ast.get(j).getName())) {
			                            new ErrorType(
			                                _localctx.ast.get(j).getLine(),
			                                _localctx.ast.get(j).getColumn(),
			                                "Repeated variable definition " + _localctx.ast.get(j).getName()
			                            );
			                        }
			                    }
			                }
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public Definition ast;
		public List<Statement> statements = new ArrayList<>();
		public Token START;
		public Token ID;
		public ParametersContext parameters;
		public Built_in_typeContext built_in_type;
		public VarDefinitionContext varDefinition;
		public StatementContext statement;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public Built_in_typeContext built_in_type() {
			return getRuleContext(Built_in_typeContext.class,0);
		}
		public List<VarDefinitionContext> varDefinition() {
			return getRuleContexts(VarDefinitionContext.class);
		}
		public VarDefinitionContext varDefinition(int i) {
			return getRuleContext(VarDefinitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionDefinition);
		int _la;
		try {
			int _alt;
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				((FunctionDefinitionContext)_localctx).START = match(T__0);
				setState(91);
				((FunctionDefinitionContext)_localctx).ID = match(ID);
				setState(92);
				match(T__2);
				setState(93);
				((FunctionDefinitionContext)_localctx).parameters = parameters();
				setState(94);
				match(T__3);
				setState(95);
				match(T__4);
				setState(96);
				((FunctionDefinitionContext)_localctx).built_in_type = built_in_type();
				setState(97);
				match(T__5);
				setState(103);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(98);
						((FunctionDefinitionContext)_localctx).varDefinition = varDefinition();
						_localctx.statements.addAll(((FunctionDefinitionContext)_localctx).varDefinition.ast);
						}
						} 
					}
					setState(105);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4370129616904L) != 0) {
					{
					{
					setState(106);
					((FunctionDefinitionContext)_localctx).statement = statement();
					_localctx.statements.add(((FunctionDefinitionContext)_localctx).statement.ast);
					}
					}
					setState(113);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(114);
				match(T__6);


				                FunctionDefinition funcDef = new FunctionDefinition(
				                                                ((FunctionDefinitionContext)_localctx).START.getLine(),
				                                                ((FunctionDefinitionContext)_localctx).START.getCharPositionInLine() + 1,
				                                                new FunctionType(0, 0, ((FunctionDefinitionContext)_localctx).parameters.ast, ((FunctionDefinitionContext)_localctx).built_in_type.ast),
				                                                (((FunctionDefinitionContext)_localctx).ID!=null?((FunctionDefinitionContext)_localctx).ID.getText():null),
				                                                _localctx.statements
				                                            );
				                funcDef.addParameters(((FunctionDefinitionContext)_localctx).parameters.ast);
				                ((FunctionDefinitionContext)_localctx).ast =  funcDef;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				((FunctionDefinitionContext)_localctx).START = match(T__0);
				setState(118);
				((FunctionDefinitionContext)_localctx).ID = match(ID);
				setState(119);
				match(T__2);
				setState(120);
				((FunctionDefinitionContext)_localctx).parameters = parameters();
				setState(121);
				match(T__3);
				setState(122);
				match(T__4);
				setState(123);
				match(T__5);
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(124);
						((FunctionDefinitionContext)_localctx).varDefinition = varDefinition();
						_localctx.statements.addAll(((FunctionDefinitionContext)_localctx).varDefinition.ast);
						}
						} 
					}
					setState(131);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4370129616904L) != 0) {
					{
					{
					setState(132);
					((FunctionDefinitionContext)_localctx).statement = statement();
					_localctx.statements.add(((FunctionDefinitionContext)_localctx).statement.ast);
					}
					}
					setState(139);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(140);
				match(T__6);

				                FunctionDefinition funcDef = new FunctionDefinition(
				                                                    ((FunctionDefinitionContext)_localctx).START.getLine(),
				                                                    ((FunctionDefinitionContext)_localctx).START.getCharPositionInLine() + 1,
				                                                    new FunctionType(0, 0, ((FunctionDefinitionContext)_localctx).parameters.ast, VoidType.getInstance()),
				                                                    (((FunctionDefinitionContext)_localctx).ID!=null?((FunctionDefinitionContext)_localctx).ID.getText():null),
				                                                    _localctx.statements
				                                                );

				                funcDef.addParameters(((FunctionDefinitionContext)_localctx).parameters.ast);
				                ((FunctionDefinitionContext)_localctx).ast =  funcDef;
				                
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public List<VariableDefinition> ast = new ArrayList<>();
		public ParameterContext parameter;
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameters);
		int _la;
		try {
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				((ParametersContext)_localctx).parameter = parameter();
				_localctx.ast.add(((ParametersContext)_localctx).parameter.ast);
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(147);
					match(T__7);
					setState(148);
					((ParametersContext)_localctx).parameter = parameter();
					_localctx.ast.add(((ParametersContext)_localctx).parameter.ast);
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public VariableDefinition ast;
		public Token ID;
		public TypeContext type;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			((ParameterContext)_localctx).ID = match(ID);
			setState(160);
			match(T__4);
			setState(161);
			((ParameterContext)_localctx).type = type();
			((ParameterContext)_localctx).ast =  new VariableDefinition(
			                                    ((ParameterContext)_localctx).ID.getLine(),
			                                    ((ParameterContext)_localctx).ID.getCharPositionInLine() + 1,
			                                    ((ParameterContext)_localctx).type.ast,
			                                    (((ParameterContext)_localctx).ID!=null?((ParameterContext)_localctx).ID.getText():null)
			                               );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Built_in_typeContext extends ParserRuleContext {
		public Type ast;
		public Built_in_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_built_in_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitBuilt_in_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Built_in_typeContext built_in_type() throws RecognitionException {
		Built_in_typeContext _localctx = new Built_in_typeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_built_in_type);
		try {
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				match(T__9);
				((Built_in_typeContext)_localctx).ast =  IntType.getInstance();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				match(T__10);
				((Built_in_typeContext)_localctx).ast =  CharType.getInstance();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				match(T__11);
				((Built_in_typeContext)_localctx).ast =  RealType.getInstance();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public List<RecordField> recordFields = new ArrayList<>();
		public Built_in_typeContext built_in_type;
		public Token START;
		public Token INT_CONSTANT;
		public TypeContext t;
		public RecordFieldContext r;
		public Built_in_typeContext built_in_type() {
			return getRuleContext(Built_in_typeContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<RecordFieldContext> recordField() {
			return getRuleContexts(RecordFieldContext.class);
		}
		public RecordFieldContext recordField(int i) {
			return getRuleContext(RecordFieldContext.class,i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		int _la;
		try {
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__10:
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				((TypeContext)_localctx).built_in_type = built_in_type();
				((TypeContext)_localctx).ast =  ((TypeContext)_localctx).built_in_type.ast;
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				((TypeContext)_localctx).START = match(T__12);
				setState(176);
				((TypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(177);
				match(T__13);
				setState(178);
				((TypeContext)_localctx).t = type();
				((TypeContext)_localctx).ast =  new ArrayType(
				                                                        ((TypeContext)_localctx).START.getLine(),
				                                                        ((TypeContext)_localctx).START.getCharPositionInLine() + 1,
				                                                        ((TypeContext)_localctx).t.ast,
				                                                        LexerHelper.lexemeToInt((((TypeContext)_localctx).INT_CONSTANT!=null?((TypeContext)_localctx).INT_CONSTANT.getText():null))
				                                                     );
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
				((TypeContext)_localctx).START = match(T__14);
				setState(182);
				match(T__5);
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(183);
					((TypeContext)_localctx).r = recordField();
					_localctx.recordFields.addAll(((TypeContext)_localctx).r.ast); 
					}
					}
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(191);
				match(T__6);

				                for(int i = 0; i < _localctx.recordFields.size() - 1 ; i++) {
				                    RecordField r = _localctx.recordFields.get(i);
				                    for (int j = i + 1; j < _localctx.recordFields.size(); j++) {
				                        if(r.name.equals(_localctx.recordFields.get(j).name)) {
				                            ErrorType error = new ErrorType
				                            (
				                                _localctx.recordFields.get(j).getLine(),
				                                _localctx.recordFields.get(j).getColumn(),
				                                "Repeated field " + _localctx.recordFields.get(j).name + " for struct"
				                            );
				                        }
				                    }
				                }
				            
				((TypeContext)_localctx).ast =  new RecordType(
				                ((TypeContext)_localctx).START.getLine(),
				                ((TypeContext)_localctx).START.getCharPositionInLine() + 1,
				                _localctx.recordFields
				            );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RecordFieldContext extends ParserRuleContext {
		public List<RecordField> ast = new ArrayList<>();
		public List<Token> aux = new ArrayList<>();
		public Token ID;
		public TypeContext type;
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public RecordFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordField; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitRecordField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordFieldContext recordField() throws RecognitionException {
		RecordFieldContext _localctx = new RecordFieldContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_recordField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			((RecordFieldContext)_localctx).ID = match(ID);
			 _localctx.aux.add(((RecordFieldContext)_localctx).ID);
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(198);
				match(T__7);
				setState(199);
				((RecordFieldContext)_localctx).ID = match(ID);
				 _localctx.aux.add(((RecordFieldContext)_localctx).ID);
				}
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(206);
			match(T__4);
			setState(207);
			((RecordFieldContext)_localctx).type = type();
			setState(208);
			match(T__8);
			_localctx.aux.forEach(token -> _localctx.ast.add(new RecordField(
			                        token.getLine(),
			                        token.getCharPositionInLine() + 1,
			                        ((RecordFieldContext)_localctx).type.ast,
			                        token.getText()
			                )));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext exp1;
		public ExpressionContext e1;
		public Token INT_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token REAL_CONSTANT;
		public Token ID;
		public ExpressionsContext expressions;
		public Token START;
		public Built_in_typeContext b;
		public Token OP;
		public ExpressionContext exp2;
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(PmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(PmmParser.REAL_CONSTANT, 0); }
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Built_in_typeContext built_in_type() {
			return getRuleContext(Built_in_typeContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(212);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				((ExpressionContext)_localctx).ast =  new IntLiteral(
				            ((ExpressionContext)_localctx).INT_CONSTANT.getLine(),
				            ((ExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine() + 1,
				            LexerHelper.lexemeToInt((((ExpressionContext)_localctx).INT_CONSTANT!=null?((ExpressionContext)_localctx).INT_CONSTANT.getText():null))
				         );
				}
				break;
			case 2:
				{
				setState(214);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				((ExpressionContext)_localctx).ast =  new CharLiteral(
				            ((ExpressionContext)_localctx).CHAR_CONSTANT.getLine(),
				            ((ExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine() + 1,
				            LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CHAR_CONSTANT!=null?((ExpressionContext)_localctx).CHAR_CONSTANT.getText():null))
				         );
				}
				break;
			case 3:
				{
				setState(216);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				((ExpressionContext)_localctx).ast =  new RealLiteral(
				            ((ExpressionContext)_localctx).REAL_CONSTANT.getLine(),
				            ((ExpressionContext)_localctx).REAL_CONSTANT.getCharPositionInLine() + 1,
				            LexerHelper.lexemeToReal((((ExpressionContext)_localctx).REAL_CONSTANT!=null?((ExpressionContext)_localctx).REAL_CONSTANT.getText():null))
				         );
				}
				break;
			case 4:
				{
				setState(218);
				((ExpressionContext)_localctx).ID = match(ID);
				setState(219);
				match(T__2);
				setState(220);
				((ExpressionContext)_localctx).expressions = expressions();
				setState(221);
				match(T__3);
				((ExpressionContext)_localctx).ast =  new FunctionInvocation(
				            ((ExpressionContext)_localctx).ID.getLine(),
				            ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1,
				            new Variable(((ExpressionContext)_localctx).ID.getLine(),
				                         ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1,
				                         (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)),
				            ((ExpressionContext)_localctx).expressions.ast
				        );
				}
				break;
			case 5:
				{
				setState(224);
				((ExpressionContext)_localctx).ID = match(ID);
				((ExpressionContext)_localctx).ast =  new Variable(
				            ((ExpressionContext)_localctx).ID.getLine(),
				            ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1,
				            (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)
				        );
				}
				break;
			case 6:
				{
				setState(226);
				match(T__2);
				setState(227);
				((ExpressionContext)_localctx).exp1 = expression(0);
				setState(228);
				match(T__3);
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).exp1.ast; 
				}
				break;
			case 7:
				{
				setState(231);
				((ExpressionContext)_localctx).START = match(T__2);
				setState(232);
				((ExpressionContext)_localctx).b = built_in_type();
				setState(233);
				match(T__3);
				setState(234);
				((ExpressionContext)_localctx).exp1 = expression(7);
				((ExpressionContext)_localctx).ast =  new Cast(
				            ((ExpressionContext)_localctx).START.getLine(),
				            ((ExpressionContext)_localctx).START.getCharPositionInLine() + 1,
				            ((ExpressionContext)_localctx).b.ast,
				            ((ExpressionContext)_localctx).exp1.ast
				         );
				}
				break;
			case 8:
				{
				setState(237);
				match(T__16);
				setState(238);
				((ExpressionContext)_localctx).exp1 = expression(6);
				((ExpressionContext)_localctx).ast =  new UnaryMinus(
				            ((ExpressionContext)_localctx).exp1.ast.getLine(),
				            ((ExpressionContext)_localctx).exp1.ast.getColumn(),
				            ((ExpressionContext)_localctx).exp1.ast
				        );
				}
				break;
			case 9:
				{
				setState(241);
				match(T__17);
				setState(242);
				((ExpressionContext)_localctx).exp1 = expression(5);
				((ExpressionContext)_localctx).ast =  new Not(
				                ((ExpressionContext)_localctx).exp1.ast.getLine(),
				                ((ExpressionContext)_localctx).exp1.ast.getColumn(),
				                ((ExpressionContext)_localctx).exp1.ast
				              );
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(279);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(277);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(247);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(248);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 3670016L) != 0) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(249);
						((ExpressionContext)_localctx).exp2 = expression(5);
						((ExpressionContext)_localctx).ast =  new Arithmetic(
						                          ((ExpressionContext)_localctx).exp1.ast.getLine(),
						                          ((ExpressionContext)_localctx).exp1.ast.getColumn(),
						                          ((ExpressionContext)_localctx).exp1.ast,
						                          ((ExpressionContext)_localctx).exp2.ast,
						                          (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null)
						                        );
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(252);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(253);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__16 || _la==T__21) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(254);
						((ExpressionContext)_localctx).exp2 = expression(4);
						((ExpressionContext)_localctx).ast =  new Arithmetic(
						                          ((ExpressionContext)_localctx).exp1.ast.getLine(),
						                          ((ExpressionContext)_localctx).exp1.ast.getColumn(),
						                          ((ExpressionContext)_localctx).exp1.ast,
						                          ((ExpressionContext)_localctx).exp2.ast,
						                          (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null)
						                        );
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(257);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(258);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 528482304L) != 0) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(259);
						((ExpressionContext)_localctx).exp2 = expression(3);
						((ExpressionContext)_localctx).ast =  new Comparison(
						                           ((ExpressionContext)_localctx).exp1.ast.getLine(),
						                           ((ExpressionContext)_localctx).exp1.ast.getColumn(),
						                           ((ExpressionContext)_localctx).exp1.ast,
						                           ((ExpressionContext)_localctx).exp2.ast,
						                           (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null)
						                         );
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(262);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(263);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__28 || _la==T__29) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(264);
						((ExpressionContext)_localctx).exp2 = expression(2);
						((ExpressionContext)_localctx).ast =  new Logical(
						                           ((ExpressionContext)_localctx).exp1.ast.getLine(),
						                           ((ExpressionContext)_localctx).exp1.ast.getColumn(),
						                           ((ExpressionContext)_localctx).exp1.ast,
						                           ((ExpressionContext)_localctx).exp2.ast,
						                           (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null)
						                        );
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(267);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(268);
						match(T__12);
						setState(269);
						((ExpressionContext)_localctx).exp2 = expression(0);
						setState(270);
						match(T__13);
						((ExpressionContext)_localctx).ast =  new ArrayAccess(
						                        ((ExpressionContext)_localctx).exp1.ast.getLine(),
						                        ((ExpressionContext)_localctx).exp1.ast.getColumn(),
						                        ((ExpressionContext)_localctx).exp1.ast,
						                        ((ExpressionContext)_localctx).exp2.ast
						                    );
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(273);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(274);
						match(T__15);
						setState(275);
						((ExpressionContext)_localctx).ID = match(ID);
						((ExpressionContext)_localctx).ast =  new FieldAccess(
						                      ((ExpressionContext)_localctx).e1.ast.getLine(),
						                      ((ExpressionContext)_localctx).e1.ast.getColumn(),
						                      ((ExpressionContext)_localctx).e1.ast,
						                      (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)
						                   );
						}
						break;
					}
					} 
				}
				setState(281);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Statement ast;
		public Token START;
		public ExpressionContext exp;
		public BodyContext body;
		public BodyContext ifStmts;
		public BodyContext elseStmts;
		public ExpressionContext exp1;
		public ExpressionContext exp2;
		public ExpressionContext expression;
		public ExpressionsContext expressions;
		public Token ID;
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement);
		try {
			setState(330);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(282);
				((StatementContext)_localctx).START = match(T__30);
				setState(283);
				((StatementContext)_localctx).exp = expression(0);
				setState(284);
				match(T__4);
				setState(285);
				((StatementContext)_localctx).body = body();
				((StatementContext)_localctx).ast =  new While(
				                                                                ((StatementContext)_localctx).START.getLine(),
				                                                                ((StatementContext)_localctx).START.getCharPositionInLine() + 1,
				                                                                ((StatementContext)_localctx).exp.ast,
				                                                                ((StatementContext)_localctx).body.ast
				                                                              );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				List<Statement> elseStatements = new ArrayList<>();
				setState(289);
				((StatementContext)_localctx).START = match(T__31);
				setState(290);
				((StatementContext)_localctx).exp = expression(0);
				setState(291);
				match(T__4);
				setState(292);
				((StatementContext)_localctx).ifStmts = body();
				setState(298);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(293);
					match(T__32);
					setState(294);
					match(T__4);
					setState(295);
					((StatementContext)_localctx).elseStmts = body();
					elseStatements = ((StatementContext)_localctx).elseStmts.ast;
					}
					break;
				}
				((StatementContext)_localctx).ast =  new IfElse(
				                                                                                    ((StatementContext)_localctx).START.getLine(),
				                                                                                    ((StatementContext)_localctx).START.getCharPositionInLine() + 1,
				                                                                                    ((StatementContext)_localctx).exp.ast,
				                                                                                    ((StatementContext)_localctx).ifStmts.ast,
				                                                                                    elseStatements
				                                                                                  );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(302);
				((StatementContext)_localctx).exp1 = expression(0);
				setState(303);
				match(T__33);
				setState(304);
				((StatementContext)_localctx).exp2 = expression(0);
				setState(305);
				match(T__8);
				((StatementContext)_localctx).ast =  new Assignment(
				                                                                        ((StatementContext)_localctx).exp1.ast.getLine(),
				                                                                        ((StatementContext)_localctx).exp1.ast.getColumn(),
				                                                                        ((StatementContext)_localctx).exp1.ast,
				                                                                        ((StatementContext)_localctx).exp2.ast
				                                                                      );
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(308);
				((StatementContext)_localctx).START = match(T__34);
				setState(309);
				((StatementContext)_localctx).expression = expression(0);
				setState(310);
				match(T__8);
				((StatementContext)_localctx).ast =  new Return(
				                                                                        ((StatementContext)_localctx).START.getLine(),
				                                                                        ((StatementContext)_localctx).START.getCharPositionInLine() + 1,
				                                                                        ((StatementContext)_localctx).expression.ast
				                                                                      );
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(313);
				((StatementContext)_localctx).START = match(T__35);
				setState(314);
				((StatementContext)_localctx).expressions = expressions();
				setState(315);
				match(T__8);
				((StatementContext)_localctx).ast =  new Print(
				                                                        ((StatementContext)_localctx).START.getLine(),
				                                                        ((StatementContext)_localctx).START.getCharPositionInLine() + 1,
				                                                        ((StatementContext)_localctx).expressions.ast
				                                                     );
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(318);
				((StatementContext)_localctx).START = match(T__36);
				setState(319);
				((StatementContext)_localctx).expressions = expressions();
				setState(320);
				match(T__8);
				((StatementContext)_localctx).ast =  new Read(
				                                                        ((StatementContext)_localctx).START.getLine(),
				                                                        ((StatementContext)_localctx).START.getCharPositionInLine() + 1,
				                                                        ((StatementContext)_localctx).expressions.ast
				                                                     );
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(323);
				((StatementContext)_localctx).ID = match(ID);
				setState(324);
				match(T__2);
				setState(325);
				((StatementContext)_localctx).expressions = expressions();
				setState(326);
				match(T__3);
				setState(327);
				match(T__8);
				((StatementContext)_localctx).ast =  new FunctionInvocation(
				                                                                    ((StatementContext)_localctx).ID.getLine(),
				                                                                    ((StatementContext)_localctx).ID.getCharPositionInLine() + 1,
				                                                                    new Variable(
				                                                                            ((StatementContext)_localctx).ID.getLine(),
				                                                                            ((StatementContext)_localctx).ID.getCharPositionInLine() + 1,
				                                                                            (((StatementContext)_localctx).ID!=null?((StatementContext)_localctx).ID.getText():null)),
				                                                                    ((StatementContext)_localctx).expressions.ast
				                                                              );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<>();
		public StatementContext st1;
		public StatementContext st2;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_body);
		int _la;
		try {
			setState(345);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__16:
			case T__17:
			case T__30:
			case T__31:
			case T__34:
			case T__35:
			case T__36:
			case INT_CONSTANT:
			case CHAR_CONSTANT:
			case REAL_CONSTANT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(332);
				((BodyContext)_localctx).st1 = statement();
				_localctx.ast.add(((BodyContext)_localctx).st1.ast);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(335);
				match(T__5);
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4370129616904L) != 0) {
					{
					{
					setState(336);
					((BodyContext)_localctx).st2 = statement();
					_localctx.ast.add(((BodyContext)_localctx).st2.ast);
					}
					}
					setState(343);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(344);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionsContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<>();
		public ExpressionContext exp1;
		public ExpressionContext exp2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitExpressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__16:
			case T__17:
			case INT_CONSTANT:
			case CHAR_CONSTANT:
			case REAL_CONSTANT:
			case ID:
				{
				setState(347);
				((ExpressionsContext)_localctx).exp1 = expression(0);
				_localctx.ast.add(((ExpressionsContext)_localctx).exp1.ast); 
				setState(355);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(349);
					match(T__7);
					setState(350);
					((ExpressionsContext)_localctx).exp2 = expression(0);
					_localctx.ast.add(((ExpressionsContext)_localctx).exp2.ast);
					}
					}
					setState(357);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__3:
			case T__8:
				{
				((ExpressionsContext)_localctx).ast =  _localctx.ast;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001,\u016a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		" \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"3\b\u0001\n\u0001\f\u00016\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001;\b\u0001\n\u0001\f\u0001>\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002I\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003P\b\u0003\n\u0003\f\u0003S\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"f\b\u0004\n\u0004\f\u0004i\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004n\b\u0004\n\u0004\f\u0004q\t\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"\u0080\b\u0004\n\u0004\f\u0004\u0083\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004\u0088\b\u0004\n\u0004\f\u0004\u008b\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004\u0090\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0098\b\u0005"+
		"\n\u0005\f\u0005\u009b\t\u0005\u0001\u0005\u0003\u0005\u009e\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00ab"+
		"\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00bb\b\b\n"+
		"\b\f\b\u00be\t\b\u0001\b\u0001\b\u0001\b\u0003\b\u00c3\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0005\t\u00ca\b\t\n\t\f\t\u00cd\t\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u00f6\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u0116"+
		"\b\n\n\n\f\n\u0119\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u012b\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0003\u000b\u014b\b\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0154\b\f\n\f\f\f\u0157\t\f"+
		"\u0001\f\u0003\f\u015a\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u0162\b\r\n\r\f\r\u0165\t\r\u0001\r\u0003\r\u0168\b\r\u0001"+
		"\r\u0000\u0001\u0014\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u0000\u0004\u0001\u0000\u0013\u0015\u0002\u0000"+
		"\u0011\u0011\u0016\u0016\u0001\u0000\u0017\u001c\u0001\u0000\u001d\u001e"+
		"\u0186\u0000!\u0001\u0000\u0000\u0000\u0002)\u0001\u0000\u0000\u0000\u0004"+
		"H\u0001\u0000\u0000\u0000\u0006J\u0001\u0000\u0000\u0000\b\u008f\u0001"+
		"\u0000\u0000\u0000\n\u009d\u0001\u0000\u0000\u0000\f\u009f\u0001\u0000"+
		"\u0000\u0000\u000e\u00aa\u0001\u0000\u0000\u0000\u0010\u00c2\u0001\u0000"+
		"\u0000\u0000\u0012\u00c4\u0001\u0000\u0000\u0000\u0014\u00f5\u0001\u0000"+
		"\u0000\u0000\u0016\u014a\u0001\u0000\u0000\u0000\u0018\u0159\u0001\u0000"+
		"\u0000\u0000\u001a\u0167\u0001\u0000\u0000\u0000\u001c\u001d\u0003\u0004"+
		"\u0002\u0000\u001d\u001e\u0006\u0000\uffff\uffff\u0000\u001e \u0001\u0000"+
		"\u0000\u0000\u001f\u001c\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000"+
		"!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"$\u0001\u0000"+
		"\u0000\u0000#!\u0001\u0000\u0000\u0000$%\u0003\u0002\u0001\u0000%&\u0006"+
		"\u0000\uffff\uffff\u0000&\'\u0005\u0000\u0000\u0001\'(\u0006\u0000\uffff"+
		"\uffff\u0000(\u0001\u0001\u0000\u0000\u0000)*\u0005\u0001\u0000\u0000"+
		"*+\u0005\u0002\u0000\u0000+,\u0005\u0003\u0000\u0000,-\u0005\u0004\u0000"+
		"\u0000-.\u0005\u0005\u0000\u0000.4\u0005\u0006\u0000\u0000/0\u0003\u0006"+
		"\u0003\u000001\u0006\u0001\uffff\uffff\u000013\u0001\u0000\u0000\u0000"+
		"2/\u0001\u0000\u0000\u000036\u0001\u0000\u0000\u000042\u0001\u0000\u0000"+
		"\u000045\u0001\u0000\u0000\u00005<\u0001\u0000\u0000\u000064\u0001\u0000"+
		"\u0000\u000078\u0003\u0016\u000b\u000089\u0006\u0001\uffff\uffff\u0000"+
		"9;\u0001\u0000\u0000\u0000:7\u0001\u0000\u0000\u0000;>\u0001\u0000\u0000"+
		"\u0000<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=?\u0001\u0000"+
		"\u0000\u0000><\u0001\u0000\u0000\u0000?@\u0005\u0007\u0000\u0000@A\u0006"+
		"\u0001\uffff\uffff\u0000A\u0003\u0001\u0000\u0000\u0000BC\u0003\u0006"+
		"\u0003\u0000CD\u0006\u0002\uffff\uffff\u0000DI\u0001\u0000\u0000\u0000"+
		"EF\u0003\b\u0004\u0000FG\u0006\u0002\uffff\uffff\u0000GI\u0001\u0000\u0000"+
		"\u0000HB\u0001\u0000\u0000\u0000HE\u0001\u0000\u0000\u0000I\u0005\u0001"+
		"\u0000\u0000\u0000JK\u0005)\u0000\u0000KQ\u0006\u0003\uffff\uffff\u0000"+
		"LM\u0005\b\u0000\u0000MN\u0005)\u0000\u0000NP\u0006\u0003\uffff\uffff"+
		"\u0000OL\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000"+
		"\u0000\u0000QR\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000SQ\u0001"+
		"\u0000\u0000\u0000TU\u0005\u0005\u0000\u0000UV\u0003\u0010\b\u0000VW\u0005"+
		"\t\u0000\u0000WX\u0006\u0003\uffff\uffff\u0000XY\u0006\u0003\uffff\uffff"+
		"\u0000Y\u0007\u0001\u0000\u0000\u0000Z[\u0005\u0001\u0000\u0000[\\\u0005"+
		")\u0000\u0000\\]\u0005\u0003\u0000\u0000]^\u0003\n\u0005\u0000^_\u0005"+
		"\u0004\u0000\u0000_`\u0005\u0005\u0000\u0000`a\u0003\u000e\u0007\u0000"+
		"ag\u0005\u0006\u0000\u0000bc\u0003\u0006\u0003\u0000cd\u0006\u0004\uffff"+
		"\uffff\u0000df\u0001\u0000\u0000\u0000eb\u0001\u0000\u0000\u0000fi\u0001"+
		"\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000"+
		"ho\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000jk\u0003\u0016\u000b"+
		"\u0000kl\u0006\u0004\uffff\uffff\u0000ln\u0001\u0000\u0000\u0000mj\u0001"+
		"\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000"+
		"op\u0001\u0000\u0000\u0000pr\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000"+
		"\u0000rs\u0005\u0007\u0000\u0000st\u0006\u0004\uffff\uffff\u0000t\u0090"+
		"\u0001\u0000\u0000\u0000uv\u0005\u0001\u0000\u0000vw\u0005)\u0000\u0000"+
		"wx\u0005\u0003\u0000\u0000xy\u0003\n\u0005\u0000yz\u0005\u0004\u0000\u0000"+
		"z{\u0005\u0005\u0000\u0000{\u0081\u0005\u0006\u0000\u0000|}\u0003\u0006"+
		"\u0003\u0000}~\u0006\u0004\uffff\uffff\u0000~\u0080\u0001\u0000\u0000"+
		"\u0000\u007f|\u0001\u0000\u0000\u0000\u0080\u0083\u0001\u0000\u0000\u0000"+
		"\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000"+
		"\u0082\u0089\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000"+
		"\u0084\u0085\u0003\u0016\u000b\u0000\u0085\u0086\u0006\u0004\uffff\uffff"+
		"\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087\u0084\u0001\u0000\u0000"+
		"\u0000\u0088\u008b\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008c\u0001\u0000\u0000"+
		"\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008c\u008d\u0005\u0007\u0000"+
		"\u0000\u008d\u008e\u0006\u0004\uffff\uffff\u0000\u008e\u0090\u0001\u0000"+
		"\u0000\u0000\u008fZ\u0001\u0000\u0000\u0000\u008fu\u0001\u0000\u0000\u0000"+
		"\u0090\t\u0001\u0000\u0000\u0000\u0091\u0092\u0003\f\u0006\u0000\u0092"+
		"\u0099\u0006\u0005\uffff\uffff\u0000\u0093\u0094\u0005\b\u0000\u0000\u0094"+
		"\u0095\u0003\f\u0006\u0000\u0095\u0096\u0006\u0005\uffff\uffff\u0000\u0096"+
		"\u0098\u0001\u0000\u0000\u0000\u0097\u0093\u0001\u0000\u0000\u0000\u0098"+
		"\u009b\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099"+
		"\u009a\u0001\u0000\u0000\u0000\u009a\u009e\u0001\u0000\u0000\u0000\u009b"+
		"\u0099\u0001\u0000\u0000\u0000\u009c\u009e\u0001\u0000\u0000\u0000\u009d"+
		"\u0091\u0001\u0000\u0000\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009e"+
		"\u000b\u0001\u0000\u0000\u0000\u009f\u00a0\u0005)\u0000\u0000\u00a0\u00a1"+
		"\u0005\u0005\u0000\u0000\u00a1\u00a2\u0003\u0010\b\u0000\u00a2\u00a3\u0006"+
		"\u0006\uffff\uffff\u0000\u00a3\r\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005"+
		"\n\u0000\u0000\u00a5\u00ab\u0006\u0007\uffff\uffff\u0000\u00a6\u00a7\u0005"+
		"\u000b\u0000\u0000\u00a7\u00ab\u0006\u0007\uffff\uffff\u0000\u00a8\u00a9"+
		"\u0005\f\u0000\u0000\u00a9\u00ab\u0006\u0007\uffff\uffff\u0000\u00aa\u00a4"+
		"\u0001\u0000\u0000\u0000\u00aa\u00a6\u0001\u0000\u0000\u0000\u00aa\u00a8"+
		"\u0001\u0000\u0000\u0000\u00ab\u000f\u0001\u0000\u0000\u0000\u00ac\u00ad"+
		"\u0003\u000e\u0007\u0000\u00ad\u00ae\u0006\b\uffff\uffff\u0000\u00ae\u00c3"+
		"\u0001\u0000\u0000\u0000\u00af\u00b0\u0005\r\u0000\u0000\u00b0\u00b1\u0005"+
		"&\u0000\u0000\u00b1\u00b2\u0005\u000e\u0000\u0000\u00b2\u00b3\u0003\u0010"+
		"\b\u0000\u00b3\u00b4\u0006\b\uffff\uffff\u0000\u00b4\u00c3\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b6\u0005\u000f\u0000\u0000\u00b6\u00bc\u0005\u0006"+
		"\u0000\u0000\u00b7\u00b8\u0003\u0012\t\u0000\u00b8\u00b9\u0006\b\uffff"+
		"\uffff\u0000\u00b9\u00bb\u0001\u0000\u0000\u0000\u00ba\u00b7\u0001\u0000"+
		"\u0000\u0000\u00bb\u00be\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000"+
		"\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00bf\u0001\u0000"+
		"\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005\u0007"+
		"\u0000\u0000\u00c0\u00c1\u0006\b\uffff\uffff\u0000\u00c1\u00c3\u0006\b"+
		"\uffff\uffff\u0000\u00c2\u00ac\u0001\u0000\u0000\u0000\u00c2\u00af\u0001"+
		"\u0000\u0000\u0000\u00c2\u00b5\u0001\u0000\u0000\u0000\u00c3\u0011\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c5\u0005)\u0000\u0000\u00c5\u00cb\u0006\t"+
		"\uffff\uffff\u0000\u00c6\u00c7\u0005\b\u0000\u0000\u00c7\u00c8\u0005)"+
		"\u0000\u0000\u00c8\u00ca\u0006\t\uffff\uffff\u0000\u00c9\u00c6\u0001\u0000"+
		"\u0000\u0000\u00ca\u00cd\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000"+
		"\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00ce\u0001\u0000"+
		"\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005\u0005"+
		"\u0000\u0000\u00cf\u00d0\u0003\u0010\b\u0000\u00d0\u00d1\u0005\t\u0000"+
		"\u0000\u00d1\u00d2\u0006\t\uffff\uffff\u0000\u00d2\u0013\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d4\u0006\n\uffff\uffff\u0000\u00d4\u00d5\u0005&\u0000"+
		"\u0000\u00d5\u00f6\u0006\n\uffff\uffff\u0000\u00d6\u00d7\u0005\'\u0000"+
		"\u0000\u00d7\u00f6\u0006\n\uffff\uffff\u0000\u00d8\u00d9\u0005(\u0000"+
		"\u0000\u00d9\u00f6\u0006\n\uffff\uffff\u0000\u00da\u00db\u0005)\u0000"+
		"\u0000\u00db\u00dc\u0005\u0003\u0000\u0000\u00dc\u00dd\u0003\u001a\r\u0000"+
		"\u00dd\u00de\u0005\u0004\u0000\u0000\u00de\u00df\u0006\n\uffff\uffff\u0000"+
		"\u00df\u00f6\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005)\u0000\u0000\u00e1"+
		"\u00f6\u0006\n\uffff\uffff\u0000\u00e2\u00e3\u0005\u0003\u0000\u0000\u00e3"+
		"\u00e4\u0003\u0014\n\u0000\u00e4\u00e5\u0005\u0004\u0000\u0000\u00e5\u00e6"+
		"\u0006\n\uffff\uffff\u0000\u00e6\u00f6\u0001\u0000\u0000\u0000\u00e7\u00e8"+
		"\u0005\u0003\u0000\u0000\u00e8\u00e9\u0003\u000e\u0007\u0000\u00e9\u00ea"+
		"\u0005\u0004\u0000\u0000\u00ea\u00eb\u0003\u0014\n\u0007\u00eb\u00ec\u0006"+
		"\n\uffff\uffff\u0000\u00ec\u00f6\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005"+
		"\u0011\u0000\u0000\u00ee\u00ef\u0003\u0014\n\u0006\u00ef\u00f0\u0006\n"+
		"\uffff\uffff\u0000\u00f0\u00f6\u0001\u0000\u0000\u0000\u00f1\u00f2\u0005"+
		"\u0012\u0000\u0000\u00f2\u00f3\u0003\u0014\n\u0005\u00f3\u00f4\u0006\n"+
		"\uffff\uffff\u0000\u00f4\u00f6\u0001\u0000\u0000\u0000\u00f5\u00d3\u0001"+
		"\u0000\u0000\u0000\u00f5\u00d6\u0001\u0000\u0000\u0000\u00f5\u00d8\u0001"+
		"\u0000\u0000\u0000\u00f5\u00da\u0001\u0000\u0000\u0000\u00f5\u00e0\u0001"+
		"\u0000\u0000\u0000\u00f5\u00e2\u0001\u0000\u0000\u0000\u00f5\u00e7\u0001"+
		"\u0000\u0000\u0000\u00f5\u00ed\u0001\u0000\u0000\u0000\u00f5\u00f1\u0001"+
		"\u0000\u0000\u0000\u00f6\u0117\u0001\u0000\u0000\u0000\u00f7\u00f8\n\u0004"+
		"\u0000\u0000\u00f8\u00f9\u0007\u0000\u0000\u0000\u00f9\u00fa\u0003\u0014"+
		"\n\u0005\u00fa\u00fb\u0006\n\uffff\uffff\u0000\u00fb\u0116\u0001\u0000"+
		"\u0000\u0000\u00fc\u00fd\n\u0003\u0000\u0000\u00fd\u00fe\u0007\u0001\u0000"+
		"\u0000\u00fe\u00ff\u0003\u0014\n\u0004\u00ff\u0100\u0006\n\uffff\uffff"+
		"\u0000\u0100\u0116\u0001\u0000\u0000\u0000\u0101\u0102\n\u0002\u0000\u0000"+
		"\u0102\u0103\u0007\u0002\u0000\u0000\u0103\u0104\u0003\u0014\n\u0003\u0104"+
		"\u0105\u0006\n\uffff\uffff\u0000\u0105\u0116\u0001\u0000\u0000\u0000\u0106"+
		"\u0107\n\u0001\u0000\u0000\u0107\u0108\u0007\u0003\u0000\u0000\u0108\u0109"+
		"\u0003\u0014\n\u0002\u0109\u010a\u0006\n\uffff\uffff\u0000\u010a\u0116"+
		"\u0001\u0000\u0000\u0000\u010b\u010c\n\t\u0000\u0000\u010c\u010d\u0005"+
		"\r\u0000\u0000\u010d\u010e\u0003\u0014\n\u0000\u010e\u010f\u0005\u000e"+
		"\u0000\u0000\u010f\u0110\u0006\n\uffff\uffff\u0000\u0110\u0116\u0001\u0000"+
		"\u0000\u0000\u0111\u0112\n\b\u0000\u0000\u0112\u0113\u0005\u0010\u0000"+
		"\u0000\u0113\u0114\u0005)\u0000\u0000\u0114\u0116\u0006\n\uffff\uffff"+
		"\u0000\u0115\u00f7\u0001\u0000\u0000\u0000\u0115\u00fc\u0001\u0000\u0000"+
		"\u0000\u0115\u0101\u0001\u0000\u0000\u0000\u0115\u0106\u0001\u0000\u0000"+
		"\u0000\u0115\u010b\u0001\u0000\u0000\u0000\u0115\u0111\u0001\u0000\u0000"+
		"\u0000\u0116\u0119\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000\u0000"+
		"\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118\u0015\u0001\u0000\u0000"+
		"\u0000\u0119\u0117\u0001\u0000\u0000\u0000\u011a\u011b\u0005\u001f\u0000"+
		"\u0000\u011b\u011c\u0003\u0014\n\u0000\u011c\u011d\u0005\u0005\u0000\u0000"+
		"\u011d\u011e\u0003\u0018\f\u0000\u011e\u011f\u0006\u000b\uffff\uffff\u0000"+
		"\u011f\u014b\u0001\u0000\u0000\u0000\u0120\u0121\u0006\u000b\uffff\uffff"+
		"\u0000\u0121\u0122\u0005 \u0000\u0000\u0122\u0123\u0003\u0014\n\u0000"+
		"\u0123\u0124\u0005\u0005\u0000\u0000\u0124\u012a\u0003\u0018\f\u0000\u0125"+
		"\u0126\u0005!\u0000\u0000\u0126\u0127\u0005\u0005\u0000\u0000\u0127\u0128"+
		"\u0003\u0018\f\u0000\u0128\u0129\u0006\u000b\uffff\uffff\u0000\u0129\u012b"+
		"\u0001\u0000\u0000\u0000\u012a\u0125\u0001\u0000\u0000\u0000\u012a\u012b"+
		"\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000\u0000\u0000\u012c\u012d"+
		"\u0006\u000b\uffff\uffff\u0000\u012d\u014b\u0001\u0000\u0000\u0000\u012e"+
		"\u012f\u0003\u0014\n\u0000\u012f\u0130\u0005\"\u0000\u0000\u0130\u0131"+
		"\u0003\u0014\n\u0000\u0131\u0132\u0005\t\u0000\u0000\u0132\u0133\u0006"+
		"\u000b\uffff\uffff\u0000\u0133\u014b\u0001\u0000\u0000\u0000\u0134\u0135"+
		"\u0005#\u0000\u0000\u0135\u0136\u0003\u0014\n\u0000\u0136\u0137\u0005"+
		"\t\u0000\u0000\u0137\u0138\u0006\u000b\uffff\uffff\u0000\u0138\u014b\u0001"+
		"\u0000\u0000\u0000\u0139\u013a\u0005$\u0000\u0000\u013a\u013b\u0003\u001a"+
		"\r\u0000\u013b\u013c\u0005\t\u0000\u0000\u013c\u013d\u0006\u000b\uffff"+
		"\uffff\u0000\u013d\u014b\u0001\u0000\u0000\u0000\u013e\u013f\u0005%\u0000"+
		"\u0000\u013f\u0140\u0003\u001a\r\u0000\u0140\u0141\u0005\t\u0000\u0000"+
		"\u0141\u0142\u0006\u000b\uffff\uffff\u0000\u0142\u014b\u0001\u0000\u0000"+
		"\u0000\u0143\u0144\u0005)\u0000\u0000\u0144\u0145\u0005\u0003\u0000\u0000"+
		"\u0145\u0146\u0003\u001a\r\u0000\u0146\u0147\u0005\u0004\u0000\u0000\u0147"+
		"\u0148\u0005\t\u0000\u0000\u0148\u0149\u0006\u000b\uffff\uffff\u0000\u0149"+
		"\u014b\u0001\u0000\u0000\u0000\u014a\u011a\u0001\u0000\u0000\u0000\u014a"+
		"\u0120\u0001\u0000\u0000\u0000\u014a\u012e\u0001\u0000\u0000\u0000\u014a"+
		"\u0134\u0001\u0000\u0000\u0000\u014a\u0139\u0001\u0000\u0000\u0000\u014a"+
		"\u013e\u0001\u0000\u0000\u0000\u014a\u0143\u0001\u0000\u0000\u0000\u014b"+
		"\u0017\u0001\u0000\u0000\u0000\u014c\u014d\u0003\u0016\u000b\u0000\u014d"+
		"\u014e\u0006\f\uffff\uffff\u0000\u014e\u015a\u0001\u0000\u0000\u0000\u014f"+
		"\u0155\u0005\u0006\u0000\u0000\u0150\u0151\u0003\u0016\u000b\u0000\u0151"+
		"\u0152\u0006\f\uffff\uffff\u0000\u0152\u0154\u0001\u0000\u0000\u0000\u0153"+
		"\u0150\u0001\u0000\u0000\u0000\u0154\u0157\u0001\u0000\u0000\u0000\u0155"+
		"\u0153\u0001\u0000\u0000\u0000\u0155\u0156\u0001\u0000\u0000\u0000\u0156"+
		"\u0158\u0001\u0000\u0000\u0000\u0157\u0155\u0001\u0000\u0000\u0000\u0158"+
		"\u015a\u0005\u0007\u0000\u0000\u0159\u014c\u0001\u0000\u0000\u0000\u0159"+
		"\u014f\u0001\u0000\u0000\u0000\u015a\u0019\u0001\u0000\u0000\u0000\u015b"+
		"\u015c\u0003\u0014\n\u0000\u015c\u0163\u0006\r\uffff\uffff\u0000\u015d"+
		"\u015e\u0005\b\u0000\u0000\u015e\u015f\u0003\u0014\n\u0000\u015f\u0160"+
		"\u0006\r\uffff\uffff\u0000\u0160\u0162\u0001\u0000\u0000\u0000\u0161\u015d"+
		"\u0001\u0000\u0000\u0000\u0162\u0165\u0001\u0000\u0000\u0000\u0163\u0161"+
		"\u0001\u0000\u0000\u0000\u0163\u0164\u0001\u0000\u0000\u0000\u0164\u0168"+
		"\u0001\u0000\u0000\u0000\u0165\u0163\u0001\u0000\u0000\u0000\u0166\u0168"+
		"\u0006\r\uffff\uffff\u0000\u0167\u015b\u0001\u0000\u0000\u0000\u0167\u0166"+
		"\u0001\u0000\u0000\u0000\u0168\u001b\u0001\u0000\u0000\u0000\u0019!4<"+
		"HQgo\u0081\u0089\u008f\u0099\u009d\u00aa\u00bc\u00c2\u00cb\u00f5\u0115"+
		"\u0117\u012a\u014a\u0155\u0159\u0163\u0167";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}