package com.company;

import exceptions.IncorrectParameter;

import java.math.*;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.exit;

public class Triangle extends Figures {
    private Point a, b, c;
    private double[] distArray;

    Triangle() {
        a = new Point(Point.gatherInfo(), Point.gatherInfo());
        b = new Point(Point.gatherInfo(), Point.gatherInfo());
        c = new Point(Point.gatherInfo(), Point.gatherInfo());
        try {
            traingleChecker(a, b, c);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void traingleChecker(Point a, Point b, Point c) throws Exception {
        distArray = new double[3];
        distArray[0] = Point.distanceBetweenTwoPoints(a, b);
        distArray[1] = Point.distanceBetweenTwoPoints(a, c);
        distArray[2] = Point.distanceBetweenTwoPoints(b, c);
        Arrays.sort(distArray);
        if (distArray[2] >= distArray[0] + distArray[1]) {
            throw new IncorrectParameter();
        }
    }

    public void printTriangleCoordinates() {
        System.out.println("Triangle points coordinates: P1 = (" + this.a.getXCoordinate() + ", " + this.a.getYCoordinate() + ")\t" + "P2 = (" + this.b.getXCoordinate() + ", " + this.b.getYCoordinate() + ")\t" + "P3 = (" + this.c.getXCoordinate() + ", " + this.c.getYCoordinate() + ")");
    }

    public void changePointCoordinates() {
        String temp;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which point to change coordinates(P1/P2/P3)?");
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
            traingleChecker(a, b, c);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        printTriangleCoordinates();
    }

    static public void areaOfMoreTri(int numberOfTriangles, Triangle[] arr){
        System.out.println("An array of triangles:");
        for (int counter = 0; counter < numberOfTriangles; ++counter){
            System.out.println(arr[counter].area());
        }
    }


    @Override
    double area() {
        return Math.sqrt(perimeter() / 2 * ((perimeter() / 2) - distArray[0]) * (perimeter() / 2 - distArray[1]) * (perimeter() / 2 - distArray[2]));
    }

    @Override
    double perimeter() {
        return distArray[0] + distArray[1] + distArray[2];
    }

    double height(String point) {
        if (point.equals("P1")){
            return 2 * area() / distArray[2];
        }
        if (point.equals("P2")){
            return 2 * area() / distArray[1];
        }
        if (point.equals("P3")){
            return 2 * area() / distArray[0];
        }
        throw new RuntimeException();
    }

    static public Triangle[] arrOfTrianglesMaker(int numberOfTriangles){
        Triangle[] arrOfTriangles = new Triangle[numberOfTriangles];
        try {
            for (int counter = 0; counter < numberOfTriangles; ++counter) {
                arrOfTriangles[counter] = new Triangle();
                arrOfTriangles[counter].traingleChecker(arrOfTriangles[counter].a, arrOfTriangles[counter].b, arrOfTriangles[counter].c);
            }
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return arrOfTriangles;
    }

}
