package ru.vova777.coordinateParachuteNotControl;

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
}
