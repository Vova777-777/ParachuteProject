package ru.vova777.data.receiver.manual;

import ru.vova777.parametersJump.CheckAbleIsDigit;
import ru.vova777.data.SectionAltitude;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class CreatorSectionsAltitudeFromUserConsole implements DataReceiverManual, CheckAbleIsDigit {
    int altitude;
    int verticalSizeHighestSection;
    int countSections;
    int speedDown;


    public Queue<SectionAltitude> createSections(int verticalSizeHighestSection,
                                                 int countSections, int speedDown) throws IOException {
        Queue<SectionAltitude> queue = new ArrayDeque<>();
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        String question = "Введите силу ветра (цифрами) в метрах в секунду и напрвление в градусах (цифрами) " +
                "через запятую\n" + "и пробел для высоты ";
        int altitudeForParameters;
        altitudeForParameters = countSections * 500;//altitude + (500 - verticalSizeHighestSection);
        for (int i = countSections; i > 0; i--) {
            System.out.println(countSections);//!!!!!!!!!!!!!!!!!!!!!!!!!!!
            System.out.println(question + "" + altitudeForParameters);
            String strengthAndAzimuthWind = readerConsole.readLine();
            if (!checkRightlyConsoleNotice(strengthAndAzimuthWind)) {i++;
                System.out.println("Введите данные корректно. Через ',' и пробел");
                continue;}
            StringTokenizer stk = new StringTokenizer(strengthAndAzimuthWind, "," + " ");
            int timeSection;
            if (i == countSections) timeSection = verticalSizeHighestSection / speedDown;
            else timeSection = 500 / speedDown;
            SectionAltitude sectionAltitude = new SectionAltitude(timeSection);
            sectionAltitude.setWindStrength(Integer.parseInt(stk.nextToken()));
            sectionAltitude.setAzimuthWind(Integer.parseInt(stk.nextToken()));
            queue.add(sectionAltitude);
            altitudeForParameters = altitudeForParameters - 500;
        }
        return queue;
    }

    private boolean checkRightlyConsoleNotice (String str){
        StringTokenizer stk = new StringTokenizer(str, ", ");
        String strengthWind = stk.nextToken();
        String azimuthWind = stk.nextToken();
        return  (isDigit(strengthWind) || isDigit(azimuthWind) || !stk.hasMoreTokens());
    }


}
