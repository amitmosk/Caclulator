package Calculator;

import MathObjects.Polynomial;
import Scalar.RationalScalar;
import Scalar.RealScalar;
import Scalar.Scalar;

import java.util.Scanner;

public class Calculator {

    public static void printTitle(String title) {
        System.out.println("\n========== " + title + " ==========");
    }

    public static void printAdd(Polynomial p1, Polynomial p2, Polynomial res) {
        System.out.println("[" + p1 + "]+[" + p2 + "]=" + res);
    }

    public static void printMul(Polynomial p1, Polynomial p2, Polynomial res) {
        System.out.println("[" + p1 + "]*[" + p2 + "]=" + res);
    }

    public static void printEval(Polynomial p, Scalar s, Scalar res) {
        System.out.println("eval(" + p + "," + s + ")=" + res);
    }

    public static void printDerivate(Polynomial p, Polynomial d) {
        System.out.println("derivate(" + p + ")=" + d);
    }

    public static String choose_function(){
        printTitle("Please Choose a function :");
        System.out.println("1) Add 2 Polynomials" + "\n" +
                "2) Multiplication 2 Polynomials" + "\n" +
                "3) Derivative Polynomial" + "\n" +
                "4) Evaluate Polynomial" + "\n" +
                "5) Work Tests");
        Scanner myObj = new Scanner(System.in);
        String choise = myObj.nextLine();
        return choise;
    }

    public static void choose_type(){
        printTitle("Welcome! Please Choose Type :");
        System.out.println("1) Real Numbers" + "\n" +
                "2) Rational Numbers");
        Scanner myObj = new Scanner(System.in);
        String choise = myObj.nextLine();
        if (choise.equals("1")){
            real_calculator();
        }
        else
            rational_calculator();
    }

    public static void real_calculator(){
        Scanner myObj = new Scanner(System.in);
        String choise = choose_function();

        // Add
        if (choise.equals("1")){
            System.out.println("First Polynomial:");
            String first_poly = myObj.nextLine();
            System.out.println("Second Polynomial:");
            String second_poly = myObj.nextLine();
            Polynomial R1 = new Polynomial(); R1.build('R', first_poly);
            Polynomial R2 = new Polynomial();  R2.build('R', second_poly);
            printAdd(R1, R2, R1.add(R2));
        }
        // Mul
        if (choise.equals("2")){
            System.out.println("First Polynomial:");
            String first_poly = myObj.nextLine();
            System.out.println("Second Polynomial:");
            String second_poly = myObj.nextLine();
            Polynomial R1 = new Polynomial(); R1.build('R', first_poly);
            Polynomial R2 = new Polynomial();  R2.build('R', second_poly);
            printMul(R1, R2, R1.mul(R2));
        }
        // Derivative
        if (choise.equals("3")){
            System.out.println("Enter a Polynomial:");
            String first_poly = myObj.nextLine();
            Polynomial R1 = new Polynomial(); R1.build('R', first_poly);
            printDerivate(R1, R1.derivative());
        }
        // Eval
        if (choise.equals("4")){
            System.out.println("Enter a Polynomial:");
            String first_poly = myObj.nextLine();
            System.out.println("Enter Real Scalar:");
            int real_value = myObj.nextInt();
            Polynomial R1 = new Polynomial(); R1.build('R', first_poly);
            RealScalar r = new RealScalar(real_value);
            printEval(R1, r, R1.evaluate(r));
        }
        if (choise.equals("5")){
            Polynomial R1 = new Polynomial(); R1.build('R', "0.5 1");
            Polynomial R2 = new Polynomial();  R2.build('R', "1 0 -1 0 0.25");
            Polynomial R3 = new Polynomial(); R3.build('R', "5 0 -2");
            Polynomial R4 = new Polynomial(); R4.build('R', "5");
            Polynomial Q1 = new Polynomial(); Q1.build('Q', "2/-1");
            Polynomial Q2 = new Polynomial(); Q2.build('Q', "1/2 1 0 8");
            Polynomial Q3 = new Polynomial(); Q3.build('Q', "0 0 100");
            Polynomial Q4 = new Polynomial(); Q4.build('Q', "0 -1");
            Polynomial Q5 = new Polynomial(); Q5.build('Q', "0 -1/-2");


            //Add Tests
            printTitle("Testing Add");
            printAdd(R1, R1, R1.add(R1));
            printAdd(R1, R2, R1.add(R2));
            printAdd(R2, R3, R2.add(R3));
            printAdd(R3, R1, R3.add(R1));
            printAdd(R4, R4, R4.add(R4));
            printAdd(Q1, Q1, Q1.add(Q1));
            printAdd(Q1, Q2, Q1.add(Q2));
            printAdd(Q2, Q3, Q2.add(Q3));
            printAdd(Q3, Q1, Q3.add(Q1));
            printAdd(Q4, Q4, Q4.add(Q4));
            printAdd(Q5, Q5, Q5.add(Q5));
            printAdd(Q4, Q5, Q4.add(Q5));


            //Mul Tests

            printTitle("Testing Mul");
            printMul(R1, R1, R1.mul(R1));
            printMul(R1, R2, R1.mul(R2));
            printMul(R2, R3, R2.mul(R3));
            printMul(R3, R1, R3.mul(R1));
            printMul(R4, R4, R4.mul(R4));
            printMul(Q1, Q1, Q1.mul(Q1));
            printMul(Q1, Q2, Q1.mul(Q2));
            printMul(Q2, Q3, Q2.mul(Q3));
            printMul(Q3, Q1, Q3.mul(Q1));
            printMul(Q4, Q4, Q4.mul(Q4));
            printMul(Q5, Q5, Q5.mul(Q5));
            printMul(Q4, Q5, Q4.mul(Q5));

            //Evaluate Tests
            printTitle("Testing Evaluate");
            RealScalar r = new RealScalar(1);
            printEval(R1, r, R1.evaluate(r));
            printEval(R2, r, R2.evaluate(r));
            printEval(R3, r, R3.evaluate(r));
            printEval(R4, r, R4.evaluate(r));
            RationalScalar q = new RationalScalar(1,1);
            printEval(Q1, q, Q1.evaluate(q));
            printEval(Q2, q, Q2.evaluate(q));
            printEval(Q3, q, Q3.evaluate(q));
            printEval(Q4, q, Q4.evaluate(q));
            printEval(Q5, q, Q5.evaluate(q));

            // Derivative Tests
            printTitle("Testing derivative");
            printDerivate(R1, R1.derivative());
            printDerivate(R2, R2.derivative());
            printDerivate(R3, R3.derivative());
            printDerivate(R4, R4.derivative());
            printDerivate(Q1, Q1.derivative());
            printDerivate(Q2, Q2.derivative());
            printDerivate(Q3, Q3.derivative());
            printDerivate(Q4, Q4.derivative());
            printDerivate(Q5, Q5.derivative());
        }
    }
    public static void rational_calculator(){
        Scanner myObj = new Scanner(System.in);
        String choise = choose_function();

        // Add
        if (choise.equals("1")){
            System.out.println("First Polynomial:");
            String first_poly = myObj.nextLine();
            System.out.println("Second Polynomial:");
            String second_poly = myObj.nextLine();
            Polynomial Q1 = new Polynomial(); Q1.build('Q', first_poly);
            Polynomial Q2 = new Polynomial();  Q2.build('Q', second_poly);
            printAdd(Q1, Q2, Q1.add(Q2));
        }
        // Mul
        if (choise.equals("2")){
            System.out.println("First Polynomial:");
            String first_poly = myObj.nextLine();
            System.out.println("Second Polynomial:");
            String second_poly = myObj.nextLine();
            Polynomial Q1 = new Polynomial(); Q1.build('Q', first_poly);
            Polynomial Q2 = new Polynomial();  Q2.build('Q', second_poly);
            printMul(Q1, Q2, Q1.mul(Q2));
        }
        // Derivative
        if (choise.equals("3")){
            System.out.println("Enter a Polynomial:");
            String first_poly = myObj.nextLine();
            Polynomial Q1 = new Polynomial(); Q1.build('Q', first_poly);
            printDerivate(Q1, Q1.derivative());
        }
        // Eval
        if (choise.equals("4")){
            System.out.println("Enter a Polynomial:");
            String first_poly = myObj.nextLine();
            System.out.println("Enter Numerator:");
            int numerator = myObj.nextInt();
            System.out.println("Enter Denominator:");
            int denominator = myObj.nextInt();
            Polynomial Q1 = new Polynomial(); Q1.build('Q', first_poly);
            RationalScalar q = new RationalScalar(numerator, denominator);
            printEval(Q1, q, Q1.evaluate(q));
        }
        if (choise.equals("5")){
            Polynomial R1 = new Polynomial(); R1.build('R', "0.5 1");
            Polynomial R2 = new Polynomial();  R2.build('R', "1 0 -1 0 0.25");
            Polynomial R3 = new Polynomial(); R3.build('R', "5 0 -2");
            Polynomial R4 = new Polynomial(); R4.build('R', "5");
            Polynomial Q1 = new Polynomial(); Q1.build('Q', "2/-1");
            Polynomial Q2 = new Polynomial(); Q2.build('Q', "1/2 1 0 8");
            Polynomial Q3 = new Polynomial(); Q3.build('Q', "0 0 100");
            Polynomial Q4 = new Polynomial(); Q4.build('Q', "0 -1");
            Polynomial Q5 = new Polynomial(); Q5.build('Q', "0 -1/-2");


            //Add Tests
            printTitle("Testing Add");
            printAdd(R1, R1, R1.add(R1));
            printAdd(R1, R2, R1.add(R2));
            printAdd(R2, R3, R2.add(R3));
            printAdd(R3, R1, R3.add(R1));
            printAdd(R4, R4, R4.add(R4));
            printAdd(Q1, Q1, Q1.add(Q1));
            printAdd(Q1, Q2, Q1.add(Q2));
            printAdd(Q2, Q3, Q2.add(Q3));
            printAdd(Q3, Q1, Q3.add(Q1));
            printAdd(Q4, Q4, Q4.add(Q4));
            printAdd(Q5, Q5, Q5.add(Q5));
            printAdd(Q4, Q5, Q4.add(Q5));


            //Mul Tests

            printTitle("Testing Mul");
            printMul(R1, R1, R1.mul(R1));
            printMul(R1, R2, R1.mul(R2));
            printMul(R2, R3, R2.mul(R3));
            printMul(R3, R1, R3.mul(R1));
            printMul(R4, R4, R4.mul(R4));
            printMul(Q1, Q1, Q1.mul(Q1));
            printMul(Q1, Q2, Q1.mul(Q2));
            printMul(Q2, Q3, Q2.mul(Q3));
            printMul(Q3, Q1, Q3.mul(Q1));
            printMul(Q4, Q4, Q4.mul(Q4));
            printMul(Q5, Q5, Q5.mul(Q5));
            printMul(Q4, Q5, Q4.mul(Q5));

            //Evaluate Tests
            printTitle("Testing Evaluate");
            RealScalar r = new RealScalar(1);
            printEval(R1, r, R1.evaluate(r));
            printEval(R2, r, R2.evaluate(r));
            printEval(R3, r, R3.evaluate(r));
            printEval(R4, r, R4.evaluate(r));
            RationalScalar q = new RationalScalar(1,1);
            printEval(Q1, q, Q1.evaluate(q));
            printEval(Q2, q, Q2.evaluate(q));
            printEval(Q3, q, Q3.evaluate(q));
            printEval(Q4, q, Q4.evaluate(q));
            printEval(Q5, q, Q5.evaluate(q));

            // Derivative Tests
            printTitle("Testing derivative");
            printDerivate(R1, R1.derivative());
            printDerivate(R2, R2.derivative());
            printDerivate(R3, R3.derivative());
            printDerivate(R4, R4.derivative());
            printDerivate(Q1, Q1.derivative());
            printDerivate(Q2, Q2.derivative());
            printDerivate(Q3, Q3.derivative());
            printDerivate(Q4, Q4.derivative());
            printDerivate(Q5, Q5.derivative());
        }
    }
    public static void main(String[] args) {
        choose_type();
    }
}