package grammaticalframework.util;


import grammaticalframework.Linearizer;
import grammaticalframework.UnknownLanguageException;
import grammaticalframework.parser.ParseError;

import java.io.IOException;

public class EvalEn {
    public static void main(String[] rags) throws Linearizer.LinearizerException, UnknownLanguageException, ParseError, IOException {
        new Eval("/home/me/neuro/JPGF.1/src/test/java/grammaticalframework/Phrasebook.pgf",
                "PhrasebookEng");
    }
}
