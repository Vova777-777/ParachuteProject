package ru.vova777.coordinateParachuteNotControl;

public class FirstCoordinateQuarter extends CoordinateQuarter {
    int x0;
    int y0;
    int length;
    int azimuth;

    public FirstCoordinateQuarter() {
        this.x0 = x0;
        this.y0 = y0;
        this.length = length;
        this.azimuth = azimuth;
    }


    @Override
    public int getFinishSectionX(int x0, int length, int azimuth) {

        int deltaX = (int) (Math.cos(Math.toRadians(azimuth)) * length);
        int x = x0 + deltaX;
        return x;
    }

    @Override
    public int getFinishSectionY(int y0, int length, int azimuth) {
        int deltaY = (int) (Math.sin(Math.toRadians(azimuth)) * length);
        int y = y0 + deltaY;
        return y;
    }
}
