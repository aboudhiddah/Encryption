package aboud;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;


class CiphxorLauncherTest {

    @Test
    void xorandxor()throws IOException{
        Ciphxor.recode("Test.txt","Youth.txt", "1", "");
        Ciphxor.recode("Youth.txt","Youth.txt.txt", "", "1");
        byte[] res = Files.readAllBytes(Paths.get("Test.txt"));
        byte[] exp = Files.readAllBytes(Paths.get("Youth.txt.txt"));
        assertEquals(new String(exp), new String(res));
    }

    @Test
    void withC() throws IOException {
        Ciphxor.recode("Text.txt","Test3.txt", "3F", "");
        byte[] res = Files.readAllBytes(Paths.get("Test3.txt"));
        assertEquals("abccdefg", new String(res));
    }



    @Test
    void withoutAnyKeys() throws IOException {
        IOException e = assertThrows(IOException.class, () ->
                Ciphxor.recode("Text3.txt","Text3.txt.txt", "", ""));
        assertEquals(e.getMessage(),"No Key");
    }

    @Test
    void withTwoKeys() throws IOException {
        IOException e = assertThrows(IOException.class, () ->
                Ciphxor.recode("Text3.txt","Text3.txt.txt", "3F", "3F"));
        assertEquals(e.getMessage(),"Enter Just One Key");
    }

}
