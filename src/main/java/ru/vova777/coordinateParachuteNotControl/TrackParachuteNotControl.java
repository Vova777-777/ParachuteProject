package ru.vova777.coordinateParachuteNotControl;

import ru.vova777.data.SectionAltitude;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Queue;

public class TrackParachuteNotControl {
    int x0;
    int y0;
    int azimuthTrack;
    int lengthTrack;
    int x;
    int y;
    Queue<SectionAltitude> sectionAltitudes;







    public int getFinishTrackX(int x0, Queue<SectionAltitude> sectionAltitudes){
        int finishX = 0;
        int timesCycle = sectionAltitudes.size();
        for (int i = 0; i < timesCycle; i ++){
            SectionAltitude sectionAltitude = sectionAltitudes.poll();
            CoordinateQuarter ccq = getNeedfulCoordinateQuarter(sectionAltitude.getAzimuthWind());

            finishX = SectionTrack.getFinishX(x0, ccq, sectionAltitude);
            x0 = finishX;
        }
        return finishX;
    }

    public int getFinishTrackY(int y0, Queue<SectionAltitude> sectionAltitudes){
        int finishY = 0;
        int timesCycle = sectionAltitudes.size();
        for (int i = 0; i < timesCycle; i ++){
            SectionAltitude sectionAltitude = sectionAltitudes.poll();
            CoordinateQuarter ccq = getNeedfulCoordinateQuarter(sectionAltitudes.poll().getAzimuthWind());
            finishY = SectionTrack.getFinishY(y0, ccq, sectionAltitudes.poll());
            y0 = SectionTrack.getFinishY(y0, ccq, sectionAltitudes.poll());
        }
        //int finishY = y0;
        return finishY;
    }


    private CoordinateQuarter getNeedfulCoordinateQuarter(int azimuthTrack){
        if (azimuthTrack >= 0 && azimuthTrack <= 90) return new FirstCoordinateQuarter();
        else if (azimuthTrack > 90 && azimuthTrack <= 180) return new SecondCoordinateQuarter();
        else if (azimuthTrack > 180 && azimuthTrack <= 270) return new ThirdCoordinateQuarter();
        return new FourthCoordinateQuarter();
    }



    public static void main(String[] args) throws IOException, URISyntaxException {
//        DataReceiverManual receiverManual = new CreatorSectionsAltitudeFromUserConsole();
//        DataReceiverAuto receiverAuto = new CreatorSectionsAltitudeFromFile();
//        CollectorParametersJump jump = new CollectorParametersJump(receiverAuto, receiverManual);
//        Queue<SectionAltitude> sectionAltitudes = jump.choiceSourceSectionsAltitude();
//
//        TrackParachuteNotControl track = new TrackParachuteNotControl();
//        track.getFinishTrackX(jump.x0, sectionAltitudes);
//        track.getFinishTrackY(jump.y0, sectionAltitudes);
//        System.out.println(track.getFinishTrackX(jump.x0, sectionAltitudes));
//        System.out.println(track.getFinishTrackY(jump.y0, sectionAltitudes));

        SectionAltitude sA1 = new SectionAltitude(100);
        sA1.setAzimuthWind(45);
        sA1.setWindStrength(5);
        SectionAltitude sA2 = new SectionAltitude(100);
        sA2.setAzimuthWind(30);
        sA2.setWindStrength(10);
        Queue<SectionAltitude> sectionAltitudes = new ArrayDeque<>();
        sectionAltitudes.add(sA1);
        sectionAltitudes.add(sA2);
        System.out.println(new TrackParachuteNotControl().getFinishTrackX(10,sectionAltitudes));

    }


}
