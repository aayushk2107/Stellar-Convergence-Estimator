/*
    Predicts the final fate of a star
    based on its mass.
*/

package model;

public class FateModel {
    public static String getFate(double mass) {
        if (mass < 8)
            return "White Dwarf";
        else if (mass < 25)
            return "Neutron Star";
        else
            return "Black Hole";
    }
}