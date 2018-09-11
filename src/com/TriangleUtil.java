package com;

public class TriangleUtil {
    public double getArea(double side1, double side2, double side3) {
        double area = 0;
        try {
            if(side1 > 0 && side2 > 0 && side3 > 0) {
                double semiperimeter = (side1 + side2 + side3) / 2;
                area = Math.sqrt(semiperimeter * (semiperimeter - side1) * (semiperimeter - side2) * (semiperimeter - side3));
            }
        } catch (NumberFormatException nfe) {
            nfe.getMessage();
        } catch (Exception e) {
            e.getMessage();
        }
        return area;
    }
}
