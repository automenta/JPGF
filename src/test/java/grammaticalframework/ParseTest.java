package grammaticalframework;

import com.google.common.io.Files;
import grammaticalframework.absyn.AbsynTree;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.nio.charset.Charset;

import static grammaticalframework.PGFTestCase.parseTree;

/**
 * Does not parse .GF yet
 */
@Ignore
public class ParseTest {

    @Ignore
    @Test
    public void parseGF_File() throws Exception {
        String filename = "math.gf";

        File f = new File(
                PGFTestCase.class.getResource(filename).getFile() );

        String gf = Files.toString(f, Charset.defaultCharset());

        System.out.println(gf);

        AbsynTree t = parseTree(gf);
        System.out.println(t);
    }
}
