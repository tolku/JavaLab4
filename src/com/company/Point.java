package com.company;

import java.util.Scanner;

public class Point {
    private double x, y;
    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getXCoordinate(){
        return x;
    }

    public double getYCoordinate(){
        return y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    static public double distanceBetweenTwoPoints(Point a, Point b){
        return Math.sqrt(Math.pow((b.getXCoordinate() - a.getXCoordinate()), 2) + Math.pow((b.getYCoordinate() - a.getYCoordinate()), 2));
    }

    static public double gatherInfo(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter coordinate value: ");
        return scan.nextDouble();
    }
}
