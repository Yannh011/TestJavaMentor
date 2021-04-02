import java.util.Scanner;

public class CalculatorTest {
    private static char sign;
    private static final int minNum = 1;
    private static final int maxNum = 10;
    private static final int[] arabNum = {1,2,3,4,5,6,7,8,9,10};
    private static final String [] romeNum = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    private static String num1;
    private static int roman;
    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String text = "";

        try {
            System.out.println("Введите арифметическое выражение");
            num1 = sc.nextLine();
            text = num1.replaceAll("\\s", "");
            String[] blocks = text.split("[\\Q^*/+-%\\E]");
            roman = 0;
            sign = checkSign(text);

            for(int i = 0; i <= 9; i++) {
                if (romeNum[i].equals(blocks[0])) {
                    blocks[0] = Integer.toString(arabNum[i]);
                    roman ++;
                }
                if (romeNum[i].equals(blocks[1])) {
                    blocks[1] = Integer.toString(arabNum[i]);
                    roman ++;
                }
            }
            if (isNumber(Integer.parseInt(blocks[0])) && isNumber(Integer.parseInt(blocks[1]))) {
                result = calculator.calculate(Integer.parseInt(blocks[0]), Integer.parseInt (blocks[1]), sign);
            } else {
                System.out.println("Введенные числа должны входить в диапазон от 1 до 10");
                throw new IllegalArgumentException();
            }

            if(roman == 1) {
                System.out.println("Калькулятор работает только с арабскими и римскими цифрами");
                throw new IllegalArgumentException();
            }

            if(roman == 2) {
                RomanArabConvrt.arabicToRoman(result);
            } else {
                System.out.println(result);
            }
        } catch (RuntimeException e) {
            System.out.println("Неверный формат данных");
        }
    }

    private static char checkSign(String text) { //определение и проверка знака
        if (text.contains("+")) {
            return '+';
        } else if (text.contains("-")) {
            return '-';
        } else if (text.contains("*")) {
            return '*';
        } else if (text.contains("/")) {
            return  '/';
        } else {
            System.out.println("Арифметический знак введен неверно. Допустимые знаки +,-,*,/");
            throw new ArithmeticException();
        }
    }

    private static boolean isNumber (int num) { //проверка введенного числа
        return (num >= minNum && num <= maxNum);
    }
}
