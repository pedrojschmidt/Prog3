package NumerosRomanos;

import java.util.HashMap;

public class RomanNumeralV2 {
    private final HashMap<Character, Integer> romanAlphabet = new HashMap<>();

    public static void main(String[] args) throws Exception {
        RomanNumeralV2 a = new RomanNumeralV2();
        a.convert("I"); //1
        a.convert("X"); //10
        a.convert("XX"); //20
        a.convert("XXX"); //30
        a.convert("XL"); //40
        a.convert("L"); //50
        a.convert("LX"); //60
        a.convert("LXX"); //70
        a.convert("LXXX"); //80
        a.convert("XC"); //90
        a.convert("C"); //100
        System.out.println("");
        a.convert("CMXCIX"); //999
        a.convert("CCXLVIII"); //248
        a.convert("DLXXXII"); //582
        a.convert("MCMLXIV"); //1964
        a.convert("MMMDCCCLXXIII"); //3873
        a.convert("IV");

        try {
            a.convert("A");
            a.convert("XXXX");
            a.convert("VC");
            a.convert("IIII");
            a.convert("LXXXX");
            a.convert("XXL");

        } catch (Exception ignored) {

        }
    }

    private RomanNumeralV2() {
        romanAlphabet.put('I', 1);
        romanAlphabet.put('V', 5);
        romanAlphabet.put('X', 10);
        romanAlphabet.put('L', 50);
        romanAlphabet.put('C', 100);
        romanAlphabet.put('D', 500);
        romanAlphabet.put('M', 1000);
    }

    private void checkFormat(String input) throws Exception {
        for (int i = 0; i < input.length() - 1; i++) {
            //Verifica que el símbolo exista
            if (!romanAlphabet.containsKey(input.charAt(i))) {
                throw new Exception("Error en el formato 1");
            }
            //Los símbolos 5 y sus múltiplos siempre suman y no pueden estar a la izquierda de uno de mayor valor
            if ((romanAlphabet.get(input.charAt(i)) < romanAlphabet.get(input.charAt(i + 1))) && ((input.charAt(i) == 'V' || input.charAt(i) == 'L' || input.charAt(i) == 'D'))) {
                throw new Exception("Error en el formato 2");
            }
            //Se permiten como mucho tres repeticiones consecutivas del mismo símbolo
            if (((input.length() - i) > 3) && ((input.charAt(i) == input.charAt(i + 1) && input.charAt(i + 1) == input.charAt(i + 2) && input.charAt(i + 2) == input.charAt(i + 3)))) {
                throw new Exception("Error en el formato 3");
            }
        }
    }

    public void convert(String input) throws Exception {
        checkFormat(input);
        int decimal = 0;
        int previous = 0;
        for (int i = 0; i < input.length(); i++) {
            int value = romanAlphabet.get(input.charAt(i));

            decimal += value;
            if (previous < value) {
                decimal -= previous * 2;
            }
            previous = value;
        }
        System.out.println(decimal);
    }
}