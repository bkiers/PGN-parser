/*
 * Copyright (c) 2013 by Bart Kiers
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * Project      : A Portable Game Notation (PGN) ANTLR 4 grammar
 *                and parser.
 * Developed by : Bart Kiers, bart@big-o.nl
 */
package nl.bigo.pp;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * A small demo class that demonstrates how to use the
 * generated parser classes.
 */
public class Main {

  public static void main(String[] args) throws Exception {

    if(args.length == 0) {
      // When no parameter is provided, pick Karpov's PGN database file.
      args = new String[]{"src/resources/Karpov.pgn"};
    }

    String fileName = args[0];
    System.out.printf("Parsing `%s`...", fileName);

    // Create the lexer and parser.
    PGNLexer lexer = new PGNLexer(new ANTLRFileStream(fileName));
    PGNParser parser = new PGNParser(new CommonTokenStream(lexer));

    // Use the demo listener which will print some info about the PGN file.
    ParseTreeWalker walker = new ParseTreeWalker();
    ParseTree tree = parser.parse();
    walker.walk(new DemoListener(), tree);

    System.out.println("\nDone!");
  }
}
