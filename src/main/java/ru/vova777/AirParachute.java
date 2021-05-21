package ru.vova777;

import ru.vova777.coordinateParachuteNotControl.TrackParachuteNotControl;
import ru.vova777.coordinatePlane.CoordinateQuarter;
import ru.vova777.data.SectionAltitude;
import ru.vova777.data.receiver.auto.CreatorSectionsAltitudeFromFile;
import ru.vova777.data.receiver.auto.DataReceiverAuto;
import ru.vova777.data.receiver.manual.CreatorSectionsAltitudeFromUserConsole;
import ru.vova777.data.receiver.manual.DataReceiverManual;
import ru.vova777.parametersJump.CollectorParametersJump;
import ru.vova777.result.CollectorParametersAnswer;
import ru.vova777.result.CreatorAnswer;
import ru.vova777.result.CreatorAnswerOverAzimuthParachute;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Queue;

public class AirParachute {
    public static void main(String[] args) {
        DataReceiverManual receiverManual = new CreatorSectionsAltitudeFromUserConsole();
        DataReceiverAuto receiverAuto = new CreatorSectionsAltitudeFromFile();

        CollectorParametersJump jump = null;
        try {
            jump = new CollectorParametersJump(receiverAuto, receiverManual);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        Queue<SectionAltitude> sectionAltitudes = null;
        try {
            sectionAltitudes = jump.choiceSourceSectionsAltitude();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        double trackNotWindX0 = TrackParachuteNotControl.getFinishTrackX(jump.x0, sectionAltitudes);
        double trackNotWindY0 = TrackParachuteNotControl.getFinishTrackY(jump.y0, sectionAltitudes);
        double coefficient = (double) jump.speedHorizontal / jump.speedDown;
        //CoordinateQuarter ccq = CoordinateQuarter.getNeedfulCoordinateQuarter(20);//!!!!!!!!!!!!!!!!!!!
        CreatorAnswer creator = new CreatorAnswerOverAzimuthParachute(jump);
        Map<Double, CollectorParametersAnswer> map = creator.createAllAnswers(/*ccq, /*jump.x0, jump.y0,*/ trackNotWindX0,
                trackNotWindY0, jump.altitude /*jump.speedHorizontal, jump.speedDown*/);
        //creator.talker(map);

        int i = 0;
        for (Map.Entry<Double, CollectorParametersAnswer> a : map.entrySet()) {
            System.out.println(i + ") "+ a);
            i++;}
    }//высота секций разная
     //500 метров
    //высота рельефа
}
