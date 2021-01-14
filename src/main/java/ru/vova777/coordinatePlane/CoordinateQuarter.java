package ru.vova777.coordinatePlane;

public abstract class CoordinateQuarter {


    public abstract int getFinishSectionX(int x0,int length, int azimuth);
    public abstract int getFinishSectionY(int y0, int length, int azimuth);

    public static CoordinateQuarter getNeedfulCoordinateQuarter(int azimuthTrack){
        if (0 <= azimuthTrack && azimuthTrack <= 90) return new FirstCoordinateQuarter();
        else if (90 < azimuthTrack && azimuthTrack <= 180) return new SecondCoordinateQuarter();
        else if (180 < azimuthTrack && azimuthTrack <= 270) return new ThirdCoordinateQuarter();
        return new FourthCoordinateQuarter();
    }
}
