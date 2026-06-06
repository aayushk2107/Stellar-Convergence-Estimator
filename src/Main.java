/*import algorithm.BinarySearchSolver;
import algorithm.LinearSearchSolver;
import algorithm.SearchResult;
import model.FateModel;
import model.StellarModel;

public class Main {

    public static void main(String[] args) {

        double mass = 1.0;
        double targetHelium = 0.50;

        double lifetime =
                StellarModel.lifetime(mass);

        SearchResult binary =
                BinarySearchSolver
                        .findTimeForHelium(
                                mass,
                                targetHelium
                        );

        SearchResult linear =
                LinearSearchSolver
                        .findTimeForHelium(
                                mass,
                                targetHelium
                        );

        String fate =
                FateModel.getFate(mass);

        System.out.println(
                "===== Stellar Convergence Estimator =====");

        System.out.println(
                "Mass: " + mass);

        System.out.println(
                "Target Helium: "
                        + targetHelium);

        System.out.println(
                "Lifetime: "
                        + lifetime);

        System.out.println();

        System.out.println(
                "Binary Search Age: "
                        + binary.age);

        System.out.println(
                "Binary Iterations: "
                        + binary.iterations);

        System.out.println();

        System.out.println(
                "Linear Search Age: "
                        + linear.age);

        System.out.println(
                "Linear Iterations: "
                        + linear.iterations);

        System.out.println();

        System.out.println(
                "Fate: " + fate);
    }
}*/

import model.Star;

public class Main {
    public static void main(String[] args) {

        Star sun = new Star("Sun", 1.0, "White Dwarf");

        System.out.println(sun.getName());
        System.out.println(sun.getMass());
        System.out.println(sun.getKnownFate());

        System.out.println(sun);
    }
}
