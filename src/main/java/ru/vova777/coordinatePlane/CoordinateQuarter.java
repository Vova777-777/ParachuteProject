package ru.vova777.coordinatePlane;

public abstract class CoordinateQuarter {


    public abstract int getFinishSectionX(int x0,int length, int azimuth);
    public abstract int getFinishSectionY(int y0, int length, int azimuth);
    public abstract double getAzimuth(int delta_x, int lengthTrack);


    public static CoordinateQuarter getNeedfulCoordinateQuarter(int azimuthTrack){
        if (0 <= azimuthTrack && azimuthTrack <= 90) return new FirstCoordinateQuarter();
        else if (90 < azimuthTrack && azimuthTrack <= 180) return new SecondCoordinateQuarter();
        else if (180 < azimuthTrack && azimuthTrack <= 270) return new ThirdCoordinateQuarter();
        return new FourthCoordinateQuarter();
    }

    public static CoordinateQuarter getNeedfulCoordinateQuarter(int delta_x, int delta_y){
        if (0 <= delta_x && 0 <= delta_y) return new FirstCoordinateQuarter();
        else if (delta_x <= 0 && 0 <= delta_y) return new SecondCoordinateQuarter();
        else if (delta_x <= 0 && delta_y <= 0) return new ThirdCoordinateQuarter();
        else return new FourthCoordinateQuarter();
    }

    public int getLength (int x0, int y0, int finish_x, int finish_y){
        int delta_x = getDelta_x(finish_x, x0);
        int delta_y = getDelta_y(finish_y, y0);
        return (int) Math.round(Math.sqrt((delta_x * delta_x) + (delta_y * delta_y)));
    }

    private int getDelta_x(int finish_x, int x0){
        return finish_x - x0;
    }

    private int getDelta_y(int finish_y, int y0){
        return finish_y - y0;
    }


}
