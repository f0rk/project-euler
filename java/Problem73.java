//solution: 7295372
public class Problem73 {

    public int eulerProblem73() {
        return fareyCount(12000, new Rational(1, 3), new Rational(1, 2));
    }
    
    public int fareyCount(int n, Rational a, Rational b) {
        Rational m = new Rational(a.num + b.num, a.den + b.den);
        if(m.den > n) {
            return 0;
        }
        return 1 + fareyCount(n, a, m) + fareyCount(n, m, b);
    }

    public static void main(String args[]) {
        System.out.println((new Problem73()).eulerProblem73());
    }

}
