public class Star {
    private double mass;
    private double targetHelium;

    public Star(double mass, double targetHelium) {
        this.mass = mass;
        this.targetHelium = targetHelium;
    }

    public double getMass() { return mass; }
    public double getTargetHelium() { return targetHelium; }

    public String getFinalFate() {
        if (mass < 8.0) return "White Dwarf";
        if (mass <= 25.0) return "Neutron Star";
        return "Black Hole";
    }
}
