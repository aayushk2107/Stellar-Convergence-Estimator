Stellar-Convergence-Estimator ⭐

Overview

Stellar-Convergence-Estimator is a Java-based simulation project that estimates a star’s age using its mass and observed helium percentage. The model treats stellar evolution as a monotonic process and applies a binary search algorithm to efficiently converge on the most probable age within a simulated lifespan.

This project is designed as a conceptual algorithmic model, not a physically accurate astrophysical calculator.

Core Idea

Many natural processes evolve in a monotonic direction over time. In this simulation, helium accumulation inside a star is modeled as a monotonic function of age. Because the function increases over time, binary search can be used instead of linear iteration to quickly approximate the age that best matches the observed helium level.

This demonstrates how algorithmic convergence can be applied to continuous, monotonic systems.

Model Assumptions

- Helium percentage increases monotonically over a star’s lifetime
- The burn progression follows a simplified quadratic curve (t² model)
- Stellar lifespan scales with mass using an approximate power-law relation
- The system is a conceptual simulation and does not use real stellar physics datasets

Features

- Binary Search Convergence: Efficiently narrows down the estimated age within a large search space
- Quadratic Burn Model: Simulates accelerating helium accumulation over time
- Mass-Based Lifespan Scaling: Adjusts lifespan dynamically based on stellar mass
- Error Minimization: Tracks the closest approximation instead of relying on exact matches
- Input Validation: Ensures physically reasonable input ranges

How It Works

1. The program estimates the maximum lifespan based on stellar mass.
2. It models helium accumulation as a monotonic function of time.
3. Binary search is applied over the lifespan range.
4. The algorithm converges on the age where simulated helium best matches the observed value.
5. The final output includes estimated age, predicted helium level, and approximation error.

Usage

Compile:

javac StellarCalculator.java

Run:

java StellarCalculator

Then input:

- Star Mass (in Solar Masses)
- Observed Helium Percentage (0–100)

Output

- Estimated Stellar Age
- Predicted Helium Percentage
- Estimation Error
- Life Completion Percentage
- Predicted Final Stellar Fate (White Dwarf / Neutron Star / Black Hole)

Limitations

- Uses a simplified burn curve instead of real stellar evolution equations
- Does not account for metallicity, fusion stages, or core temperature dynamics
- Intended for algorithmic demonstration, not scientific accuracy

Why This Project Matters

This project showcases the application of binary search beyond traditional sorted arrays. It demonstrates how monotonic modeling and convergence logic can be used to estimate unknown parameters in large search spaces, which is a common pattern in simulations, optimization problems, and scientific computing.

Future Improvements

- Replace quadratic burn model with multi-phase stellar evolution curves
- Introduce metallicity as an additional parameter
- Add graphical visualization of convergence
- Support noisy (non-perfectly monotonic) observational data
- Compare binary search vs linear search performance empirically
