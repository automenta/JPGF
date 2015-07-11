package grammaticalframework;


import grammaticalframework.Trees.absyn.Tree;
import org.junit.Test;

import java.util.List;

import static grammaticalframework.PGFTestCase.getPGF;

public class GeneratorTest  {


    @Test
    public void testGenerator() throws Exception {
        PGF pgf = getPGF("Phrasebook.pgf");
        Linearizer linearizer = new Linearizer(pgf, "PhrasebookEng");

        Generator g = new Generator(pgf);
        Tree randomTree = g.gen();

        //System.out.println( PrettyPrinter.print(randomTree) );

        System.out.println(randomTree);

        final String lin = linearizer.linearizeString(randomTree);
        System.out.println(lin);

        Parser p = new Parser(pgf, "PhrasebookEng");

        List<Tree> parsed = p.parseToTrees(lin);
        System.out.println(parsed);
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
