import java.util.Arrays;

public class MergeArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{-1,0,0,3,3,3,0,0,0};
        int m = 6;
        int[] nums2 = new int[]{1,2,2};
        int n = 3;
        merge(nums1, m, nums2, n);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {

        if(n == 0) {
            return;
        }

        if(m == 0) {
            if (n >= 0) System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }

        if(m + n == 2) {
            int num1Value = nums1[0];
            int num2Value = nums2[0];

            nums1[0] = Math.min(num1Value, num2Value);
            nums1[1] = Math.max(num1Value, num2Value);
            return;
        }

        int num1Pointer = 0;
        int num2Pointer = 0;
        int[] res = new int[m + n];

        for(int i = 0; i < m + n; i++) {
            int num2Val;
            if(num2Pointer == n) {
                num2Val = Integer.MAX_VALUE;
            }
            else {
                num2Val = nums2[num2Pointer];
            }

            // case 1 val is 0, just replace and increase both pointer
            if(num1Pointer >= m && nums1[num1Pointer] == 0) {
                res[i] = num2Val;
                ++num1Pointer;
                ++num2Pointer;
                continue;
            }

            // case 2 >= 1 -> just increase num1Pointer
            if(nums1[num1Pointer] <= num2Val) {
                res[i] = nums1[num1Pointer];
                ++num1Pointer;
                continue;
            }

            // case 1 > 2
            res[i] = num2Val;
            ++num2Pointer;


        }

        System.arraycopy(res, 0, nums1, 0, m+n);
        System.out.println(Arrays.toString(nums1));
    }
}
