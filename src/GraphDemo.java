package visualization;

import algorithm.BinarySearchSolver;
import algorithm.SearchResult;
import model.SimulationData;
import model.SimulationPoint;
import model.StellarModel;
import org.knowm.xchart.*;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GraphDemo {

    public static void generateHeliumGraph(double mass) {

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

        double binaryAge =
                result.age;

        double targetHelium =
                StellarModel.helium(
                        binaryAge,
                        mass
                );

        // ---------- Horizontal Line ----------

        List<Double> horizontalX =
                new ArrayList<>();

        List<Double> horizontalY =
                new ArrayList<>();

        horizontalX.add(0.0);
        horizontalX.add(
                StellarModel.lifetime(mass)
        );

        horizontalY.add(targetHelium);
        horizontalY.add(targetHelium);

        chart.addSeries(
                "Target Helium",
                horizontalX,
                horizontalY
        );

        // ---------- Vertical Line ----------

        List<Double> verticalX =
                new ArrayList<>();

        List<Double> verticalY =
                new ArrayList<>();

        verticalX.add(binaryAge);
        verticalX.add(binaryAge);

        verticalY.add(0.25);
        verticalY.add(0.70);

        chart.addSeries(
                "Binary Search Age",
                verticalX,
                verticalY
        );

        // ---------- Solution Point ----------

        List<Double> xPoint =
                new ArrayList<>();

        List<Double> yPoint =
                new ArrayList<>();

        xPoint.add(binaryAge);
        yPoint.add(targetHelium);

        XYSeries marker =
                chart.addSeries(
                        "Solution",
                        xPoint,
                        yPoint
                );

        marker.setMarker(
                SeriesMarkers.CIRCLE
        );

        try {

            BitmapEncoder.saveBitmap(
                    chart,
                    "helium_graph",
                    BitmapEncoder.BitmapFormat.PNG
            );

            System.out.println(
                    "Graph saved as helium_graph.png"
            );

        }

        catch (IOException e) {

            e.printStackTrace();

        }

    }

}