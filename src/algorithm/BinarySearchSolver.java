/*
    Uses binary search to find the age
    at which a star reaches a target
    helium fraction.
*/

package algorithm;

import model.StellarModel;

public class BinarySearchSolver {

    public static SearchResult findTimeForHelium(
            double mass,
            double targetHelium) {

        double low = 0;
        double high = StellarModel.lifetime(mass);

        double eps = 1e4;

        int iterations = 0;

        while (high - low > eps) {

            iterations++;

            double mid = (low + high) / 2;

            if (StellarModel.helium(mid, mass)
                    < targetHelium) {

                low = mid;
            } else {

                high = mid;
            }
        }

        return new SearchResult(
                low,
                iterations
        );
    }
}