//solution: 8319823
import java.util.*;
public class Problem70 {

    public int eulerProblem70() {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for(int i = 3; i < 1000000; i += 2) {
            if(isPrime(i)) {
                primes.add(i);
            }
        }
        
        int minN = 0;
        double minQ = 10000000;
        for(int n = 2; n <= 10000000; ++n) {
            ArrayList<Integer> factors = primeFactorization(n, primes);
            int totient = 1;
            for(int i = 0; i < factors.size(); i += 2) {
                totient *= intPow(factors.get(i), factors.get(i+1)) - intPow(factors.get(i), factors.get(i+1)-1);
            }
            if(n/((double)totient) < minQ && isPermutation(n+"", totient+"")) {
                minQ = n/((double)totient);
                minN = n;
            }
        }
        return minN;
    }
    
    public int intPow(int n, int p) {
        int ret = 1;
        for(int i = 0; i < p; ++i) {
            ret *= n;
        }
        return ret;
    }
    
    public boolean isPermutation(String is, String ns) {
        if(is.length() != ns.length()) {
            return false;
        }
        char[] ia = new char[is.length()];
        char[] na = new char[ns.length()];
        is.getChars(0, ia.length, ia, 0);
        ns.getChars(0, na.length, na, 0);
        Arrays.sort(ia); Arrays.sort(na);
        for(int i = 0; i < ia.length; ++i) {
            if(ia[i] != na[i]) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> primeFactorization(int n, ArrayList<Integer> primes) {
        ArrayList<Integer> ar = new ArrayList<Integer>();
        if(isPrime(n)) {
            ar.add(n);
            ar.add(1);
            return ar;
        }
        for(int i = 0; primes.get(i) <= Math.sqrt(n); ++i) {
            if(n % primes.get(i) == 0) {
                int count = 1;
                n /= primes.get(i);
                while(n % primes.get(i) == 0 ) {
                    n /= primes.get(i);
                    ++count;
                }
                ar.add(primes.get(i));
                ar.add(count);
            }
        }
        if(n != 1) { //n is prime
           ar.add(n);
           ar.add(1); 
        }
        return ar;
    }

    public static void main(String args[]) {
        System.out.println((new Problem70()).eulerProblem70());
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
