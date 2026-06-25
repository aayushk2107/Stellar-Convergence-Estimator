/*
    Stores the result of a search algorithm.

    Contains:
    - The estimated age
    - The number of iterations performed
*/

package algorithm;

public class SearchResult {
    public double age;
    public int iterations;
    public SearchResult(double age,int iterations) {
        this.age = age;
        this.iterations = iterations;
    }
}
