//solution: 972
import java.math.*;
public class Problem56 {

    public int eulerProblem56() {
        int max = 0;
        for(int i = 1; i < 100; ++i) {
            for(int j = 1; j < 100; ++j) {
                int sum = sumOfDigits(((new BigInteger(i+"")).pow(j)).toString());
                if(sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
    
    public int sumOfDigits(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '1') {
                sum += 1;
            } else if(s.charAt(i) == '2') {
                sum += 2;
            } else if(s.charAt(i) == '3') {
                sum += 3;
            } else if(s.charAt(i) == '4') {
                sum += 4;
            } else if(s.charAt(i) == '5') {
                sum += 5;
            } else if(s.charAt(i) == '6') {
                sum += 6;
            } else if(s.charAt(i) == '7') {
                sum += 7;
            } else if(s.charAt(i) == '8') {
                sum += 8;
            } else if(s.charAt(i) == '9') {
                sum += 9;
            }
        }
        return sum;
    }

    public static void main(String args[]) {
        System.out.println((new Problem56()).eulerProblem56());
    }

}
