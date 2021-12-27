package Scalar;

public abstract class Scalar extends Object {

    public boolean isMatch(Scalar s){
        return this.ScalarType()==s.ScalarType();
    }
    public abstract boolean ScalarType();
    public abstract Scalar add(Scalar s);
    public abstract Scalar mul(Scalar s);
    public abstract Scalar mul(int i);
    public Scalar power(int exp){
            Scalar ans = getOne();
            Scalar temp = this;
            while (exp>0){
                ans =ans.mul(temp);
                exp--;
            }
            return ans;
        }
    public abstract double getValue();
    public abstract Scalar getOne();
    public int sign(){
        if (this.getValue()<0) return -1;
        else return 1;
    }
    public abstract Integer getA();
    public abstract Integer getB();
}
