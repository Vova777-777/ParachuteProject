package ru.vova777.coordinateParachuteNotControl;

import ru.vova777.coordinatePlane.CoordinateQuarter;
import ru.vova777.data.SectionAltitude;

public class SectionTrack {


    public static double getLengthSectionTrack (SectionAltitude secAlt){
        return secAlt.getTime() * secAlt.getWindStrength();
    }

    public static double getAzimuthTrack(SectionAltitude secAlt){
        return secAlt.getAzimuthWind();
    }

    public static double getFinishX(double x0, CoordinateQuarter ccq, SectionAltitude secAlt){
        return ccq.getFinishSectionX(x0, getLengthSectionTrack(secAlt), getAzimuthTrack(secAlt));
    }

    public static double getFinishY(double y0, CoordinateQuarter ccq, SectionAltitude secAlt){
        return ccq.getFinishSectionY(y0, getLengthSectionTrack(secAlt), getAzimuthTrack(secAlt));
    }


}
