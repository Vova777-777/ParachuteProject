package ru.vova777.coordinatePlane;

public class SecondCoordinateQuarter extends CoordinateQuarter {


    @Override
    public double getFinishSectionX(double x0, double length, double azimuth) {
        double deltaX = (Math.cos(Math.toRadians(180 - azimuth)) * length);
        double x = x0 - deltaX;
        return x;
    }

    @Override
    public double getFinishSectionY(double y0, double length, double azimuth) {
        double deltaY = (Math.sin(Math.toRadians(180 - azimuth)) * length);
        double y = y0 + deltaY;
        return y;
    }

    @Override
    public double getAzimuth(double delta_x, double lengthTrack) {
        double angle = Math.toDegrees(Math.acos(delta_x / lengthTrack));
        return (180 - angle);
    }

    @Override
    public double getDelta_x(double x0, double finish_x) {
        return (x0 - finish_x);
    }

    @Override
    public double getDelta_y(double y0, double finish_y) {
        return (finish_y - y0);
    }

    public static void main(String[] args) {
//        SecondCoordinateQuarter qua = new SecondCoordinateQuarter();
//        System.out.println(qua.getFinishSectionX(100,2000,160));
//        System.out.println(qua.getAzimuth(-100,2000));
//        System.out.println(qua.getLength(100,200,-1779,884));
    }
}


