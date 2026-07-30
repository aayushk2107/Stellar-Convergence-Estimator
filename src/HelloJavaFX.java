import algorithm.BinarySearchSolver;
import algorithm.LinearSearchSolver;
import algorithm.SearchResult;
import data.StarRepository;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Star;
import model.StellarModel;

public class HelloJavaFX extends Application {

    @Override
    public void start(Stage stage) {

        Label title =
                new Label("⭐ Stellar Convergence Estimator");

        Label starLabel =
                new Label("Choose Star:");

        ComboBox<String> starBox =
                new ComboBox<>();

        starBox.getItems().addAll(
                "Sun",
                "Sirius",
                "Betelgeuse",
                "Rigel",
                "Aldebaran",
                "Arcturus",
                "Spica",
                "Eta Carinae"
        );

        starBox.setValue("Sun");

        Label heliumLabel =
                new Label("Target Helium (%)");

        TextField heliumField =
                new TextField("50");

        Button analyzeButton =
                new Button("Analyze");

        Label starInfoTitle =
                new Label("========== Star Information ==========");

        Label lifetimeLabel =
                new Label("Lifetime :");

        Label fateLabel =
                new Label("Known Fate :");

        Label binaryTitle =
                new Label("========== Binary Search ==========");

        Label binaryAgeLabel =
                new Label("Age Found :");

        Label binaryIterationLabel =
                new Label("Iterations :");

        Label linearTitle =
                new Label("========== Linear Search ==========");

        Label linearAgeLabel =
                new Label("Age Found :");

        Label linearIterationLabel =
                new Label("Iterations :");

        Label efficiencyTitle =
                new Label("========== Efficiency ==========");

        Label efficiencyLabel =
                new Label("Waiting...");

        VBox root =
                new VBox(12);

        root.setPadding(new Insets(20));

        root.getChildren().addAll(

                title,

                starLabel,
                starBox,

                heliumLabel,
                heliumField,

                analyzeButton,

                starInfoTitle,
                lifetimeLabel,
                fateLabel,

                binaryTitle,
                binaryAgeLabel,
                binaryIterationLabel,

                linearTitle,
                linearAgeLabel,
                linearIterationLabel,

                efficiencyTitle,
                efficiencyLabel
        );

        analyzeButton.setOnAction(e -> {

            try {

                String starName =
                        starBox.getValue();

                double helium =
                        Double.parseDouble(
                                heliumField.getText()
                        ) / 100.0;

                Star star =
                        StarRepository.findByName(starName);

                if (star == null) {

                    lifetimeLabel.setText("Star not found.");

                    return;
                }

                SearchResult binary =
                        BinarySearchSolver.findTimeForHelium(
                                star.getMass(),
                                helium
                        );

                SearchResult linear =
                        LinearSearchSolver.findTimeForHelium(
                                star.getMass(),
                                helium
                        );

                double lifetime =
                        StellarModel.lifetime(
                                star.getMass()
                        );

                lifetimeLabel.setText(
                        "Lifetime : "
                                + String.format("%.2e", lifetime)
                                + " Years"
                );

                fateLabel.setText(
                        "Known Fate : "
                                + star.getKnownFate()
                );

                binaryAgeLabel.setText(
                        "Age Found : "
                                + String.format("%.2e", binary.age)
                                + " Years"
                );

                binaryIterationLabel.setText(
                        "Iterations : "
                                + binary.iterations
                );

                linearAgeLabel.setText(
                        "Age Found : "
                                + String.format("%.2e", linear.age)
                                + " Years"
                );

                linearIterationLabel.setText(
                        "Iterations : "
                                + linear.iterations
                );

                double speedup =
                        (double) linear.iterations
                                / binary.iterations;

                efficiencyLabel.setText(
                        String.format(
                                "Binary Search was %.2fx more efficient.",
                                speedup
                        )
                );

            }

            catch (NumberFormatException ex) {

                lifetimeLabel.setText(
                        "Please enter a valid helium percentage."
                );

                fateLabel.setText("");

                binaryAgeLabel.setText("");
                binaryIterationLabel.setText("");

                linearAgeLabel.setText("");
                linearIterationLabel.setText("");

                efficiencyLabel.setText("");

            }

        });

        Scene scene =
                new Scene(root, 550, 700);

        stage.setTitle("Stellar Convergence Estimator");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
