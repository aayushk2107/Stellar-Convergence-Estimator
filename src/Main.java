import data.StarRepository;
import model.FateModel;
import model.Star;

public class Main {

    public static void main(String[] args) {

        System.out.println(
                "===== Validation Table =====");

        System.out.printf(
                "%-15s %-15s %-15s %-10s%n",
                "Star",
                "Known Fate",
                "Predicted",
                "Match"
        );

        for (Star star :
                StarRepository.getAllStars()) {

            String predicted =
                    FateModel.getFate(
                            star.getMass()
                    );

            String match =
                    predicted.equals(
                            star.getKnownFate()
                    )
                            ? "YES"
                            : "NO";

            System.out.printf(
                    "%-15s %-15s %-15s %-10s%n",
                    star.getName(),
                    star.getKnownFate(),
                    predicted,
                    match
            );
        }
    }
}