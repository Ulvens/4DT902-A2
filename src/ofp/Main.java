
/**
 * Main.java
 * 10 sep. 2023
 * jlnmsi
 * 
 * Starting point for the ofp compiler
 */
package ofp;

import java.io.IOException;

import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.gui.Trees;

import generated.OFPLexer;
import generated.OFPParser;

public class Main  {

    public static void main(String[] args)  {
			
        // Select test program
        String testDir = "/home/ulv/Documents/y4/4DT902/4DT902-A2/src/inputs/";
        String testProgram = testDir + "max.ofp";
        
        // Check if input ends with ".ofp"
        if ( !testProgram.endsWith(".ofp") ) {
            System.out.println("\nPrograms most end with suffix .ofp! Found "+testProgram);
            System.exit(-1);
        }
        System.out.println("Reading test program from: "+testProgram);
        
        // Parse input program
        System.out.println("\nParsing started");
        OFPParser parser = null;
        OFPParser.ProgramContext root = null;
        try {
            CharStream inputStream = CharStreams.fromFileName(testProgram);
            OFPLexer lexer = new OFPLexer( inputStream );		
            parser = new OFPParser(new BufferedTokenStream(lexer));	
            root = parser.program();
        } catch (IOException e) {				
            e.printStackTrace();
        } 
        System.out.println("\nParsing completed");

        // Display tree
        Trees.inspect(root, parser);

        ParseTreeWalker walker = new ParseTreeWalker();

        PrintListener printListener = new PrintListener(); // PrintListener implements

        walker.walk(printListener, root); // BaseListener
        System.out.println("\nParse tree printed using a listener");
        //Symbol table construction using a listener ... (This lecture)
        //Symbol reference checking using a listener ... (Next lecture)
        //Type checking using a visitor ... 

    }
}

