package model;

public class StellarModel {
    public static double lifetime(double mass){
        return Math.pow(mass,2.5)*1e10;
    }
    public static double helium(double t,double mass){
        double HO=0.25;
        double Hmax=0.70;
        double k=3.0;
        double life=lifetime(mass);
        double x=t/life;
        return HO +(Hmax-HO)*(1-Math.exp(-k *x));
    }
}
