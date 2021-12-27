package MathObjects;

import Scalar.Scalar;
import Scalar.RationalScalar;
import Scalar.RealScalar;

import java.util.LinkedList;

public class Polynomial extends Object {
        private LinkedList<Monomial> monomials;

        public Polynomial(){
                monomials = new LinkedList<Monomial>();
        }

        public Polynomial build(char type,String input){
                Polynomial pol = new Polynomial();
                String [] arr = input.split(" ");
                for (int i=0;i<arr.length;i++) {

                        if (!arr[i].equals(""))
                        {
                                if (type=='Q') {
                                        int b=1;
                                        String[] brr=arr[i].split("/");
                                        int a=stringToInt(brr[0]);
                                        if (brr.length==2)
                                        {
                                                b = stringToInt(brr[1]); // have to change from string to int
                                        }
                                        RationalScalar temp = new RationalScalar(a, b);
                                        Monomial mono = new Monomial(temp, i);
                                        pol.monomials.add(mono);
                                }
                                else if (type=='R') {
                                        double value=stringToDouble(arr[i]);
                                        RealScalar temp = new RealScalar(value); // value from the function
                                        Monomial mono = new Monomial(temp, i);
                                        pol.monomials.add(mono);
                                }
                        }

                }
                this.monomials=pol.monomials;
                return pol;
        }//have to check
        public boolean isMatch(Polynomial p){
                Monomial mon = p.monomials.getFirst();
                return (mon.isMatch(this.monomials.getFirst()));

        }
        public Polynomial add(Polynomial p){
                if (!this.isMatch(p))
                        return null;
                Polynomial ans = new Polynomial();
                Monomial curr1=this.monomials.get(0);
                Monomial curr2=p.monomials.get(0);
                int counter=1;
                while (counter < this.monomials.size() & counter < p.monomials.size())
                {
                        Monomial sum = curr1.add(curr2);
                        ans.monomials.add(sum);
                        curr1 = this.monomials.get(counter);
                        curr2 = p.monomials.get(counter);
                        counter++;
                }
                Monomial sum = curr1.add(curr2);
                ans.monomials.add(sum);
                while(counter<this.monomials.size())
                {
                        ans.monomials.add(this.monomials.get(counter));
                        counter++;
                }
                while(counter<p.monomials.size())
                {
                        ans.monomials.add(p.monomials.get(counter));
                        counter++;
                }

                return ans;

        }
        public Polynomial mul(Polynomial p){
                Polynomial ans = new Polynomial();
                Monomial [] arr = new Monomial[p.monomials.size()*this.monomials.size()];
                boolean [] visit = new boolean[arr.length];
                for (int i=0;i<visit.length;i++) { visit[i]=false;}
                for (int i=0;i<this.monomials.size();i++)
                {
                        for (int j=0;j<p.monomials.size();j++)
                        {
                                Monomial temp = this.monomials.get(i).mul(p.monomials.get(j));
                                if (visit[temp.getExp()])
                                        arr[temp.getExp()]=arr[temp.getExp()].add(temp);
                                else {
                                        arr[temp.getExp()] = temp;
                                        visit[temp.getExp()]=true;
                                }
                        }
                }
                for (int i=0;i<arr.length;i++)
                        if (arr[i]!=null)
                                ans.monomials.add(arr[i]);
                return ans;
        } // Have to check
        public Scalar evaluate(Scalar scalar){
                Scalar ans = this.monomials.get(0).evaluate(scalar);
                for (int i=1;i<this.monomials.size();i++) {
                        ans = ans.add(this.monomials.get(i).evaluate(scalar));
                }
                return ans;
        }
        public Polynomial derivative(){
                Polynomial ans = new Polynomial();
                for (int i=0;i<this.monomials.size();i++){
                        ans.monomials.add(this.monomials.get(i).derivative());
                }
                return ans;
        }
        public String toString(){
                String ans = "";
                int counter=0;
                while ((counter<this.monomials.size())&&(this.monomials.get(counter).toString().equals("0")) |(this.monomials.get(counter).toString().equals("0.0"))) //check the first monomonial different from zero
                {
                        counter++;
                }
                if (counter==this.monomials.size())
                        return "0";
                for (int i=counter;i<this.monomials.size();i++)
                {

                        String temp =this.monomials.get(i).toString();
                        if (!temp.equals("0"))
                        {
                                if (counter==i)
                                        ans=ans+temp;
                                else if (this.monomials.get(i).sign()==1)//if positive
                                        ans=ans+"+"+temp;
                                else
                                        ans=ans+temp;
                        }

                }
                return ans;
        }
        public int stringToInt (String str){
                int ans=0;
                boolean sign = true;
                if (str.charAt(0)=='-'){
                        sign = false;
                        str=str.substring(1);
                }
                for (int i=0;i<str.length();i++){
                        ans=ans+(str.charAt(i)-'0')*(int)Math.pow(10,str.length()-i-1);
                }
                if (!sign) ans=ans*-1;
                return ans;

        }// for build implemention
        public double stringToDouble (String str){
                double ans=0;
                boolean sign = true;
                if (str.charAt(0)=='-'){
                        sign = false;
                        str=str.substring(1);
                }
                int help = str.indexOf('.');
                if (help==-1) {
                        for (int i=0;i<str.length();i++){
                                ans=ans+(str.charAt(i)-'0')*(int)Math.pow(10,str.length()-i-1);
                        }
                }
                else {
                        String s1 = str.substring(0,help);
                        ans = ans + stringToInt(s1);
                        String s2 = str.substring(help+1);
                        ans = ans + (double)stringToInt(s2)/Math.pow(10,s2.length());

                }


                if (!sign) ans=ans*-1;
                return ans;

        }// for build implemention

}
