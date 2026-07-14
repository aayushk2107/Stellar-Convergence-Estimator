package visualization;

import model.SimulationData;
import model.SimulationPoint;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.util.ArrayList;
import java.util.List;

public class GraphDemo {

    public static void showHeliumGraph(double mass) {

        List<SimulationPoint> points =
                SimulationData.generate(mass);

        List<Double> xData =
                new ArrayList<>();

        List<Double> yData =
                new ArrayList<>();

        for (SimulationPoint point : points) {

            xData.add(
                    point.getTime()
            );

            yData.add(
                    point.getHelium()
            );
        }

        XYChart chart =
                QuickChart.getChart(
                        "Helium vs Time",
                        "Time (Years)",
                        "Helium Fraction",
                        "Helium",
                        xData,
                        yData
                );

        new SwingWrapper<>(chart)
                .displayChart();
    }
}