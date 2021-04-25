package aboud;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;


class CiphxorLauncherTest {

    @Test
    void xorandxor()throws IOException{
        Ciphxor.recode("Test.txt","Youth.txt", "1");
        Ciphxor.recode("Youth.txt","Youth.txt.txt", "1");
        byte[] res = Files.readAllBytes(Paths.get("Test.txt"));
        byte[] exp = Files.readAllBytes(Paths.get("Youth.txt.txt"));
        assertEquals(new String(exp), new String(res));
    }

    @Test
    void withC() throws IOException {
        Ciphxor.recode("Text.txt","Test3.txt", "3F");
        byte[] res = Files.readAllBytes(Paths.get("Test3.txt"));
        assertEquals("abccdefg", new String(res));
    }
    @Test
    void xorandxo()throws IOException{
        Ciphxor.recode("Test.txt","Youth.txt", "123456");
        Ciphxor.recode("Youth.txt","Youth.txt.txt", "123456");
        byte[] res = Files.readAllBytes(Paths.get("Test.txt"));
        byte[] exp = Files.readAllBytes(Paths.get("Youth.txt.txt"));
        assertEquals(new String(exp), new String(res));
    }

}
