package ru.vova777.data.receiver.auto;

import ru.vova777.data.receiver.CreateAbleSectionsAltitude;
import ru.vova777.data.SectionAltitude;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CreatorSectionsAltitudeFromFile implements DataReceiverAuto {
    public int verticalSizeHighestSection;
    public int countSections;
    int speedDown;
    BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));



    String getPatchFile() throws IOException {
        System.out.println("Введите путь к файлу");
        String fileName = readerConsole.readLine();
        return fileName;
    }


    public Queue<SectionAltitude> createSections(int verticalSizeHighestSection,
                                                 int countSections, int speedDown) throws IOException {
        FileInputStream file = new FileInputStream(getPatchFile());
        BufferedReader readerFile = new BufferedReader(new InputStreamReader(file));
        Queue<SectionAltitude> queue = new ArrayDeque<>();
        List<String> list = new ArrayList<>();
        for (int i = countSections; i > 0; i--){
            String strFromFile = readerFile.readLine();
            StringTokenizer stk = new StringTokenizer(strFromFile, ";,. ");
            while (stk.hasMoreTokens()){
                list.add(stk.nextToken());
            }
            int time;
            if (i == countSections) time = verticalSizeHighestSection / speedDown;
            else time = 500 / speedDown;
            SectionAltitude sectionAltitude = new SectionAltitude(time);
            sectionAltitude.setWindStrength(Integer.parseInt(list.get(2)));
            sectionAltitude.setAzimuthWind(Integer.parseInt(list.get(5)));
            queue.add(sectionAltitude);
            list.clear();
        }
        return queue;
    }


    public static void main(String[] args) throws IOException {


        System.out.println(new CreatorSectionsAltitudeFromFile().createSections(2100, 5, 5));
    }
}
