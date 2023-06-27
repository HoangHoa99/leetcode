class ReserveInteger {
    
    private static int reverseNum(int x) {
        
        StringBuilder res = new StringBuilder();
        
        while(x > 0) {
            int temp = x % 10;
            x = x / 10;
            res.append(temp);
        }
        try {
            return Integer.parseInt(res.toString());
        }
        catch (Exception e) {
            return 0;
        }
    }
    
    private static int reversePosNum(int x) {
        x = Math.abs(x);
        
        int res = reverseNum(x);
        
        return -res;
    }
    
    public static int reverse(int x) {
        
        if(x == 0) {
            return 0;
        }
        
        if(x > 0) {
            return reverseNum(x);
        }
        
        return reversePosNum(x);
        
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}