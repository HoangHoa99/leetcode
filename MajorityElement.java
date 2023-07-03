import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,3,1,1,4,1,1,5,1,1,6};
        System.out.println(majorityElement(nums));
    }

    private static int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                ++count;
            } else {
                --count;
            }
        }

        return candidate;
    }
}
