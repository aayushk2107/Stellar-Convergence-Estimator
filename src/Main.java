import algorithm.BinarySearchSolver;
import algorithm.LinearSearchSolver;
import algorithm.SearchResult;
import data.StarRepository;
import model.FateModel;
import model.Star;
import model.StellarModel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter star name: ");
        String starName = scanner.nextLine();

        Star star =
                StarRepository.findByName(starName);

        if (star == null) {
            System.out.println("Star not found.");
            return;
        }

        System.out.print(
                "Enter helium produced percentage (0-100): ");

        double heliumPercent =
                scanner.nextDouble();

        double targetHelium =
                0.25 + (heliumPercent / 100.0) * 0.45;

        double mass =
                star.getMass();

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

        System.out.println();
        System.out.println(
                "===== Stellar Convergence Estimator =====");

        System.out.println(
                "Star: " + star.getName());

        System.out.println(
                "Mass: " + mass);

        System.out.println(
                "Known Fate: "
                        + star.getKnownFate());

        System.out.println(
                "Predicted Fate: "
                        + fate);

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
    }
}