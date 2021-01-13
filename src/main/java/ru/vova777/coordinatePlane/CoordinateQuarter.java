package ru.vova777.coordinatePlane;

public abstract class CoordinateQuarter {


    public abstract int getFinishSectionX(int x0,int length, int azimuth);
    public abstract int getFinishSectionY(int y0, int length, int azimuth);

    public static CoordinateQuarter getNeedfulCoordinateQuarter(int azimuthTrack){
        if (azimuthTrack >= 0 && azimuthTrack <= 90) return new FirstCoordinateQuarter();
        else if (azimuthTrack > 90 && azimuthTrack <= 180) return new SecondCoordinateQuarter();
        else if (azimuthTrack > 180 && azimuthTrack <= 270) return new ThirdCoordinateQuarter();
        return new FourthCoordinateQuarter();
    }
}
