package model;

public class StellarModel {

    public static double lifetime(double mass) {

        return 1e10 / Math.pow(mass, 2.5);
    }

    public static double helium(double t, double mass) {

        double H0 = 0.25;
        double Hmax = 0.70;
        double k = 3.0;

        double life = lifetime(mass);
        double x = t / life;

        return H0 + (Hmax - H0) *
                (1 - Math.exp(-k * x));
    }
}