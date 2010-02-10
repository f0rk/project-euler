//solution: 161667
public class Problem75 {

    public int eulerProblem75() {
        int limit = 1500000;
        int[] ps = new int[limit];
        for(int n = 1; n < Math.sqrt(limit); n += 2) {
            for(int m = 2; m < Math.sqrt(limit); m += 2) {
                if(this.gcd(n, m) == 1) {
                    int p = Math.abs(m*m - n*n) + 2*n*m + n*n + m*m;
                    for(int x = p; x < limit; x += p) {
                        ps[x]++;
                    }
                }
            }
        }
        int ct = 0;
        for(int i = 0; i < ps.length; ++i) {
            if(ps[i] == 1) {
                ++ct;
            }
        }
        return ct;
    }
    
    public static int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String args[]) {
        System.out.println((new Problem75()).eulerProblem75());
    }

}
