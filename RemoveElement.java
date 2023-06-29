import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,2,3};
        int val = 3;
        removeElement(nums, val);
    }

    private static int removeElement(int[] nums, int val) {

        int k = 0;

        int[] res = new int[nums.length];
        int pointer = 0;

        for (int num : nums) {
            if (num != val) {
                res[pointer] = num;
                k++;
                pointer++;
            }
        }

        System.arraycopy(res, 0, nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
        System.out.println(k);
        return k;
    }
}
