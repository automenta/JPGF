package grammaticalframework;


import grammaticalframework.absyn.AbsynTree;
import grammaticalframework.parser.Parser;
import org.junit.Test;

import java.util.List;

import static grammaticalframework.PGFTestCase.getPGF;
import static junit.framework.TestCase.assertEquals;

public class GeneratorTest  {

    int numTests = 16;

    @Test
    public void testGenerator() throws Exception {
        PGF pgf = getPGF("corpus/Phrasebook.pgf");
        String lang = "PhrasebookEng";
        Parser p = new Parser(pgf, lang);

        Linearizer linearizer = new Linearizer(pgf, lang);

        Generator g = new Generator(pgf);

        //for (int i = 0; i < numTests; i++){
            randomGeneration(p, linearizer, g);
        //}

    }

    private void randomGeneration(Parser p, Linearizer linearizer, Generator g) throws Exception {
        AbsynTree randomTree = g.gen();
        //System.out.println( PrettyPrinter.print(randomTree) );
        System.out.println(randomTree);

        final String lin = linearizer.linearizeString(randomTree);
        System.out.println(lin);

        List<AbsynTree> parsed = p.parseToTrees(lin);
        System.out.println(parsed);

        assertEquals(1, parsed.size());
        assertEquals(randomTree, parsed.get(0));
    }


    /*
      public static void main(String[] args)
      { try {
      Generator gg = new Generator("Phrasebook.pgf");
      Vector<Expr> rez = gg.generateMany("Greeting",9);
      if(rez != null)
      { System.out.println("Rezultatul este "+rez.toString());
      System.out.println("Dimensiunea este "+rez.size());}
      else System.out.println("Rezultatul este nul");
      }
      catch(Exception e) {System.out.println("No such file"+e.toString());}
      }
    */

}
