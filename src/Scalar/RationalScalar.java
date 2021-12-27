package Scalar;

public class RationalScalar extends Scalar {
    private int a;
    private int b;

    public RationalScalar(int a, int b) {
        if (b==0)
            throw new IllegalArgumentException("can not divide by zero");
        this.a=a;
        this.b=b;
    }

    public boolean ScalarType(){return false;}
    public Scalar add(Scalar s) {
        if (!isMatch(s))
            return null;
        int first = s.getA()*this.b;
        int second = s.getB()*this.a;
        int sum = first+second;
        int div = this.b*s.getB();
        return new RationalScalar(sum,div);
    }
    public Scalar mul(Scalar s) {
        if (!isMatch(s))
            return null;
        return new RationalScalar(a*s.getA(),b*s.getB());
    }
    public Scalar mul(int i) {
        Scalar mul = new RationalScalar(a*i, b);
        return mul;
    }
    public Scalar getOne(){ return new RationalScalar(1,1);}
    public String toString() {
        String out="";
        boolean pos=true;
        if (a<0 & b<0 |(a>=0 & b<0))
        {
            a=-1*a;
            b=-1*b;
        }
        if (a%b==0)
        {
            Integer res =a/b;
            return res.toString();
        }
        else
        {
            return out + "("+a + "/" + b + ")";
        }
    }
    public Integer getA()
    {
        return this.a;
    }
    public Integer getB()
    {
        return this.b;
    }
    public double getValue()
    {
        return ((a/b)+((a%b)/b));
    }

}