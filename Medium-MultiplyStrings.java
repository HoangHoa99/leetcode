class MultiflyString {

    private static boolean leadingZero(String num) {
        int length = num.length();
        char firstChar = num.charAt(0);
        return length != 1 && firstChar == '0';
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isNumberString(String num) {
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if(!isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValidLength(String num) {
        int length = num.length();
        return length >= 1 && length <= 200;
    }

    private static String plusStepByStep(String numList[], int index) {
        int res = 0;
        int numListLength = numList.length;
        for(int i = 0; i < numListLength; i++) {
            String num = numList[i];
            try {
                char value = num.charAt(index - numListLength + i);
                int valueAsInt = Integer.valueOf(String.valueOf(value));
                res += valueAsInt;
            }
            catch (Exception e) {
                res += 0;
            }
        }
        return String.valueOf(res);
    }

    private static String addStringInList(String numList[], int lastResLength) {

        StringBuilder result = new StringBuilder();

        long temp = 0;

        for(int i = lastResLength - 1; i > 0; i--) {
            String res = plusStepByStep(numList, i);
            long resAsLong = Long.valueOf(res);
            resAsLong += temp;

            if(resAsLong > 10) {
                temp = 1;
            }
            else {
                temp = 0;
            }

            result.insert(0, String.valueOf(resAsLong % 10));
        }

        return result.toString();
    }

    private static String multiplyString(String num1, String num2) {
        int index = 0;
        long number1 = Long.valueOf(num1);
        long number2 = Long.valueOf(num2);

        String multiResList[] = new String[num2.length()];
        while(number2 > 0) {

            long temp = (long) Math.pow(10, index);
            long multiVar = number2%10;
            number2 = number2/10;
            temp = temp * multiVar * number1;
            multiResList[index] = String.valueOf(temp);

            index ++;
        }

        int lastResLength = multiResList[multiResList.length - 1].length();
        return addStringInList(multiResList, lastResLength);
    }

    public static String multiply(String num1, String num2) {

        if(!isValidLength(num1) || !isValidLength(num2)) {
            return "0";
        }

        if(!isNumberString(num1) || !isNumberString(num2)) {
            return "0";
        }

        if(leadingZero(num1) || leadingZero(num2)) {
            return "0";
        }
        return multiplyString(num1, num2);
    }

    public static void main(String[] args) {
        System.out.println(multiply("498828660196", "840477629533"));
    }
}
