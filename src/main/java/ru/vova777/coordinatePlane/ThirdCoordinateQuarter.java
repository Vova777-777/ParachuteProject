package ru.vova777.coordinatePlane;

public class ThirdCoordinateQuarter extends CoordinateQuarter {


    @Override
    public double getFinishSectionX(double x0, double length, double azimuth) {
        double deltaX = (int) (Math.sin(Math.toRadians(270 - azimuth)) * length);
        double x = x0 - deltaX;
        return x;
    }

    @Override
    public double getFinishSectionY(double y0, double length, double azimuth) {
        double deltaY = (int) (Math.cos(Math.toRadians(270 - azimuth)) * length);
        double y = y0 - deltaY;
        return y;
    }

    @Override
    public double getAzimuth(double delta_x, double lengthTrack) {
        double angle = Math.toDegrees(Math.asin(delta_x / lengthTrack));
        return  (270 - angle);
    }

    @Override
    public double getDelta_x(double x0, double finish_x) {
        return (x0 - finish_x);
    }

    @Override
    public double getDelta_y(double y0, double finish_y) {
        return (y0 - finish_y);
    }
}
