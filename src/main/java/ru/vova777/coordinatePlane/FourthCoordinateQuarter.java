package ru.vova777.coordinatePlane;

public class FourthCoordinateQuarter extends CoordinateQuarter {




    @Override
    public int getFinishSectionX(int x0, int length, int azimuth) {
        int deltaX = (int) (Math.cos(Math.toRadians(360 - azimuth)) * length);
        int x = x0 + deltaX;
        return x;
    }

    @Override
    public int getFinishSectionY(int y0, int length, int azimuth) {
        int deltaY = (int) (Math.sin(Math.toRadians(360 - azimuth)) * length);
        int y = y0 + deltaY;
        return y;
    }

    @Override
    public int getAzimuth(int delta_x, int lengthTrack) {
        int angle = (int) Math.toDegrees(Math.acos(delta_x / lengthTrack));
        return 360 - angle;
    }
}
