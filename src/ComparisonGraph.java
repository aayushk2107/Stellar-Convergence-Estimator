package visualization;

import algorithm.BinarySearchSolver;
import algorithm.SearchResult;
import data.StarRepository;
import model.SimulationData;
import model.SimulationPoint;
import model.Star;
import model.StellarModel;
import org.knowm.xchart.*;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.util.ArrayList;
import java.util.List;

public class ComparisonGraph {

    public static void showComparisonGraph(double targetHelium) {

        String[] starNames = {
                "Sun",
                "Eta Carinae"
        };

        XYChart chart =
                new XYChartBuilder()
                        .width(950)
                        .height(600)
                        .title("Sun vs Eta Carinae")
                        .xAxisTitle("Time (Years)")
                        .yAxisTitle("Helium Fraction")
                        .build();

        for (String name : starNames) {

            Star star =
                    StarRepository.findByName(name);

            double mass =
                    star.getMass();

            List<SimulationPoint> points =
                    SimulationData.generate(mass);

            List<Double> x =
                    new ArrayList<>();

            List<Double> y =
                    new ArrayList<>();

            for (SimulationPoint point : points) {

                x.add(point.getTime());
                y.add(point.getHelium());

            }

            XYSeries curve =
                    chart.addSeries(
                            star.getName(),
                            x,
                            y
                    );

            curve.setMarker(
                    SeriesMarkers.NONE
            );

            SearchResult result =
                    BinarySearchSolver.findTimeForHelium(
                            mass,
                            targetHelium
                    );

            List<Double> pointX =
                    new ArrayList<>();

            List<Double> pointY =
                    new ArrayList<>();

            pointX.add(result.age);

            pointY.add(
                    StellarModel.helium(
                            result.age,
                            mass
                    )
            );

            XYSeries marker =
                    chart.addSeries(
                            star.getName() + " Result",
                            pointX,
                            pointY
                    );

            marker.setMarker(
                    SeriesMarkers.CIRCLE
            );

            marker.setLineStyle(
                    SeriesLines.NONE
            );
        }

        List<Double> hx =
                new ArrayList<>();

        List<Double> hy =
                new ArrayList<>();

        hx.add(0.0);
        hx.add(StellarModel.lifetime(1.0));

        hy.add(targetHelium);
        hy.add(targetHelium);

        XYSeries target =
                chart.addSeries(
                        "Target Helium",
                        hx,
                        hy
                );

        target.setMarker(
                SeriesMarkers.NONE
        );

        target.setLineStyle(
                SeriesLines.DASH_DASH
        );

        new SwingWrapper<>(chart)
                .displayChart();
    }

}