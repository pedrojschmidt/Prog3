package NumerosRomanos;

import java.util.HashMap;

public class Converter{

    private final HashMap<String, Integer> romanNumbers;

    public Converter(){
        this.romanNumbers = new HashMap<>();
        fillHashMap();
    }

    public int convert(String romanNumber){
        int decimalNumber = 0;
        int actualNumber;
        int nextNumber;
        int numberLength = romanNumber.length();

        for (int i = 0; i < numberLength; i++) {
            if (i<numberLength-1) {
                actualNumber = romanNumbers.get(Character.toString(romanNumber.charAt(i)).toUpperCase());
                nextNumber = romanNumbers.get(Character.toString(romanNumber.charAt(i+1)).toUpperCase());
                if (actualNumber < nextNumber) {
                    decimalNumber += (nextNumber-actualNumber);
                    i++;
                } else {
                    decimalNumber += actualNumber;
                }
            }else{
                decimalNumber += romanNumbers.get(Character.toString(romanNumber.charAt(i)).toUpperCase());
            }
        }
        return decimalNumber;
    }

    private void fillHashMap(){
        this.romanNumbers.put("I", 1);
        this.romanNumbers.put("V", 5);
        this.romanNumbers.put("X", 10);
        this.romanNumbers.put("L", 50);
        this.romanNumbers.put("C", 100);
        this.romanNumbers.put("D", 500);
        this.romanNumbers.put("M", 1000);
    }

    public static void main(String[] args) {
        Converter converter = new Converter();

        System.out.println(converter.convert("CMXCIX"));
    }
}
