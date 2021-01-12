package ru.vova777.solution;

public abstract class CalculationCoordinateQuarter {
    int x0;
    int y0;
    int length;
    int azimuth;


    public CalculationCoordinateQuarter(int x0, int y0, int length, int azimuth) {
        this.x0 = x0;
        this.y0 = y0;
        this.length = length;
        this.azimuth = azimuth;
    }

    public abstract int getFinishSectionX();
    public abstract int getFinishSectionY();
}
