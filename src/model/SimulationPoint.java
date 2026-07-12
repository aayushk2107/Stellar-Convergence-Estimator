package model;

public class SimulationPoint {

    private final double time;
    private final double helium;

    public SimulationPoint(double time, double helium) {
        this.time = time;
        this.helium = helium;
    }

    public double getTime() {
        return time;
    }

    public double getHelium() {
        return helium;
    }
}
