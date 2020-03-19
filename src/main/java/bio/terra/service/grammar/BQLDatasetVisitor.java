package bio.terra.service.grammar;

import bio.terra.service.grammar.BQLBaseListener;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class BQLDatasetVisitor implements ParseTreeVisitor<String> {
    @Override
    public String visit(ParseTree tree) {
        for (int i = 0; i < tree.getChildCount(); i++) {
            ParseTree child = tree.getChild(i);
            child.accept(this);
        }
        return tree.getPayload().toString();
    }

    @Override
    public String visitChildren(RuleNode node) {
        return null;
    }

    @Override
    public String visitTerminal(TerminalNode node) {
        return null;
    }

    @Override
    public String visitErrorNode(ErrorNode node) {
        return null;
    }
}
