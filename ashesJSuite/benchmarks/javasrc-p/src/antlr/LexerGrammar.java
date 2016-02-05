package antlr;

/**
 * <b>SOFTWARE RIGHTS</b>
 * <p>
 * ANTLR 2.5.0 MageLang Institute, 1998
 * <p>
 * We reserve no legal rights to the ANTLR--it is fully in the
 * public domain. An individual or company may do whatever
 * they wish with source code distributed with ANTLR or the
 * code generated by ANTLR, including the incorporation of
 * ANTLR, or its output, into commerical software.
 * <p>
 * We encourage users to develop software with ANTLR. However,
 * we do ask that credit is given to us for developing
 * ANTLR. By "credit", we mean that if you use ANTLR or
 * incorporate any source code into one of your programs
 * (commercial product, research project, or otherwise) that
 * you acknowledge this fact somewhere in the documentation,
 * research report, etc... If you like ANTLR and have
 * developed a nice tool with the output, please mention that
 * you developed it using ANTLR. In addition, we ask that the
 * headers remain intact in our source code. As long as these
 * guidelines are kept, we expect to continue enhancing this
 * system and expect to make other tools available as they are
 * completed.
 * <p>
 * The ANTLR gang:
 * @version ANTLR 2.5.0 MageLang Institute, 1998
 * @author Terence Parr, <a href=http://www.MageLang.com>MageLang Institute</a>
 * @author <br>John Lilley, <a href=http://www.Empathy.com>Empathy Software</a>
 */
import java.util.Hashtable;
import java.util.Enumeration;
import java.io.IOException;
import antlr.collections.impl.BitSet;
import antlr.collections.impl.Vector;

/** Lexer-specific grammar subclass */
class LexerGrammar extends Grammar {
	// character set used by lexer
	protected BitSet charVocabulary;
	// true if the lexer generates literal testing code for nextToken
	protected boolean testLiterals = true;
	// true if the lexer generates case-sensitive LA(k) testing
	protected boolean caseSensitiveLiterals = true;
	/** true if the lexer generates case-sensitive literals testing */
	protected boolean caseSensitive = true;
	/** true if lexer is to ignore all unrecognized tokens */
	protected boolean filterMode = false;

	/** if filterMode is true, then filterRule can indicate an optional
	 *  rule to use as the scarf language.  If null, programmer used
	 *  plain "filter=true" not "filter=rule".
	 */
	protected String filterRule = null;

	LexerGrammar(String className_, Tool tool_, String superClass) {
		super(className_, tool_, superClass);
		charVocabulary = new BitSet();

		// Lexer usually has no default error handling
		defaultErrorHandler = false;
	}
	/** Top-level call to generate the code	 */
	public void generate() throws IOException {
		generator.gen(this);
	}
	public String getSuperClass() {
		// If debugging, use debugger version of scanner
		if (debuggingOutput)
			return "debug.DebuggingCharScanner";
		return "CharScanner";
	}
	// Get the testLiterals option value
	public boolean getTestLiterals() {
		return testLiterals;
	}
	/**Process command line arguments.
	 * -trace			have all rules call traceIn/traceOut
	 * -traceLexer		have lexical rules call traceIn/traceOut
	 * -debug			generate debugging output for parser debugger
	 */
	public void processArguments(String[] args) {
		for (int i=0; i<args.length; i++) {
			if ( args[i].equals("-trace") ) {
				traceRules = true;
				Tool.setArgOK(i);
			}
			else if ( args[i].equals("-traceLexer") ) {
				traceRules = true;
				Tool.setArgOK(i);
			}
			else if ( args[i].equals("-debug") ) {
				debuggingOutput = true;
				Tool.setArgOK(i);
			}
		}
	}
	/** Set the character vocabulary used by the lexer */
	public void setCharVocabulary(BitSet b) {
		charVocabulary = b;
	}
	/** Set lexer options */
	public boolean setOption(String key, Token value) {
		String s = value.getText();
		if (key.equals("buildAST")) {
			tool.warning("buildAST option is not valid for lexer", value.getLine());
			return true;
		}
		if (key.equals("testLiterals")) {
			if (s.equals("true")) {
				testLiterals = true;
			} else if (s.equals("false")) {
				testLiterals = false;
			} else {
				tool.warning("testLiterals option must be true or false", value.getLine());
			}
			return true;
		}
		if (key.equals("literal")) {
			if (tokenManager == null) {
				tool.error("Specify a tokenVocabulary before defining literals", value.getLine());
				return false;
			}
			if ( tokenManager.getTokenSymbol(s) != null ) {
				// string symbol is already defined
				return true;
			}
			StringLiteralSymbol sl = new StringLiteralSymbol(value.getText());
			int tt = tokenManager.nextTokenType();
			if (tt != 0) {
				sl.setTokenType(tt);
				tokenManager.define(sl);
			} else {
				tool.error("You cannot define new string literals when using tokdef", value.getLine());
				return false;
			}
			return true;
		}
		if (key.equals("interactive")) {
			if (s.equals("true")) {
				interactive = true;
			} else if (s.equals("false")) {
				interactive = false;
			} else {
				tool.error("interactive option must be true or false", value.getLine());
			}
			return true;
		}
		if (key.equals("caseSensitive")) {
			if (s.equals("true")) {
				caseSensitive = true;
			} else if (s.equals("false")) {
				caseSensitive = false;
			} else {
				tool.warning("caseSensitive option must be true or false", value.getLine());
			}
			return true;
		}
		if (key.equals("caseSensitiveLiterals")) {
			if (s.equals("true")) {
				caseSensitiveLiterals= true;
			} else if (s.equals("false")) {
				caseSensitiveLiterals= false;
			} else {
				tool.warning("caseSensitiveLiterals option must be true or false", value.getLine());
			}
			return true;
		}
		if (key.equals("filter")) {
			if (s.equals("true")) {
				filterMode = true;
			} else if (s.equals("false")) {
				filterMode = false;
			} else if ( value.getType()==ANTLRTokenTypes.TOKEN_REF) {
				filterMode = true;
				filterRule = s;
			}
			else {
				tool.warning("filter option must be true, false, or a lexer rule name", value.getLine());
			}
			return true;
		}
		if (key.equals("longestPossible")) {
			tool.warning("longestPossible option has been deprecated; ignoring it...", value.getLine());
			return true;
		}
		if (super.setOption(key, value)) {
			return true;
		}
		tool.error("Invalid option: " + key, value.getLine());
		return false;
	}
}