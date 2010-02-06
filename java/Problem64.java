//solution: 1322
import java.util.*;
public class Problem64 {

    public int eulerProblem64() {
        HashMap<String,Boolean> ps = new HashMap<String,Boolean>();
        for(int i = 2; i <= 100; ++i) {
            ps.put((i*i)+"", true);
        }
        
        int count = 0;
        for(int i = 2; i <= 10000; ++i) {
            if(ps.containsKey(i+"")) {
                continue;
            }
            if(contFracPer(i, 0, 1) % 2 != 0) {
                ++count;
            }
        }
        return count;
    }
    
    public int contFracPer(int s, int m, int d) {
        if(d == 1 && m != 0) {
            return 0;
        }
        int a = (int)((Math.sqrt(s)+m)/d);
        m = d * a - m;
        return 1 + contFracPer(s, m, (s - m*m)/d);
    }
    
    public static void main(String args[]) {
        System.out.println((new Problem64()).eulerProblem64());
    }

}
