/*
 * SENG2200 Programming Languages & Paradigms
 * Assignment 1 (100 marks, 10%) - Due March 19, 23:59
 * 
 * Student Name: NI ZENG
 * Student Number: C3238805
 */

public class Polygon implements ComparePoly {
    // representation of the objects

    private double area; // variable area
    private Point[] points; // create an memory array for points
    private int i = 0; // keep track of points

    // public methods

    public Polygon(int side) {

        points = new Point[side];
        i = 0;
        area = 0;
    }

    public void addPoint(double x, double y) {

        if (i < points.length) {
            points[i] = new Point(x, y);
            setPoint(points[i], x, y);
            i++;
        }
        if (i > points.length) {
            System.out.println("Error");
        }

    }

    public void setPoint(Point p, double x, double y) {

        p.setX(x);
        p.setY(y);
    }

    public String toString() {
        String allPoints = "";
        for (int s = 0; s < points.length; s++) {
            points[s].toString();
            allPoints = allPoints + points[s].toString();
        }

        return "[" + allPoints + "]: " + String.format("%5.2f", area);
    }

    public double distanceClosest() {

        double min = points[0].distanceCalculate(points[0].getX(), points[0].getY());

        for (int c = 1; c < points.length; c++) {

            double d1 = points[c].distanceCalculate(points[c].getX(), points[c].getY());
            if (min > d1) {
                min = d1;

            } else if (min == d1) {
                min = points[0].distanceCalculate(points[0].getX(), points[0].getY());
            }

        }
        return min;
    }

    public double areaCal(int n) {

        // Calculate value of shoelace formula
        int j = n - 1;
        for (int f = 0; f < n; f++) {
            area += (points[j].getX() + points[f].getX()) * (points[j].getY() - points[f].getY());

            // j is previous vertex to i
            j = f;
        }
        area = Math.abs(area / 2.0);

        // Return absolute value
        return area;

    }

    // ------------------------------------------------------------------------------------------------------------------
    // ------------------------------------------------------------------------------------------------------------------

    @Override
    public boolean ComesBefore(Polygon po1) {
        // true if this < param // p < po1, list: p - po1 .....

        if (Math.abs(this.area - po1.area) <= 0.0005) {
            this.area = po1.area;
            if (this.distanceClosest() <= po1.distanceClosest()) {

                return true; // true, p - po1
            } else
                return false; // false, po1 - p
        } else if (this.area < po1.area && Math.abs(this.area - po1.area) >= 0.0005)
            return true; // ture, p -po1

        else if (this.area > po1.area)
            return false; // false, po1 - p

        else
            return true; // ture, p - po1

    }

}
