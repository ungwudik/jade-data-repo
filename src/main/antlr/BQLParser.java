// Generated from BQL.g4 by ANTLR 4.8

    package bio.terra.service.grammar;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		INT=25, FLOAT=26, DIGITS=27, QUOTE=28, DQOUTE=29, ALL=30, AND=31, ANY=32, 
		ARRAY=33, AS=34, ASC=35, ASSERT_ROWS_MODIFIED=36, AT=37, BETWEEN=38, BY=39, 
		CASE=40, CAST=41, COLLATE=42, CONTAINS=43, CREATE=44, CROSS=45, CUBE=46, 
		CURRENT=47, DEFAULT=48, DEFINE=49, DESC=50, DISTINCT=51, ELSE=52, END=53, 
		ENUM=54, ESCAPE=55, EXCEPT=56, EXCLUDE=57, EXISTS=58, EXTRACT=59, FALSE=60, 
		FETCH=61, FOLLOWING=62, FOR=63, FROM=64, FULL=65, GROUP=66, GROUPING=67, 
		GROUPS=68, HASH=69, HAVING=70, IF=71, IGNORE=72, IN=73, INNER=74, INTERSECT=75, 
		INTERVAL=76, INTO=77, IS=78, JOIN=79, LATERAL=80, LEFT=81, LIKE=82, LIMIT=83, 
		LOOKUP=84, MERGE=85, NATURAL=86, NEW=87, NO=88, NOT=89, S_NULL=90, NULLS=91, 
		OF=92, OFFSET=93, ON=94, OR=95, ORDER=96, ORDINAL=97, OUTER=98, OVER=99, 
		PARTITION=100, PRECEDING=101, PROTO=102, RANGE=103, RECURSIVE=104, REPLACE=105, 
		RESPECT=106, RIGHT=107, ROLLUP=108, ROWS=109, SAFE_OFFSET=110, SAFE_ORDINAL=111, 
		SELECT=112, SET=113, SOME=114, SSTRUCT=115, SYSTEM=116, TABLESAMPLE=117, 
		THEN=118, TIME=119, TO=120, TREAT=121, TRUE=122, UNBOUNDED=123, UNION=124, 
		UNNEST=125, USING=126, WHEN=127, WHERE=128, WINDOW=129, WITH=130, WITHIN=131, 
		WS=132, CMT=133, M_CMT=134, QUOTED_STRING=135, TRIPLE_QUOTED_STRING=136, 
		RAW_STRING=137, BYTE_STRING=138, RAW_BYTE_STRING=139, ID=140, RB=141;
	public static final int
		RULE_query_statement = 0, RULE_query_expr = 1, RULE_select_statement = 2, 
		RULE_from_statement = 3, RULE_from_item = 4, RULE_where_statement = 5, 
		RULE_limit_clause = 6, RULE_using_clause = 7, RULE_array_expr = 8, RULE_expr = 9, 
		RULE_column_expr = 10, RULE_join_type = 11, RULE_except_statement = 12, 
		RULE_on_clause = 13, RULE_bool_expression = 14, RULE_count = 15, RULE_name = 16, 
		RULE_unary_operator = 17, RULE_alias_name = 18, RULE_array_name = 19, 
		RULE_column_name = 20, RULE_cte_name = 21, RULE_dataset_name = 22, RULE_datatype_name = 23, 
		RULE_function_name = 24, RULE_join_name = 25, RULE_member_name = 26, RULE_project_name = 27, 
		RULE_struct_name = 28, RULE_table_name = 29, RULE_table_expr = 30, RULE_number = 31, 
		RULE_integer_type = 32, RULE_float_type = 33, RULE_string = 34, RULE_quoted_string = 35, 
		RULE_triple_quoted_string = 36, RULE_raw_string = 37, RULE_byte_string = 38, 
		RULE_raw_byte_string = 39, RULE_special_string = 40, RULE_keyword = 41;
	private static String[] makeRuleNames() {
		return new String[] {
			"query_statement", "query_expr", "select_statement", "from_statement", 
			"from_item", "where_statement", "limit_clause", "using_clause", "array_expr", 
			"expr", "column_expr", "join_type", "except_statement", "on_clause", 
			"bool_expression", "count", "name", "unary_operator", "alias_name", "array_name", 
			"column_name", "cte_name", "dataset_name", "datatype_name", "function_name", 
			"join_name", "member_name", "project_name", "struct_name", "table_name", 
			"table_expr", "number", "integer_type", "float_type", "string", "quoted_string", 
			"triple_quoted_string", "raw_string", "byte_string", "raw_byte_string", 
			"special_string", "keyword"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'*'", "','", "'('", "')'", "'<'", "'>'", "'['", "']'", 
			"'/'", "'+'", "'-'", "'<<'", "'>>'", "'&'", "'^'", "'|'", "'='", "'<='", 
			"'>='", "'!='", "'<>'", "'`'", "'~'", null, null, null, "'''", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "INT", "FLOAT", "DIGITS", "QUOTE", "DQOUTE", "ALL", "AND", "ANY", 
			"ARRAY", "AS", "ASC", "ASSERT_ROWS_MODIFIED", "AT", "BETWEEN", "BY", 
			"CASE", "CAST", "COLLATE", "CONTAINS", "CREATE", "CROSS", "CUBE", "CURRENT", 
			"DEFAULT", "DEFINE", "DESC", "DISTINCT", "ELSE", "END", "ENUM", "ESCAPE", 
			"EXCEPT", "EXCLUDE", "EXISTS", "EXTRACT", "FALSE", "FETCH", "FOLLOWING", 
			"FOR", "FROM", "FULL", "GROUP", "GROUPING", "GROUPS", "HASH", "HAVING", 
			"IF", "IGNORE", "IN", "INNER", "INTERSECT", "INTERVAL", "INTO", "IS", 
			"JOIN", "LATERAL", "LEFT", "LIKE", "LIMIT", "LOOKUP", "MERGE", "NATURAL", 
			"NEW", "NO", "NOT", "S_NULL", "NULLS", "OF", "OFFSET", "ON", "OR", "ORDER", 
			"ORDINAL", "OUTER", "OVER", "PARTITION", "PRECEDING", "PROTO", "RANGE", 
			"RECURSIVE", "REPLACE", "RESPECT", "RIGHT", "ROLLUP", "ROWS", "SAFE_OFFSET", 
			"SAFE_ORDINAL", "SELECT", "SET", "SOME", "SSTRUCT", "SYSTEM", "TABLESAMPLE", 
			"THEN", "TIME", "TO", "TREAT", "TRUE", "UNBOUNDED", "UNION", "UNNEST", 
			"USING", "WHEN", "WHERE", "WINDOW", "WITH", "WITHIN", "WS", "CMT", "M_CMT", 
			"QUOTED_STRING", "TRIPLE_QUOTED_STRING", "RAW_STRING", "BYTE_STRING", 
			"RAW_BYTE_STRING", "ID", "RB"
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
	public String getGrammarFileName() { return "BQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Query_statementContext extends ParserRuleContext {
		public Query_exprContext query_expr() {
			return getRuleContext(Query_exprContext.class,0);
		}
		public Query_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterQuery_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitQuery_statement(this);
		}
	}

	public final Query_statementContext query_statement() throws RecognitionException {
		Query_statementContext _localctx = new Query_statementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			query_expr();
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

	public static class Query_exprContext extends ParserRuleContext {
		public Select_statementContext select_statement() {
			return getRuleContext(Select_statementContext.class,0);
		}
		public Limit_clauseContext limit_clause() {
			return getRuleContext(Limit_clauseContext.class,0);
		}
		public Query_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterQuery_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitQuery_expr(this);
		}
	}

	public final Query_exprContext query_expr() throws RecognitionException {
		Query_exprContext _localctx = new Query_exprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_query_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			select_statement();
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(87);
				limit_clause();
				}
				break;
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

	public static class Select_statementContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(BQLParser.SELECT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public From_statementContext from_statement() {
			return getRuleContext(From_statementContext.class,0);
		}
		public Where_statementContext where_statement() {
			return getRuleContext(Where_statementContext.class,0);
		}
		public TerminalNode ALL() { return getToken(BQLParser.ALL, 0); }
		public TerminalNode DISTINCT() { return getToken(BQLParser.DISTINCT, 0); }
		public List<Alias_nameContext> alias_name() {
			return getRuleContexts(Alias_nameContext.class);
		}
		public Alias_nameContext alias_name(int i) {
			return getRuleContext(Alias_nameContext.class,i);
		}
		public List<Except_statementContext> except_statement() {
			return getRuleContexts(Except_statementContext.class);
		}
		public Except_statementContext except_statement(int i) {
			return getRuleContext(Except_statementContext.class,i);
		}
		public List<TerminalNode> AS() { return getTokens(BQLParser.AS); }
		public TerminalNode AS(int i) {
			return getToken(BQLParser.AS, i);
		}
		public Select_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterSelect_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitSelect_statement(this);
		}
	}

	public final Select_statementContext select_statement() throws RecognitionException {
		Select_statementContext _localctx = new Select_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_select_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(SELECT);
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(91);
				_la = _input.LA(1);
				if ( !(_la==ALL || _la==DISTINCT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				{
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__11) | (1L << T__22) | (1L << T__23) | (1L << INT) | (1L << FLOAT) | (1L << QUOTE) | (1L << DQOUTE) | (1L << ALL) | (1L << AND) | (1L << ANY) | (1L << ARRAY) | (1L << AS) | (1L << ASC) | (1L << ASSERT_ROWS_MODIFIED) | (1L << AT) | (1L << BETWEEN) | (1L << BY) | (1L << CASE) | (1L << CAST) | (1L << COLLATE) | (1L << CONTAINS) | (1L << CREATE) | (1L << CROSS) | (1L << CUBE) | (1L << CURRENT) | (1L << DEFAULT) | (1L << DEFINE) | (1L << DESC) | (1L << DISTINCT) | (1L << ELSE) | (1L << END) | (1L << ENUM) | (1L << ESCAPE) | (1L << EXCEPT) | (1L << EXCLUDE) | (1L << EXISTS) | (1L << EXTRACT) | (1L << FALSE) | (1L << FETCH) | (1L << FOLLOWING) | (1L << FOR))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FROM - 64)) | (1L << (FULL - 64)) | (1L << (GROUP - 64)) | (1L << (GROUPING - 64)) | (1L << (GROUPS - 64)) | (1L << (HASH - 64)) | (1L << (HAVING - 64)) | (1L << (IF - 64)) | (1L << (IGNORE - 64)) | (1L << (IN - 64)) | (1L << (INNER - 64)) | (1L << (INTERSECT - 64)) | (1L << (INTERVAL - 64)) | (1L << (INTO - 64)) | (1L << (IS - 64)) | (1L << (JOIN - 64)) | (1L << (LATERAL - 64)) | (1L << (LEFT - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (LOOKUP - 64)) | (1L << (MERGE - 64)) | (1L << (NATURAL - 64)) | (1L << (NEW - 64)) | (1L << (NO - 64)) | (1L << (NOT - 64)) | (1L << (S_NULL - 64)) | (1L << (NULLS - 64)) | (1L << (OF - 64)) | (1L << (OFFSET - 64)) | (1L << (ON - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (ORDINAL - 64)) | (1L << (OUTER - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)) | (1L << (PRECEDING - 64)) | (1L << (PROTO - 64)) | (1L << (RANGE - 64)) | (1L << (RECURSIVE - 64)) | (1L << (REPLACE - 64)) | (1L << (RESPECT - 64)) | (1L << (RIGHT - 64)) | (1L << (ROLLUP - 64)) | (1L << (ROWS - 64)) | (1L << (SAFE_OFFSET - 64)) | (1L << (SAFE_ORDINAL - 64)) | (1L << (SELECT - 64)) | (1L << (SET - 64)) | (1L << (SOME - 64)) | (1L << (SSTRUCT - 64)) | (1L << (SYSTEM - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (THEN - 64)) | (1L << (TIME - 64)) | (1L << (TO - 64)) | (1L << (TREAT - 64)) | (1L << (TRUE - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (UNION - 64)) | (1L << (UNNEST - 64)) | (1L << (USING - 64)) | (1L << (WHEN - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (WHERE - 128)) | (1L << (WINDOW - 128)) | (1L << (WITH - 128)) | (1L << (WITHIN - 128)) | (1L << (QUOTED_STRING - 128)) | (1L << (TRIPLE_QUOTED_STRING - 128)) | (1L << (RAW_STRING - 128)) | (1L << (BYTE_STRING - 128)) | (1L << (RAW_BYTE_STRING - 128)) | (1L << (ID - 128)))) != 0)) {
					{
					setState(94);
					expr(0);
					}
				}

				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(97);
					match(T__0);
					}
				}

				setState(100);
				match(T__1);
				setState(102);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(101);
					except_statement();
					}
					break;
				}
				}
				}
				break;
			case 2:
				{
				setState(104);
				expr(0);
				setState(109);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(105);
						match(AS);
						}
					}

					setState(108);
					alias_name();
					}
					break;
				}
				}
				break;
			}
			setState(132);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(113);
					match(T__2);
					setState(128);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						{
						setState(115);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__11) | (1L << T__22) | (1L << T__23) | (1L << INT) | (1L << FLOAT) | (1L << QUOTE) | (1L << DQOUTE) | (1L << ALL) | (1L << AND) | (1L << ANY) | (1L << ARRAY) | (1L << AS) | (1L << ASC) | (1L << ASSERT_ROWS_MODIFIED) | (1L << AT) | (1L << BETWEEN) | (1L << BY) | (1L << CASE) | (1L << CAST) | (1L << COLLATE) | (1L << CONTAINS) | (1L << CREATE) | (1L << CROSS) | (1L << CUBE) | (1L << CURRENT) | (1L << DEFAULT) | (1L << DEFINE) | (1L << DESC) | (1L << DISTINCT) | (1L << ELSE) | (1L << END) | (1L << ENUM) | (1L << ESCAPE) | (1L << EXCEPT) | (1L << EXCLUDE) | (1L << EXISTS) | (1L << EXTRACT) | (1L << FALSE) | (1L << FETCH) | (1L << FOLLOWING) | (1L << FOR))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FROM - 64)) | (1L << (FULL - 64)) | (1L << (GROUP - 64)) | (1L << (GROUPING - 64)) | (1L << (GROUPS - 64)) | (1L << (HASH - 64)) | (1L << (HAVING - 64)) | (1L << (IF - 64)) | (1L << (IGNORE - 64)) | (1L << (IN - 64)) | (1L << (INNER - 64)) | (1L << (INTERSECT - 64)) | (1L << (INTERVAL - 64)) | (1L << (INTO - 64)) | (1L << (IS - 64)) | (1L << (JOIN - 64)) | (1L << (LATERAL - 64)) | (1L << (LEFT - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (LOOKUP - 64)) | (1L << (MERGE - 64)) | (1L << (NATURAL - 64)) | (1L << (NEW - 64)) | (1L << (NO - 64)) | (1L << (NOT - 64)) | (1L << (S_NULL - 64)) | (1L << (NULLS - 64)) | (1L << (OF - 64)) | (1L << (OFFSET - 64)) | (1L << (ON - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (ORDINAL - 64)) | (1L << (OUTER - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)) | (1L << (PRECEDING - 64)) | (1L << (PROTO - 64)) | (1L << (RANGE - 64)) | (1L << (RECURSIVE - 64)) | (1L << (REPLACE - 64)) | (1L << (RESPECT - 64)) | (1L << (RIGHT - 64)) | (1L << (ROLLUP - 64)) | (1L << (ROWS - 64)) | (1L << (SAFE_OFFSET - 64)) | (1L << (SAFE_ORDINAL - 64)) | (1L << (SELECT - 64)) | (1L << (SET - 64)) | (1L << (SOME - 64)) | (1L << (SSTRUCT - 64)) | (1L << (SYSTEM - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (THEN - 64)) | (1L << (TIME - 64)) | (1L << (TO - 64)) | (1L << (TREAT - 64)) | (1L << (TRUE - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (UNION - 64)) | (1L << (UNNEST - 64)) | (1L << (USING - 64)) | (1L << (WHEN - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (WHERE - 128)) | (1L << (WINDOW - 128)) | (1L << (WITH - 128)) | (1L << (WITHIN - 128)) | (1L << (QUOTED_STRING - 128)) | (1L << (TRIPLE_QUOTED_STRING - 128)) | (1L << (RAW_STRING - 128)) | (1L << (BYTE_STRING - 128)) | (1L << (RAW_BYTE_STRING - 128)) | (1L << (ID - 128)))) != 0)) {
							{
							setState(114);
							expr(0);
							}
						}

						setState(117);
						match(T__1);
						setState(119);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
						case 1:
							{
							setState(118);
							except_statement();
							}
							break;
						}
						}
						}
						break;
					case 2:
						{
						setState(121);
						expr(0);
						setState(126);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
						case 1:
							{
							setState(123);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==AS) {
								{
								setState(122);
								match(AS);
								}
							}

							setState(125);
							alias_name();
							}
							break;
						}
						}
						break;
					}
					}
					} 
				}
				setState(134);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(135);
				from_statement();
				}
				break;
			}
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(138);
				where_statement();
				}
				break;
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

	public static class From_statementContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(BQLParser.FROM, 0); }
		public List<From_itemContext> from_item() {
			return getRuleContexts(From_itemContext.class);
		}
		public From_itemContext from_item(int i) {
			return getRuleContext(From_itemContext.class,i);
		}
		public From_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterFrom_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitFrom_statement(this);
		}
	}

	public final From_statementContext from_statement() throws RecognitionException {
		From_statementContext _localctx = new From_statementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_from_statement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(FROM);
			setState(142);
			from_item(0);
			setState(147);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(143);
					match(T__2);
					setState(144);
					from_item(0);
					}
					} 
				}
				setState(149);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public static class From_itemContext extends ParserRuleContext {
		public Table_exprContext table_expr() {
			return getRuleContext(Table_exprContext.class,0);
		}
		public List<Alias_nameContext> alias_name() {
			return getRuleContexts(Alias_nameContext.class);
		}
		public Alias_nameContext alias_name(int i) {
			return getRuleContext(Alias_nameContext.class,i);
		}
		public TerminalNode FOR() { return getToken(BQLParser.FOR, 0); }
		public TerminalNode SYSTEM() { return getToken(BQLParser.SYSTEM, 0); }
		public TerminalNode TIME() { return getToken(BQLParser.TIME, 0); }
		public List<TerminalNode> AS() { return getTokens(BQLParser.AS); }
		public TerminalNode AS(int i) {
			return getToken(BQLParser.AS, i);
		}
		public TerminalNode OF() { return getToken(BQLParser.OF, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public Query_statementContext query_statement() {
			return getRuleContext(Query_statementContext.class,0);
		}
		public TerminalNode UNNEST() { return getToken(BQLParser.UNNEST, 0); }
		public Array_exprContext array_expr() {
			return getRuleContext(Array_exprContext.class,0);
		}
		public TerminalNode WITH() { return getToken(BQLParser.WITH, 0); }
		public TerminalNode OFFSET() { return getToken(BQLParser.OFFSET, 0); }
		public List<From_itemContext> from_item() {
			return getRuleContexts(From_itemContext.class);
		}
		public From_itemContext from_item(int i) {
			return getRuleContext(From_itemContext.class,i);
		}
		public TerminalNode JOIN() { return getToken(BQLParser.JOIN, 0); }
		public On_clauseContext on_clause() {
			return getRuleContext(On_clauseContext.class,0);
		}
		public Using_clauseContext using_clause() {
			return getRuleContext(Using_clauseContext.class,0);
		}
		public Join_typeContext join_type() {
			return getRuleContext(Join_typeContext.class,0);
		}
		public From_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterFrom_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitFrom_item(this);
		}
	}

	public final From_itemContext from_item() throws RecognitionException {
		return from_item(0);
	}

	private From_itemContext from_item(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		From_itemContext _localctx = new From_itemContext(_ctx, _parentState);
		From_itemContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_from_item, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(151);
				table_expr();
				setState(156);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(152);
						match(AS);
						}
					}

					setState(155);
					alias_name();
					}
					break;
				}
				setState(164);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(158);
					match(FOR);
					setState(159);
					match(SYSTEM);
					setState(160);
					match(TIME);
					setState(161);
					match(AS);
					setState(162);
					match(OF);
					setState(163);
					string();
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(166);
				match(T__3);
				setState(167);
				query_statement();
				setState(168);
				match(T__4);
				setState(173);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(170);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(169);
						match(AS);
						}
					}

					setState(172);
					alias_name();
					}
					break;
				}
				}
				break;
			case 3:
				{
				setState(175);
				match(UNNEST);
				setState(176);
				match(T__3);
				setState(177);
				array_expr();
				setState(178);
				match(T__4);
				setState(183);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(180);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(179);
						match(AS);
						}
					}

					setState(182);
					alias_name();
					}
					break;
				}
				setState(191);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(185);
					match(WITH);
					setState(186);
					match(OFFSET);
					{
					setState(188);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(187);
						match(AS);
						}
					}

					setState(190);
					alias_name();
					}
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new From_itemContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_from_item);
					setState(195);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(197);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (CROSS - 45)) | (1L << (FULL - 45)) | (1L << (INNER - 45)) | (1L << (LEFT - 45)) | (1L << (RIGHT - 45)))) != 0)) {
						{
						setState(196);
						join_type();
						}
					}

					setState(199);
					match(JOIN);
					setState(200);
					from_item(0);
					setState(203);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ON:
						{
						setState(201);
						on_clause();
						}
						break;
					case USING:
						{
						setState(202);
						using_clause();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(209);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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

	public static class Where_statementContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(BQLParser.WHERE, 0); }
		public Bool_expressionContext bool_expression() {
			return getRuleContext(Bool_expressionContext.class,0);
		}
		public Where_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterWhere_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitWhere_statement(this);
		}
	}

	public final Where_statementContext where_statement() throws RecognitionException {
		Where_statementContext _localctx = new Where_statementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_where_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(WHERE);
			setState(211);
			bool_expression();
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

	public static class Limit_clauseContext extends ParserRuleContext {
		public TerminalNode LIMIT() { return getToken(BQLParser.LIMIT, 0); }
		public CountContext count() {
			return getRuleContext(CountContext.class,0);
		}
		public Limit_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limit_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterLimit_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitLimit_clause(this);
		}
	}

	public final Limit_clauseContext limit_clause() throws RecognitionException {
		Limit_clauseContext _localctx = new Limit_clauseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_limit_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(LIMIT);
			setState(214);
			count();
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

	public static class Using_clauseContext extends ParserRuleContext {
		public TerminalNode USING() { return getToken(BQLParser.USING, 0); }
		public List<Join_nameContext> join_name() {
			return getRuleContexts(Join_nameContext.class);
		}
		public Join_nameContext join_name(int i) {
			return getRuleContext(Join_nameContext.class,i);
		}
		public Using_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_using_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterUsing_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitUsing_clause(this);
		}
	}

	public final Using_clauseContext using_clause() throws RecognitionException {
		Using_clauseContext _localctx = new Using_clauseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_using_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(USING);
			setState(217);
			match(T__3);
			setState(218);
			join_name();
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(219);
				match(T__2);
				setState(220);
				join_name();
				}
				}
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(226);
			match(T__4);
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

	public static class Array_exprContext extends ParserRuleContext {
		public TerminalNode ARRAY() { return getToken(BQLParser.ARRAY, 0); }
		public Datatype_nameContext datatype_name() {
			return getRuleContext(Datatype_nameContext.class,0);
		}
		public Array_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterArray_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitArray_expr(this);
		}
	}

	public final Array_exprContext array_expr() throws RecognitionException {
		Array_exprContext _localctx = new Array_exprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_array_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(ARRAY);
			setState(229);
			match(T__5);
			setState(230);
			datatype_name();
			setState(231);
			match(T__6);
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

	public static class ExprContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public Array_nameContext array_name() {
			return getRuleContext(Array_nameContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OFFSET() { return getToken(BQLParser.OFFSET, 0); }
		public TerminalNode ORDINAL() { return getToken(BQLParser.ORDINAL, 0); }
		public TerminalNode SAFE_OFFSET() { return getToken(BQLParser.SAFE_OFFSET, 0); }
		public TerminalNode SAFE_ORDINAL() { return getToken(BQLParser.SAFE_ORDINAL, 0); }
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public TerminalNode IS() { return getToken(BQLParser.IS, 0); }
		public TerminalNode TRUE() { return getToken(BQLParser.TRUE, 0); }
		public TerminalNode NOT() { return getToken(BQLParser.NOT, 0); }
		public TerminalNode FALSE() { return getToken(BQLParser.FALSE, 0); }
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public Column_exprContext column_expr() {
			return getRuleContext(Column_exprContext.class,0);
		}
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public TerminalNode LIKE() { return getToken(BQLParser.LIKE, 0); }
		public TerminalNode BETWEEN() { return getToken(BQLParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(BQLParser.AND, 0); }
		public TerminalNode OR() { return getToken(BQLParser.OR, 0); }
		public TerminalNode S_NULL() { return getToken(BQLParser.S_NULL, 0); }
		public TerminalNode IN() { return getToken(BQLParser.IN, 0); }
		public Query_statementContext query_statement() {
			return getRuleContext(Query_statementContext.class,0);
		}
		public TerminalNode UNNEST() { return getToken(BQLParser.UNNEST, 0); }
		public Array_exprContext array_expr() {
			return getRuleContext(Array_exprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(234);
				number();
				}
				break;
			case 2:
				{
				setState(235);
				string();
				}
				break;
			case 3:
				{
				setState(236);
				array_name();
				setState(237);
				match(T__7);
				setState(238);
				_la = _input.LA(1);
				if ( !(((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (OFFSET - 93)) | (1L << (ORDINAL - 93)) | (1L << (SAFE_OFFSET - 93)) | (1L << (SAFE_ORDINAL - 93)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(239);
				match(T__3);
				setState(240);
				expr(0);
				setState(241);
				match(T__4);
				setState(242);
				match(T__8);
				}
				break;
			case 4:
				{
				setState(244);
				unary_operator();
				setState(245);
				expr(18);
				}
				break;
			case 5:
				{
				setState(247);
				match(IS);
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(248);
					match(NOT);
					}
				}

				setState(251);
				match(TRUE);
				}
				break;
			case 6:
				{
				setState(252);
				match(IS);
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(253);
					match(NOT);
					}
				}

				setState(256);
				match(FALSE);
				}
				break;
			case 7:
				{
				setState(257);
				function_name();
				setState(258);
				match(T__3);
				setState(268);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__3:
				case T__11:
				case T__22:
				case T__23:
				case INT:
				case FLOAT:
				case QUOTE:
				case DQOUTE:
				case ALL:
				case AND:
				case ANY:
				case ARRAY:
				case AS:
				case ASC:
				case ASSERT_ROWS_MODIFIED:
				case AT:
				case BETWEEN:
				case BY:
				case CASE:
				case CAST:
				case COLLATE:
				case CONTAINS:
				case CREATE:
				case CROSS:
				case CUBE:
				case CURRENT:
				case DEFAULT:
				case DEFINE:
				case DESC:
				case DISTINCT:
				case ELSE:
				case END:
				case ENUM:
				case ESCAPE:
				case EXCEPT:
				case EXCLUDE:
				case EXISTS:
				case EXTRACT:
				case FALSE:
				case FETCH:
				case FOLLOWING:
				case FOR:
				case FROM:
				case FULL:
				case GROUP:
				case GROUPING:
				case GROUPS:
				case HASH:
				case HAVING:
				case IF:
				case IGNORE:
				case IN:
				case INNER:
				case INTERSECT:
				case INTERVAL:
				case INTO:
				case IS:
				case JOIN:
				case LATERAL:
				case LEFT:
				case LIKE:
				case LIMIT:
				case LOOKUP:
				case MERGE:
				case NATURAL:
				case NEW:
				case NO:
				case NOT:
				case S_NULL:
				case NULLS:
				case OF:
				case OFFSET:
				case ON:
				case OR:
				case ORDER:
				case ORDINAL:
				case OUTER:
				case OVER:
				case PARTITION:
				case PRECEDING:
				case PROTO:
				case RANGE:
				case RECURSIVE:
				case REPLACE:
				case RESPECT:
				case RIGHT:
				case ROLLUP:
				case ROWS:
				case SAFE_OFFSET:
				case SAFE_ORDINAL:
				case SELECT:
				case SET:
				case SOME:
				case SSTRUCT:
				case SYSTEM:
				case TABLESAMPLE:
				case THEN:
				case TIME:
				case TO:
				case TREAT:
				case TRUE:
				case UNBOUNDED:
				case UNION:
				case UNNEST:
				case USING:
				case WHEN:
				case WHERE:
				case WINDOW:
				case WITH:
				case WITHIN:
				case QUOTED_STRING:
				case TRIPLE_QUOTED_STRING:
				case RAW_STRING:
				case BYTE_STRING:
				case RAW_BYTE_STRING:
				case ID:
					{
					{
					setState(259);
					expr(0);
					setState(264);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(260);
						match(T__2);
						setState(261);
						expr(0);
						}
						}
						setState(266);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case T__1:
					{
					setState(267);
					match(T__1);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(270);
				match(T__4);
				}
				break;
			case 8:
				{
				setState(272);
				match(T__3);
				setState(273);
				expr(0);
				setState(274);
				match(T__4);
				}
				break;
			case 9:
				{
				setState(276);
				column_expr();
				}
				break;
			case 10:
				{
				setState(277);
				keyword();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(359);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(357);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(280);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(281);
						_la = _input.LA(1);
						if ( !(_la==T__1 || _la==T__9) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(282);
						expr(18);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(283);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(284);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__11) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(285);
						expr(17);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(286);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(287);
						_la = _input.LA(1);
						if ( !(_la==T__12 || _la==T__13) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(288);
						expr(16);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(289);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(290);
						match(T__14);
						setState(291);
						expr(15);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(292);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(293);
						match(T__15);
						setState(294);
						expr(14);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(295);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(296);
						match(T__16);
						setState(297);
						expr(13);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(298);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(318);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
						case 1:
							{
							setState(299);
							match(T__17);
							}
							break;
						case 2:
							{
							setState(300);
							match(T__5);
							}
							break;
						case 3:
							{
							setState(301);
							match(T__6);
							}
							break;
						case 4:
							{
							setState(302);
							match(T__18);
							}
							break;
						case 5:
							{
							setState(303);
							match(T__19);
							}
							break;
						case 6:
							{
							setState(304);
							match(T__20);
							}
							break;
						case 7:
							{
							setState(305);
							match(T__21);
							}
							break;
						case 8:
							{
							setState(307);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==NOT) {
								{
								setState(306);
								match(NOT);
								}
							}

							setState(309);
							match(LIKE);
							}
							break;
						case 9:
							{
							setState(311);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==NOT) {
								{
								setState(310);
								match(NOT);
								}
							}

							setState(313);
							match(BETWEEN);
							setState(314);
							expr(0);
							setState(315);
							match(AND);
							setState(316);
							expr(0);
							}
							break;
						}
						setState(320);
						expr(12);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(321);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(322);
						match(AND);
						setState(323);
						expr(7);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(324);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(325);
						match(OR);
						setState(326);
						expr(6);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(327);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(328);
						match(IS);
						setState(330);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(329);
							match(NOT);
							}
						}

						setState(332);
						match(S_NULL);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(333);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(335);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(334);
							match(NOT);
							}
						}

						setState(337);
						match(IN);
						setState(355);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__3:
							{
							{
							setState(338);
							match(T__3);
							setState(339);
							expr(0);
							setState(344);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__2) {
								{
								{
								setState(340);
								match(T__2);
								setState(341);
								expr(0);
								}
								}
								setState(346);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							setState(347);
							match(T__4);
							}
							}
							break;
						case SELECT:
							{
							setState(349);
							query_statement();
							}
							break;
						case UNNEST:
							{
							setState(350);
							match(UNNEST);
							setState(351);
							match(T__3);
							setState(352);
							array_expr();
							setState(353);
							match(T__4);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					}
					} 
				}
				setState(361);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
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

	public static class Column_exprContext extends ParserRuleContext {
		public Column_exprContext column_expr() {
			return getRuleContext(Column_exprContext.class,0);
		}
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Dataset_nameContext dataset_name() {
			return getRuleContext(Dataset_nameContext.class,0);
		}
		public Project_nameContext project_name() {
			return getRuleContext(Project_nameContext.class,0);
		}
		public Column_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterColumn_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitColumn_expr(this);
		}
	}

	public final Column_exprContext column_expr() throws RecognitionException {
		Column_exprContext _localctx = new Column_exprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_column_expr);
		try {
			setState(382);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(362);
				match(T__22);
				setState(363);
				column_expr();
				setState(364);
				match(T__22);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(379);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(374);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
					case 1:
						{
						setState(369);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
						case 1:
							{
							setState(366);
							project_name();
							setState(367);
							match(T__0);
							}
							break;
						}
						setState(371);
						dataset_name();
						setState(372);
						match(T__0);
						}
						break;
					}
					setState(376);
					table_name();
					setState(377);
					match(T__0);
					}
					break;
				}
				setState(381);
				column_name();
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

	public static class Join_typeContext extends ParserRuleContext {
		public TerminalNode INNER() { return getToken(BQLParser.INNER, 0); }
		public TerminalNode CROSS() { return getToken(BQLParser.CROSS, 0); }
		public TerminalNode FULL() { return getToken(BQLParser.FULL, 0); }
		public TerminalNode OUTER() { return getToken(BQLParser.OUTER, 0); }
		public TerminalNode LEFT() { return getToken(BQLParser.LEFT, 0); }
		public TerminalNode RIGHT() { return getToken(BQLParser.RIGHT, 0); }
		public Join_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterJoin_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitJoin_type(this);
		}
	}

	public final Join_typeContext join_type() throws RecognitionException {
		Join_typeContext _localctx = new Join_typeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_join_type);
		int _la;
		try {
			setState(398);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(384);
				match(INNER);
				}
				break;
			case CROSS:
				enterOuterAlt(_localctx, 2);
				{
				setState(385);
				match(CROSS);
				}
				break;
			case FULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(386);
				match(FULL);
				setState(388);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(387);
					match(OUTER);
					}
				}

				}
				break;
			case LEFT:
				enterOuterAlt(_localctx, 4);
				{
				setState(390);
				match(LEFT);
				setState(392);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(391);
					match(OUTER);
					}
				}

				}
				break;
			case RIGHT:
				enterOuterAlt(_localctx, 5);
				{
				setState(394);
				match(RIGHT);
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(395);
					match(OUTER);
					}
				}

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

	public static class Except_statementContext extends ParserRuleContext {
		public TerminalNode EXCEPT() { return getToken(BQLParser.EXCEPT, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public Except_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_except_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterExcept_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitExcept_statement(this);
		}
	}

	public final Except_statementContext except_statement() throws RecognitionException {
		Except_statementContext _localctx = new Except_statementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_except_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			match(EXCEPT);
			setState(401);
			match(T__3);
			setState(402);
			column_name();
			setState(407);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(403);
				match(T__2);
				setState(404);
				column_name();
				}
				}
				setState(409);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(410);
			match(T__4);
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

	public static class On_clauseContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(BQLParser.ON, 0); }
		public Bool_expressionContext bool_expression() {
			return getRuleContext(Bool_expressionContext.class,0);
		}
		public On_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_on_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterOn_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitOn_clause(this);
		}
	}

	public final On_clauseContext on_clause() throws RecognitionException {
		On_clauseContext _localctx = new On_clauseContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_on_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			match(ON);
			setState(413);
			bool_expression();
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

	public static class Bool_expressionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Bool_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterBool_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitBool_expression(this);
		}
	}

	public final Bool_expressionContext bool_expression() throws RecognitionException {
		Bool_expressionContext _localctx = new Bool_expressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_bool_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			expr(0);
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

	public static class CountContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public CountContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_count; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterCount(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitCount(this);
		}
	}

	public final CountContext count() throws RecognitionException {
		CountContext _localctx = new CountContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_count);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			number();
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

	public static class NameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BQLParser.ID, 0); }
		public List<TerminalNode> DQOUTE() { return getTokens(BQLParser.DQOUTE); }
		public TerminalNode DQOUTE(int i) {
			return getToken(BQLParser.DQOUTE, i);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<TerminalNode> QUOTE() { return getTokens(BQLParser.QUOTE); }
		public TerminalNode QUOTE(int i) {
			return getToken(BQLParser.QUOTE, i);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_name);
		try {
			setState(436);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(419);
				match(ID);
				}
				break;
			case DQOUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(420);
				match(DQOUTE);
				setState(421);
				name();
				setState(422);
				match(DQOUTE);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(424);
				match(T__3);
				setState(425);
				name();
				setState(426);
				match(T__4);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 4);
				{
				setState(428);
				match(T__22);
				setState(429);
				name();
				setState(430);
				match(T__22);
				}
				break;
			case QUOTE:
				enterOuterAlt(_localctx, 5);
				{
				setState(432);
				match(QUOTE);
				setState(433);
				name();
				setState(434);
				match(QUOTE);
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

	public static class Unary_operatorContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(BQLParser.NOT, 0); }
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitUnary_operator(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			_la = _input.LA(1);
			if ( !(_la==T__11 || _la==T__23 || _la==NOT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Alias_nameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Alias_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alias_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterAlias_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitAlias_name(this);
		}
	}

	public final Alias_nameContext alias_name() throws RecognitionException {
		Alias_nameContext _localctx = new Alias_nameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_alias_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			name();
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

	public static class Array_nameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Array_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterArray_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitArray_name(this);
		}
	}

	public final Array_nameContext array_name() throws RecognitionException {
		Array_nameContext _localctx = new Array_nameContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_array_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			name();
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

	public static class Column_nameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Column_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterColumn_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitColumn_name(this);
		}
	}

	public final Column_nameContext column_name() throws RecognitionException {
		Column_nameContext _localctx = new Column_nameContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_column_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			name();
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

	public static class Cte_nameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Cte_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cte_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterCte_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitCte_name(this);
		}
	}

	public final Cte_nameContext cte_name() throws RecognitionException {
		Cte_nameContext _localctx = new Cte_nameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_cte_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			name();
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

	public static class Dataset_nameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Dataset_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataset_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterDataset_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitDataset_name(this);
		}
	}

	public final Dataset_nameContext dataset_name() throws RecognitionException {
		Dataset_nameContext _localctx = new Dataset_nameContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_dataset_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			name();
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

	public static class Datatype_nameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Datatype_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterDatatype_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitDatatype_name(this);
		}
	}

	public final Datatype_nameContext datatype_name() throws RecognitionException {
		Datatype_nameContext _localctx = new Datatype_nameContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_datatype_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			name();
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

	public static class Function_nameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterFunction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitFunction_name(this);
		}
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			name();
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

	public static class Join_nameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Join_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterJoin_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitJoin_name(this);
		}
	}

	public final Join_nameContext join_name() throws RecognitionException {
		Join_nameContext _localctx = new Join_nameContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_join_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			name();
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

	public static class Member_nameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Member_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterMember_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitMember_name(this);
		}
	}

	public final Member_nameContext member_name() throws RecognitionException {
		Member_nameContext _localctx = new Member_nameContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_member_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			name();
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

	public static class Project_nameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Project_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_project_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterProject_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitProject_name(this);
		}
	}

	public final Project_nameContext project_name() throws RecognitionException {
		Project_nameContext _localctx = new Project_nameContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_project_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			name();
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

	public static class Struct_nameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Struct_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterStruct_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitStruct_name(this);
		}
	}

	public final Struct_nameContext struct_name() throws RecognitionException {
		Struct_nameContext _localctx = new Struct_nameContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_struct_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			name();
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

	public static class Table_nameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterTable_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitTable_name(this);
		}
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			name();
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

	public static class Table_exprContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Dataset_nameContext dataset_name() {
			return getRuleContext(Dataset_nameContext.class,0);
		}
		public Project_nameContext project_name() {
			return getRuleContext(Project_nameContext.class,0);
		}
		public Table_exprContext table_expr() {
			return getRuleContext(Table_exprContext.class,0);
		}
		public Table_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterTable_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitTable_expr(this);
		}
	}

	public final Table_exprContext table_expr() throws RecognitionException {
		Table_exprContext _localctx = new Table_exprContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_table_expr);
		try {
			setState(479);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(472);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
				case 1:
					{
					setState(467);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
					case 1:
						{
						setState(464);
						project_name();
						setState(465);
						match(T__0);
						}
						break;
					}
					setState(469);
					dataset_name();
					setState(470);
					match(T__0);
					}
					break;
				}
				setState(474);
				table_name();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(475);
				match(T__22);
				setState(476);
				table_expr();
				setState(477);
				match(T__22);
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

	public static class NumberContext extends ParserRuleContext {
		public Integer_typeContext integer_type() {
			return getRuleContext(Integer_typeContext.class,0);
		}
		public Float_typeContext float_type() {
			return getRuleContext(Float_typeContext.class,0);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_number);
		try {
			setState(483);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(481);
				integer_type();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(482);
				float_type();
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

	public static class Integer_typeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(BQLParser.INT, 0); }
		public Integer_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterInteger_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitInteger_type(this);
		}
	}

	public final Integer_typeContext integer_type() throws RecognitionException {
		Integer_typeContext _localctx = new Integer_typeContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_integer_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			match(INT);
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

	public static class Float_typeContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(BQLParser.FLOAT, 0); }
		public Float_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_float_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterFloat_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitFloat_type(this);
		}
	}

	public final Float_typeContext float_type() throws RecognitionException {
		Float_typeContext _localctx = new Float_typeContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_float_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			match(FLOAT);
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

	public static class StringContext extends ParserRuleContext {
		public Quoted_stringContext quoted_string() {
			return getRuleContext(Quoted_stringContext.class,0);
		}
		public Triple_quoted_stringContext triple_quoted_string() {
			return getRuleContext(Triple_quoted_stringContext.class,0);
		}
		public Raw_stringContext raw_string() {
			return getRuleContext(Raw_stringContext.class,0);
		}
		public Byte_stringContext byte_string() {
			return getRuleContext(Byte_stringContext.class,0);
		}
		public Raw_byte_stringContext raw_byte_string() {
			return getRuleContext(Raw_byte_stringContext.class,0);
		}
		public Special_stringContext special_string() {
			return getRuleContext(Special_stringContext.class,0);
		}
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitString(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_string);
		try {
			setState(495);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case QUOTED_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(489);
				quoted_string();
				}
				break;
			case TRIPLE_QUOTED_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(490);
				triple_quoted_string();
				}
				break;
			case RAW_STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(491);
				raw_string();
				}
				break;
			case BYTE_STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(492);
				byte_string();
				}
				break;
			case RAW_BYTE_STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(493);
				raw_byte_string();
				}
				break;
			case T__3:
			case T__22:
			case QUOTE:
			case DQOUTE:
			case ID:
				enterOuterAlt(_localctx, 6);
				{
				setState(494);
				special_string();
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

	public static class Quoted_stringContext extends ParserRuleContext {
		public TerminalNode QUOTED_STRING() { return getToken(BQLParser.QUOTED_STRING, 0); }
		public Quoted_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quoted_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterQuoted_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitQuoted_string(this);
		}
	}

	public final Quoted_stringContext quoted_string() throws RecognitionException {
		Quoted_stringContext _localctx = new Quoted_stringContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_quoted_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			match(QUOTED_STRING);
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

	public static class Triple_quoted_stringContext extends ParserRuleContext {
		public TerminalNode TRIPLE_QUOTED_STRING() { return getToken(BQLParser.TRIPLE_QUOTED_STRING, 0); }
		public Triple_quoted_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triple_quoted_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterTriple_quoted_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitTriple_quoted_string(this);
		}
	}

	public final Triple_quoted_stringContext triple_quoted_string() throws RecognitionException {
		Triple_quoted_stringContext _localctx = new Triple_quoted_stringContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_triple_quoted_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			match(TRIPLE_QUOTED_STRING);
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

	public static class Raw_stringContext extends ParserRuleContext {
		public TerminalNode RAW_STRING() { return getToken(BQLParser.RAW_STRING, 0); }
		public Raw_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_raw_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterRaw_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitRaw_string(this);
		}
	}

	public final Raw_stringContext raw_string() throws RecognitionException {
		Raw_stringContext _localctx = new Raw_stringContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_raw_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			match(RAW_STRING);
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

	public static class Byte_stringContext extends ParserRuleContext {
		public TerminalNode BYTE_STRING() { return getToken(BQLParser.BYTE_STRING, 0); }
		public Byte_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_byte_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterByte_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitByte_string(this);
		}
	}

	public final Byte_stringContext byte_string() throws RecognitionException {
		Byte_stringContext _localctx = new Byte_stringContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_byte_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			match(BYTE_STRING);
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

	public static class Raw_byte_stringContext extends ParserRuleContext {
		public TerminalNode RAW_BYTE_STRING() { return getToken(BQLParser.RAW_BYTE_STRING, 0); }
		public Raw_byte_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_raw_byte_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterRaw_byte_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitRaw_byte_string(this);
		}
	}

	public final Raw_byte_stringContext raw_byte_string() throws RecognitionException {
		Raw_byte_stringContext _localctx = new Raw_byte_stringContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_raw_byte_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			match(RAW_BYTE_STRING);
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

	public static class Special_stringContext extends ParserRuleContext {
		public Datatype_nameContext datatype_name() {
			return getRuleContext(Datatype_nameContext.class,0);
		}
		public TerminalNode QUOTED_STRING() { return getToken(BQLParser.QUOTED_STRING, 0); }
		public Special_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_special_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterSpecial_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitSpecial_string(this);
		}
	}

	public final Special_stringContext special_string() throws RecognitionException {
		Special_stringContext _localctx = new Special_stringContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_special_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			datatype_name();
			setState(508);
			match(QUOTED_STRING);
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

	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode ALL() { return getToken(BQLParser.ALL, 0); }
		public TerminalNode AND() { return getToken(BQLParser.AND, 0); }
		public TerminalNode ANY() { return getToken(BQLParser.ANY, 0); }
		public TerminalNode ARRAY() { return getToken(BQLParser.ARRAY, 0); }
		public TerminalNode AS() { return getToken(BQLParser.AS, 0); }
		public TerminalNode ASC() { return getToken(BQLParser.ASC, 0); }
		public TerminalNode ASSERT_ROWS_MODIFIED() { return getToken(BQLParser.ASSERT_ROWS_MODIFIED, 0); }
		public TerminalNode AT() { return getToken(BQLParser.AT, 0); }
		public TerminalNode BETWEEN() { return getToken(BQLParser.BETWEEN, 0); }
		public TerminalNode BY() { return getToken(BQLParser.BY, 0); }
		public TerminalNode CASE() { return getToken(BQLParser.CASE, 0); }
		public TerminalNode CAST() { return getToken(BQLParser.CAST, 0); }
		public TerminalNode COLLATE() { return getToken(BQLParser.COLLATE, 0); }
		public TerminalNode CONTAINS() { return getToken(BQLParser.CONTAINS, 0); }
		public TerminalNode CREATE() { return getToken(BQLParser.CREATE, 0); }
		public TerminalNode CROSS() { return getToken(BQLParser.CROSS, 0); }
		public TerminalNode CUBE() { return getToken(BQLParser.CUBE, 0); }
		public TerminalNode CURRENT() { return getToken(BQLParser.CURRENT, 0); }
		public TerminalNode DEFAULT() { return getToken(BQLParser.DEFAULT, 0); }
		public TerminalNode DEFINE() { return getToken(BQLParser.DEFINE, 0); }
		public TerminalNode DESC() { return getToken(BQLParser.DESC, 0); }
		public TerminalNode DISTINCT() { return getToken(BQLParser.DISTINCT, 0); }
		public TerminalNode ELSE() { return getToken(BQLParser.ELSE, 0); }
		public TerminalNode END() { return getToken(BQLParser.END, 0); }
		public TerminalNode ENUM() { return getToken(BQLParser.ENUM, 0); }
		public TerminalNode ESCAPE() { return getToken(BQLParser.ESCAPE, 0); }
		public TerminalNode EXCEPT() { return getToken(BQLParser.EXCEPT, 0); }
		public TerminalNode EXCLUDE() { return getToken(BQLParser.EXCLUDE, 0); }
		public TerminalNode EXISTS() { return getToken(BQLParser.EXISTS, 0); }
		public TerminalNode EXTRACT() { return getToken(BQLParser.EXTRACT, 0); }
		public TerminalNode FALSE() { return getToken(BQLParser.FALSE, 0); }
		public TerminalNode FETCH() { return getToken(BQLParser.FETCH, 0); }
		public TerminalNode FOLLOWING() { return getToken(BQLParser.FOLLOWING, 0); }
		public TerminalNode FOR() { return getToken(BQLParser.FOR, 0); }
		public TerminalNode FROM() { return getToken(BQLParser.FROM, 0); }
		public TerminalNode FULL() { return getToken(BQLParser.FULL, 0); }
		public TerminalNode GROUP() { return getToken(BQLParser.GROUP, 0); }
		public TerminalNode GROUPING() { return getToken(BQLParser.GROUPING, 0); }
		public TerminalNode GROUPS() { return getToken(BQLParser.GROUPS, 0); }
		public TerminalNode HASH() { return getToken(BQLParser.HASH, 0); }
		public TerminalNode HAVING() { return getToken(BQLParser.HAVING, 0); }
		public TerminalNode IF() { return getToken(BQLParser.IF, 0); }
		public TerminalNode IGNORE() { return getToken(BQLParser.IGNORE, 0); }
		public TerminalNode IN() { return getToken(BQLParser.IN, 0); }
		public TerminalNode INNER() { return getToken(BQLParser.INNER, 0); }
		public TerminalNode INTERSECT() { return getToken(BQLParser.INTERSECT, 0); }
		public TerminalNode INTERVAL() { return getToken(BQLParser.INTERVAL, 0); }
		public TerminalNode INTO() { return getToken(BQLParser.INTO, 0); }
		public TerminalNode IS() { return getToken(BQLParser.IS, 0); }
		public TerminalNode JOIN() { return getToken(BQLParser.JOIN, 0); }
		public TerminalNode LATERAL() { return getToken(BQLParser.LATERAL, 0); }
		public TerminalNode LEFT() { return getToken(BQLParser.LEFT, 0); }
		public TerminalNode LIKE() { return getToken(BQLParser.LIKE, 0); }
		public TerminalNode LIMIT() { return getToken(BQLParser.LIMIT, 0); }
		public TerminalNode LOOKUP() { return getToken(BQLParser.LOOKUP, 0); }
		public TerminalNode MERGE() { return getToken(BQLParser.MERGE, 0); }
		public TerminalNode NATURAL() { return getToken(BQLParser.NATURAL, 0); }
		public TerminalNode NEW() { return getToken(BQLParser.NEW, 0); }
		public TerminalNode NO() { return getToken(BQLParser.NO, 0); }
		public TerminalNode NOT() { return getToken(BQLParser.NOT, 0); }
		public TerminalNode S_NULL() { return getToken(BQLParser.S_NULL, 0); }
		public TerminalNode NULLS() { return getToken(BQLParser.NULLS, 0); }
		public TerminalNode OF() { return getToken(BQLParser.OF, 0); }
		public TerminalNode OFFSET() { return getToken(BQLParser.OFFSET, 0); }
		public TerminalNode ON() { return getToken(BQLParser.ON, 0); }
		public TerminalNode OR() { return getToken(BQLParser.OR, 0); }
		public TerminalNode ORDER() { return getToken(BQLParser.ORDER, 0); }
		public TerminalNode ORDINAL() { return getToken(BQLParser.ORDINAL, 0); }
		public TerminalNode OUTER() { return getToken(BQLParser.OUTER, 0); }
		public TerminalNode OVER() { return getToken(BQLParser.OVER, 0); }
		public TerminalNode PARTITION() { return getToken(BQLParser.PARTITION, 0); }
		public TerminalNode PRECEDING() { return getToken(BQLParser.PRECEDING, 0); }
		public TerminalNode PROTO() { return getToken(BQLParser.PROTO, 0); }
		public TerminalNode RANGE() { return getToken(BQLParser.RANGE, 0); }
		public TerminalNode RECURSIVE() { return getToken(BQLParser.RECURSIVE, 0); }
		public TerminalNode REPLACE() { return getToken(BQLParser.REPLACE, 0); }
		public TerminalNode RESPECT() { return getToken(BQLParser.RESPECT, 0); }
		public TerminalNode RIGHT() { return getToken(BQLParser.RIGHT, 0); }
		public TerminalNode ROLLUP() { return getToken(BQLParser.ROLLUP, 0); }
		public TerminalNode ROWS() { return getToken(BQLParser.ROWS, 0); }
		public TerminalNode SAFE_OFFSET() { return getToken(BQLParser.SAFE_OFFSET, 0); }
		public TerminalNode SAFE_ORDINAL() { return getToken(BQLParser.SAFE_ORDINAL, 0); }
		public TerminalNode SELECT() { return getToken(BQLParser.SELECT, 0); }
		public TerminalNode SET() { return getToken(BQLParser.SET, 0); }
		public TerminalNode SOME() { return getToken(BQLParser.SOME, 0); }
		public TerminalNode SSTRUCT() { return getToken(BQLParser.SSTRUCT, 0); }
		public TerminalNode SYSTEM() { return getToken(BQLParser.SYSTEM, 0); }
		public TerminalNode TABLESAMPLE() { return getToken(BQLParser.TABLESAMPLE, 0); }
		public TerminalNode THEN() { return getToken(BQLParser.THEN, 0); }
		public TerminalNode TIME() { return getToken(BQLParser.TIME, 0); }
		public TerminalNode TO() { return getToken(BQLParser.TO, 0); }
		public TerminalNode TREAT() { return getToken(BQLParser.TREAT, 0); }
		public TerminalNode TRUE() { return getToken(BQLParser.TRUE, 0); }
		public TerminalNode UNBOUNDED() { return getToken(BQLParser.UNBOUNDED, 0); }
		public TerminalNode UNION() { return getToken(BQLParser.UNION, 0); }
		public TerminalNode UNNEST() { return getToken(BQLParser.UNNEST, 0); }
		public TerminalNode USING() { return getToken(BQLParser.USING, 0); }
		public TerminalNode WHEN() { return getToken(BQLParser.WHEN, 0); }
		public TerminalNode WHERE() { return getToken(BQLParser.WHERE, 0); }
		public TerminalNode WINDOW() { return getToken(BQLParser.WINDOW, 0); }
		public TerminalNode WITH() { return getToken(BQLParser.WITH, 0); }
		public TerminalNode WITHIN() { return getToken(BQLParser.WITHIN, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).enterKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BQLListener ) ((BQLListener)listener).exitKeyword(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			_la = _input.LA(1);
			if ( !(((((_la - 30)) & ~0x3f) == 0 && ((1L << (_la - 30)) & ((1L << (ALL - 30)) | (1L << (AND - 30)) | (1L << (ANY - 30)) | (1L << (ARRAY - 30)) | (1L << (AS - 30)) | (1L << (ASC - 30)) | (1L << (ASSERT_ROWS_MODIFIED - 30)) | (1L << (AT - 30)) | (1L << (BETWEEN - 30)) | (1L << (BY - 30)) | (1L << (CASE - 30)) | (1L << (CAST - 30)) | (1L << (COLLATE - 30)) | (1L << (CONTAINS - 30)) | (1L << (CREATE - 30)) | (1L << (CROSS - 30)) | (1L << (CUBE - 30)) | (1L << (CURRENT - 30)) | (1L << (DEFAULT - 30)) | (1L << (DEFINE - 30)) | (1L << (DESC - 30)) | (1L << (DISTINCT - 30)) | (1L << (ELSE - 30)) | (1L << (END - 30)) | (1L << (ENUM - 30)) | (1L << (ESCAPE - 30)) | (1L << (EXCEPT - 30)) | (1L << (EXCLUDE - 30)) | (1L << (EXISTS - 30)) | (1L << (EXTRACT - 30)) | (1L << (FALSE - 30)) | (1L << (FETCH - 30)) | (1L << (FOLLOWING - 30)) | (1L << (FOR - 30)) | (1L << (FROM - 30)) | (1L << (FULL - 30)) | (1L << (GROUP - 30)) | (1L << (GROUPING - 30)) | (1L << (GROUPS - 30)) | (1L << (HASH - 30)) | (1L << (HAVING - 30)) | (1L << (IF - 30)) | (1L << (IGNORE - 30)) | (1L << (IN - 30)) | (1L << (INNER - 30)) | (1L << (INTERSECT - 30)) | (1L << (INTERVAL - 30)) | (1L << (INTO - 30)) | (1L << (IS - 30)) | (1L << (JOIN - 30)) | (1L << (LATERAL - 30)) | (1L << (LEFT - 30)) | (1L << (LIKE - 30)) | (1L << (LIMIT - 30)) | (1L << (LOOKUP - 30)) | (1L << (MERGE - 30)) | (1L << (NATURAL - 30)) | (1L << (NEW - 30)) | (1L << (NO - 30)) | (1L << (NOT - 30)) | (1L << (S_NULL - 30)) | (1L << (NULLS - 30)) | (1L << (OF - 30)) | (1L << (OFFSET - 30)))) != 0) || ((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & ((1L << (ON - 94)) | (1L << (OR - 94)) | (1L << (ORDER - 94)) | (1L << (ORDINAL - 94)) | (1L << (OUTER - 94)) | (1L << (OVER - 94)) | (1L << (PARTITION - 94)) | (1L << (PRECEDING - 94)) | (1L << (PROTO - 94)) | (1L << (RANGE - 94)) | (1L << (RECURSIVE - 94)) | (1L << (REPLACE - 94)) | (1L << (RESPECT - 94)) | (1L << (RIGHT - 94)) | (1L << (ROLLUP - 94)) | (1L << (ROWS - 94)) | (1L << (SAFE_OFFSET - 94)) | (1L << (SAFE_ORDINAL - 94)) | (1L << (SELECT - 94)) | (1L << (SET - 94)) | (1L << (SOME - 94)) | (1L << (SSTRUCT - 94)) | (1L << (SYSTEM - 94)) | (1L << (TABLESAMPLE - 94)) | (1L << (THEN - 94)) | (1L << (TIME - 94)) | (1L << (TO - 94)) | (1L << (TREAT - 94)) | (1L << (TRUE - 94)) | (1L << (UNBOUNDED - 94)) | (1L << (UNION - 94)) | (1L << (UNNEST - 94)) | (1L << (USING - 94)) | (1L << (WHEN - 94)) | (1L << (WHERE - 94)) | (1L << (WINDOW - 94)) | (1L << (WITH - 94)) | (1L << (WITHIN - 94)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
		case 4:
			return from_item_sempred((From_itemContext)_localctx, predIndex);
		case 9:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean from_item_sempred(From_itemContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 17);
		case 2:
			return precpred(_ctx, 16);
		case 3:
			return precpred(_ctx, 15);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 13);
		case 6:
			return precpred(_ctx, 12);
		case 7:
			return precpred(_ctx, 11);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 10);
		case 11:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u008f\u0203\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\3\3\3\5\3[\n\3\3\4\3\4\5\4_\n\4\3\4\5\4b\n\4\3\4\5\4e\n\4\3\4"+
		"\3\4\5\4i\n\4\3\4\3\4\5\4m\n\4\3\4\5\4p\n\4\5\4r\n\4\3\4\3\4\5\4v\n\4"+
		"\3\4\3\4\5\4z\n\4\3\4\3\4\5\4~\n\4\3\4\5\4\u0081\n\4\5\4\u0083\n\4\7\4"+
		"\u0085\n\4\f\4\16\4\u0088\13\4\3\4\5\4\u008b\n\4\3\4\5\4\u008e\n\4\3\5"+
		"\3\5\3\5\3\5\7\5\u0094\n\5\f\5\16\5\u0097\13\5\3\6\3\6\3\6\5\6\u009c\n"+
		"\6\3\6\5\6\u009f\n\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00a7\n\6\3\6\3\6\3\6"+
		"\3\6\5\6\u00ad\n\6\3\6\5\6\u00b0\n\6\3\6\3\6\3\6\3\6\3\6\5\6\u00b7\n\6"+
		"\3\6\5\6\u00ba\n\6\3\6\3\6\3\6\5\6\u00bf\n\6\3\6\5\6\u00c2\n\6\5\6\u00c4"+
		"\n\6\3\6\3\6\5\6\u00c8\n\6\3\6\3\6\3\6\3\6\5\6\u00ce\n\6\7\6\u00d0\n\6"+
		"\f\6\16\6\u00d3\13\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7\t\u00e0"+
		"\n\t\f\t\16\t\u00e3\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00fc"+
		"\n\13\3\13\3\13\3\13\5\13\u0101\n\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13"+
		"\u0109\n\13\f\13\16\13\u010c\13\13\3\13\5\13\u010f\n\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u0119\n\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0136\n\13\3\13\3\13\5\13\u013a"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u0141\n\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u014d\n\13\3\13\3\13\3\13\5\13\u0152\n"+
		"\13\3\13\3\13\3\13\3\13\3\13\7\13\u0159\n\13\f\13\16\13\u015c\13\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0166\n\13\7\13\u0168\n\13"+
		"\f\13\16\13\u016b\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0174\n\f\3\f"+
		"\3\f\3\f\5\f\u0179\n\f\3\f\3\f\3\f\5\f\u017e\n\f\3\f\5\f\u0181\n\f\3\r"+
		"\3\r\3\r\3\r\5\r\u0187\n\r\3\r\3\r\5\r\u018b\n\r\3\r\3\r\5\r\u018f\n\r"+
		"\5\r\u0191\n\r\3\16\3\16\3\16\3\16\3\16\7\16\u0198\n\16\f\16\16\16\u019b"+
		"\13\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u01b7\n\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3 \5 \u01d6\n \3 \3 \3 \5 \u01db\n \3 \3 \3 \3 \3 \5 \u01e2\n "+
		"\3!\3!\5!\u01e6\n!\3\"\3\"\3#\3#\3$\3$\3$\3$\3$\3$\5$\u01f2\n$\3%\3%\3"+
		"&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3+\3+\3+\2\4\n\24,\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT\2\t\4\2  \65"+
		"\65\5\2__ccpq\4\2\4\4\f\f\3\2\r\16\3\2\17\20\5\2\16\16\32\32[[\3\2 \u0085"+
		"\2\u0238\2V\3\2\2\2\4X\3\2\2\2\6\\\3\2\2\2\b\u008f\3\2\2\2\n\u00c3\3\2"+
		"\2\2\f\u00d4\3\2\2\2\16\u00d7\3\2\2\2\20\u00da\3\2\2\2\22\u00e6\3\2\2"+
		"\2\24\u0118\3\2\2\2\26\u0180\3\2\2\2\30\u0190\3\2\2\2\32\u0192\3\2\2\2"+
		"\34\u019e\3\2\2\2\36\u01a1\3\2\2\2 \u01a3\3\2\2\2\"\u01b6\3\2\2\2$\u01b8"+
		"\3\2\2\2&\u01ba\3\2\2\2(\u01bc\3\2\2\2*\u01be\3\2\2\2,\u01c0\3\2\2\2."+
		"\u01c2\3\2\2\2\60\u01c4\3\2\2\2\62\u01c6\3\2\2\2\64\u01c8\3\2\2\2\66\u01ca"+
		"\3\2\2\28\u01cc\3\2\2\2:\u01ce\3\2\2\2<\u01d0\3\2\2\2>\u01e1\3\2\2\2@"+
		"\u01e5\3\2\2\2B\u01e7\3\2\2\2D\u01e9\3\2\2\2F\u01f1\3\2\2\2H\u01f3\3\2"+
		"\2\2J\u01f5\3\2\2\2L\u01f7\3\2\2\2N\u01f9\3\2\2\2P\u01fb\3\2\2\2R\u01fd"+
		"\3\2\2\2T\u0200\3\2\2\2VW\5\4\3\2W\3\3\2\2\2XZ\5\6\4\2Y[\5\16\b\2ZY\3"+
		"\2\2\2Z[\3\2\2\2[\5\3\2\2\2\\^\7r\2\2]_\t\2\2\2^]\3\2\2\2^_\3\2\2\2_q"+
		"\3\2\2\2`b\5\24\13\2a`\3\2\2\2ab\3\2\2\2bd\3\2\2\2ce\7\3\2\2dc\3\2\2\2"+
		"de\3\2\2\2ef\3\2\2\2fh\7\4\2\2gi\5\32\16\2hg\3\2\2\2hi\3\2\2\2ir\3\2\2"+
		"\2jo\5\24\13\2km\7$\2\2lk\3\2\2\2lm\3\2\2\2mn\3\2\2\2np\5&\24\2ol\3\2"+
		"\2\2op\3\2\2\2pr\3\2\2\2qa\3\2\2\2qj\3\2\2\2r\u0086\3\2\2\2s\u0082\7\5"+
		"\2\2tv\5\24\13\2ut\3\2\2\2uv\3\2\2\2vw\3\2\2\2wy\7\4\2\2xz\5\32\16\2y"+
		"x\3\2\2\2yz\3\2\2\2z\u0083\3\2\2\2{\u0080\5\24\13\2|~\7$\2\2}|\3\2\2\2"+
		"}~\3\2\2\2~\177\3\2\2\2\177\u0081\5&\24\2\u0080}\3\2\2\2\u0080\u0081\3"+
		"\2\2\2\u0081\u0083\3\2\2\2\u0082u\3\2\2\2\u0082{\3\2\2\2\u0083\u0085\3"+
		"\2\2\2\u0084s\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087"+
		"\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008b\5\b\5\2\u008a"+
		"\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008e\5\f"+
		"\7\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e\7\3\2\2\2\u008f\u0090"+
		"\7B\2\2\u0090\u0095\5\n\6\2\u0091\u0092\7\5\2\2\u0092\u0094\5\n\6\2\u0093"+
		"\u0091\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\t\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099\b\6\1\2\u0099\u009e"+
		"\5> \2\u009a\u009c\7$\2\2\u009b\u009a\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009f\5&\24\2\u009e\u009b\3\2\2\2\u009e\u009f\3\2"+
		"\2\2\u009f\u00a6\3\2\2\2\u00a0\u00a1\7A\2\2\u00a1\u00a2\7v\2\2\u00a2\u00a3"+
		"\7y\2\2\u00a3\u00a4\7$\2\2\u00a4\u00a5\7^\2\2\u00a5\u00a7\5F$\2\u00a6"+
		"\u00a0\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00c4\3\2\2\2\u00a8\u00a9\7\6"+
		"\2\2\u00a9\u00aa\5\2\2\2\u00aa\u00af\7\7\2\2\u00ab\u00ad\7$\2\2\u00ac"+
		"\u00ab\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\5&"+
		"\24\2\u00af\u00ac\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00c4\3\2\2\2\u00b1"+
		"\u00b2\7\177\2\2\u00b2\u00b3\7\6\2\2\u00b3\u00b4\5\22\n\2\u00b4\u00b9"+
		"\7\7\2\2\u00b5\u00b7\7$\2\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00b8\3\2\2\2\u00b8\u00ba\5&\24\2\u00b9\u00b6\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba\u00c1\3\2\2\2\u00bb\u00bc\7\u0084\2\2\u00bc\u00be\7_\2\2\u00bd"+
		"\u00bf\7$\2\2\u00be\u00bd\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2"+
		"\2\2\u00c0\u00c2\5&\24\2\u00c1\u00bb\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\u00c4\3\2\2\2\u00c3\u0098\3\2\2\2\u00c3\u00a8\3\2\2\2\u00c3\u00b1\3\2"+
		"\2\2\u00c4\u00d1\3\2\2\2\u00c5\u00c7\f\5\2\2\u00c6\u00c8\5\30\r\2\u00c7"+
		"\u00c6\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\7Q"+
		"\2\2\u00ca\u00cd\5\n\6\2\u00cb\u00ce\5\34\17\2\u00cc\u00ce\5\20\t\2\u00cd"+
		"\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00c5\3\2"+
		"\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\13\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d5\7\u0082\2\2\u00d5\u00d6\5"+
		"\36\20\2\u00d6\r\3\2\2\2\u00d7\u00d8\7U\2\2\u00d8\u00d9\5 \21\2\u00d9"+
		"\17\3\2\2\2\u00da\u00db\7\u0080\2\2\u00db\u00dc\7\6\2\2\u00dc\u00e1\5"+
		"\64\33\2\u00dd\u00de\7\5\2\2\u00de\u00e0\5\64\33\2\u00df\u00dd\3\2\2\2"+
		"\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e4"+
		"\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5\7\7\2\2\u00e5\21\3\2\2\2\u00e6"+
		"\u00e7\7#\2\2\u00e7\u00e8\7\b\2\2\u00e8\u00e9\5\60\31\2\u00e9\u00ea\7"+
		"\t\2\2\u00ea\23\3\2\2\2\u00eb\u00ec\b\13\1\2\u00ec\u0119\5@!\2\u00ed\u0119"+
		"\5F$\2\u00ee\u00ef\5(\25\2\u00ef\u00f0\7\n\2\2\u00f0\u00f1\t\3\2\2\u00f1"+
		"\u00f2\7\6\2\2\u00f2\u00f3\5\24\13\2\u00f3\u00f4\7\7\2\2\u00f4\u00f5\7"+
		"\13\2\2\u00f5\u0119\3\2\2\2\u00f6\u00f7\5$\23\2\u00f7\u00f8\5\24\13\24"+
		"\u00f8\u0119\3\2\2\2\u00f9\u00fb\7P\2\2\u00fa\u00fc\7[\2\2\u00fb\u00fa"+
		"\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u0119\7|\2\2\u00fe"+
		"\u0100\7P\2\2\u00ff\u0101\7[\2\2\u0100\u00ff\3\2\2\2\u0100\u0101\3\2\2"+
		"\2\u0101\u0102\3\2\2\2\u0102\u0119\7>\2\2\u0103\u0104\5\62\32\2\u0104"+
		"\u010e\7\6\2\2\u0105\u010a\5\24\13\2\u0106\u0107\7\5\2\2\u0107\u0109\5"+
		"\24\13\2\u0108\u0106\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u010f\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010f\7\4"+
		"\2\2\u010e\u0105\3\2\2\2\u010e\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		"\u0111\7\7\2\2\u0111\u0119\3\2\2\2\u0112\u0113\7\6\2\2\u0113\u0114\5\24"+
		"\13\2\u0114\u0115\7\7\2\2\u0115\u0119\3\2\2\2\u0116\u0119\5\26\f\2\u0117"+
		"\u0119\5T+\2\u0118\u00eb\3\2\2\2\u0118\u00ed\3\2\2\2\u0118\u00ee\3\2\2"+
		"\2\u0118\u00f6\3\2\2\2\u0118\u00f9\3\2\2\2\u0118\u00fe\3\2\2\2\u0118\u0103"+
		"\3\2\2\2\u0118\u0112\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0117\3\2\2\2\u0119"+
		"\u0169\3\2\2\2\u011a\u011b\f\23\2\2\u011b\u011c\t\4\2\2\u011c\u0168\5"+
		"\24\13\24\u011d\u011e\f\22\2\2\u011e\u011f\t\5\2\2\u011f\u0168\5\24\13"+
		"\23\u0120\u0121\f\21\2\2\u0121\u0122\t\6\2\2\u0122\u0168\5\24\13\22\u0123"+
		"\u0124\f\20\2\2\u0124\u0125\7\21\2\2\u0125\u0168\5\24\13\21\u0126\u0127"+
		"\f\17\2\2\u0127\u0128\7\22\2\2\u0128\u0168\5\24\13\20\u0129\u012a\f\16"+
		"\2\2\u012a\u012b\7\23\2\2\u012b\u0168\5\24\13\17\u012c\u0140\f\r\2\2\u012d"+
		"\u0141\7\24\2\2\u012e\u0141\7\b\2\2\u012f\u0141\7\t\2\2\u0130\u0141\7"+
		"\25\2\2\u0131\u0141\7\26\2\2\u0132\u0141\7\27\2\2\u0133\u0141\7\30\2\2"+
		"\u0134\u0136\7[\2\2\u0135\u0134\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0137"+
		"\3\2\2\2\u0137\u0141\7T\2\2\u0138\u013a\7[\2\2\u0139\u0138\3\2\2\2\u0139"+
		"\u013a\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013c\7(\2\2\u013c\u013d\5\24"+
		"\13\2\u013d\u013e\7!\2\2\u013e\u013f\5\24\13\2\u013f\u0141\3\2\2\2\u0140"+
		"\u012d\3\2\2\2\u0140\u012e\3\2\2\2\u0140\u012f\3\2\2\2\u0140\u0130\3\2"+
		"\2\2\u0140\u0131\3\2\2\2\u0140\u0132\3\2\2\2\u0140\u0133\3\2\2\2\u0140"+
		"\u0135\3\2\2\2\u0140\u0139\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0168\5\24"+
		"\13\16\u0143\u0144\f\b\2\2\u0144\u0145\7!\2\2\u0145\u0168\5\24\13\t\u0146"+
		"\u0147\f\7\2\2\u0147\u0148\7a\2\2\u0148\u0168\5\24\13\b\u0149\u014a\f"+
		"\f\2\2\u014a\u014c\7P\2\2\u014b\u014d\7[\2\2\u014c\u014b\3\2\2\2\u014c"+
		"\u014d\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u0168\7\\\2\2\u014f\u0151\f\t"+
		"\2\2\u0150\u0152\7[\2\2\u0151\u0150\3\2\2\2\u0151\u0152\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153\u0165\7K\2\2\u0154\u0155\7\6\2\2\u0155\u015a\5\24"+
		"\13\2\u0156\u0157\7\5\2\2\u0157\u0159\5\24\13\2\u0158\u0156\3\2\2\2\u0159"+
		"\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015d\3\2"+
		"\2\2\u015c\u015a\3\2\2\2\u015d\u015e\7\7\2\2\u015e\u0166\3\2\2\2\u015f"+
		"\u0166\5\2\2\2\u0160\u0161\7\177\2\2\u0161\u0162\7\6\2\2\u0162\u0163\5"+
		"\22\n\2\u0163\u0164\7\7\2\2\u0164\u0166\3\2\2\2\u0165\u0154\3\2\2\2\u0165"+
		"\u015f\3\2\2\2\u0165\u0160\3\2\2\2\u0166\u0168\3\2\2\2\u0167\u011a\3\2"+
		"\2\2\u0167\u011d\3\2\2\2\u0167\u0120\3\2\2\2\u0167\u0123\3\2\2\2\u0167"+
		"\u0126\3\2\2\2\u0167\u0129\3\2\2\2\u0167\u012c\3\2\2\2\u0167\u0143\3\2"+
		"\2\2\u0167\u0146\3\2\2\2\u0167\u0149\3\2\2\2\u0167\u014f\3\2\2\2\u0168"+
		"\u016b\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\25\3\2\2"+
		"\2\u016b\u0169\3\2\2\2\u016c\u016d\7\31\2\2\u016d\u016e\5\26\f\2\u016e"+
		"\u016f\7\31\2\2\u016f\u0181\3\2\2\2\u0170\u0171\58\35\2\u0171\u0172\7"+
		"\3\2\2\u0172\u0174\3\2\2\2\u0173\u0170\3\2\2\2\u0173\u0174\3\2\2\2\u0174"+
		"\u0175\3\2\2\2\u0175\u0176\5.\30\2\u0176\u0177\7\3\2\2\u0177\u0179\3\2"+
		"\2\2\u0178\u0173\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\3\2\2\2\u017a"+
		"\u017b\5<\37\2\u017b\u017c\7\3\2\2\u017c\u017e\3\2\2\2\u017d\u0178\3\2"+
		"\2\2\u017d\u017e\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0181\5*\26\2\u0180"+
		"\u016c\3\2\2\2\u0180\u017d\3\2\2\2\u0181\27\3\2\2\2\u0182\u0191\7L\2\2"+
		"\u0183\u0191\7/\2\2\u0184\u0186\7C\2\2\u0185\u0187\7d\2\2\u0186\u0185"+
		"\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0191\3\2\2\2\u0188\u018a\7S\2\2\u0189"+
		"\u018b\7d\2\2\u018a\u0189\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u0191\3\2"+
		"\2\2\u018c\u018e\7m\2\2\u018d\u018f\7d\2\2\u018e\u018d\3\2\2\2\u018e\u018f"+
		"\3\2\2\2\u018f\u0191\3\2\2\2\u0190\u0182\3\2\2\2\u0190\u0183\3\2\2\2\u0190"+
		"\u0184\3\2\2\2\u0190\u0188\3\2\2\2\u0190\u018c\3\2\2\2\u0191\31\3\2\2"+
		"\2\u0192\u0193\7:\2\2\u0193\u0194\7\6\2\2\u0194\u0199\5*\26\2\u0195\u0196"+
		"\7\5\2\2\u0196\u0198\5*\26\2\u0197\u0195\3\2\2\2\u0198\u019b\3\2\2\2\u0199"+
		"\u0197\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019c\3\2\2\2\u019b\u0199\3\2"+
		"\2\2\u019c\u019d\7\7\2\2\u019d\33\3\2\2\2\u019e\u019f\7`\2\2\u019f\u01a0"+
		"\5\36\20\2\u01a0\35\3\2\2\2\u01a1\u01a2\5\24\13\2\u01a2\37\3\2\2\2\u01a3"+
		"\u01a4\5@!\2\u01a4!\3\2\2\2\u01a5\u01b7\7\u008e\2\2\u01a6\u01a7\7\37\2"+
		"\2\u01a7\u01a8\5\"\22\2\u01a8\u01a9\7\37\2\2\u01a9\u01b7\3\2\2\2\u01aa"+
		"\u01ab\7\6\2\2\u01ab\u01ac\5\"\22\2\u01ac\u01ad\7\7\2\2\u01ad\u01b7\3"+
		"\2\2\2\u01ae\u01af\7\31\2\2\u01af\u01b0\5\"\22\2\u01b0\u01b1\7\31\2\2"+
		"\u01b1\u01b7\3\2\2\2\u01b2\u01b3\7\36\2\2\u01b3\u01b4\5\"\22\2\u01b4\u01b5"+
		"\7\36\2\2\u01b5\u01b7\3\2\2\2\u01b6\u01a5\3\2\2\2\u01b6\u01a6\3\2\2\2"+
		"\u01b6\u01aa\3\2\2\2\u01b6\u01ae\3\2\2\2\u01b6\u01b2\3\2\2\2\u01b7#\3"+
		"\2\2\2\u01b8\u01b9\t\7\2\2\u01b9%\3\2\2\2\u01ba\u01bb\5\"\22\2\u01bb\'"+
		"\3\2\2\2\u01bc\u01bd\5\"\22\2\u01bd)\3\2\2\2\u01be\u01bf\5\"\22\2\u01bf"+
		"+\3\2\2\2\u01c0\u01c1\5\"\22\2\u01c1-\3\2\2\2\u01c2\u01c3\5\"\22\2\u01c3"+
		"/\3\2\2\2\u01c4\u01c5\5\"\22\2\u01c5\61\3\2\2\2\u01c6\u01c7\5\"\22\2\u01c7"+
		"\63\3\2\2\2\u01c8\u01c9\5\"\22\2\u01c9\65\3\2\2\2\u01ca\u01cb\5\"\22\2"+
		"\u01cb\67\3\2\2\2\u01cc\u01cd\5\"\22\2\u01cd9\3\2\2\2\u01ce\u01cf\5\""+
		"\22\2\u01cf;\3\2\2\2\u01d0\u01d1\5\"\22\2\u01d1=\3\2\2\2\u01d2\u01d3\5"+
		"8\35\2\u01d3\u01d4\7\3\2\2\u01d4\u01d6\3\2\2\2\u01d5\u01d2\3\2\2\2\u01d5"+
		"\u01d6\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01d8\5.\30\2\u01d8\u01d9\7\3"+
		"\2\2\u01d9\u01db\3\2\2\2\u01da\u01d5\3\2\2\2\u01da\u01db\3\2\2\2\u01db"+
		"\u01dc\3\2\2\2\u01dc\u01e2\5<\37\2\u01dd\u01de\7\31\2\2\u01de\u01df\5"+
		"> \2\u01df\u01e0\7\31\2\2\u01e0\u01e2\3\2\2\2\u01e1\u01da\3\2\2\2\u01e1"+
		"\u01dd\3\2\2\2\u01e2?\3\2\2\2\u01e3\u01e6\5B\"\2\u01e4\u01e6\5D#\2\u01e5"+
		"\u01e3\3\2\2\2\u01e5\u01e4\3\2\2\2\u01e6A\3\2\2\2\u01e7\u01e8\7\33\2\2"+
		"\u01e8C\3\2\2\2\u01e9\u01ea\7\34\2\2\u01eaE\3\2\2\2\u01eb\u01f2\5H%\2"+
		"\u01ec\u01f2\5J&\2\u01ed\u01f2\5L\'\2\u01ee\u01f2\5N(\2\u01ef\u01f2\5"+
		"P)\2\u01f0\u01f2\5R*\2\u01f1\u01eb\3\2\2\2\u01f1\u01ec\3\2\2\2\u01f1\u01ed"+
		"\3\2\2\2\u01f1\u01ee\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f1\u01f0\3\2\2\2\u01f2"+
		"G\3\2\2\2\u01f3\u01f4\7\u0089\2\2\u01f4I\3\2\2\2\u01f5\u01f6\7\u008a\2"+
		"\2\u01f6K\3\2\2\2\u01f7\u01f8\7\u008b\2\2\u01f8M\3\2\2\2\u01f9\u01fa\7"+
		"\u008c\2\2\u01faO\3\2\2\2\u01fb\u01fc\7\u008d\2\2\u01fcQ\3\2\2\2\u01fd"+
		"\u01fe\5\60\31\2\u01fe\u01ff\7\u0089\2\2\u01ffS\3\2\2\2\u0200\u0201\t"+
		"\b\2\2\u0201U\3\2\2\2>Z^adhloquy}\u0080\u0082\u0086\u008a\u008d\u0095"+
		"\u009b\u009e\u00a6\u00ac\u00af\u00b6\u00b9\u00be\u00c1\u00c3\u00c7\u00cd"+
		"\u00d1\u00e1\u00fb\u0100\u010a\u010e\u0118\u0135\u0139\u0140\u014c\u0151"+
		"\u015a\u0165\u0167\u0169\u0173\u0178\u017d\u0180\u0186\u018a\u018e\u0190"+
		"\u0199\u01b6\u01d5\u01da\u01e1\u01e5\u01f1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}