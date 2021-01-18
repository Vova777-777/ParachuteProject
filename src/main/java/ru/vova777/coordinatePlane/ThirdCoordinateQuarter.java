package ru.vova777.coordinatePlane;

public class ThirdCoordinateQuarter extends CoordinateQuarter {


    @Override
    public int getFinishSectionX(int x0, int length, int azimuth) {
        int deltaX = (int) (Math.sin(Math.toRadians(270 - azimuth)) * length);
        int x = x0 - deltaX;
        return x;
    }

    @Override
    public int getFinishSectionY(int y0, int length, int azimuth) {
        int deltaY = (int) (Math.cos(Math.toRadians(270 - azimuth)) * length);
        int y = y0 - deltaY;
        return y;
    }

    @Override
    public double getAzimuth(int delta_x, int lengthTrack) {
        double angle = Math.toDegrees(Math.asin((double) delta_x / lengthTrack));
        return  (270 - angle);
    }

    @Override
    public int getDelta_x(int x0, int finish_x) {
        return (x0 - finish_x);
    }

    @Override
    public int getDelta_y(int y0, int finish_y) {
        return (y0 - finish_y);
    }
}
