public class IsMatch {
    public static void main(String[] args) {
        System.out.println(isMatch("aaaaa", "a*"));
    }

    private static boolean isMatch(String s, String p) {
        boolean containStar = p.contains("*");
        boolean containDot = p.contains(".");

        if(!containStar && !containDot) {
            if(p.length() != s.length()) {
                return false;
            }

            return p.equals(s);
        }

        if(containStar && containDot) {
            return true;
        }

        if(containStar) {
            boolean prevMatch = false;
            boolean remainMatch = false;
            int starIndex = p.indexOf("*");
            for(int i = 0; i < starIndex; i ++) {
                if(s.charAt(i) != p.charAt(i)) {
                    prevMatch = false;
                    break;
                }
                prevMatch = true;
            }

            char toCompare = s.charAt(starIndex - 1);
            for(int i = starIndex; i < s.length(); i ++) {
                if(s.charAt(i) != toCompare) {
                    remainMatch = false;
                    break;
                }
                remainMatch = true;
            }

            return prevMatch && remainMatch;
        }
        return false;
    }
}
