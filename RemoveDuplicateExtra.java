import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicateExtra {

    public static void main(String[] args) {
//        int[] nums1 = new int[]{0,1,2,2,2,2,2,3,4,4,4};
//        System.out.println(removeDuplicates(nums1));
//        int[] nums2 = new int[]{0,0,0,1,1,1,1,2,3,3};
//        System.out.println(removeDuplicates(nums2));
//        int[] nums3 = new int[]{1,2,2};
//        System.out.println(removeDuplicates(nums3));
//        int[] nums4 = new int[]{1,1,2,2};
//        System.out.println(removeDuplicates(nums4));
        int[] nums5 = new int[]{0,0,1,2,3,3,3,3,3,3,4,4,4,4,5,5,6,6,6};
        System.out.println(removeDuplicates(nums5));
    }

    private static int removeDuplicates(int[] nums) {

        if(nums.length < 3) {
            return nums.length;
        }

        if(nums.length == 3) {
            return nums[0] == nums[nums.length - 1] ? nums.length - 1 : nums.length;
        }

        int pointer = 2;
        int numPointer = 2;

        while (numPointer != nums.length) {

            boolean pointerCond = nums[pointer] <= nums[pointer - 1] && nums[pointer] <= nums[pointer - 2];
            boolean numPointerCond = nums[numPointer] == nums[numPointer - 1] && nums[numPointer] == nums[numPointer - 2];

            if(pointerCond && numPointerCond) {
                ++numPointer;
                continue;
            }

            if(!pointerCond && !numPointerCond) {
                nums[pointer] = nums[numPointer];
                ++pointer;
                ++numPointer;
                continue;
            }

            if(pointerCond) {
                nums[pointer] = nums[numPointer];
                ++pointer;
                ++numPointer;
                continue;
            }

            ++pointer;
            ++numPointer;
        }

        System.out.println(Arrays.toString(nums));

        if(pointer < nums.length && nums[pointer] > nums[pointer - 1]) {
            --pointer;
        }
        return pointer;
    }



    // if(nums.length < 3) {
    //     return nums.length;
    // }

    // if(nums.length == 3 && nums[1] == nums[2]) {
    //     return 2;
    // }

    // int pointer = 2;
    // int numPointer = 2;
    // while (numPointer < nums.length) {
    //     boolean a = nums[pointer] == nums[pointer - 1] && nums[pointer] == nums[pointer - 2];
    //     boolean b = nums[numPointer] == nums[numPointer - 1] && nums[numPointer] == nums[numPointer - 2];

    //     if(a && b) {
    //         ++numPointer;
    //         continue;
    //     }

    //     if(!a && !b) {
    //         nums[pointer] = nums[numPointer];
    //         ++numPointer;
    //         ++pointer;
    //         continue;
    //     }

    //     if(a) {
    //         nums[pointer] = nums[numPointer];
    //     }

    //     ++numPointer;
    //     ++pointer;
    // }

    // if((pointer == nums.length)) {
    //     --pointer;
    //     return pointer;
    // }
    // if(nums[pointer] == nums[nums.length - 1] && nums[pointer] != nums[pointer - 1]) {
    //     --pointer;
    //     return pointer;
    // }
    // return pointer;
}
