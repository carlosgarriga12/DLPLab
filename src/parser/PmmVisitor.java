// Generated from java-escape by ANTLR 4.11.1
package parser;

    import ast.definition.*;
    import ast.expression.*;
    import ast.statement.*;
    import ast.type.*;
    import parser.LexerHelper;
    import ast.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PmmParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PmmVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PmmParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#main_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain_function(PmmParser.Main_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(PmmParser.DefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#varDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefinition(PmmParser.VarDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(PmmParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(PmmParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(PmmParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#built_in_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuilt_in_type(PmmParser.Built_in_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(PmmParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#recordField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordField(PmmParser.RecordFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PmmParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PmmParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(PmmParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#expressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressions(PmmParser.ExpressionsContext ctx);
}