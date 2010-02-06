//solution: 49
import java.math.*;
public class Problem63 {

    public int eulerProblem63() {
        int count = 0;
        for(int i = 1; i < 10; ++i) {
            for(int j = 1; j < 24; ++j) {
                BigInteger r = (new BigInteger(i+"")).pow(j);
                if(r.toString().length() == j) {
                    ++count;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        System.out.println((new Problem63()).eulerProblem63());
    }

}
