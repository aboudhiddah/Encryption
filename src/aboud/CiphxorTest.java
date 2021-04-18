package aboud;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CiphxorTest {

    @Test
    void keyToByteArray() {
        byte[] k = Ciphxor.keyToByteArray("100A");
    assertEquals(16,k[0]);
    assertEquals(10,k[1]);
    byte[] k1 = Ciphxor.keyToByteArray("10F");
    assertEquals(1,k1[0]);
    assertEquals(15,k1[1]);
    }


}