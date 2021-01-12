package ru.vova777.coordinateParachuteNotControl;

public abstract class CoordinateQuarter {
    int x0;
    int y0;
    int length;
    int azimuth;


    public CoordinateQuarter() {
        this.x0 = x0;
        this.y0 = y0;
        this.length = length;
        this.azimuth = azimuth;
    }

    public abstract int getFinishSectionX(int x0,int length, int azimuth);
    public abstract int getFinishSectionY(int y0, int length, int azimuth);
}
