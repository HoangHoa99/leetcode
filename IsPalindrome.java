public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
    }

    private static boolean isPalindrome(int x) {
        if(x == 0) {
            return true;
        }
        String valueAsStr = String.valueOf(x);

        if(valueAsStr.length() == 1) {
            return true;
        }

        int size = valueAsStr.length();
        int middle = size / 2;

        for(int i = 0; i < middle; i++) {
            if(!(valueAsStr.charAt(i) == valueAsStr.charAt(size - i - 1))) {
                return false;
            }
        }

        return true;
    }
}
