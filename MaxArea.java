public class MaxArea {
    public static void main(String[] args) {
        int[] test = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(test));
    }

//    private static int maxArea(int[] height) {
//        int maxArea = 0;
//
//        for(int i : height) {
//            height = Arrays.copyOfRange(height, 1, height.length);
//            int distance = 1;
//            for(int j : height) {
//                int heightToCal = Math.min(i, j);
//                int area = distance * heightToCal;
//
//                if(area > maxArea) {
//                    maxArea = area;
//                }
//                distance++;
//            }
//        }
//
//        return maxArea;
//    }

    private static int maxArea(int[] height) {
        int maxArea = 0;

        int leftPointer = 0;
        int rightPointer = height.length - 1;

        while (rightPointer > leftPointer) {
            int heightToCal = Math.min(height[rightPointer], height[leftPointer]);

            int area = heightToCal * (rightPointer - leftPointer);

            maxArea = Math.max(maxArea, area);

            if(height[leftPointer] < height[rightPointer]) {
                ++leftPointer;
            }else if (height[leftPointer] > height[rightPointer]) {
                --rightPointer;
            }
            else {
                ++leftPointer;
                --rightPointer;
            }

        }

        return maxArea;
    }
}
