import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ReaderParametersJump {

   public String ownDataOrFromInternet;
   public int speedDown;
   public int speedHorizontal;
   public int altitude;
   public int verticalSizeHighestSection;
   public int countSections;
   Parachute parachute = new Parachute();

    public ReaderParametersJump() throws IOException {
        this.speedDown = parachute.getParachuteSystem().speedDown;
        this.speedHorizontal = parachute.getParachuteSystem().speedHorizontal;
        this.altitude = getAltitude();
        this.countSections = getCountSections();
        this.verticalSizeHighestSection = getVerticalSizeHighestSection();
    }

    BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));



    boolean isDigit(String value){
        try {
            int digit = Integer.parseInt(value);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

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

    Queue<SectionAltitude> getSections() throws IOException { //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if (ownDataForSections()) return new
                CreatorSectionAltitudeFromUser(altitude, verticalSizeHighestSection, countSections, speedDown).createSections();
        else return new CreatorSectionsAltitudeFromFile(verticalSizeHighestSection, countSections, speedDown).createSections();
    }

   boolean ownDataForSections() throws IOException {
        System.out.println("Вы сами введете данные? Иначе данные будут получены из файла. YES/NO");
        ownDataOrFromInternet = readerConsole.readLine();
        while (true){
            if (ownDataOrFromInternet.equalsIgnoreCase("YES")) break;
            else if (ownDataOrFromInternet.equalsIgnoreCase("NO")) break;
            else {
                System.out.println("Введите корректный ответ YES/NO");
                ownDataOrFromInternet = readerConsole.readLine();
            }
        }
        return ownDataOrFromInternet.equalsIgnoreCase("YES");
    }

    public static void main(String[] args) throws IOException {
        ReaderParametersJump readerParametersJump = new ReaderParametersJump();
        for (SectionAltitude a : readerParametersJump.getSections()) {
            System.out.println(a);
        }
    }

}

