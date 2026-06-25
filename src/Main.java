import algorithm.BinarySearchSolver;
import algorithm.SearchResult;
import data.StarRepository;
import model.FateModel;
import model.Star;
import model.StellarModel;

public class Main {

    public static void main(String[] args) {

        double targetHelium = 0.50;

        System.out.println(
                "===== Stellar Analysis Table =====");

        System.out.printf(
                "%-15s %-8s %-15s %-15s %-15s%n",
                "Star",
                "Mass",
                "Lifetime",
                "Age(50%)",
                "Fate"
        );

        for (Star star :
                StarRepository.getAllStars()) {

            double mass =
                    star.getMass();

            double lifetime =
                    StellarModel.lifetime(mass);

            SearchResult result =
                    BinarySearchSolver
                            .findTimeForHelium(
                                    mass,
                                    targetHelium
                            );

            String fate =
                    FateModel.getFate(mass);

            System.out.printf(
                    "%-15s %-8.1f %-15.2e %-15.2e %-15s%n",
                    star.getName(),
                    mass,
                    lifetime,
                    result.age,
                    fate
            );
        }
    }
}