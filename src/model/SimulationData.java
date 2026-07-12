package model;

import java.util.ArrayList;
import java.util.List;

public class SimulationData {

    public static List<SimulationPoint> generate(double mass) {

        List<SimulationPoint> points = new ArrayList<>();

        double lifetime = StellarModel.lifetime(mass);

        double step = lifetime / 100.0;

        for (double time = 0; time <= lifetime; time += step) {

            double helium =
                    StellarModel.helium(time, mass);

            points.add(
                    new SimulationPoint(
                            time,
                            helium
                    )
            );
        }

        return points;
    }
}
