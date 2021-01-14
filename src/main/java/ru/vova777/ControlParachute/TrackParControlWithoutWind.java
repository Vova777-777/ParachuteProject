package ru.vova777.ControlParachute;

import ru.vova777.coordinateParachuteNotControl.TrackParachuteNotControl;
import ru.vova777.coordinatePlane.CoordinateQuarter;
import ru.vova777.data.SectionAltitude;
import ru.vova777.data.receiver.auto.CreatorSectionsAltitudeFromFile;
import ru.vova777.data.receiver.auto.DataReceiverAuto;
import ru.vova777.data.receiver.manual.CreatorSectionsAltitudeFromUserConsole;
import ru.vova777.data.receiver.manual.DataReceiverManual;
import ru.vova777.parametersJump.CollectorParametersJump;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Queue;

import static ru.vova777.coordinateParachuteNotControl.TrackParachuteNotControl.getFinishTrackX;
import static ru.vova777.coordinateParachuteNotControl.TrackParachuteNotControl.getFinishTrackY;

public class TrackParControlWithoutWind {
    int x0;
    int y0;

    public TrackParControlWithoutWind(int x0, int y0) {
        this.x0 = x0;
        this.y0 = y0;
    }

//    List<ParachuteControl> getAllTracksParControlNotWind (){
//       return new List<ParachuteControl>();
//    }



    int getFinishX_OfParControl(int length, int azimuth){
        CoordinateQuarter cq = CoordinateQuarter.getNeedfulCoordinateQuarter(azimuth);
        return cq.getFinishSectionX(x0, length, azimuth);
    }

    int getFinishY_OfParControl(int length, int azimuth){
        CoordinateQuarter cq = CoordinateQuarter.getNeedfulCoordinateQuarter(azimuth);
        return cq.getFinishSectionX(y0, length, azimuth);
    }

    int getLengthTrack(int altitude, double coefficient){
        return (int) ((altitude - 500) * coefficient);
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        DataReceiverManual receiverManual = new CreatorSectionsAltitudeFromUserConsole();
        DataReceiverAuto receiverAuto = new CreatorSectionsAltitudeFromFile();
        CollectorParametersJump jump = new CollectorParametersJump(receiverAuto, receiverManual);
        Queue<SectionAltitude> sectionAltitudes = jump.choiceSourceSectionsAltitude();
        int trackNotWindX0 = TrackParachuteNotControl.getFinishTrackX(jump.x0, sectionAltitudes);
        int trackNotWindY0 = TrackParachuteNotControl.getFinishTrackY(jump.y0, sectionAltitudes);
        double coefficient = (double) jump.speedHorizontal / jump.speedDown;
        TrackParControlWithoutWind trParNotWind = new TrackParControlWithoutWind(trackNotWindX0, trackNotWindY0);


    }

}
