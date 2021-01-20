package ru.vova777.result;

public class CollectorParametersAnswer {

    public double x0;
    public double y0;
    public double finishX;
    public double finishY;
    public double length;
    public double azimuthTrackResult;

    CollectorParametersAnswer(double x0, double y0, double finishX, double finishY, double length,
                         double azimuthTrackResult) {
        this.x0 = x0;
        this.y0 = y0;
        this.finishX = finishX;
        this.finishY = finishY;
        this.length = length;
        this.azimuthTrackResult = azimuthTrackResult;
    }

    @Override
    public String toString() {
        return "CollectorParametersAnswer{" +
                "x0=" + x0 +
                ", y0=" + y0 +
                ", finishX=" + finishX +
                ", finishY=" + finishY +
                ", length=" + length +
                ", azimuthTrackResult=" + azimuthTrackResult +
                '}';
    }
}
