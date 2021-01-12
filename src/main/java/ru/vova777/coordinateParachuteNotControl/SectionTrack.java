package ru.vova777.coordinateParachuteNotControl;

import ru.vova777.data.SectionAltitude;

public class SectionTrack {


    public static int getLengthSectionTrack (SectionAltitude secAlt){
        return secAlt.getTime() * secAlt.getWindStrength();
    }

    public static int getAzimuthTrack(SectionAltitude secAlt){
        return secAlt.getAzimuthWind();
    }

    public static int getFinishX(int x0, CoordinateQuarter ccq, SectionAltitude secAlt){
        return ccq.getFinishSectionX(x0, getLengthSectionTrack(secAlt), getAzimuthTrack(secAlt));
    }

    public static int getFinishY(int y0, CoordinateQuarter ccq, SectionAltitude secAlt){
        return ccq.getFinishSectionY(y0, getLengthSectionTrack(secAlt), getAzimuthTrack(secAlt));
    }


}
