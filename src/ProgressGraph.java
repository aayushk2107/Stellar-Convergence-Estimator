package visualization;

import model.ProgressData;
import model.ProgressPoint;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.util.ArrayList;
import java.util.List;

public class ProgressGraph {

    public static void show(double mass) {

        List<ProgressPoint> points =
                ProgressData.generate(mass);

        List<Double> xData = new ArrayList<>();
        List<Double> yData = new ArrayList<>();

        for (ProgressPoint point : points) {

            xData.add(point.getTime());
            yData.add(point.getProgress());

        }

        XYChart chart =
                QuickChart.getChart(
                        "Main Sequence Progress",
                        "Time (Years)",
                        "Progress (%)",
                        "Progress",
                        xData,
                        yData
                );

        new SwingWrapper<>(chart)
                .displayChart();
    }
}