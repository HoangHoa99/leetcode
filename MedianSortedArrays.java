import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {4,5,6,8,9};
        int[] nums2 = {};
        System.out.println(findMedianSortedArrays(nums1, nums2));
        int[] nums3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
        int[] nums4 = {0,6};
        System.out.println(findMedianSortedArrays(nums3, nums4));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int numberToDivine = nums1.length + nums2.length;

        if(numberToDivine <= 0) {
            return 0;
        }
        if(numberToDivine > 2) {
            numberToDivine -= 2;
        }

        List<Integer> merge = new ArrayList<>();
        int sum = 0;
        for(int i : nums1) {
            merge.add(i);
        }

        for(int i : nums2) {
            merge.add(i);
        }
        merge = merge.stream().sorted().collect(Collectors.toList());
        int begin = merge.size() > 2 ? 1 : 0;
        int end = merge.size() > 2 ? merge.size() - 1 : merge.size();
        for(int i = begin; i < end; i++) {
            sum += merge.get(i);
        }

        double res = (double) sum / numberToDivine;
        double intType = (int) res;

        double minus = res - intType;

        if(minus == 0.5) {
            intType += 0.5;
        }

        if(minus == -0.5) {
            intType -= 0.5;
        }

        if(minus > 0.5) {
            intType += 1;
        }

        if(minus > -0.5) {
            intType -= 0;
        }

        if(minus < -0.5) {
            intType -= 1;
        }

        return intType;
    }
}
