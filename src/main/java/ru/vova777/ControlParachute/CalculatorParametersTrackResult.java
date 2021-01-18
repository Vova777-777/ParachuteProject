package ru.vova777.ControlParachute;

import ru.vova777.coordinateParachuteNotControl.TrackParachuteNotControl;
import ru.vova777.coordinatePlane.CoordinateQuarter;
import ru.vova777.data.receiver.manual.CreatorSectionsAltitudeFromUserConsole;

public class CalculatorParametersTrackResult {

    CoordinateQuarter ccq;

    CalculatorParametersTrackResult(CoordinateQuarter ccq){
    }

    public int getLengthTrackResult (int x0, int y0, int finish_x, int finish_y){
        ccq = CoordinateQuarter.getNeedfulCoordinateQuarter(x0, y0, finish_x, finish_y);
        int delta_x = ccq.getDelta_x(x0, finish_x);
        int delta_y = ccq.getDelta_y(y0, finish_y);
        return ccq.getLength(delta_x, delta_y);
    }

    public double getAzimuthTrackResult (int x0, int y0, int finish_x,
                                      int finish_y, int lengthTrack) {
        int delta_x = ccq.getDelta_x(x0, finish_x);
        int delta_y = ccq.getDelta_y(y0, finish_y);
        ccq = CoordinateQuarter.getNeedfulCoordinateQuarter(x0, y0, finish_x, finish_y);
        return ccq.getAzimuth(delta_x, lengthTrack);
    }

    public int getFinishX(TrackParControlNotWind trackNotWind, int altitude, int speedHorizontal, int speedDown){
        return trackNotWind.getFinish_X(ccq, altitude, speedHorizontal, speedDown);
    }

    public int getFinishY(TrackParControlNotWind trackNotWind, int altitude, int speedHorizontal, int speedDown){
        return trackNotWind.getFinish_Y(ccq, altitude, speedHorizontal, speedDown);
    }
}
