//solution: 6531031914842725
import java.util.*;
import java.math.*;
public class Problem68 {

    public BigInteger eulerProblem68() {
        int p0, p1, p2, p3, p4, p5, p6, p7, p8, p9;
        Stack<BigInteger> s = new Stack<BigInteger>();
        for(p0 = 1; p0 <= 10; ++p0) {
            for(p1 = 1; p1 <= 10; ++p1) {
                if(p1 == p0) { continue; }
                for(p5 = 1; p5 <= 10; ++p5) {
                    if(p5 == p1 || p5 == p0) { continue; }
                    //all other lines must equal p5 + p0 + p1
                    //determine p6 and p2 based on p1 => p6 + p2 == p5 + p0
                    for(p2 = 1; p2 <= 10; ++p2) {
                        if(p2 == p0 || p2 == p1 || p2 == p5) { continue; }
                        p6 = p5 + p0 - p2;
                        if(p6 < 1 || p6 > 10 || p6 == p0 || p6 == p1 || p6 == p2 || p6 == p5) { continue; }
                        //now we have p0, p1, p2, p5, and p6
                        for(p3 = 1; p3 <= 10; ++p3) {
                            if(p3 == p0 || p3 == p1 || p3 == p2 || p3 == p5 || p3 == p6) { continue; }
                            p7 = p1 + p6 - p3;
                            if(p7 < 1 || p7 > 10 || p7 == p0 || p7 == p1 || p7 == p2 || p7 == p3 || p7 == p5 || p7 == p6) { continue; }
                            //now we have p0, p1, p2, p3, p5, p6, p7
                            for(p4 = 1; p4 <= 10; ++p4) {
                                if(p4 == p0 || p4 == p1 || p4 == p2 || p4 == p3 || p4 == p5 || p4 == p6 || p4 == p7) { continue; }
                                p8 = p7 + p2 - p4;
                                if(p8 < 1 || p8 > 10 || p8 == p0 || p8 == p1 || p8 == p2 || p8 == p3 || p8 == p4 || p8 == p5 || p8 == p6 || p8 == p7) { continue; }
                                p9 = p8 + p3 - p0;
                                if(p9 < 1 || p9 > 10 || p9 == p0 || p9 == p1 || p9 == p2 || p9 == p3 || p9 == p4 || p9 == p5 || p9 == p6 || p9 == p7 || p9 == p8) { continue; }
                                //valid ring
                                String ring = ringString(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
                                if(ring.length() != 16) { continue; }
                                s.push(new BigInteger(ring));
                            }
                        }
                    }
                }
            }
        }
        BigInteger max = BigInteger.ZERO;
        while(!s.empty()) {
            BigInteger b = s.pop();
            if(max.compareTo(b) < 0) {
                max = b;
            }
        }
        return max;
    }
    
    public String ringString(int p0, int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8, int p9) {
        String ret = "";
        if(p5 < p6 && p5 < p7 && p5 < p8 && p5 < p9) { //p5 smallest
            ret += p5 + "" + p0 + "" + p1;
            ret += p6 + "" + p1 + "" + p2;
            ret += p7 + "" + p2 + "" + p3;
            ret += p8 + "" + p3 + "" + p4;
            ret += p9 + "" + p4 + "" + p0;
        } else if(p6 < p5 && p6 < p7 && p6 < p8 && p6 < p9) { //p6 smallest
            ret += p6 + "" + p1 + "" + p2;
            ret += p7 + "" + p2 + "" + p3;
            ret += p8 + "" + p3 + "" + p4;
            ret += p9 + "" + p4 + "" + p0;
            ret += p5 + "" + p0 + "" + p1;
        } else if(p7 < p5 && p7 < p6 && p7 < p8 && p7 < p9) { //p7 smallest
            ret += p7 + "" + p2 + "" + p3;
            ret += p8 + "" + p3 + "" + p4;
            ret += p9 + "" + p4 + "" + p0;
            ret += p5 + "" + p0 + "" + p1;
            ret += p6 + "" + p1 + "" + p2;
        } else if(p8 < p5 && p8 < p6 && p8 < p7 && p8 < p9) { //p8 smallest
            ret += p8 + "" + p3 + "" + p4;
            ret += p9 + "" + p4 + "" + p0;
            ret += p5 + "" + p0 + "" + p1;
            ret += p6 + "" + p1 + "" + p2;
            ret += p7 + "" + p2 + "" + p3;
        } else { //p9 smallest
            ret += p9 + "" + p4 + "" + p0;
            ret += p5 + "" + p0 + "" + p1;
            ret += p6 + "" + p1 + "" + p2;
            ret += p7 + "" + p2 + "" + p3;
            ret += p8 + "" + p3 + "" + p4;
        }
        return ret;
    }

    public static void main(String args[]) {
        System.out.println((new Problem68()).eulerProblem68());
    }

}
