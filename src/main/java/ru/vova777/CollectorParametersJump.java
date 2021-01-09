package ru.vova777;

import com.opensymphony.xwork2.util.ClassLoaderUtil;
import ru.vova777.data.SectionAltitude;
import ru.vova777.data.receiver.CreateAbleSectionsAltitude;
import ru.vova777.data.receiver.auto.CreatorSectionsAltitudeFromFile;
import ru.vova777.data.receiver.auto.DataReceiverAuto;
import ru.vova777.data.receiver.manual.CreatorSectionsAltitudeFromUserConsole;
import ru.vova777.data.receiver.manual.DataReceiverManual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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
    DataReceiverAuto receiverAuto;
    DataReceiverManual receiverManual;


    public CollectorParametersJump(DataReceiverAuto receiverAuto,
                                   DataReceiverManual receiverManual) throws IOException, URISyntaxException {
        this.x0 = coordinateJump.getX();
        this.y0 = coordinateJump.getY();
        this.speedDown = par.speedDown;
        this.speedHorizontal = par.speedHorizontal;
        this.altitude = getAltitude();
        this.countSections = getCountSections();
        this.verticalSizeHighestSection = getVerticalSizeHighestSection();
        this.receiverAuto = receiverAuto;
        this.receiverManual = receiverManual;
    }

    BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));

    int getAltitude() throws IOException {
        System.out.println("Введите высоту раскрытия (цифрами)");
        String value = readerConsole.readLine();
        while (true) {
            if (isDigit(value)) break;
            else {
                System.out.println("Введите корректно высоту раскрытия (ЦИФРАМИ)");
                value = readerConsole.readLine();
            }
        }
        int result = Integer.parseInt(value);
        return result;
    }

    int getVerticalSizeHighestSection() {
        if (altitude % 500 == 0) verticalSizeHighestSection = 500;
        else verticalSizeHighestSection = altitude % 500;
        return verticalSizeHighestSection;
    }

    int getCountSections() {
        if (verticalSizeHighestSection == 500) countSections = altitude / 500;
        else countSections = (altitude / 500) + 1;
        return countSections;
    }

    Queue<SectionAltitude> choiceSourceSectionsAltitude() throws IOException, URISyntaxException {
        System.out.println("Вы сами введете данные? Иначе данные будут получены из файла. YES/NO");
        String userDataOrFromInternet;
        userDataOrFromInternet = readerConsole.readLine();
        while (true) {
            if (userDataOrFromInternet.equalsIgnoreCase("YES"))
                return receiverManual.createSections(verticalSizeHighestSection, countSections, speedDown);
            else if (userDataOrFromInternet.equalsIgnoreCase("NO"))
                return receiverAuto.createSections(verticalSizeHighestSection, countSections, speedDown);
            else {
                System.out.println("Введите корректный ответ YES/NO");
                userDataOrFromInternet = readerConsole.readLine();
            }
        }
    }

    public static void main(String[] args) throws IOException, URISyntaxException {


        DataReceiverManual receiverManual = new CreatorSectionsAltitudeFromUserConsole();
        DataReceiverAuto receiverAuto = new CreatorSectionsAltitudeFromFile();
        CollectorParametersJump jump = new CollectorParametersJump(receiverAuto, receiverManual);
        for (SectionAltitude a : jump.choiceSourceSectionsAltitude()) {
            System.out.println(a);
        }
    }

}

