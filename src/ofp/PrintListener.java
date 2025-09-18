package ofp;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import generated.OFPBaseListener;
import generated.OFPParser;


public class PrintListener extends OFPBaseListener {

    @Override 
    public void enterProgram(OFPParser.ProgramContext ctx) { }

    @Override 
    public void exitProgram(OFPParser.ProgramContext ctx) { }

    @Override public void enterMain(OFPParser.MainContext ctx) { }

	@Override public void exitMain(OFPParser.MainContext ctx) { }

	@Override public void enterFuncDecl(OFPParser.FuncDeclContext ctx) { }

	@Override public void exitFuncDecl(OFPParser.FuncDeclContext ctx) { }

	@Override public void enterBlock(OFPParser.BlockContext ctx) { }

	@Override public void exitBlock(OFPParser.BlockContext ctx) { }

	@Override public void enterParamList(OFPParser.ParamListContext ctx) { }

	@Override public void exitParamList(OFPParser.ParamListContext ctx) { }

	@Override public void enterStmt(OFPParser.StmtContext ctx) { }

	@Override public void exitStmt(OFPParser.StmtContext ctx) { }

	@Override public void enterExpr(OFPParser.ExprContext ctx) { }

	@Override public void exitExpr(OFPParser.ExprContext ctx) { }

	@Override public void enterAccess(OFPParser.AccessContext ctx) { }

	@Override public void exitAccess(OFPParser.AccessContext ctx) { }

	@Override public void enterAssignment(OFPParser.AssignmentContext ctx) { }

	@Override public void exitAssignment(OFPParser.AssignmentContext ctx) { }

	@Override public void enterDeclaration(OFPParser.DeclarationContext ctx) { }

	@Override public void exitDeclaration(OFPParser.DeclarationContext ctx) { }

	@Override public void enterFuncCall(OFPParser.FuncCallContext ctx) { }

	@Override public void exitFuncCall(OFPParser.FuncCallContext ctx) { }

	@Override public void enterArgList(OFPParser.ArgListContext ctx) { }

	@Override public void exitArgList(OFPParser.ArgListContext ctx) { }

    @Override public void enterEveryRule(ParserRuleContext ctx) {
        System.out.println("enter: "+ctx.getClass().getName()+" text: "+ctx.getText());
       
    }

	@Override public void exitEveryRule(ParserRuleContext ctx) { }

	@Override public void visitTerminal(TerminalNode node) { }

	@Override public void visitErrorNode(ErrorNode node) { }


}
