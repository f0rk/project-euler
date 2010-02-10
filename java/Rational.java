public class Rational extends Number implements Comparable<Rational> {
    
    private static final long serialVersionUID = 4831114521130586940L;

    public final long num;
    public final long den;

    public static final Rational ZERO = new Rational(0);
    public static final Rational ONE = new Rational(1);
    public static final Rational TWO = new Rational(2);
    
    public Rational(Rational r) {
        this(r.num, r.den);
    }
    
    public Rational(int num) {
        this(num, 1);
    }
    
    public Rational(long num) {
        this(num, 1L);
    }

    public Rational(int num, int den) {
        this((long)num, (long)den);
    }

    public Rational(long num, long den) {
        if(den == 0) {
            throw new ArithmeticException("Denominator is zero");
        }
        
        if(den < 0) {
            num = -num;
            den = -den;
        }
        
        long gcd = gcd(num, den);
        num = num / gcd;
        den = den / gcd;
        this.num = num;
        this.den = den;
    }
    
    public static long gcd(long a, long b) {
        if(a < b) {
            long t = a;
            a = b;
            b = t;
        }
        long t;
        while(b != 0) {
            t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public double doubleValue() {
        return ((double)this.num) / this.den;
    }

    public float floatValue() {
        return ((float)this.num) / this.den;
    }

    public int intValue() {
        return (int)(this.num / this.den);
    }

    public long longValue() {
        return this.num / this.den;
    }

    public String toString() {
        if (this.den == 1) {
            return this.num + "";
        } else {
            return this.num + "/" + this.den;
        }
    }
    
    public Rational add(Rational b) {
        return new Rational(this.num * b.den + b.num * this.den, this.den * b.den);
    }

    public Rational subtract(Rational b) {
        return this.add(b.negate());
    }
    
    public Rational multiply(Rational b) {
        return new Rational(this.num * b.num, this.den * b.den);
    }

    public Rational divide(Rational b) {
        return new Rational(this.num * b.den, this.den * b.num);
    }
    
    public Rational negate() {
        return new Rational(-this.num, this.den);
    }

    public Rational reciprocal() {
        return new Rational(this.den, this.num);
    }
    
    public Rational abs() {
        return new Rational(this.num < 0 ? -this.num : this.num, this.den);
    }

    public int compareTo(Rational b) {
        long sn = this.subtract(b).num;
        if(sn < 0) {
            return -1;
        } else if(sn > 0) {
            return 1;
        }
        return 0;
    }
    
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        
        if(o == null) {
            return false; 
        }
        
        if(o.getClass() != this.getClass()) {
            return false;
        }
        
        return (this.compareTo((Rational) o) == 0);
    }
    
    public int hashCode() {
        return this.toString().hashCode();
    }
}
