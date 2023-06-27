import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums1, 9)));
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;

                    break;
                }
            }
        }

        return res;
    }
}
