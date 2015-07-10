package grammaticalframework;


import grammaticalframework.Trees.absyn.Tree;
import org.junit.Test;

public class GeneratorTest extends PGFTestCase {


    @Test
    public void testGenerator() throws Exception {
        PGF pgf = getPGF("Phrasebook.pgf");
        Linearizer linearizer = new Linearizer(pgf, "PhrasebookEng");

        Generator g = new Generator(pgf);
        Tree randomTree = g.gen();

        //System.out.println( PrettyPrinter.print(randomTree) );


        System.out.println(randomTree);
        System.out.println(linearizer.linearizeString(randomTree));
    }

    public GeneratorTest(String name) {  super(name);     }

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
