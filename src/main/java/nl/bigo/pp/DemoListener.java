/*
 * The MIT License (MIT)
 *
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

import org.antlr.v4.runtime.misc.NotNull;

/**
 * A small demo listener that retrieves the player's name and
 * the result from the game termination production rule. Of course
 * the result could more easily be retrieved from the result-tag,
 * [Result "..."], but this is just a quick example of how to
 * retrieve information from the parser context objects.
 */
public class DemoListener extends PGNBaseListener {

  private String white = null;
  private String black = null;

  // Grammar production rule:
  //
  //   tag_pair
  //    : LEFT_BRACKET tag_name tag_value RIGHT_BRACKET
  //    ;
  @Override
  public void enterTag_pair(@NotNull PGNParser.Tag_pairContext ctx) {

    String tagName = ctx.tag_name().getText();

    if(tagName.equals("White")) {
      white = ctx.tag_value().getText().replace("\"", "");
    }
    else if(tagName.equals("Black")) {
      black = ctx.tag_value().getText().replace("\"", "");
    }
  }

  // Grammar production rule:
  //
  //   movetext_section
  //    : element_sequence game_termination
  //    ;
  @Override
  public void enterMovetext_section(@NotNull PGNParser.Movetext_sectionContext ctx) {

    String result = ctx.game_termination().getText();

    System.out.printf("`%s` with white against `%s` with black resulted in: %s\n",
        white, black, result);
  }
}
