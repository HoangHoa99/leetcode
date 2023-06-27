import java.util.ArrayList;
import java.util.List;

public class FindPossibleWord {

    public static void main(String[] args) {
        System.out.println(findPossibleWord());
    }

    private static List<String> findPossibleWord(){
        List<String> res = new ArrayList<>();
        List<String> dictionary = List.of("Java", "Point", "Quiz");

        List<List<String>> inputChars = List.of(
                List.of("J", "P", "T"),
                List.of("U", "A", "A"),
                List.of("Q", "S", "V")
        );

        List<String> combineInput = new ArrayList<>();
        for(List<String> input : inputChars) {
            combineInput.addAll(input);
        }

        for(String value : dictionary) {
            boolean isImpossible = findImpossible(value, combineInput);
            if(!isImpossible) {
                res.add(value);
            }
        }

        return res;
    }

    private static boolean findImpossible(String value, List<String> combineInput) {
        for(int index = 0; index < value.length(); index ++) {
            if(!combineInput.contains(String.valueOf(value.charAt(index)).toUpperCase())) {
                return true;
            }
        }

        return false;
    }
}
