package model;

import java.util.ArrayList;
import java.util.List;

public class ProgressData {

    public static List<ProgressPoint> generate(double mass) {

        List<ProgressPoint> points = new ArrayList<>();

        double lifetime = StellarModel.lifetime(mass);
        double step = lifetime / 100.0;

        for (double time = 0; time <= lifetime; time += step) {

            double progress =
                    (time / lifetime) * 100.0;

            points.add(
                    new ProgressPoint(
                            time,
                            progress
                    )
            );
        }

        return points;
    }
}