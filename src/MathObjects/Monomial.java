package MathObjects;

import Scalar.Scalar;
import Scalar.RationalScalar;
import Scalar.RealScalar;

public class Monomial extends Object {
    private Scalar coe;
    private int exp;

    public Monomial(Scalar coe, int exp){
        if (exp<0)
            throw new IllegalArgumentException("exp can not be negative");
        this.coe=coe;
        this.exp=exp;
    }

    public boolean isMatch(Monomial m){
        if (this.coe.isMatch(m.getCoe())) return true;
        return false;
    }
    public boolean canAdd(Monomial m){
        if ((this.isMatch(m)) & (this.exp==m.getExp()))
                return true;
        return false;
    }
    public Monomial add(Monomial m){
        if (!this.canAdd(m))
            return null;
        Scalar s = this.coe.add(m.getCoe());
        Monomial ans = new Monomial(s,exp);
        return ans;
    }
    public Monomial mul(Monomial m){
        if (!this.isMatch(m))
            return null;
        Scalar s = this.coe.mul(m.getCoe());
        return new Monomial(s,this.exp+m.getExp());
    }
    public Scalar evaluate(Scalar scalar) {
        if (coe.isMatch(scalar)) {
            Scalar temp = scalar.power(exp);
            return coe.mul(temp);
        }
        else return null;
    }
    public Monomial derivative(){
        if (exp==0) { // check the type of the monomonial
            if (this.coe.ScalarType()) // realScalar
                return new Monomial(new RealScalar(0),0);
            else
                return new Monomial(new RationalScalar(0,1),0);
        }
        return new Monomial(coe.mul(exp), exp - 1);
    }
    public int sign(){
        return coe.sign();
    }
    public String toString(){
        String out = "";
        if (this.exp==0)
            return coe.toString();

        if (this.coe.ScalarType()) { // realScalar
            if (this.coe.getValue() == 0)
                return "0";
            else if (this.coe.getValue() == -1)
                out = out + "-";
            else if (this.coe.getValue() != 1)
                out = out + coe.toString();

        }
        else { // Scalar.RationalScalar
            if (this.coe.getA() == 0)
                return "0";
            else if (this.coe.getA() == -1*(this.coe.getB()))
                out = out + "-";
            else if (this.coe.getA()!=this.coe.getB())
                out = out + coe.toString();
        }
            if (exp==1)
                out = out + "x";
            else
                out = out +  "x^" + exp;
            return out;
    }
    public Scalar getCoe() {
        return coe;
    }
    public int getExp() {
        return exp;
    }

}
