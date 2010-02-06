//solution: 127035954683
import java.util.*;
public class Problem62 {

    public long eulerProblem62() {
        long[] cubes = new long[10000];
        for(long i = 0; i < cubes.length; ++i) {
            cubes[(int)i] = i*i*i;
        }
        
        for(int i = 0; i < cubes.length; ++i) {
            ArrayList<Long> chk = filter(cubes[i], cubes);
            if(chk.size() == 5) {
                return chk.get(0);
            }
        }
        return 0;
    }
    
    public ArrayList<Long> filter(long n, long[] arr) {
        ArrayList<Long> ret = new ArrayList<Long>();
        for(int i = 0; i < arr.length; ++i) {
            if(isPermutation(n+"", arr[i]+"")) {
                ret.add(arr[i]);
            }
        }
        return ret;
    }
    
    public boolean isPermutation(String is, String ns) {
        if(is.length() != ns.length()) {
            return false;
        }
        char[] ia = new char[is.length()];
        char[] na = new char[ns.length()];
        is.getChars(0, ia.length, ia, 0);
        ns.getChars(0, na.length, na, 0);
        Arrays.sort(ia); Arrays.sort(na);
        for(int i = 0; i < ia.length; ++i) {
            if(ia[i] != na[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println((new Problem62()).eulerProblem62());
    }

}
