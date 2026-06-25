/*
    Uses linear search as a baseline
    algorithm to compare against
    binary search performance.
*/

package algorithm;

import model.StellarModel;

public class LinearSearchSolver {

    public static SearchResult findTimeForHelium(
            double mass,
            double targetHelium) {

        double lifetime =
                StellarModel.lifetime(mass);

        double step = lifetime/10000.0;

        double time = 0;

        int iterations = 0;

        while (time <= lifetime) {

            iterations++;

            double helium =
                    StellarModel.helium(
                            time,
                            mass
                    );

            if (helium >= targetHelium) {

                return new SearchResult(
                        time,
                        iterations
                );
            }

            time += step;
        }

        return new SearchResult(
                lifetime,
                iterations
        );
    }
}