package com.company;

import java.util.Random;
import java.util.Scanner;

public class Point {
    static private int count = 1;
    private int number;
    private double x, y;
    Point(double x, double y){
        this.x = x;
        this.y = y;
        number = count++;
    }

    public void changePointCoordinates(){
        System.out.print("changing Point" + this.number + " coordinates..... \t");
        this.x = new Random().nextDouble();
        this.y = new Random().nextDouble();
    }

    public void printPointCoordinates(){
        System.out.println("Coordinates of " + toString() + "(" + this.x + ", " + this.y + ")");
    }

    public String toString(){
        return "Point" + this.number;
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
