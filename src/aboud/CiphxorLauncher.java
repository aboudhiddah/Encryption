package aboud;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;


public class CiphxorLauncher {

    @Option(name = "-c", metaVar = "inputEncryption", usage = "Input file encryption key")
    String inputEncryption;

    @Option(name = "-d", metaVar = "inputDecryption", usage = "Input file decryption key")
    String inputDecryption;

    @Argument(required = true, metaVar = "inPut" , usage = "input file name")
    String inputFileName;

    @Option(name = "-o", metaVar = "outPut" ,usage = "output file name")
    String outputFileName;
    // По заданию может не быть -o

    public static void main(String[] args) {
        new CiphxorLauncher().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
            if (outputFileName == null)
                outputFileName = inputFileName.replace("." , "Output.");

        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar Сiphxor.jar [-c Encryption][-d Decryption] InputName [-o OutputName]");
            parser.printUsage(System.err);
            return;
        }
        try {
            String finalKey = check(inputEncryption, inputDecryption);
            Ciphxor.recode(inputFileName, outputFileName, finalKey);
            System.out.println("Done");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private String check(String ekey,String dkey) throws IOException{
        if (ekey != null && dkey != null) {
            throw new IOException("Enter Just One Key");
        }
        if (ekey  != null || dkey  != null) {
            if(ekey!= null) return ekey;
            else return dkey;
        } else {
            throw new IOException("No Key");
        }
    }
}
