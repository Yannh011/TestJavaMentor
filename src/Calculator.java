public class Calculator {
    private static int result;

    public int calculate(int num, int num1, char sign) {
        switch (sign) {
            case '+':
                result = Math.addExact(num, num1);
                break;
            case '-':
                result = Math.subtractExact(num, num1);
                break;
            case '*':
                result = Math.multiplyExact(num, num1);
                break;
            case '/':
                result = Math.floorDiv(num,num1);
        }
        return result;
    }
}
