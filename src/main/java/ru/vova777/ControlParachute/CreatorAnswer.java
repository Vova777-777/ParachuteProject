package ru.vova777.ControlParachute;

import ru.vova777.coordinateParachuteNotControl.TrackParachuteNotControl;
import ru.vova777.coordinatePlane.CoordinateQuarter;
import ru.vova777.coordinatePlane.FirstCoordinateQuarter;
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

public class CreatorAnswer implements CheckAbleIsDigit {



    Scanner scan = new Scanner(System.in);
    CollectorParametersJump jump;

    CreatorAnswer(CollectorParametersJump jump){
        this.jump = jump;
    }

    private static class CollectorParametersAnswer{//???????????????????????????
        int x0;
        int y0;
        int finishX;
        int finishY;
        int length;
        int azimuthTrackNotWind;

        public CollectorParametersAnswer(int x0, int y0, int finishX, int finishY, int length,
                                         int azimuthTrackNotWind) {
            this.x0 = x0;
            this.y0 = y0;
            this.finishX = finishX;
            this.finishY = finishY;
            this.length = length;
            this.azimuthTrackNotWind = azimuthTrackNotWind;
        }

        @Override
        public String toString() {
            return "CollectorParametersAnswer{" +
                    "x0=" + x0 +
                    ", y0=" + y0 +
                    ", finishX=" + finishX +
                    ", finishY=" + finishY +
                    ", length=" + length +
                    ", azimuthTrackNotWind=" + azimuthTrackNotWind +
                    '}';
        }
    }

    public Map<Double, CollectorParametersAnswer> createAllAnswers(CoordinateQuarter ccq,
                                                                    int trackParNotWind_x0,
                                                                    int trackParNotWind_y0, int altitude) {
        Map<Double, CollectorParametersAnswer> map = new HashMap<>();
       for (int i = 0; i < 360; i++){
           TrackParControlNotWind trackParControl = new TrackParControlNotWind(trackParNotWind_x0, trackParNotWind_y0, i);
           CalculatorParametersTrackResult calculator = new CalculatorParametersTrackResult(ccq);
           int finishX = calculator.getFinishX(trackParControl, altitude, jump.speedHorizontal, jump.speedDown);
           int finishY = calculator.getFinishY(trackParControl, altitude, jump.speedHorizontal, jump.speedDown);
           int length = calculator.getLengthTrackResult(jump.x0, jump.y0, finishX, finishY);
           Double azimuthTrackResult = calculator.getAzimuthTrackResult(jump.x0, jump.y0, finishX, finishY, length);

           CollectorParametersAnswer collector = new CollectorParametersAnswer(jump.x0, jump.y0, finishX, finishY, length, i);
           map.put(azimuthTrackResult, collector);

       }
       return map;
    }

    public void talker(Map<Integer, CollectorParametersAnswer> map) {
        String str = "";
        while (true){
            System.out.println("Введите азимут на площадку приземления в градусах\n" +
                    "или наберите 'exit' для завершеня.");
            str = scan.nextLine();
            if (str.equalsIgnoreCase("exit")) return;
            if (!isDigit(str)) {
                System.out.println("Данные введены некорректно. Внимательнее. В ГРАДУСАХ. Попробуй еще раз");
                continue;
            }
            Integer key = Integer.parseInt(str);
            System.out.println(map.get(key));
        }
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
//        DataReceiverManual receiverManual = new CreatorSectionsAltitudeFromUserConsole();
//        DataReceiverAuto receiverAuto = new CreatorSectionsAltitudeFromFile();
//        CollectorParametersJump jump = new CollectorParametersJump(receiverAuto, receiverManual);
//        Queue<SectionAltitude> sectionAltitudes = jump.choiceSourceSectionsAltitude();
//        int trackNotWindX0 = TrackParachuteNotControl.getFinishTrackX(jump.x0, sectionAltitudes);
//        int trackNotWindY0 = TrackParachuteNotControl.getFinishTrackY(jump.y0, sectionAltitudes);
//        double coefficient = (double) jump.speedHorizontal / jump.speedDown;
//        CoordinateQuarter ccq = CoordinateQuarter.getNeedfulCoordinateQuarter(20);//!!!!!!!!!!!!!!!!!!!
//        CreatorAnswer creator = new CreatorAnswer(jump);
//        Map<Integer, CollectorParametersAnswer> map = creator.createAllAnswers(ccq, /*jump.x0, jump.y0,*/ trackNotWindX0,
//                trackNotWindY0, jump.altitude /*jump.speedHorizontal, jump.speedDown*/);
//        creator.talker(map);

        SectionAltitude sA1 = new SectionAltitude(100);
        sA1.setAzimuthWind(12);
        sA1.setWindStrength(0);
        SectionAltitude sA2 = new SectionAltitude(100);
        sA2.setAzimuthWind(90);
        sA2.setWindStrength(0);
        SectionAltitude sA3 = new SectionAltitude(100);
        sA3.setAzimuthWind(135);
        sA3.setWindStrength(0);
        Queue<SectionAltitude> sectionAltitudes = new ArrayDeque<>();
        sectionAltitudes.add(sA1);
        sectionAltitudes.add(sA2);
        sectionAltitudes.add(sA3);
        CollectorParametersJump jump = new CollectorParametersJump(100, 200, 5, 10);
        int trackNotWindX0 = TrackParachuteNotControl.getFinishTrackX(jump.x0, sectionAltitudes);
        int trackNotWindY0 = TrackParachuteNotControl.getFinishTrackY(jump.y0, sectionAltitudes);
        CoordinateQuarter ccq = new FirstCoordinateQuarter();
        CreatorAnswer answer = new CreatorAnswer(jump);
        Map<Double, CollectorParametersAnswer> map = answer.createAllAnswers(ccq, trackNotWindX0,
                trackNotWindY0, 1500);
        int i = 1;
        for (Map.Entry<Double, CollectorParametersAnswer> a : map.entrySet()) {
            System.out.println(i + ") "+ a);
            i++;
        }

    }
}
