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

public class TrackParControlNotWind {
    double x0;
    double y0;
    double lengthTrack;
    double azimuth;

    public TrackParControlNotWind(double x0, double y0, double azimuth) {
        this.x0 = x0;
        this.y0 = y0;
        this.azimuth = azimuth;
    }

//    List<ParachuteControl> getAllTracksParControlNotWind (){
//       return new List<ParachuteControl>();
//    }



//    int getFinishX_OfParControl(int length, int azimuth){
//        CoordinateQuarter cq = CoordinateQuarter.getNeedfulCoordinateQuarter(azimuth);
//        return cq.getFinishSectionX(x0, length, azimuth);
//    }
//
//    int getFinishY_OfParControl(int length, int azimuth){
//        CoordinateQuarter cq = CoordinateQuarter.getNeedfulCoordinateQuarter(azimuth);
//        return cq.getFinishSectionX(y0, length, azimuth);
//    }
//
    private double getLengthTrack(double altitude, double speedHorizontal, double speedDown){
        double coefficient = speedHorizontal / speedDown;
        return  ((altitude - 500) * coefficient);
    }

    public double getFinish_X(CoordinateQuarter ccq, double altitude, double speedHorizontal, double speedDown){
        ccq = CoordinateQuarter.getNeedfulCoordinateQuarter(azimuth);
        lengthTrack = getLengthTrack(altitude, speedHorizontal, speedDown);
        return ccq.getFinishSectionX (x0, lengthTrack, azimuth);
    }

    public double getFinish_Y(CoordinateQuarter ccq, double altitude, double speedHorizontal, double speedDown){
        ccq = CoordinateQuarter.getNeedfulCoordinateQuarter(azimuth);
        lengthTrack = getLengthTrack(altitude, speedHorizontal, speedDown);
        return ccq.getFinishSectionY (y0, lengthTrack, azimuth);
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        DataReceiverManual receiverManual = new CreatorSectionsAltitudeFromUserConsole();
        DataReceiverAuto receiverAuto = new CreatorSectionsAltitudeFromFile();
        CollectorParametersJump jump = new CollectorParametersJump(receiverAuto, receiverManual);
        Queue<SectionAltitude> sectionAltitudes = jump.choiceSourceSectionsAltitude();
        double trackNotWindX0 = TrackParachuteNotControl.getFinishTrackX(jump.x0, sectionAltitudes);
        double trackNotWindY0 = TrackParachuteNotControl.getFinishTrackY(jump.y0, sectionAltitudes);
        double coefficient = (double) jump.speedHorizontal / jump.speedDown;
        CoordinateQuarter cq;
       // TrackParControlWithoutWind trParNotWind = new TrackParControlWithoutWind(trackNotWindX0, trackNotWindY0);


    }

}
