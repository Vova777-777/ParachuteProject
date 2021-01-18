package ru.vova777.coordinatePlane;

public class SecondCoordinateQuarter extends CoordinateQuarter {


    @Override
    public int getFinishSectionX(int x0, int length, int azimuth) {
        int deltaX = (int) (Math.cos(Math.toRadians(180 - azimuth)) * length);
        int x = x0 - deltaX;
        return x;
    }

    @Override
    public int getFinishSectionY(int y0, int length, int azimuth) {
        int deltaY = (int) (Math.sin(Math.toRadians(180 - azimuth)) * length);
        int y = y0 + deltaY;
        return y;
    }

    @Override
    public double getAzimuth(int delta_x, int lengthTrack) {
        double angle = Math.toDegrees(Math.acos((double) delta_x / lengthTrack));
        return (180 - angle);
    }

    @Override
    public int getDelta_x(int x0, int finish_x) {
        return (x0 - finish_x);
    }

    @Override
    public int getDelta_y(int y0, int finish_y) {
        return (finish_y - y0);
    }

    public static void main(String[] args) {
//        SecondCoordinateQuarter qua = new SecondCoordinateQuarter();
//        System.out.println(qua.getFinishSectionX(100,2000,160));
//        System.out.println(qua.getAzimuth(-100,2000));
//        System.out.println(qua.getLength(100,200,-1779,884));
    }
}


