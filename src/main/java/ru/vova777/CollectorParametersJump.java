package ru.vova777;

import ru.vova777.data.SectionAltitude;
import ru.vova777.data.receiver.CreateAbleSectionsAltitude;
import ru.vova777.data.receiver.auto.CreatorSectionsAltitudeFromFile;
import ru.vova777.data.receiver.manual.CreatorSectionsAltitudeFromUserConsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;

public class CollectorParametersJump implements CheckAbleIsDigit {


   public int speedDown;
   public int speedHorizontal;
   public int altitude;
   public int verticalSizeHighestSection;
   public int countSections;
    int x0;  //координата выброски по оси X
    int y0;  //координата выброски по оси Y
   CoordinateJump coordinateJump = new CoordinateJump();
   NeedfulParachuteSystem parachute = new NeedfulParachuteSystem();
   ParachuteSystem par = parachute.getParachuteSystem();





    public CollectorParametersJump() throws IOException {
        this.x0 = coordinateJump.getX();
        this.y0 = coordinateJump.getY();
        this.speedDown = par.speedDown;
        this.speedHorizontal = par.speedHorizontal;
        this.altitude = getAltitude();
        this.countSections = getCountSections();
        this.verticalSizeHighestSection = getVerticalSizeHighestSection();

    }

    BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));

    int getAltitude () throws IOException {
        System.out.println("Введите высоту раскрытия (цифрами)");
        String value = readerConsole.readLine();
        while (true) {
            if (isDigit(value)) break;
            else {System.out.println("Введите корректно высоту раскрытия (ЦИФРАМИ)");
                value = readerConsole.readLine(); }
        }
        int result = Integer.parseInt(value);
        return result;
    }

    int getVerticalSizeHighestSection(){
        if (altitude % 500 == 0) verticalSizeHighestSection = 500;
        else verticalSizeHighestSection = altitude % 500;
        return verticalSizeHighestSection;
    }

    int getCountSections(){
        if (verticalSizeHighestSection == 500) countSections = altitude / 500;
        else countSections = (altitude / 500) + 1;
        return countSections;
    }

    Queue<SectionAltitude> getSections(CreateAbleSectionsAltitude creatorSections) throws IOException { //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
       return creatorSections.createSections(verticalSizeHighestSection, countSections, speedDown);
//        if (ownDataForSections()) return new
//                CreatorSectionsAltitudeFromUserConsole().createSections (verticalSizeHighestSection, countSections, speedDown);
//        else return new CreatorSectionsAltitudeFromFile().createSections(verticalSizeHighestSection, countSections, speedDown);
    }

    Queue<SectionAltitude> choiceSourceSectionsAltitude() throws IOException {
        System.out.println("Вы сами введете данные? Иначе данные будут получены из файла. YES/NO");
        String userDataOrFromInternet;
        userDataOrFromInternet = readerConsole.readLine();
        while (true){
            if (userDataOrFromInternet.equalsIgnoreCase("YES"))
                return getSections(new CreatorSectionsAltitudeFromUserConsole());
            else if (userDataOrFromInternet.equalsIgnoreCase("NO"))
                return getSections(new CreatorSectionsAltitudeFromFile());
            else {
                System.out.println("Введите корректный ответ YES/NO");
                userDataOrFromInternet = readerConsole.readLine();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        CollectorParametersJump jump = new CollectorParametersJump();
        for (SectionAltitude a : jump.choiceSourceSectionsAltitude()) {
            System.out.println(a);
        }
    }

}

