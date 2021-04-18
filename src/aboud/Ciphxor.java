package aboud;

import java.io.*;

@SuppressWarnings("WeakerAccess")

public class Ciphxor {
    public static byte[] keyToByteArray(String key) {
        String temp;
        byte[] res = new byte[(int)Math.ceil((float)key.length()/2)];
        int pos = res.length - 1;
        for(int i = key.length() - 1; i >= 0; i -= 2){
            if(i == 0) {
                temp = Character.toString(key.charAt(0));
            } else{
                temp = key.substring(i - 1, i + 1);
            }
            res[pos] = (byte)Integer.parseInt(temp, 16);
            pos--;
        }
        return res;
    }

    private static void recode(FileInputStream inputStream, String outputFileName, String finalKey)
            throws IOException {

        byte[] keyarr;
        try ( FileOutputStream out = new FileOutputStream(outputFileName)){
            keyarr = keyToByteArray(finalKey);
            byte temp;
            byte res;
            int i = 0;
            while ((temp = (byte)inputStream.read()) != -1) {
                res = (byte)(temp^keyarr[i]);
                i++;
                i = i % keyarr.length;
                out.write(res);
            }
        }

    }

    public static void recode(String inputFileName, String outputFileName, String finalKey)
            throws IOException {
        try (FileInputStream inputStream = new FileInputStream(inputFileName)) {
            Ciphxor.recode(inputStream, outputFileName, finalKey);
        }
    }
}