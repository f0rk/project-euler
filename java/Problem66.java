//solution: 661
import java.util.*;
import java.math.*;
public class Problem66 {

    public int eulerProblem66() {
        BigInteger max = BigInteger.ZERO;
        BigInteger maxD = BigInteger.ZERO;
        for(int D = 2; D <= 1000; ++D) {
            if(IsPerfectSquare.isPerfectSquare(D)) {
                continue;
            }
            int cur = 0;
            BigInteger x = BigInteger.ONE;
            BigInteger y = BigInteger.ONE;
            BigInteger d = new BigInteger(""+D);
            while(x.pow(2).subtract(y.pow(2).multiply(d)).compareTo(BigInteger.ONE) != 0) {
                Stack s = convCoeffs(d, cur);
                BigRational r = new BigRational(0);
                while(s.size() != 1) {
                    BigInteger pp = s.pop();
                    r = BigRational.ONE.divide((new BigRational(pp, BigInteger.ONE)).add(r));
                }
                BigInteger pp = s.pop();
                r = r.add(new BigRational(pp, BigInteger.ONE));
                x = r.num;
                y = r.den;
                ++cur;
                if(x.compareTo(max) > 0) {
                    max = x;
                    maxD = d;
                }
            }
        }
        return maxD.intValue();
    }
    
    public Stack convCoeffs(BigInteger S, long n) {
        BigInteger ss = (new BigSquareRoot()).get(new BigDecimal(S)).toBigInteger();
        BigInteger m0 = BigInteger.ZERO;
        BigInteger d0 = BigInteger.ONE;
        BigInteger a0 = ss;
        BigInteger m1 = d0.multiply(a0).subtract(m0);
        BigInteger d1 = S.subtract(m1.multiply(m1)).divide(d0);
        BigInteger a1 = ss.add(m1).divide(d1);
        Stack s = new Stack();
        s.push(a0);
        for(int i = 0; i < n; ++i) {
            m1 = d0.multiply(a0).subtract(m0);
            d1 = S.subtract(m1.multiply(m1)).divide(d0);
            a1 = ss.add(m1).divide(d1);
            s.push(a1);
            a0 = a1;
            m0 = m1;
            d0 = d1;
        }
        return s;
    }

    public static void main(String args[]) {
        System.out.println((new Problem66()).eulerProblem66());
    }
    
    //lightweight stack for longs
    private class Stack {
        private int cur = 0;
        private int INIT_CAP = 20;
        private BigInteger[] stack;
        
        public Stack() {
            stack = new BigInteger[INIT_CAP];
        }
        
        public void push(BigInteger n) {
            if(cur + 1 == stack.length) {
                BigInteger[] t = new BigInteger[stack.length*2];
                System.arraycopy(stack, 0, t, 0, stack.length - 1);
                stack = t;
            }
            stack[cur] = n;
            ++cur;
        }
        
        public BigInteger pop() {
            if(cur == 0) {
                throw new EmptyStackException();
            }
            --cur;
            return stack[cur];
        }
        
        public BigInteger peek() {
            return stack[cur-1];
        }
        
        public boolean poppable() {
            return cur != 0;
        }
        
        public int size() {
            return cur;
        }
    }
}
