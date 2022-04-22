package com.company;

import exceptions.IncorrectParameter;

import java.util.Arrays;
import java.util.Collections;

import static java.lang.System.exit;

public class Quadrangle extends Figures{
    Quadrangle(){
        Point a = new Point(Point.gatherInfo(), Point.gatherInfo());
        Point b = new Point(Point.gatherInfo(), Point.gatherInfo());
        Point c = new Point(Point.gatherInfo(), Point.gatherInfo());
        Point d = new Point(Point.gatherInfo(), Point.gatherInfo());
        double ab, bc, ad, cd;
        ab = Point.distanceBetweenTwoPoints(a, b);
        bc = Point.distanceBetweenTwoPoints(b, c);
        ad = Point.distanceBetweenTwoPoints(a, d);
        cd = Point.distanceBetweenTwoPoints(c, d);
        try {
            QuadrangleChecker(ab, bc, ad, cd);
        } catch (Throwable x){
            x.printStackTrace();
            exit(-1);
        }
    }

    public void QuadrangleChecker(double ab, double bc, double ad, double cd) throws Throwable{
        Double[] arr = findMax1(ab, bc, ad, cd);
        if (arr[0] >= arr[1] + arr[2] + arr[3]){
            throw new IncorrectParameter();
        }
    }

    public Double[] findMax1(double ab, double bc, double ad, double cd){
        Double[] arr = new Double[4];
        Arrays.sort(arr, Collections.reverseOrder());
        for (int counter = 0; counter < 4; ++counter){
            System.out.println("element numer " + counter + " = " + arr[counter]);
        }
        return arr;
    }

    @Override
    double area() {
        return 0;
    }

    @Override
    double perimeter() {
        return 0;
    }
}
