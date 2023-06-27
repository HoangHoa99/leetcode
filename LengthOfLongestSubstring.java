import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

        private static int lengthOfLongestSubstring(String s) {
        List<Integer> subLength = new ArrayList<>();
        if(s.length() == 0) {
            return 0;
        }

        for(int i = -1; i < s.length(); i++) {
            List<Character> sub = new ArrayList<>();
            for(int j = i + 1; j < s.length(); j++) {
                if(!sub.contains(s.charAt(j))) {
                    sub.add(s.charAt(j));
                }
                else {
                    break;
                }
            }

            subLength.add(sub.size());
        }

        subLength = subLength.stream().sorted().collect(Collectors.toList());
        return subLength.get(subLength.size() - 1);
    }
}
