class ReserveInteger {
    
    private static int reverseNum(int x) {
        
        String res = "";
        
        while(x > 0) {
            int temp = x%10;
            x = x/10;
            res += String.valueOf(temp);
        }
        try {
            return Integer.valueOf(res); 
        }
        catch (Exception e) {
            return 0;
        }
    }
    
    private static int reversePosNum(int x) {
        x = Math.abs(x);
        
        int res = reverseNum(x);
        
        return 0 - res;
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