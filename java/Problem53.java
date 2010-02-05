//solution: 4075
import java.math.*; 
public class Problem53 {

    public int eulerProblem53() {
        int count = 0;
        BigInteger mil = new BigInteger("1000000");
        BigInteger hun = new BigInteger("100");
        for(BigInteger n = BigInteger.ONE; n.compareTo(hun) <= 0; n = n.add(BigInteger.ONE)) {
            for(BigInteger r = BigInteger.ONE; r.compareTo(n) <= 0; r = r.add(BigInteger.ONE)) {
                if(nCr(n,r).compareTo(mil) > 0) {
                    ++count;
                }
            }
        }
        return count;
    }

    public BigInteger nCr(BigInteger n, BigInteger k) {
        if(k.compareTo(BigInteger.ZERO) <= 0 || n.compareTo(BigInteger.ZERO) <= 0) {
            return BigInteger.ZERO;
        }
        
        if(k.compareTo(n) > 0) {
            return BigInteger.ZERO;
        }
        
        return factorial(n).divide((factorial(k).multiply(factorial(n.subtract(k)))));
    }
    
    public BigInteger factorial(BigInteger n) {        
        if(n.compareTo(BigInteger.ZERO) == 0) {
            return BigInteger.ONE;
        }
        
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }

    public static void main(String args[]) {
        System.out.println((new Problem53()).eulerProblem53());
    }

}
