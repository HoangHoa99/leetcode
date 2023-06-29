import java.util.ArrayList;
import java.util.List;

public class FindPalindrome {

    public static void main(String[] args) {
        String s = "bcba";
        List<Integer> startIndex = List.of(1,2,1);
        List<Integer> endIndex = List.of(3,3,1);
        List<Integer> subs = List.of(2, 0, 0);
        System.out.println(findPalindrome(s, startIndex, endIndex, subs));
    }

    private static String findPalindrome(String s, List<Integer> startIndex, List<Integer> endIndex, List<Integer> subs) {
        StringBuilder res = new StringBuilder();

        int limit = startIndex.size();

        for(int i = 0; i < limit; i++) {
            int subTime = subs.get(i);
            int start = startIndex.get(i);
            int end = endIndex.get(i) + 1;
            String validateSub = s.substring(start, end);

            res.append(isPalindrome(validateSub, subTime));
        }

        return res.toString();
    }

    private static String isPalindrome(String validateSub, int subTime) {

        List<Character> uniqueCharList = new ArrayList<>();
        int subLength = validateSub.length();
        int possibleCouple = subLength / 2;

        for(int i = 0; i < subLength; i++) {
            char uniqueChar = validateSub.charAt(i);
            if(!uniqueCharList.contains(uniqueChar)) {
                uniqueCharList.add(uniqueChar);
            }
        }

        if(subTime == 0 && uniqueCharList.size() == 1) {
            return "1";
        }

        if((uniqueCharList.size() - subTime) <= possibleCouple) {
            return "1";
        }

        return "0";
    }
}
