package ru.vova777.result;

import ru.vova777.controlParachute.TrackParControlNotWind;
import ru.vova777.coordinateParachuteNotControl.TrackParachuteNotControl;
import ru.vova777.coordinatePlane.CoordinateQuarter;
import ru.vova777.data.SectionAltitude;
import ru.vova777.data.receiver.auto.CreatorSectionsAltitudeFromFile;
import ru.vova777.data.receiver.auto.DataReceiverAuto;
import ru.vova777.data.receiver.manual.CreatorSectionsAltitudeFromUserConsole;
import ru.vova777.data.receiver.manual.DataReceiverManual;
import ru.vova777.parametersJump.CheckAbleIsDigit;
import ru.vova777.parametersJump.CollectorParametersJump;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class CreatorAnswerOverAzimuthParachute implements CreatorAnswer, CheckAbleIsDigit {

    Scanner scan = new Scanner(System.in);
CollectorParametersJump jump;

    public CreatorAnswerOverAzimuthParachute(CollectorParametersJump jump) {
        this.jump = jump;
    }






    public Map<Double, CollectorParametersAnswer> createAllAnswers(CoordinateQuarter ccq,
                                                                   double trackParNotWind_x0,
                                                                   double trackParNotWind_y0, double altitude) {
        Map<Double, CollectorParametersAnswer> map = new TreeMap<>();
        //i = Азимут, котрый надо выдерживать на парашютной системе;
       for (double i = 0; i < 360; i++){
           TrackParControlNotWind trackParControl = new TrackParControlNotWind(trackParNotWind_x0, trackParNotWind_y0, i);
           CalculatorParametersTrackResult calculator = new CalculatorParametersTrackResult(ccq);
           double finishX = calculator.getFinishX(trackParControl, altitude, jump.speedHorizontal, jump.speedDown);
           double finishY = calculator.getFinishY(trackParControl, altitude, jump.speedHorizontal, jump.speedDown);
           double length = calculator.getLengthTrackResult(jump.x0, jump.y0, finishX, finishY);
           double azimuthTrackResult = calculator.getAzimuthTrackResult(jump.x0, jump.y0, finishX, finishY, length);


           CollectorParametersAnswer collector = new CollectorParametersAnswer(jump.x0, jump.y0, finishX, finishY, length, azimuthTrackResult);//поменял азимуты
           map.put( i, collector);

       }
       return map;
    }

//    public void talker(Map<Integer, CollectorParametersAnswer> map) {
//        String str = "";
//        while (true){
//            System.out.println("Введите азимут на площадку приземления в градусах\n" +
//                    "или наберите 'exit' для завершеня.");
//            str = scan.nextLine();
//            if (str.equalsIgnoreCase("exit")) return;
//            if (!isDigit(str)) {
//                System.out.println("Данные введены некорректно. Внимательнее. В ГРАДУСАХ. Попробуй еще раз");
//                continue;
//            }
//            Integer key = Integer.parseInt(str);
//            System.out.println(map.get(key));
//        }
//    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        DataReceiverManual receiverManual = new CreatorSectionsAltitudeFromUserConsole();
        DataReceiverAuto receiverAuto = new CreatorSectionsAltitudeFromFile();
        CollectorParametersJump jump = new CollectorParametersJump(receiverAuto, receiverManual);
        Queue<SectionAltitude> sectionAltitudes = jump.choiceSourceSectionsAltitude();
        double trackNotWindX0 = TrackParachuteNotControl.getFinishTrackX(jump.x0, sectionAltitudes);
        double trackNotWindY0 = TrackParachuteNotControl.getFinishTrackY(jump.y0, sectionAltitudes);
        double coefficient = (double) jump.speedHorizontal / jump.speedDown;
        CoordinateQuarter ccq = CoordinateQuarter.getNeedfulCoordinateQuarter(20);//!!!!!!!!!!!!!!!!!!!
        CreatorAnswer creator = new CreatorAnswerOverAzimuthParachute(jump);
        Map<Double, CollectorParametersAnswer> map = creator.createAllAnswers(ccq, /*jump.x0, jump.y0,*/ trackNotWindX0,
                trackNotWindY0, jump.altitude /*jump.speedHorizontal, jump.speedDown*/);
        //creator.talker(map);

        int i = 0;
        for (Map.Entry<Double, CollectorParametersAnswer> a : map.entrySet()) {
            System.out.println(i + ") "+ a);
            i++;}

//        SectionAltitude sA1 = new SectionAltitude(100);
//        sA1.setAzimuthWind(12);
//        sA1.setWindStrength(0);
//        SectionAltitude sA2 = new SectionAltitude(100);
//        sA2.setAzimuthWind(90);
//        sA2.setWindStrength(0);
//        SectionAltitude sA3 = new SectionAltitude(100);
//        sA3.setAzimuthWind(135);
//        sA3.setWindStrength(0);
//        Queue<SectionAltitude> sectionAltitudes = new ArrayDeque<>();
//        sectionAltitudes.add(sA1);
//        sectionAltitudes.add(sA2);
//        sectionAltitudes.add(sA3);
//        CollectorParametersJump jump = new CollectorParametersJump(100, 200, 5, 10);
//        double trackNotWindX0 = TrackParachuteNotControl.getFinishTrackX(jump.x0, sectionAltitudes);
//        double trackNotWindY0 = TrackParachuteNotControl.getFinishTrackY(jump.y0, sectionAltitudes);
//        CoordinateQuarter ccq = new FirstCoordinateQuarter();
//        CreatorAnswer answer = new CreatorAnswer(jump);
//        Map<Integer, CollectorParametersAnswer> map = answer.createAllAnswers(ccq, trackNotWindX0,
//                trackNotWindY0, 1500);
//        int i = 0;
//        for (Map.Entry<Integer, CollectorParametersAnswer> a : map.entrySet()) {
//            System.out.println(i + ") "+ a);
//            i++;
//        }

    }
}
