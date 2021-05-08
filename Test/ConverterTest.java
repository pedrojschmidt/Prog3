import NumerosRomanos.Converter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @Test
    public void test(){
        Converter convertidor = new Converter();
        int numero = convertidor.convert("CMXCIX");
        assertEquals(999, numero);
    }
}