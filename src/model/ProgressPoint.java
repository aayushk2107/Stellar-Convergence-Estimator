package model;

public class ProgressPoint {

    private final double time;
    private final double progress;

    public ProgressPoint(double time, double progress) {
        this.time = time;
        this.progress = progress;
    }

    public double getTime() {
        return time;
    }

    public double getProgress() {
        return progress;
    }
}