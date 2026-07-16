package visualization;

import algorithm.BinarySearchSolver;
import algorithm.SearchResult;
import model.SimulationData;
import model.SimulationPoint;
import org.knowm.xchart.*;
import org.knowm.xchart.style.markers.SeriesMarkers;

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

            xData.add(point.getTime());
            yData.add(point.getHelium());

        }

        XYChart chart =
                new XYChartBuilder()
                        .width(900)
                        .height(600)
                        .title("Helium vs Time")
                        .xAxisTitle("Time (Years)")
                        .yAxisTitle("Helium Fraction")
                        .build();

        chart.addSeries(
                "Helium Curve",
                xData,
                yData
        );

        SearchResult result =
                BinarySearchSolver.findTimeForHelium(
                        mass,
                        0.50
                );

        List<Double> xPoint =
                new ArrayList<>();

        List<Double> yPoint =
                new ArrayList<>();

        xPoint.add(result.age);

        yPoint.add(
                model.StellarModel.helium(
                        result.age,
                        mass
                )
        );

        XYSeries marker =
                chart.addSeries(
                        "Binary Search Result",
                        xPoint,
                        yPoint
                );

        marker.setMarker(
                SeriesMarkers.CIRCLE
        );

        new SwingWrapper<>(chart)
                .displayChart();

    }

}