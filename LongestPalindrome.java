import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LongestPalindrome {
    public static void main(String[] args) {

        System.out.println(longestPalindrome("abcba"));
        System.out.println(longestPalindrome("babad"));
    }

    private static String longestPalindrome(String s) {

        if(s.length() == 0) {
            return "";
        }

        if(s.length() == 1) {
            return s;
        }
        List<String> subStringChar = new ArrayList<>();

        // case not the same char
        for(int i = 0; i < s.length(); i ++) {
            List<String> sub = new ArrayList<>();
            sub.add(String.valueOf(s.charAt(i)));
            int tryTime = i + 1;
            for(int j = 0; j < tryTime; j++) {
                char nextChar;
                char prevChar;
                try {
                    nextChar = s.charAt(i + j + 1);
                    prevChar = s.charAt(i - j - 1);

                    if(nextChar == prevChar) {
                        sub.add(String.valueOf(nextChar));
                        sub.add(0, String.valueOf(prevChar));
                    }
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            subStringChar.add(String.join("", sub));
            sub.clear();
        }

        // case same char
        for(int i = 0; i < s.length(); i++) {
            List<String> sub = new ArrayList<>();
            sub.add(String.valueOf(s.charAt(i)));
            for(int j = i + 1; j < s.length(); j++) {
                if(s.charAt(i) != s.charAt(j)) {
                    break;
                }
                sub.add(String.valueOf(s.charAt(j)));
            }

            subStringChar.add(String.join("", sub));
            sub.clear();
        }

        subStringChar = subStringChar.stream().sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        return subStringChar.get(subStringChar.size() - 1);
    }
}
