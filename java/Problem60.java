//solution: 26033
import java.util.*;
import java.math.*;
public class Problem60 {

    public int eulerProblem60() {
        int[] primes = new int[1500];
        primes[0] = 2;
        int count = 1;
        for(int i = 3; count < primes.length; i += 2) {
            if(isPrime(i)) {
                primes[count] = i;
                ++count;
            }
        }
        
        int minsum = 1000000000;
        for(int i = 0; i < primes.length && primes[i] < minsum; ++i) {
            for(int j = i+1; j < primes.length && primes[i] + primes[j] < minsum; ++j) {
                if(isPrime(cat(primes[i],primes[j])) && isPrime(cat(primes[j],primes[i]))) {
                    for(int k = j+1; k < primes.length && primes[i] + primes[j] + primes[k] < minsum; ++k) {
                        if(isPrime(cat(primes[i],primes[k])) && isPrime(cat(primes[k],primes[i]))
                        && isPrime(cat(primes[j],primes[k])) && isPrime(cat(primes[k],primes[j]))) {
                            for(int l = k+1; l < primes.length && primes[i] + primes[j] + primes[k] + primes[l] < minsum; ++l) {
                                if(isPrime(cat(primes[i],primes[l])) && isPrime(cat(primes[l],primes[i]))
                                && isPrime(cat(primes[j],primes[l])) && isPrime(cat(primes[l],primes[j]))
                                && isPrime(cat(primes[k],primes[l])) && isPrime(cat(primes[l],primes[k]))) {
                                    for(int m = l+1; m < primes.length && primes[i] + primes[j] + primes[k] + primes[l] + primes[m] < minsum; ++m) {
                                        if(isPrime(cat(primes[i],primes[m])) && isPrime(cat(primes[m],primes[i]))
                                        && isPrime(cat(primes[j],primes[m])) && isPrime(cat(primes[m],primes[j]))
                                        && isPrime(cat(primes[k],primes[m])) && isPrime(cat(primes[m],primes[k]))
                                        && isPrime(cat(primes[l],primes[m])) && isPrime(cat(primes[m],primes[l]))) {
                                            if(primes[i] + primes[j] + primes[k] + primes[l] + primes[m] < minsum) {
                                                minsum =  primes[i] + primes[j] + primes[k] + primes[l] + primes[m];
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return minsum;
    }
    
    public BigInteger cat(int l, int r) {
        return new BigInteger(l+""+r,10);
    }

    public static void main(String args[]) {
        System.out.println((new Problem60()).eulerProblem60());
    }
    
    private HashMap<BigInteger,Integer> phash = new HashMap<BigInteger,Integer>();
    
    public boolean isPrime(BigInteger n) {
        if(phash.containsKey(n)) {
            return true;
        }
    
        if(n.isProbablePrime(1)) {
            phash.put(n, 1);
            return true;
        }
        return false;
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
