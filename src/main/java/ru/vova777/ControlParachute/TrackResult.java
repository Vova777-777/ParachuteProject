package ru.vova777.ControlParachute;

public class TrackResult {
    int x0;
    int y0;
    int finishX;
    int finishY;
    int length;
    int azimuth;

    public TrackResult(int x0, int y0, int finishX, int finishY, int length, int azimuth) {
        this.x0 = x0;
        this.y0 = y0;
        this.finishX = finishX;
        this.finishY = finishY;
        this.length = length;
        this.azimuth = azimuth;
    }
}
