//solution: 402
import java.util.*;
public class Problem74 {

    public int eulerProblem74() {
        int count60 = 0;
        for(int i = 0; i < 1000000; ++i) {
            if(factorialChainLength(i) == 60) {
                ++count60;
            }
        }
        return count60;
    }
    
    public int factorialChainLength(int n) {
        HashMap<Integer,Boolean> has = new HashMap<Integer,Boolean>();
        int count = 0;
        while(!has.containsKey(n)) {
            has.put(n, true);
            int[] digits = digitsFromNum(n);
            int sum = 0;
            for(int i = 0; i < digits.length; ++i) {
                sum += factorial(digits[i]);
            }
            n = sum;
            ++count;
        }
        return count;
    }
    
    public int factorial(int n) {
        if(n == 0) {
            return 1;
        } else if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2;
        } else if(n == 3) {
            return 6;
        } else if(n == 4) {
            return 24;
        } else if(n == 5) {
            return 120;
        } else if(n == 6) {
            return 720;
        } else if(n == 7) {
            return 5040;
        } else if(n == 8) {
            return 40320;
        } else if(n == 9) {
            return 362880;
        }
        
        return n * factorial(n-1);
    }
    
    public int[] digitsFromNum(int n) {
        String s = n+"";
        int[] ret = new int[s.length()];
        for(int i = 0; i < s.length(); ++i) {
            int x;
            switch(s.charAt(i)) {
                case '1': x = 1; break;
                case '2': x = 2; break;
                case '3': x = 3; break;
                case '4': x = 4; break;
                case '5': x = 5; break;
                case '6': x = 6; break;
                case '7': x = 7; break;
                case '8': x = 8; break;
                case '9': x = 9; break;
                case '0': x = 0; break;
                default: x = 0; break;
            }
            ret[i] = x;
        }
        return ret;
    }

    public static void main(String args[]) {
        System.out.println((new Problem74()).eulerProblem74());
    }

}
