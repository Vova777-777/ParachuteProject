package ru.vova777.data.receiver.auto;

import ru.vova777.data.receiver.CreateAbleSectionsAltitude;
import ru.vova777.data.SectionAltitude;
import ru.vova777.utils.ResourceLoader;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

public class CreatorSectionsAltitudeFromFile implements DataReceiverAuto {
    public int verticalSizeHighestSection;
    public int countSections;
    int speedDown;
    BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));



    public Queue<SectionAltitude> createSections(int verticalSizeHighestSection,
                                                 int countSections, int speedDown) throws IOException, URISyntaxException {
        FileInputStream file = new FileInputStream(String.valueOf(ResourceLoader.getPathResource("777.txt")));
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


    public static void main(String[] args) throws IOException, URISyntaxException {


        System.out.println(new CreatorSectionsAltitudeFromFile().createSections(2100, 5, 5));

    }
}
