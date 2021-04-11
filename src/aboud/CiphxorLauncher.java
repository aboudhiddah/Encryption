package aboud;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;


public class CiphxorLauncher {

    @Option(name = "-c", metaVar = "inputEncryption", usage = "Input file encryption key")
    private String inputEncryption = "";

    @Option(name = "-d", metaVar = "inputDecryption", usage = "Input file decryption key")
    private String inputDecryption = "";

    @Argument(required = true, usage = "input file name")
    private String inputFileName;

    @Option(name = "-o", usage = "output file name")
    private String outputFileName;

    public static void main(String[] args) {
        new CiphxorLauncher().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
            if (outputFileName == null)
                throw new IllegalArgumentException("Output file name is not given");
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar Сiphxor.jar [-c Encryption][-d Decryption] InputName [-o OutputName]");
            parser.printUsage(System.err);
            return;
        }
        try {
            Ciphxor.recode(inputFileName, outputFileName, inputEncryption, inputDecryption);
            System.out.println("Done");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
