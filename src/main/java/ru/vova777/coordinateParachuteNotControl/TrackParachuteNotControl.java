package ru.vova777.coordinateParachuteNotControl;

import ru.vova777.coordinatePlane.*;
import ru.vova777.data.SectionAltitude;
import ru.vova777.data.receiver.auto.CreatorSectionsAltitudeFromFile;
import ru.vova777.data.receiver.auto.DataReceiverAuto;
import ru.vova777.data.receiver.manual.CreatorSectionsAltitudeFromUserConsole;
import ru.vova777.data.receiver.manual.DataReceiverManual;
import ru.vova777.parametersJump.CollectorParametersJump;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class TrackParachuteNotControl {


    public static int getFinishTrackX(int x0, Queue<SectionAltitude> sectionAltitudes){
        int finishCoordinate = 0;
        Iterator<SectionAltitude> iterator = sectionAltitudes.iterator();
        while (iterator.hasNext()){
            SectionAltitude sectionAltitude = iterator.next();
            CoordinateQuarter cq = CoordinateQuarter.getNeedfulCoordinateQuarter(sectionAltitude.getAzimuthWind());
                finishCoordinate = SectionTrack.getFinishX(x0, cq, sectionAltitude);
            x0 = finishCoordinate;
        }
        return finishCoordinate;
    }

    public static int getFinishTrackY(int y0, Queue<SectionAltitude> sectionAltitudes){
        int finishCoordinate = 0;
        Iterator<SectionAltitude> iterator = sectionAltitudes.iterator();
        while (iterator.hasNext()){
            SectionAltitude sectionAltitude = iterator.next();
            CoordinateQuarter cq = CoordinateQuarter.getNeedfulCoordinateQuarter(sectionAltitude.getAzimuthWind());
            finishCoordinate = SectionTrack.getFinishY(y0, cq, sectionAltitude);
            y0 = finishCoordinate;
        }
        return finishCoordinate;
    }







    public static void main(String[] args) throws IOException, URISyntaxException {
//        DataReceiverManual receiverManual = new CreatorSectionsAltitudeFromUserConsole();
//        DataReceiverAuto receiverAuto = new CreatorSectionsAltitudeFromFile();
//        CollectorParametersJump jump = new CollectorParametersJump(receiverAuto, receiverManual);
//        Queue<SectionAltitude> sectionAltitudes = jump.choiceSourceSectionsAltitude();
//        getFinishTrackX(jump.x0, sectionAltitudes);
//        getFinishTrackY(jump.y0, sectionAltitudes);
//        System.out.println(getFinishTrackX(jump.x0, sectionAltitudes));
//        System.out.println(getFinishTrackY(jump.y0, sectionAltitudes));

        SectionAltitude sA1 = new SectionAltitude(60);
        sA1.setAzimuthWind(75);
        sA1.setWindStrength(10);
        SectionAltitude sA2 = new SectionAltitude(100);
        sA2.setAzimuthWind(130);
        sA2.setWindStrength(15);
        SectionAltitude sA3 = new SectionAltitude(100);
        sA3.setAzimuthWind(270);
        sA3.setWindStrength(5);
        Queue<SectionAltitude> sectionAltitudes = new ArrayDeque<>();
        sectionAltitudes.add(sA1);
        sectionAltitudes.add(sA2);
        sectionAltitudes.add(sA3);
        System.out.println(getFinishTrackX(-300,sectionAltitudes));
        System.out.println(getFinishTrackY(100,sectionAltitudes));
    }


}
