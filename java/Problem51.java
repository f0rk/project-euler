//solution: 121313
import java.util.*;
public class Problem51 {

    public int eulerProblem51() {
        int minPrime = 1000000;
        for(int i = 99; i < 200000; i += 2) {
            if(isPrime(i)) {
                String s = "" + i;
                String digits[] = splitToChars(s);
                for(int j = 1; j < digits.length; ++j) { //how many replacements
                    for(int k = 1; k <= nCr(digits.length, j); ++k) { //position in number of replacements
                        int primesCount = 0;
                        int canMinPrime = 1000000;
                        for(int rep = 1; rep < 10; ++rep) { //number to use as the replacement
                            String[] arr = combination(copyStrArray(digits), ""+rep, j, k, 0, digits.length);
                            int check = intFromStrArray(arr);
                            if(isPrime(check)) {
                                if(canMinPrime > check) {
                                    canMinPrime = check;
                                }
                                ++primesCount;
                                if(primesCount == 8) {
                                    if(minPrime > canMinPrime) {
                                        minPrime = canMinPrime;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return minPrime;
    }
    
    public String[] splitToChars(String in) {
        String[] ret = new String[in.length()];
        for(int i = 0; i < in.length(); ++i) {
            ret[i] = in.charAt(i) + "";
        }
        return ret;
    }
    
    public String[] copyStrArray(String[] in) {
        String[] ret = new String[in.length];
        for(int i = 0; i < in.length; ++i) {
            ret[i] = in[i];
        }
        return ret;
    }
    
    public String[] combination(String[] arr, String rep, int times, int pos, int low, int elems) {
        if(times == 1) {
            arr[low+pos-1] = rep;
            return arr;
        }
        
        int n = elems - 1;
        int k = times - 1;
        int count = 0;
        int ncr = nCr(n, k);
        while(ncr < pos) { 
            pos -= ncr;
            --n;
            ++count;
            ncr = nCr(n, k);
        }
        
        arr[low + count] = rep;
        return combination(arr, rep, times - 1, pos, low + count + 1, n);
    }
    
    public int nCr(int n, int k) {
        if(k <= 0 || n <= 0) {
            return 0;
        }
        
        if(k > n) {
            return 0;
        }
        return factorial(n) / (factorial(k) * factorial(n-k));
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
    
    public int intFromStrArray(String[] arr) {
        int ret = 0; int mul = 1;
        for(int i = arr.length - 1; i >= 0; --i) {
            if(arr[i].equals("1")) {
                ret += 1 * mul;
            } else if(arr[i].equals("2")) {
                ret += 2 * mul;
            } else if(arr[i].equals("3")) {
                ret += 3 * mul;
            } else if(arr[i].equals("4")) {
                ret += 4 * mul;
            } else if(arr[i].equals("5")) {
                ret += 5 * mul;
            } else if(arr[i].equals("6")) {
                ret += 6 * mul;
            } else if(arr[i].equals("7")) {
                ret += 7 * mul;
            } else if(arr[i].equals("8")) {
                ret += 8 * mul;
            } else if(arr[i].equals("9")) {
                ret += 9 * mul;
            }
            mul *= 10;
        }
        return ret;
    }

    public static void main(String args[]) {
        Problem51 problem = new Problem51();
        System.out.println(problem.eulerProblem51());
    }
    
    private HashMap<Integer,Integer> phash = new HashMap<Integer,Integer>();
    
    public boolean isPrime(int n) {
        if(phash.containsKey(n)) {
            return true;
        }
    
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
        
        phash.put(n, 1);
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
        
        phash.put(n, 1);
        return true;
    }

}
