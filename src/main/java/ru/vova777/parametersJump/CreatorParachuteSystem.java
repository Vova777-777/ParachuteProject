package ru.vova777.parametersJump;

import ru.vova777.utils.ResourceLoader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CreatorParachuteSystem implements CheckAbleIsDigit {


    BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));

    void createParachuteSystem () throws IOException, URISyntaxException {
        ParachuteSystem parachuteSystem = new ParachuteSystem(getName(), getSpeedDown(),getSpeedHorizontal());
        ResourceLoader.getInfoFromResource("NamesParachuteSystems");
        String strInFile = parachuteSystem.name + "&" + parachuteSystem.speedDown + "&" + parachuteSystem.speedHorizontal + "\n";
        Path path = ResourceLoader.getPathResource("NamesParachuteSystems");
        Files.writeString(path, strInFile, StandardOpenOption.APPEND);
    }

    String getName () throws IOException {
        System.out.println("Введите название парашютной системы");
        return readerConsole.readLine();
    }

    int getSpeedDown() throws IOException {
        System.out.println("Введите скорость снижения парашюта");
        String value = readerConsole.readLine();
        value = getCorrectlyRecord(value);
        int result = Integer.parseInt(value);
        return result;
    }

    int getSpeedHorizontal() throws IOException {
        System.out.println("Введите горизонтальную скорость парашюта");
        String value = readerConsole.readLine();
        value = getCorrectlyRecord(value);
        int result = Integer.parseInt(value);
        return result;
    }

    String getCorrectlyRecord(String value) throws IOException {
        while (true) {
            if (isDigit(value)) break;
            else {System.out.println("Введите корректно скорость (ЦИФРАМИ)");
                value = readerConsole.readLine(); }
        }
        return value;
    }



    public static void main(String[] args) throws IOException, URISyntaxException {
        new CreatorParachuteSystem().createParachuteSystem();
    }

}
