//solution: 153
public class Problem57 {

    public int eulerProblem57() {
        int count = 0;
        for(int i = 0; i < 1000; ++i) {
            BigRational b = BigRational.ONE.add(BigRational.ONE.divide(nthIterContFracSqRt2(i)));
            if(b.num.toString().length() > b.den.toString().length()) {
                ++count;
            }
        }
        return count;
    }
    
    public BigRational nthIterContFracSqRt2(int iter) {
        if(iter == 0) {
            return new BigRational(2);
        }
        
        return (new BigRational(2)).add(BigRational.ONE.divide(nthIterContFracSqRt2(iter-1)));
    }

    public static void main(String args[]) {
        System.out.println((new Problem57()).eulerProblem57());
    }

}
