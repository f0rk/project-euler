//solution: 428570
public class Problem71 {

    public long eulerProblem71() {
        return fareySequence(new Rational(0, 1), new Rational(3, 7));
    }
    
    public long fareySequence(Rational a, Rational b) {
        while(a.den <= 1000000) {
            a = new Rational(a.num + b.num, a.den + b.den);
        }
        return a.num - b.num;
    }

    public static void main(String args[]) {
        System.out.println((new Problem71()).eulerProblem71());
    }

}
