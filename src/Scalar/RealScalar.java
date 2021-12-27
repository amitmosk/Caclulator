package Scalar;

public class RealScalar extends Scalar  {
    private double v;
    public RealScalar(double v){
        this.v=v;
    }
    public boolean ScalarType(){return true;}
    public Scalar add(Scalar s){
        if (!isMatch(s))
            return  null;
        Scalar ans = new RealScalar(this.getValue()+ s.getValue());
        return ans;
    }
    public Scalar mul(int i){
        Scalar ans = new RealScalar(this.getValue()*i);
        return ans;
    }
    public Scalar mul(Scalar s){
        if (!isMatch(s))
            return  null;
        Scalar ans = new RealScalar(this.getValue()* s.getValue());
        return ans;
    }
    public Scalar getOne(){
        return new RealScalar(1.0);
    }
    public double getValue(){return v;}
    public String toString(){
        Double value = v;
        String str = value.toString();
        int index = str.indexOf('.');
        if (index+4<=str.length())
            str = str.substring(0,index+4);
        if (str.length()-str.indexOf(".")-1==1 && str.charAt(str.length()-1)=='0')
            str=str.substring(0,str.length()-2);
        return str;
    }
    public Integer getA() {
        int a=1;
        int b=1;
        double v = getValue();
        Double V=v;
        String sValue=V.toString();
        int lengthAfterPoint = sValue.length()-sValue.indexOf(".");//number of cells after the point
        for (int i=0;i<lengthAfterPoint;i++)
            b=b*10;
        int completeV=0;
        for (int i=1;i<v;i++)
            completeV++;
        a=completeV*b;
        return a;
    }
    public Integer getB() {
        int a=1;
        int b=1;
        double v = getValue();
        Double V=v;
        String sValue=V.toString();
        int lengthAfterPoint = sValue.length()-sValue.indexOf(".");//number of cells after the point
        for (int i=0;i<lengthAfterPoint;i++)
            b=b*10;
        int completeV=0;
        for (int i=1;i<v;i++)
            completeV++;
        a=completeV*b;
        return b;
    }


}
