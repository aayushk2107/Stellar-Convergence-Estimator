# Stellar-Convergence-Estimator ⭐
A high-precision Java tool that estimates the age of a star based on its mass and observed Helium levels. 

### 🧬 The Concept
Unlike a linear search, this project utilizes a *Binary Search Algorithm* to navigate the non-linear "burn curve" of a star.
 It treats the star's lifespan as a monotonic structure where the rate of Helium accumulation accelerates as the core densifies.

### 📐 The Geometry of the Search
The search logic follows a *convergent geometric model*.
 As the algorithm eliminates half of the search space with each iteration, the "radius of uncertainty" narrows—much like the cross-section of a cone—until
 it reaches a singular point of temporal clarity.

### 🚀 Features
* *Quadratic Burn Model:* Simulates realistic core acceleration ($t^2$ curve).
* *Mass-Lifespan Scaling:* Dynamically calculates max lifespan based on solar masses.
* *Resilient Estimation:* Tracks the minimum error to provide the best possible age approximation, even with floating-point complexity.

### 🛠️ Usage
1. Compile: javac StellarAgeEstimator.java
2. Run: java StellarAgeEstimator
3. Input the star's mass and helium percentage to get its predicted age and final cosmic fate.
