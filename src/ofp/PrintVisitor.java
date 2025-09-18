package ofp;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import generated.OFPBaseVisitor;
import generated.OFPParser;


public class PrintVisitor extends OFPBaseVisitor<Object> {
    
    @Override
    public Object visitExpr(OFPParser.ExprContext ctx) {
        return visitAllChildren(ctx);
    }
    public ParseTree visitAllChildren(ParseTree node) {
        System.out.println(node.getClass().getName()+":"+node.getChildCount());
        for (int i=0; i<node.getChildCount();i++) {
            ParseTree child = node.getChild(i);
            if (child instanceof TerminalNode)
                visitTerminalNode( (TerminalNode) child);
            else
                visit(child); // Visit a non-terminal child
        } // Will call corresponding visitX method
        
        return node;
    }

    public void visitTerminalNode(TerminalNode node) {
        System.out.println("\t"+node.getClass().getName()+": "+node.getText());
    }
}
