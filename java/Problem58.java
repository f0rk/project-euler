//solution: 26241
import java.util.*;
public class Problem58 {

    public int eulerProblem58() {
        int sl = 4;
        int sls = sl * sl;
        int count = 3;
        for(int i = 9;; i += sl) {
            if(isPrime(i)) {
                ++count;
            }
            
            if(10 * count < sl * 2 + 1) {
                return sl+1;
            }
            
            if(sls == 0) {
                sl += 2;
                sls = sl * sl;
            }
            sls -= (sl/2) * (sl/2);
        }
    }

    public static void main(String args[]) {
        System.out.println((new Problem58()).eulerProblem58());
    }
    
    public boolean isPrime(int n) {
        if(n < 99) {
            return slowPrime(n);
        }
        
        if(n % 2 == 0
        || n % 3 == 0
        || n % 5 == 0
        || n % 7 == 0
        || n % 11 == 0
        || n % 13 == 0
        || n % 17 == 0
        || n % 19 == 0
        || n % 23 == 0
        || n % 29 == 0
        || n % 31 == 0
        || n % 37 == 0
        || n % 41 == 0
        || n % 43 == 0
        || n % 47 == 0
        || n % 53 == 0
        || n % 59 == 0
        || n % 61 == 0
        || n % 67 == 0
        || n % 71 == 0
        || n % 73 == 0
        || n % 79 == 0
        || n % 83 == 0
        || n % 89 == 0
        || n % 97 == 0) {
            return false;
        }
        
        for(int i = 3; i <= Math.sqrt(n); i += 2) {
            if(n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean slowPrime(int n) {
        if(n == 0) { return false; }
        if(n == 1) { return false; }
        if(n == 2) { return true; }
        if(n % 2 == 0) { return false; }
        for(int i = 2; i <= Math.sqrt(n); ++i) {
            if(n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
