package com.company;

import exceptions.IncorrectParameter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.System.exit;

public class Quadrangle extends Figures{
    private Point a, b, c, d;
    private double[] distArr;
    Quadrangle(){
        a = new Point(Point.gatherInfo(), Point.gatherInfo());
        b = new Point(Point.gatherInfo(), Point.gatherInfo());
        c = new Point(Point.gatherInfo(), Point.gatherInfo());
        d = new Point(Point.gatherInfo(), Point.gatherInfo());
        distArr = new double[4];
        distArr[0] = Point.distanceBetweenTwoPoints(a, b);
        distArr[1] = Point.distanceBetweenTwoPoints(b, c);
        distArr[2] = Point.distanceBetweenTwoPoints(a, d);
        distArr[3] = Point.distanceBetweenTwoPoints(c, d);
        try {
            quadrangleChecker(distArr);
        } catch (Exception x){
            throw new RuntimeException(x);
        }
    }



    public void printQuadrangleCoordinates() {
        System.out.println("Quadrangle points coordinates: P1 = (" + this.a.getXCoordinate() + ", " + this.a.getYCoordinate() + ")\t" + "P2 = (" + this.b.getXCoordinate() + ", " + this.b.getYCoordinate() + ")\t" + "P3 = (" + this.c.getXCoordinate() + ", " + this.c.getYCoordinate() + ") " + "P4 = (" + this.d.getXCoordinate() + ", " + this.d.getYCoordinate() + ")");
    }

    public void quadrangleChecker(double[] arr) throws Exception{
        Arrays.sort(arr);
        if (arr[3] >= arr[0] + arr[1] + arr[2]){
            throw new IncorrectParameter();
        }
    }

    @Override
    void changePointCoordinates() {
        String temp;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which point to change coordinates(P1/P2/P3/P4)?");
        temp = scanner.next();
        try {
            if (temp.equals("P1")) {
                System.out.println("set X coord");
                this.a.setX(scanner.nextDouble());
                System.out.println("set Y coord");
                this.a.setY(scanner.nextDouble());
            }
            if (temp.equals("P2")) {
                System.out.println("set X coord");
                this.b.setX(scanner.nextDouble());
                System.out.println("set Y coord");
                this.b.setY(scanner.nextDouble());
            }
            if (temp.equals("P3")) {
                System.out.println("set X coord");
                this.c.setX(scanner.nextDouble());
                System.out.println("set Y coord");
                this.c.setY(scanner.nextDouble());
            }
            if (temp.equals("P4")){
                System.out.println("set X coord");
                this.d.setX(scanner.nextDouble());
                System.out.println("set Y coord");
                this.d.setY(scanner.nextDouble());
            }
            quadrangleChecker(distArr);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    double diagEst(String from){
        if (from.equals("P1") || from.equals("P3")){
            return Point.distanceBetweenTwoPoints(a, c);
        } else {
            return Point.distanceBetweenTwoPoints(b, d);
        }
    }

    @Override
    double area() {
        return Math.sqrt((perimeter() - distArr[0]) * (perimeter() - distArr[1]) * (perimeter() - distArr[2]) * (perimeter() - distArr[3]));
    }

    @Override
    double perimeter() {
        return distArr[0] + distArr[1] + distArr[2] + distArr[3];
    }

    static public void areaOfMoreQuad(int numberOfQuad, Quadrangle[] arr){
        System.out.println("An array of quadrangles:");
        for (int counter = 0; counter < numberOfQuad; ++counter){
            System.out.println(arr[counter].area());
        }
    }

    static public Quadrangle[] arrOfQuadranglesMaker(int numberOfQuadrangles){
        Quadrangle[] arrOfQuad = new Quadrangle[numberOfQuadrangles];
        try {
            for (int counter = 0; counter < numberOfQuadrangles; ++counter) {
                arrOfQuad[counter] = new Quadrangle();
                arrOfQuad[counter].quadrangleChecker(arrOfQuad[counter].distArr);
            }
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return arrOfQuad;
    }
}
