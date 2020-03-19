// Generated from BQL.g4 by ANTLR 4.8

    package bio.terra.service.grammar;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BQLParser}.
 */
public interface BQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BQLParser#query_statement}.
	 * @param ctx the parse tree
	 */
	void enterQuery_statement(BQLParser.Query_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#query_statement}.
	 * @param ctx the parse tree
	 */
	void exitQuery_statement(BQLParser.Query_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#query_expr}.
	 * @param ctx the parse tree
	 */
	void enterQuery_expr(BQLParser.Query_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#query_expr}.
	 * @param ctx the parse tree
	 */
	void exitQuery_expr(BQLParser.Query_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#select_statement}.
	 * @param ctx the parse tree
	 */
	void enterSelect_statement(BQLParser.Select_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#select_statement}.
	 * @param ctx the parse tree
	 */
	void exitSelect_statement(BQLParser.Select_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#from_statement}.
	 * @param ctx the parse tree
	 */
	void enterFrom_statement(BQLParser.From_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#from_statement}.
	 * @param ctx the parse tree
	 */
	void exitFrom_statement(BQLParser.From_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#from_item}.
	 * @param ctx the parse tree
	 */
	void enterFrom_item(BQLParser.From_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#from_item}.
	 * @param ctx the parse tree
	 */
	void exitFrom_item(BQLParser.From_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#where_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhere_statement(BQLParser.Where_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#where_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhere_statement(BQLParser.Where_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#limit_clause}.
	 * @param ctx the parse tree
	 */
	void enterLimit_clause(BQLParser.Limit_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#limit_clause}.
	 * @param ctx the parse tree
	 */
	void exitLimit_clause(BQLParser.Limit_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#using_clause}.
	 * @param ctx the parse tree
	 */
	void enterUsing_clause(BQLParser.Using_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#using_clause}.
	 * @param ctx the parse tree
	 */
	void exitUsing_clause(BQLParser.Using_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#array_expr}.
	 * @param ctx the parse tree
	 */
	void enterArray_expr(BQLParser.Array_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#array_expr}.
	 * @param ctx the parse tree
	 */
	void exitArray_expr(BQLParser.Array_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(BQLParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(BQLParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#column_expr}.
	 * @param ctx the parse tree
	 */
	void enterColumn_expr(BQLParser.Column_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#column_expr}.
	 * @param ctx the parse tree
	 */
	void exitColumn_expr(BQLParser.Column_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#join_type}.
	 * @param ctx the parse tree
	 */
	void enterJoin_type(BQLParser.Join_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#join_type}.
	 * @param ctx the parse tree
	 */
	void exitJoin_type(BQLParser.Join_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#except_statement}.
	 * @param ctx the parse tree
	 */
	void enterExcept_statement(BQLParser.Except_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#except_statement}.
	 * @param ctx the parse tree
	 */
	void exitExcept_statement(BQLParser.Except_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#on_clause}.
	 * @param ctx the parse tree
	 */
	void enterOn_clause(BQLParser.On_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#on_clause}.
	 * @param ctx the parse tree
	 */
	void exitOn_clause(BQLParser.On_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#bool_expression}.
	 * @param ctx the parse tree
	 */
	void enterBool_expression(BQLParser.Bool_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#bool_expression}.
	 * @param ctx the parse tree
	 */
	void exitBool_expression(BQLParser.Bool_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#count}.
	 * @param ctx the parse tree
	 */
	void enterCount(BQLParser.CountContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#count}.
	 * @param ctx the parse tree
	 */
	void exitCount(BQLParser.CountContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(BQLParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(BQLParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator(BQLParser.Unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator(BQLParser.Unary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#alias_name}.
	 * @param ctx the parse tree
	 */
	void enterAlias_name(BQLParser.Alias_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#alias_name}.
	 * @param ctx the parse tree
	 */
	void exitAlias_name(BQLParser.Alias_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#array_name}.
	 * @param ctx the parse tree
	 */
	void enterArray_name(BQLParser.Array_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#array_name}.
	 * @param ctx the parse tree
	 */
	void exitArray_name(BQLParser.Array_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#column_name}.
	 * @param ctx the parse tree
	 */
	void enterColumn_name(BQLParser.Column_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#column_name}.
	 * @param ctx the parse tree
	 */
	void exitColumn_name(BQLParser.Column_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#cte_name}.
	 * @param ctx the parse tree
	 */
	void enterCte_name(BQLParser.Cte_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#cte_name}.
	 * @param ctx the parse tree
	 */
	void exitCte_name(BQLParser.Cte_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#dataset_name}.
	 * @param ctx the parse tree
	 */
	void enterDataset_name(BQLParser.Dataset_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#dataset_name}.
	 * @param ctx the parse tree
	 */
	void exitDataset_name(BQLParser.Dataset_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#datatype_name}.
	 * @param ctx the parse tree
	 */
	void enterDatatype_name(BQLParser.Datatype_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#datatype_name}.
	 * @param ctx the parse tree
	 */
	void exitDatatype_name(BQLParser.Datatype_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#function_name}.
	 * @param ctx the parse tree
	 */
	void enterFunction_name(BQLParser.Function_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#function_name}.
	 * @param ctx the parse tree
	 */
	void exitFunction_name(BQLParser.Function_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#join_name}.
	 * @param ctx the parse tree
	 */
	void enterJoin_name(BQLParser.Join_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#join_name}.
	 * @param ctx the parse tree
	 */
	void exitJoin_name(BQLParser.Join_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#member_name}.
	 * @param ctx the parse tree
	 */
	void enterMember_name(BQLParser.Member_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#member_name}.
	 * @param ctx the parse tree
	 */
	void exitMember_name(BQLParser.Member_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#project_name}.
	 * @param ctx the parse tree
	 */
	void enterProject_name(BQLParser.Project_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#project_name}.
	 * @param ctx the parse tree
	 */
	void exitProject_name(BQLParser.Project_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#struct_name}.
	 * @param ctx the parse tree
	 */
	void enterStruct_name(BQLParser.Struct_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#struct_name}.
	 * @param ctx the parse tree
	 */
	void exitStruct_name(BQLParser.Struct_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#table_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_name(BQLParser.Table_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#table_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_name(BQLParser.Table_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#table_expr}.
	 * @param ctx the parse tree
	 */
	void enterTable_expr(BQLParser.Table_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#table_expr}.
	 * @param ctx the parse tree
	 */
	void exitTable_expr(BQLParser.Table_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(BQLParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(BQLParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#integer_type}.
	 * @param ctx the parse tree
	 */
	void enterInteger_type(BQLParser.Integer_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#integer_type}.
	 * @param ctx the parse tree
	 */
	void exitInteger_type(BQLParser.Integer_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#float_type}.
	 * @param ctx the parse tree
	 */
	void enterFloat_type(BQLParser.Float_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#float_type}.
	 * @param ctx the parse tree
	 */
	void exitFloat_type(BQLParser.Float_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(BQLParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(BQLParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#quoted_string}.
	 * @param ctx the parse tree
	 */
	void enterQuoted_string(BQLParser.Quoted_stringContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#quoted_string}.
	 * @param ctx the parse tree
	 */
	void exitQuoted_string(BQLParser.Quoted_stringContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#triple_quoted_string}.
	 * @param ctx the parse tree
	 */
	void enterTriple_quoted_string(BQLParser.Triple_quoted_stringContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#triple_quoted_string}.
	 * @param ctx the parse tree
	 */
	void exitTriple_quoted_string(BQLParser.Triple_quoted_stringContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#raw_string}.
	 * @param ctx the parse tree
	 */
	void enterRaw_string(BQLParser.Raw_stringContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#raw_string}.
	 * @param ctx the parse tree
	 */
	void exitRaw_string(BQLParser.Raw_stringContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#byte_string}.
	 * @param ctx the parse tree
	 */
	void enterByte_string(BQLParser.Byte_stringContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#byte_string}.
	 * @param ctx the parse tree
	 */
	void exitByte_string(BQLParser.Byte_stringContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#raw_byte_string}.
	 * @param ctx the parse tree
	 */
	void enterRaw_byte_string(BQLParser.Raw_byte_stringContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#raw_byte_string}.
	 * @param ctx the parse tree
	 */
	void exitRaw_byte_string(BQLParser.Raw_byte_stringContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#special_string}.
	 * @param ctx the parse tree
	 */
	void enterSpecial_string(BQLParser.Special_stringContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#special_string}.
	 * @param ctx the parse tree
	 */
	void exitSpecial_string(BQLParser.Special_stringContext ctx);
	/**
	 * Enter a parse tree produced by {@link BQLParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(BQLParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link BQLParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(BQLParser.KeywordContext ctx);
}