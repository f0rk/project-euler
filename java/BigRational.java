import java.math.BigInteger;

public class BigRational extends Number implements Comparable<BigRational> {
    
    private static final long serialVersionUID = 4831114521130586940L;

    public final BigInteger num;
    public final BigInteger den;

    public static final BigRational ZERO = new BigRational(0);
    public static final BigRational ONE = new BigRational(1);
    public static final BigRational TWO = new BigRational(2);
    
    public BigRational(BigRational r) {
        this(r.num, r.den);
    }
    
    public BigRational(int num) {
        this(num, 1);
    }
    
    public BigRational(long num) {
        this(num, 1L);
    }

    public BigRational(int num, int den) {
        this(new BigInteger(num+""), new BigInteger(den+""));
    }

    public BigRational(long num, long den) {
        this(new BigInteger(num+""), new BigInteger(den+""));
    }

    public BigRational(String s) {
        this(s.split("/"));
    }
    
    public BigRational(String[] tok) {
        this(new BigInteger(tok[0]), tok.length == 1 ? BigInteger.ONE : tok.length == 2 ? new BigInteger(tok[1]) : BigInteger.ZERO);
    }
    
    public BigRational(String num, String den) {
        this(new BigInteger(num), new BigInteger(den));
    }

    public BigRational(BigInteger num, BigInteger den) {
        if(den.compareTo(BigInteger.ZERO) == 0) {
            throw new ArithmeticException("Denominator is zero");
        }
        
        if(den.compareTo(BigInteger.ZERO) < 0) {
            num = num.negate();
            den = den.negate();
        }
        
        BigInteger gcd = num.gcd(den);
        num = num.divide(gcd);
        den = den.divide(gcd);
        this.num = num;
        this.den = den;
    }

    public double doubleValue() {
        return this.num.doubleValue() / this.den.doubleValue();
    }

    public float floatValue() {
        return this.num.floatValue() / this.den.floatValue();
    }

    public int intValue() {
        return (this.num.divide(this.den)).intValue();
    }

    public long longValue() {
        return (this.num.divide(this.den)).longValue();
    }

    public BigInteger bigIntegerValue() {
        return this.num.divide(this.den);
    }

    public String toString() {
        if (this.den.equals(BigInteger.ONE)) {
            return this.num.toString();
        } else {
            return this.num.toString() + "/" + this.den.toString();
        }
    }
    
    public BigRational add(BigRational b) {
        return new BigRational(this.num.multiply(b.den).add(b.num.multiply(this.den)),
                   this.den.multiply(b.den));
    }

    public BigRational subtract(BigRational b) {
        return this.add(b.negate());
    }
    
    public BigRational multiply(BigRational b) {
        return new BigRational(this.num.multiply(b.num), this.den.multiply(b.den));
    }

    public BigRational divide(BigRational b) {
        return new BigRational(this.num.multiply(b.den), this.den.multiply(b.num));
    }
    
    public BigRational negate() {
        return new BigRational(this.num.negate(), this.den);
    }

    public BigRational reciprocal() {
        return new BigRational(this.den, this.num);
    }
    
    public BigRational abs() {
        return new BigRational(this.num.abs(), this.den);
    }

    public int compareTo(BigRational b) {
        return this.subtract(b).num.compareTo(BigInteger.ZERO);
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
        
        return (this.compareTo((BigRational) o) == 0);
    }
    
    public int hashCode() {
        return this.toString().hashCode();
    }
}
