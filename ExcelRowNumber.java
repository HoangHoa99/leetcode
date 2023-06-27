public class ExcelRowNumber {
    public static void main(String[] args) {
        System.out.println(calculateValue("MNO"));
        System.out.println(calculateValue("ABC"));
    }

    private static int calculateValue(String val) {

        int res = 0;

        for(int i = val.length() - 1; i >= 0; i--) {
            int indexVal = (int) val.charAt(i) - 64;
            double multiVal = Math.pow(26, val.length() - 1 - i);
            res += indexVal * multiVal;
        }

        return res;
    }
}
