package ru.vova777.coordinatePlane;

public abstract class CoordinateQuarter {


    public abstract int getFinishSectionX(int x0,int length, int azimuth);
    public abstract int getFinishSectionY(int y0, int length, int azimuth);
    public abstract double getAzimuth(int delta_x, int lengthTrack);
    public abstract int getDelta_x (int x0, int finish_x);
    public abstract int getDelta_y (int y0, int finish_y);

    public static CoordinateQuarter getNeedfulCoordinateQuarter(int azimuthTrack){
        if (0 <= azimuthTrack && azimuthTrack <= 90) return new FirstCoordinateQuarter();
        else if (90 < azimuthTrack && azimuthTrack <= 180) return new SecondCoordinateQuarter();
        else if (180 < azimuthTrack && azimuthTrack <= 270) return new ThirdCoordinateQuarter();
        return new FourthCoordinateQuarter();
    }

    public static CoordinateQuarter getNeedfulCoordinateQuarter(int x0, int y0,int finish_x, int finish_y){
        if (x0 <= finish_x && y0 <= finish_y) return new FirstCoordinateQuarter();
        else if (finish_x <= x0 && y0 <= finish_y) return new SecondCoordinateQuarter();
        else if (finish_x <= x0) return new ThirdCoordinateQuarter();
        else return new FourthCoordinateQuarter();
    }

    public int getLength (int delta_x, int delta_y){
        return (int) Math.round(Math.sqrt((delta_x * delta_x) + (delta_y * delta_y)));
    }
}
