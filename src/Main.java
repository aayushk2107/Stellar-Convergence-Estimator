import model.SimulationData;
import model.SimulationPoint;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<SimulationPoint> points =
                SimulationData.generate(1.0);

        System.out.printf("%-15s %-15s%n",
                "Time",
                "Helium");

        System.out.println("------------------------------");

        for (SimulationPoint point : points) {

            System.out.printf(
                    "%-15.2e %-15.4f%n",
                    point.getTime(),
                    point.getHelium()
            );
        }
    }
}