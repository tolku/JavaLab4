package com.company;

import exceptions.IncorrectParameter;

import java.math.*;

import static java.lang.System.exit;

public class Triangle extends Figures {

    Triangle(){
        Point a = new Point(Point.gatherInfo(), Point.gatherInfo());
        Point b = new Point(Point.gatherInfo(), Point.gatherInfo());
        Point c = new Point(Point.gatherInfo(), Point.gatherInfo());
        double ab, ac, bc;
        ab = Point.distanceBetweenTwoPoints(a, b);
        ac = Point.distanceBetweenTwoPoints(a, c);
        bc = Point.distanceBetweenTwoPoints(b, c);
        try {
            traingleChecker(ab, ac, bc);
        } catch (Throwable e) {
            e.printStackTrace();
            exit(-1);
        }
        System.out.println("Trójkąt zbudowany!");
    }

    public void traingleChecker(double ab, double ac, double bc) throws Throwable {
        double[] arr;
        arr = findMax(ab, ac, bc);
        if (arr[0] >= arr[1] + arr[2]){
            throw new IncorrectParameter();
        }
    }

    public double[] findMax(double ab, double ac, double bc) throws Throwable{
        double[] arr = new double[3];
        if (ab > ac && ab > bc){
            if (ac > bc){
                arr[0] = ab;
                arr[1] = ac;
                arr[2] = bc;
                return arr;
            } else {
                arr[0] = ab;
                arr[1] = bc;
                arr[2] = ac;
                return arr;
            }
        }
        if (ac > ab && ac > bc){
            if (ab > bc){
                arr[0] = ac;
                arr[1] = ab;
                arr[2] = bc;
                return arr;
            } else {
                arr[0] = ac;
                arr[1] = bc;
                arr[2] = ab;
                return arr;
            }
        }
        if (bc > ab && bc > ac){
            if (ab > ac){
                arr[0] = bc;
                arr[1] = ab;
                arr[2] = ac;
                return arr;
            } else {
                arr[0] = bc;
                arr[1] = ac;
                arr[2] = ab;
                return arr;
            }
        }
        throw new IncorrectParameter();
    }

    @Override
    double area() {

    }

    @Override
    double perimeter() {

    }
}
