/*
 * SENG2200 Programming Languages & Paradigms
 * Assignment 1 (100 marks, 10%) - Due March 19, 23:59
 * 
 * Student Name: NI ZENG
 * Student Number: C3238805
 */

public class Point {
    // representation of the object
    private double x;
    private double y;

    // public methods

    public Point(double a, double b) {
        x = a;
        y = b;
    }

    public void setX(double setx) {
        x = setx;
    }

    public void setY(double sety) {
        y = sety;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // conversion of a Point object into a String of the form (x , y)
    public String toString() {

        String strX = String.format("%3.2f", this.x); // Format this.x according to the 3.2f specification

        String strY = String.format("%3.2f", this.y); // Format this.y according to the 3.2f specification

        return "(" + strX + "," + strY + ")";
    }

    public double distanceCalculate(double x, double y) {

        // calculate the distance of the point from the origin.
        double d = Math.sqrt((x * x) + (y * y));
        return d;

    }

}
