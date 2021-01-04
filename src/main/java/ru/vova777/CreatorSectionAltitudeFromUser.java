package main.java.ru.vova777;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class CreatorSectionAltitudeFromUser {
    int altitude;
    int verticalSizeHighestSection;
    int countSections;
    int speedDown;

    CreatorSectionAltitudeFromUser(int altitude) {
        this.altitude = altitude;
    }
    CreatorSectionAltitudeFromUser(int altitude, int verticalSizeHighestSection, int countSections, int speedDown) {
        this.altitude = altitude;
        this.verticalSizeHighestSection = verticalSizeHighestSection;
        this.countSections = countSections;
        this.speedDown = speedDown;
    }


    public Queue<SectionAltitude> createSections() throws IOException {
        Queue<SectionAltitude> queue = new ArrayDeque<>();
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        String question = "Введите силу ветра (цифрами) в метрах в секунду и напрвление в градусах (цифрами) " +
                "через запятую\n" + "и пробел для высоты ";
        int altitudeForParameters;
        altitudeForParameters = altitude + (500 - verticalSizeHighestSection);
        for (int i = countSections; i > 0; i--) {
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
            sectionAltitude.windStrength = Integer.parseInt(stk.nextToken());
            sectionAltitude.azimuthWind = Integer.parseInt(stk.nextToken());
            queue.add(sectionAltitude);
            altitudeForParameters = altitudeForParameters - 500;
        }
        return queue;
    }

    boolean checkRightlyConsoleNotice (String str){
        StringTokenizer stk = new StringTokenizer(str, ", ");
        String strengthWind = stk.nextToken();
        String azimuthWind = stk.nextToken();
        return  (isDigit(strengthWind) || isDigit(azimuthWind) || !stk.hasMoreTokens());
    }

    boolean isDigit(String value){
        try {
            int digit = Integer.parseInt(value);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
