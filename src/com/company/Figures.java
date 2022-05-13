package com.company;

public abstract class Figures {
    abstract double area();
    abstract double perimeter();
    abstract void changePointCoordinates();

    static public void sortArrOfFigures(Figures[] arr){
        boolean sorting = true;
        while (sorting){
            for (int counter = 1; counter < arr.length; ++counter){
                sorting = false;
                if (arr[counter].area() < arr[counter - 1].area()){
                    Figures temp = arr[counter];
                    arr[counter] = arr[counter - 1];
                    arr[counter - 1] = temp;
                    sorting = true;
                }
            }
        }
    }

    public static void main(String[] args){
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, -3);
        p1.printPointCoordinates();
        p2.printPointCoordinates();
        p2.changePointCoordinates();
        p2.printPointCoordinates();
        System.out.println("distance betweeen " + p1.toString() + " and " + p2.toString() + " = " + Point.distanceBetweenTwoPoints(p1, p2));
        Triangle acute = new Triangle();
        acute.printTriangleCoordinates();
        acute.changePointCoordinates();
        System.out.println("Perimeter = " + acute.perimeter() + "\tArea = " + acute.area() + "\tHeight from coordinate P1 = " + acute.height("P1"));
        Quadrangle rhomb = new Quadrangle();
        rhomb.printQuadrangleCoordinates();
        System.out.println("Perimeter = " + rhomb.perimeter() + "\tArea = " + rhomb.area() + " Diagonal from coordinate " + rhomb.diagEst("P1"));
        rhomb.changePointCoordinates();
        rhomb.printQuadrangleCoordinates();
        Triangle[] arrOfTriangles;
        arrOfTriangles = Triangle.arrOfTrianglesMaker(3);
        Triangle.areaOfMoreTri(3, arrOfTriangles);
        Triangle.sortArrOfFigures(arrOfTriangles);
        Triangle.areaOfMoreTri(3, arrOfTriangles);
        Quadrangle[] arrOfQuadrangles;
        arrOfQuadrangles = Quadrangle.arrOfQuadranglesMaker(3);
        Quadrangle.areaOfMoreQuad(3, arrOfQuadrangles);
        Quadrangle.sortArrOfFigures(arrOfQuadrangles);
        Quadrangle.areaOfMoreQuad(3, arrOfQuadrangles);
    }
}
