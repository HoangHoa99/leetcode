import java.util.ArrayList;
import java.util.List;

public class MergeList {

    public static void main(String[] args) {
        mergeList();
    }

    private static void mergeList() {
        List<Integer> a = List.of(1, 3, 5);
        List<Integer> b = List.of(2, 4, 6, 10, 12);

        List<Integer> res = new ArrayList<>();

        while (b.size() != 0) {
            int firstOfA = 0;
            try {
                firstOfA = a.get(0);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            int firstOfB = b.get(0);

            if(firstOfA == 0 || firstOfA > firstOfB) {
                res.add(firstOfB);
                b = b.subList(1, b.size());
            }
            else {
                res.add(firstOfA);
                a = a.subList(1, a.size());
            }
        }

        System.out.println(res);
    }
}
