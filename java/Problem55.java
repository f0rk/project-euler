//solution: 249
import java.math.*;
public class Problem55 {

    public int eulerProblem55() {
        int count = 0;
        for(int i = 0; i < 10000; i = ++i) {
            BigInteger k = new BigInteger(i+"");
            for(int j = 0; j < 50; ++j) {
                k = k.add(new BigInteger(reverse(k.toString()), 10));
                if(isPalindrome(k.toString())) {
                    ++count;
                    break;
                }
            }
        }
        return 10000 - count;
    }
    
    public boolean isPalindrome(String s) {
        return s.equals(reverse(s));
    }
    
    public String reverse(String s) {
        char arr[] = new char[s.length()];
        for(int i = s.length() - 1; i >= 0; --i) {
            arr[s.length() - i - 1] = s.charAt(i);
        }
        return new String(arr);
    }

    public static void main(String args[]) {
        System.out.println((new Problem55()).eulerProblem55());
    }

}
