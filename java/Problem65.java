//solution: 272
public class Problem65 {

    public int eulerProblem65() {
        BigRational r = BigRational.TWO.add(nthConv(0,99));
        String num = r.num.toString();
        int sum = 0;
        for(int i = 0; i < num.length(); ++i) {
            if(num.charAt(i) == '1') {
                sum += 1;
            } else if(num.charAt(i) == '2') {
                sum += 2;
            } else if(num.charAt(i) == '3') {
                sum += 3;
            } else if(num.charAt(i) == '4') {
                sum += 4;
            } else if(num.charAt(i) == '5') {
                sum += 5;
            } else if(num.charAt(i) == '6') {
                sum += 6;
            } else if(num.charAt(i) == '7') {
                sum += 7;
            } else if(num.charAt(i) == '8') {
                sum += 8;
            } else if(num.charAt(i) == '9') {
                sum += 9;
            }
        }
        return sum;
    }
    
    public BigRational nthConv(int n, int limit) {
        BigRational add = BigRational.ONE;
        if(n % 3 == 1) {
            int k = (n-1)/3+1;
            add = BigRational.TWO.multiply(new BigRational(k));
        }
        if(n == limit) {
            return BigRational.ZERO;
        }
        return BigRational.ONE.divide(add.add(nthConv(++n, limit)));
    }

    public static void main(String args[]) {
        System.out.println((new Problem65()).eulerProblem65());
    }

}
