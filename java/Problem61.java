//solution: 28684
import java.util.*;
public class Problem61 {

    public int eulerProblem61() {
        ArrayList<Integer> tri = new ArrayList<Integer>();
        for(int i = 0;; ++i) {
            int n = nthTriangular(i);
            if(n >= 10000) {
                break;
            }
            if(n >= 1000) {
                tri.add(n);
            }
        } 
        
        ArrayList<Integer> squ = new ArrayList<Integer>();
        for(int i = 0;; ++i) {
            int n = nthSquare(i);
            if(n >= 10000) {
                break;
            }
            if(n >= 1000) {
                squ.add(n);
            }
        } 
        
        ArrayList<Integer> pen = new ArrayList<Integer>();
        for(int i = 0;; ++i) {
            int n = nthPentagonal(i);
            if(n >= 10000) {
                break;
            }
            if(n >= 1000) {
                pen.add(n);
            }
        }
        
        ArrayList<Integer> hex = new ArrayList<Integer>();
        for(int i = 0;; ++i) {
            int n = nthHexagonal(i);
            if(n >= 10000) {
                break;
            }
            if(n >= 1000) {
                hex.add(n);
            }
        }
        
        ArrayList<Integer> hep = new ArrayList<Integer>();
        for(int i = 0;; ++i) {
            int n = nthHeptagonal(i);
            if(n >= 10000) {
                break;
            }
            if(n >= 1000) {
                hep.add(n);
            }
        }
        
        ArrayList<Integer> oct = new ArrayList<Integer>();
        for(int i = 0;; ++i) {
            int n = nthOctagonal(i);
            if(n >= 10000) {
                break;
            }
            if(n >= 1000) {
                oct.add(n);
            }
        }
        
        ArrayList[] seq = new ArrayList[6];
        for(int i = 0; i < 720; ++i) {
            seq[0] = tri;
            seq[1] = squ;
            seq[2] = pen;
            seq[3] = hex;
            seq[4] = hep;
            seq[5] = oct;
            seq = permutation(i, seq);
            int ret = check(seq[0], seq[1], seq[2], seq[3], seq[4], seq[5]);
            if(ret > 0) {
                return ret;
            }
        }
        
        return 0; 
    }
    
    public ArrayList<Integer>[] permutation(int pos, ArrayList<Integer>[] seq) {
        int n = seq.length; int factorial = 1;
        for(int i = 2; i < n; ++i) {
            factorial *= i;
        }

        for(int i = 0; i < n - 1; ++i) {
            int ti = (pos / factorial) % (n - i);
            ArrayList<Integer> ts = seq[i + ti];
            for(int j = i + ti; j > i; --j) {
                seq[j] = seq[j - 1];
            }
            seq[i] = ts;
            factorial = factorial / (n - (i + 1));
        }
        return seq;
    }
    
    public int check(ArrayList<Integer> al1, ArrayList<Integer> al2, ArrayList<Integer> al3, ArrayList<Integer> al4, ArrayList<Integer> al5, ArrayList<Integer> al6) {
        for(int i = 0; i < al1.size(); ++i) {
            ArrayList<Integer> fal2 = filter(gete(al1.get(i)), al2);
            for(int j = 0; j < fal2.size(); ++j) {
                ArrayList<Integer> fal3 = filter(gete(fal2.get(j)), al3);
                for(int k = 0; k < fal3.size(); ++k) {
                    ArrayList<Integer> fal4 = filter(gete(fal3.get(k)), al4);
                    for(int l = 0; l < fal4.size(); ++l) {
                        ArrayList<Integer> fal5 = filter(gete(fal4.get(l)), al5);
                        for(int m = 0; m < fal5.size(); ++m) {
                            ArrayList<Integer> fal6 = filter(gete(fal5.get(m)), al6);
                            for(int n = 0; n < fal6.size(); ++n) {
                                if(gete(fal6.get(n)).equals(getb(al1.get(i)))) {
                                    return al1.get(i) + fal2.get(j) + fal3.get(k)
                                        + fal4.get(l) + fal5.get(m) + fal6.get(n);
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
    
    public ArrayList<Integer> filter(String beg, ArrayList<Integer> arr) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i < arr.size(); ++i) {
            if((""+arr.get(i)).startsWith(beg)) {
                ret.add(arr.get(i));
            }
        }
        return ret;
    }
    
    public String getb(int n) {
        return (""+n).substring(0,2);
    }
    
    public String gete(int n) {
        return (""+n).substring(2,4);
    }
    
    public int nthTriangular(int n) {
        return n*(n-1)/2;
    }
    
    public int nthSquare(int n) {
        return n*n;
    }
    
    public int nthPentagonal(int n) {
        return n*(3*n-1)/2;
    }
    
    public int nthHexagonal(int n) {
        return n*(2*n-1);
    }
    
    public int nthHeptagonal(int n) {
        return n*(5*n-3)/2;
    }
    
    public int nthOctagonal(int n) {
        return n*(3*n-2);
    }

    public static void main(String args[]) {
        System.out.println((new Problem61()).eulerProblem61());
    }

}
