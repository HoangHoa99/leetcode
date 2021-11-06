class StringToInteger {

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isPunc(char c) {
        return c == '-' || c == '+';
    }

    private static boolean isNegativePunc(char c) {
        return c == '-';
    }

    private static boolean isChar(char c) {
        return !isDigit(c) && !isPunc(c) && c != ' ';
    }

    private static int letNextPunc(String res) {
        int temp = 0;
        for(int i = 0; i < res.length(); i++) {
            if(isPunc(res.charAt(i))) {
                temp = i;
            }
        }

        return temp;
    }

    private static int formatRes(String res) {

        if(res == "") {
            return 0;
        }

        char first = res.charAt(0);
        char last = res.charAt(res.length() - 1);

        if(res.length() == 1 && isPunc(first)) {
            return 0;
        }

        if((res.contains("-") || res.contains("+")) && !isPunc(first) && !isPunc(last)) {
            return 0;
        }

        for(int i = res.length() - 1; i >= 0; i--) {
            if(isDigit(res.charAt(i))) {
                break;
            }

            res = res.substring(0, res.length() - 1);
        }

        if(res.equals("")) {
            return 0;
        }

        try{

            if(isDigit(first)) {
                return Integer.valueOf(res);
            }

            char second = res.charAt(1);
            if(!isDigit(second)) {
                return 0;
            }

            int nextPunc = letNextPunc(res);

            if(nextPunc != 0) {
                res = res.substring(0, nextPunc);
            }

            return Integer.valueOf(res);
        }
        catch(Exception e) {
            if(isNegativePunc(first)) {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
    }

    public static int myAtoi(String s) {
        String res = "";
        s = s.trim();

        if(s.equals("")) {
            return 0;
        }

        if(isChar(s.charAt(0))) {
            return 0;
        }

        for(int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);

            if(!isPunc(value) && !isDigit(value)) {
                break;
            }

            if(isPunc(value) || isDigit(value)) {
                res += String.valueOf(value);
            }
        }

        return formatRes(res);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("123-"));
    }
}