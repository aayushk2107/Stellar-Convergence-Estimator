import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🌟 Stellar Convergence Estimator 🌟");

        System.out.print("Enter Star Mass (Solar Masses): ");
        double mass = scanner.nextDouble();
        
        System.out.print("Enter Observed Helium %: ");
        double helium = scanner.nextDouble();

        if (mass < 0.1 || helium < 0 || helium > 100) {
            System.out.println("❌ Invalid Input. Simulation Terminated.");
            return;
        }

        Star userStar = new Star(mass, helium);
        long maxLifespan = PhysicsEngine.calculateMaxLifespan(userStar.getMass());
        
        long low = 0, high = maxLifespan, bestAge = 0;
        double minError = Double.MAX_VALUE;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            double currentHelium = PhysicsEngine.calculateHelium(mid, maxLifespan);
            double error = Math.abs(currentHelium - userStar.getTargetHelium());

            if (error < minError) {
                minError = error;
                bestAge = mid;
            }

            if (currentHelium < userStar.getTargetHelium()) low = mid + 1;
            else high = mid - 1;
        }

        double lifePct = ((double) bestAge / maxLifespan) * 100.0;
        System.out.println("\n" + "=".repeat(36));
        System.out.printf("🎯 Estimated Age:  %,d Years\n", bestAge);
        System.out.printf("⏳ Life Completed: %.4f%%\n", lifePct);
        System.out.printf("💀 Final Fate:     %s\n", userStar.getFinalFate());
        System.out.println("=".repeat(36));

        scanner.close();
    }
}
