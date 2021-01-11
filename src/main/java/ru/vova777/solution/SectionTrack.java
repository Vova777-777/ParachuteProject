package ru.vova777.solution;

import ru.vova777.data.SectionAltitude;

public class SectionTrack {
//    int x0;
//    int y0;
//    int x;
//    int y;
//    int lengthSectionTrack;
//    int azimuthSectionTrack;
//
//    public SectionTrack(){
//        this.x0 = x0;
//        this.y0 = y0;
//        this.x = x;
//        this.y = y;
//        this.lengthSectionTrack = 0;
//        this.azimuthSectionTrack = 0;
//
//    }

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
        return ccq.getFinishSectionX(y0, getLengthSectionTrack(secAlt), getAzimuthTrack(secAlt));
    }


}
