package ru.vova777.ControlParachute;

public class TrackResult {
    double x0;
    double y0;
    double finishX;
    double finishY;
    double length;
    double azimuth;

    public TrackResult(double x0, double y0, double finishX, double finishY, double length, double azimuth) {
        this.x0 = x0;
        this.y0 = y0;
        this.finishX = finishX;
        this.finishY = finishY;
        this.length = length;
        this.azimuth = azimuth;
    }
}
