package bio.terra.service.grammar;

import bio.terra.service.grammar.BQLLexer;
import bio.terra.service.grammar.BQLParser;
import bio.terra.service.grammar.BQLBaseListener;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GrammarService {
    public boolean validateBQLString(String bql) throws IOException {
        CharStream inputStream = CharStreams.fromString(bql);
        BQLLexer lexer = new BQLLexer(inputStream);
        BQLParser parser = new BQLParser(new CommonTokenStream(lexer));
        int index = parser.getRuleIndex("query_statement");
//        parser.query_statement().enterRule(new BQLBaseListener());
//        parser.
        ParseTreePattern pattern = parser.compileParseTreePattern(bql, index);
        return pattern.matches(pattern.getPatternTree());
    }

    public String getDatasetName(String bql) {
        CharStream inputStream = CharStreams.fromString(bql);
        BQLLexer lexer = new BQLLexer(inputStream);
        BQLParser parser = new BQLParser(new CommonTokenStream(lexer));
        parser.dataset_name().getText();
        BQLDatasetVisitor bqlDatasetVisitor = new BQLDatasetVisitor();
        bqlDatasetVisitor.visit(parser.compileParseTreePattern(bql, parser.query_statement().getRuleIndex()).getPatternTree());

        return parser.dataset_name().name().toString();
    }
}
