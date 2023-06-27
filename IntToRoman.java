public class IntToRoman {

    public static void main(String[] args) {

        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(3841));
    }

    private static String intToRoman(int num) {
        StringBuilder res = new StringBuilder();

        while (num > 0) {

            if(num >= 1000) {
                res.append("M");
                num -= 1000;

                continue;
            }

            if(num >= 900) {
                res.append("CM");
                num -= 900;

                continue;
            }

            if(num >= 500) {
                res.append("D");
                num -= 500;

                continue;
            }

            if(num >= 400) {
                res.append("CD");
                num -= 400;

                continue;
            }

            if(num >= 100) {
                res.append("C");
                num -= 100;

                continue;
            }

            if(num >= 90) {
                res.append("XC");
                num -= 90;

                continue;
            }

            if(num >= 50) {
                res.append("L");
                num -= 50;

                continue;
            }

            if(num >= 40) {
                res.append("XL");
                num -= 40;

                continue;
            }

            if(num >= 10) {
                res.append("X");
                num -= 10;

                continue;
            }

            if(num == 9) {
                res.append("IX");
                num -= 9;

                continue;
            }

            if(num >= 5) {
                res.append("V");
                num -= 5;

                continue;
            }

            if(num == 4) {
                res.append("IV");
                num -= 4;

                continue;
            }

            res.append("I");
            num -= 1;
        }

        return res.toString();
    }
}
