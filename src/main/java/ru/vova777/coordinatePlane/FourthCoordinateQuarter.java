package ru.vova777.coordinatePlane;

public class FourthCoordinateQuarter extends CoordinateQuarter {

    @Override
    public double getFinishSectionX(double x0, double length, double azimuth) {
        double deltaX = (Math.cos(Math.toRadians(360 - azimuth)) * length);
        double x = x0 + deltaX;
        return x;
    }

    @Override
    public double getFinishSectionY(double y0, double length, double azimuth) {
        double deltaY = (Math.sin(Math.toRadians(360 - azimuth)) * length);
        double y = y0 - deltaY;
        return y;
    }

    @Override
    public double getAzimuth(double delta_x, double lengthTrack) {
        double angle = Math.toDegrees(Math.acos((double) delta_x / lengthTrack));
        return  (360 - angle);
    }

    @Override
    public double getDelta_x(double x0, double finish_x) {
        return (finish_x - x0);
    }

    @Override
    public double getDelta_y(double y0, double finish_y) {
        return (y0 - finish_y);
    }
}
