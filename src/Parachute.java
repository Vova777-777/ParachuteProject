import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parachute {


    CreatorParachuteSystem creatorParachuteSystem = new CreatorParachuteSystem();
    BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));

    ParachuteSystem getParachuteSystem() throws IOException {     //  проверить на правильность ввода цифрой
        List<ParachuteSystem> parSys = getParachuteSystemsFromFile();
        if (parSys.isEmpty()){ creatorParachuteSystem.createParachuteSystem(); parSys = getParachuteSystemsFromFile();}
        ParachuteSystem result = null;//??????????????
        int numberChoice = Integer.parseInt(choiceParachuteSystemByUser(parSys));
        if (numberChoice == parSys.size() + 1) {creatorParachuteSystem.createParachuteSystem();
        getParachuteSystem();//??????????????
        }
        else if (numberChoice == parSys.size() + 2) {new RemoverParachuteSystem(parSys).removeParachuteSystem();
        getParachuteSystem();//????????????
        }
        for (int i = 1; i <= parSys.size(); i++){
             if (numberChoice == i) result = parSys.get(i - 1);
        }
        System.out.println(parSys);//!!!!!!!!!!!!!!!!!!!!!!!!!!
        System.out.println(numberChoice);//!!!!!!!!!!!!!!!!!!!!!!!!!!
        return result; //parSys.get(numberChoice - 1);
    }

    String choiceParachuteSystemByUser(List<ParachuteSystem> parSys) throws IOException {
        //System.out.println(parSys);//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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



    List<ParachuteSystem>getParachuteSystemsFromFile() throws IOException {
        List<ParachuteSystem> parachuteSystems = new ArrayList<>();
        List<String> list = new ArrayList<>();
//        FileInputStream fileInputStream = new FileInputStream(".\\src\\NamesParachuteSystems");
//        BufferedReader readerFile = new BufferedReader( new InputStreamReader (fileInputStream));
        Path path = Paths.get(".\\src\\NamesParachuteSystems");
        list = Files.readAllLines(path);
        if (!list.isEmpty()){
            for (int i = 0; i < list.size(); i ++){
                parachuteSystems.add(changeStringToParachuteSystem(list.get(i)));
            }
        }

        return parachuteSystems;
    }

    ParachuteSystem changeStringToParachuteSystem(String strFromFile){
        StringTokenizer stk = new StringTokenizer(strFromFile, " ");
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


    boolean isDigit(String value){
        try {
            int digit = Integer.parseInt(value);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }


    public static void main(String[] args) throws IOException {

        System.out.println(new Parachute().getParachuteSystem());

    }
}
