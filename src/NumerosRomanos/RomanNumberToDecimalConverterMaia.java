package NumerosRomanos;

import java.util.HashMap;

public class RomanNumberToDecimalConverterMaia {

    private final HashMap<String, Integer> romanNumbers = new HashMap <>();

    public static void main(String[] args) {
        RomanNumberToDecimalConverterMaia a = new RomanNumberToDecimalConverterMaia();
        a.convert("CMXCIX");
    }

    public RomanNumberToDecimalConverterMaia() {
        romanNumbers.put("I", 1);
        romanNumbers.put("V", 5);
        romanNumbers.put("X", 10);
        romanNumbers.put("L", 50);
        romanNumbers.put("C", 100);
        romanNumbers.put("D", 500);
        romanNumbers.put("M", 1000);
    }

    public void convert(String input) {
        int decimal = 0;
        int previous = 0;
        for(int i = 0; i < input.length(); i++)	{
            boolean containsKey = romanNumbers.containsKey(Character.toString(input.charAt(i)));
            if(containsKey)	{
                int value = romanNumbers.get(Character.toString(input.charAt(i)).toUpperCase());
                decimal += value;
                if(previous < value) {
                    decimal -= previous*2;
                }
                previous = value;
            }
            else {
                decimal = 0;
            }
        }
        System.out.println(decimal);
    }
}
