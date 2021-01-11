package ru.vova777;

import ru.vova777.utils.ResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NeedfulParachuteSystem implements CheckAbleIsDigit {

    CreatorParachuteSystem creatorParachuteSystem = new CreatorParachuteSystem();
    BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));

    ParachuteSystem getParachuteSystem() throws IOException, URISyntaxException {
        List<ParachuteSystem> parSys;
        ParachuteSystem result = new ParachuteSystem("for cycle", 0, 0);//?????? как чтоб не null
        while (result.name.equals("for cycle")){
        parSys = getParachuteSystemsFromFile();
        if (parSys.isEmpty()){ creatorParachuteSystem.createParachuteSystem(); parSys = getParachuteSystemsFromFile();}
        int numberChoice = Integer.parseInt(choiceParachuteSystemByUser(parSys));
        if (numberChoice == parSys.size() + 1) {creatorParachuteSystem.createParachuteSystem();
         continue;
        }
        else if (numberChoice == parSys.size() + 2) {new RemoverParachuteSystem(parSys).removeParachuteSystem();
        continue;
        }

            for (int i = 1; i <= parSys.size(); i++){
             if (numberChoice == i) result = parSys.get(i - 1);
        }
            }
        return result;
    }

    String choiceParachuteSystemByUser(List<ParachuteSystem> parSys) throws IOException {
            for (int i = 1; i <= parSys.size(); i++) {
                System.out.println(i + " - " + parSys.get(i - 1).name);
            }
        System.out.println((parSys.size() + 1) + " - " + "создать новый профиль парашютной системы");
        System.out.println((parSys.size() + 2) + " - " + "удалить существующий профиль");
        System.out.println("Введите необходимую цифру для выбора парашютной системы, создания нового профиля или\n" +
                "удаления");
        String strNumberChoice = readerConsole.readLine();
        strNumberChoice = getCorrectlyRecordChoice(strNumberChoice, parSys.size() + 2);
        return strNumberChoice;
    }



    List<ParachuteSystem>getParachuteSystemsFromFile() throws IOException, URISyntaxException {
        List<ParachuteSystem> parachuteSystems = new ArrayList<>();
        List<String> list = ResourceLoader.getInfoFromResource("NamesParachuteSystems");
        if (!list.isEmpty()){
            for (int i = 0; i < list.size(); i ++){
               // System.out.println(list.get(i));
                parachuteSystems.add(changeStringToParachuteSystem(list.get(i)));
            }
        }

        return parachuteSystems;
    }

    ParachuteSystem changeStringToParachuteSystem(String strFromFile){
        StringTokenizer stk = new StringTokenizer(strFromFile, "&");
        String name = stk.nextToken();
        int speedDown = Integer.parseInt(stk.nextToken());
        int speedHorizontal = Integer.parseInt(stk.nextToken());
        return new ParachuteSystem(name, speedDown, speedHorizontal);
    }

    String getCorrectlyRecordChoice(String strNumberChoice, int maxNumber) throws IOException {
        while (true){
            if (isDigit(strNumberChoice) && Integer.parseInt(strNumberChoice) > 0 &&
            Integer.parseInt(strNumberChoice) <= maxNumber) break;
            else {System.out.println("Введите число стоящее перед вашим выбором, а не другии символы");
                strNumberChoice = readerConsole.readLine(); }
        }
        return strNumberChoice;
    }


    public static void main(String[] args) throws IOException, URISyntaxException {

        System.out.println("Выбранная парашютная система - " + new NeedfulParachuteSystem().getParachuteSystem());

    }
}
