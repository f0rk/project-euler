//solution: 142857
import java.util.*;
public class Problem52 {

    public int eulerProblem52() {
        for(int i = 1;; ++i) {
            String[] x = splitToChars(i+"");
            String[] x2 = splitToChars((2*i)+"");
            String[] x3 = splitToChars((3*i)+"");
            String[] x4 = splitToChars((4*i)+"");
            String[] x5 = splitToChars((5*i)+"");
            String[] x6 = splitToChars((6*i)+"");
            Arrays.sort(x);
            Arrays.sort(x2);
            Arrays.sort(x3);
            Arrays.sort(x4);
            Arrays.sort(x5);
            Arrays.sort(x6);
            if(x.length == x2.length
            && x.length == x3.length
            && x.length == x4.length
            && x.length == x5.length
            && x.length == x6.length) {
                boolean ret = false;
                for(int j = 0; j < x.length; ++j) {
                    if(x[j].equals(x2[j])
                    && x[j].equals(x3[j])
                    && x[j].equals(x4[j])
                    && x[j].equals(x5[j])
                    && x[j].equals(x6[j])) {
                        ret = true;
                    } else {
                        ret = false;
                        break;
                    }
                }
                if(ret) {
                    return i;
                }
            }
        }
    }
    
    public String[] splitToChars(String in) {
        String[] ret = new String[in.length()];
        for(int i = 0; i < in.length(); ++i) {
            ret[i] = in.charAt(i) + "";
        }
        return ret;
    }

    public static void main(String args[]) {
        System.out.println((new Problem52()).eulerProblem52());
    }

}
