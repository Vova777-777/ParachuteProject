package ru.vova777.coordinatePlane;

public class FirstCoordinateQuarter extends CoordinateQuarter {



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
