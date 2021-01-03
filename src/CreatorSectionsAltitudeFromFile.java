import java.io.*;
import java.util.*;

public class CreatorSectionsAltitudeFromFile {
    public int verticalSizeHighestSection;
    public int countSections;
    int speedDown;
    BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));

    public CreatorSectionsAltitudeFromFile(int verticalSizeHighestSection, int countSections, int speedDown) {
        this.verticalSizeHighestSection = verticalSizeHighestSection;
        this.countSections = countSections;
        this.speedDown = speedDown;
    }

    String getPatchFile() throws IOException {
        System.out.println("Введите путь к файлу");
        String fileName = readerConsole.readLine();
        return fileName;
    }


    public Queue<SectionAltitude> createSections() throws IOException {
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
            sectionAltitude.windStrength = Integer.parseInt(list.get(2));
            sectionAltitude.azimuthWind = Integer.parseInt(list.get(5));
            queue.add(sectionAltitude);
            list.clear();
        }
        return queue;
    }


    public static void main(String[] args) throws IOException {


        System.out.println(new CreatorSectionsAltitudeFromFile(2100, 5, 5).createSections());
    }
}
