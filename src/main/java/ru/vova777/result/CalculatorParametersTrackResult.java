package ru.vova777.result;

import ru.vova777.controlParachute.TrackParControlNotWind;
import ru.vova777.coordinatePlane.CoordinateQuarter;

public class CalculatorParametersTrackResult {

    CoordinateQuarter ccq;

    CalculatorParametersTrackResult(/*CoordinateQuarter ccq*/){
    }

    public double getLengthTrackResult (double x0, double y0, double finish_x, double finish_y){
        ccq = CoordinateQuarter.getNeedfulCoordinateQuarter(x0, y0, finish_x, finish_y);
        double delta_x = ccq.getDelta_x(x0, finish_x);
        double delta_y = ccq.getDelta_y(y0, finish_y);
        return ccq.getLength(delta_x, delta_y);
    }

    public double getAzimuthTrackResult (double x0, double y0, double finish_x,
                                         double finish_y, double lengthTrack) {
        double delta_x = ccq.getDelta_x(x0, finish_x);
       // double delta_y = ccq.getDelta_y(y0, finish_y);
        ccq = CoordinateQuarter.getNeedfulCoordinateQuarter(x0, y0, finish_x, finish_y);
        return ccq.getAzimuth(delta_x, lengthTrack);
    }

    public double getFinishX(TrackParControlNotWind trackNotWind, double altitude,
                             double speedHorizontal, double speedDown){
        return trackNotWind.getFinish_X(ccq, altitude, speedHorizontal, speedDown);
    }

    public double getFinishY(TrackParControlNotWind trackNotWind, double altitude,
                             double speedHorizontal, double speedDown){
        return trackNotWind.getFinish_Y(ccq, altitude, speedHorizontal, speedDown);
    }
}
