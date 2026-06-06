public class PhysicsEngine {
    
    public static long calculateMaxLifespan(double mass) {
        return (long) (1e10 * Math.pow(mass, -2.5));
    }

    public static double calculateHelium(long age, long lifespan) {
        double timeFraction = (double) age / lifespan;
        return Math.pow(timeFraction, 2) * 100.0;
    }
}
