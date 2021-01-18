package ru.vova777.coordinatePlane;

public abstract class CoordinateQuarter {


    public abstract double getFinishSectionX(double x0,double length, double azimuth);
    public abstract double getFinishSectionY(double y0, double length, double azimuth);
    public abstract double getAzimuth(double delta_x, double lengthTrack);
    public abstract double getDelta_x (double x0, double finish_x);
    public abstract double getDelta_y (double y0, double finish_y);

    public static CoordinateQuarter getNeedfulCoordinateQuarter(double azimuthTrack){
        if (0 <= azimuthTrack && azimuthTrack <= 90) return new FirstCoordinateQuarter();
        else if (90 < azimuthTrack && azimuthTrack <= 180) return new SecondCoordinateQuarter();
        else if (180 < azimuthTrack && azimuthTrack <= 270) return new ThirdCoordinateQuarter();
        return new FourthCoordinateQuarter();
    }

    public static CoordinateQuarter getNeedfulCoordinateQuarter(double x0, double y0, double finish_x, double finish_y){
        if (x0 <= finish_x && y0 <= finish_y) return new FirstCoordinateQuarter();
        else if (finish_x <= x0 && y0 <= finish_y) return new SecondCoordinateQuarter();
        else if (finish_x <= x0 && finish_y <= y0) return new ThirdCoordinateQuarter();
        else return new FourthCoordinateQuarter();
    }

    public double getLength (double delta_x, double delta_y){
        return  Math.round(Math.sqrt((delta_x * delta_x) + (delta_y * delta_y)));
    }
}
