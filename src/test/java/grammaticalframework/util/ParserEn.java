package grammaticalframework.util;

import grammaticalframework.Linearizer;
import grammaticalframework.PGF;
import grammaticalframework.Trees.absyn.AbsynTree;
import grammaticalframework.UnknownLanguageException;
import grammaticalframework.parser.Parser;
import org.grammaticalframework.pgf.ParseError;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static grammaticalframework.PGFBuilder.fromFile;

/**
 * Created by me on 7/10/15.
 */
public class ParserEn {
    public static void main(String[] args) throws UnknownLanguageException, Linearizer.LinearizerException, IOException, ParseError, org.grammaticalframework.pgf.ParseError {
        //PGF pgf = getPGF("Phrasebook.pgf");
        PGF pgf = fromFile("/tmp/SUMO.pgf");


        String language = "PhrasebookEng"; //"DisambPhrasebookEng";

        System.out.println(pgf.getAbstract());

        for (Object c : pgf.getConcrete(language).getCncCat()) {
            System.out.println(c);
        }

        Linearizer linearizer = new Linearizer(pgf, language);

        while (true) {
            System.out.print("IN: ");
            String s = new Scanner(System.in).nextLine();

            //System.out.println( PrettyPrinter.print(randomTree) );


            //System.out.println("Parsing: " + s);

            Parser p = new Parser(pgf, language);

            List<AbsynTree> parsed = p.parseToTrees(s);

            System.out.println(" Parse: \t" + parsed);

            for (AbsynTree t : parsed) {
                final String lin = linearizer.linearizeString(t);
                System.out.println("Linear: \t" + lin);
            }

        }

    }
}
