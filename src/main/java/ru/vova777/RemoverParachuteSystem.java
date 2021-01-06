package main.java.ru.vova777;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class RemoverParachuteSystem implements CheckAbleCorrectRecord {
    List<ParachuteSystem> parSys;


    RemoverParachuteSystem(List<ParachuteSystem> parSys){
        this.parSys = parSys;

    }

    void removeParachuteSystem() throws IOException {
        //File file = new File(getClass().getClassLoader().getResource("NamesParachuteSystems").getFile());//???????????????????
        //Path path = Paths.get(String.valueOf(file));
        Path path = Paths.get(".\\src\\main\\java\\ru\\vova777\\NamesParachuteSystems");
        //if (parSys.size() == 1) {
            Files.delete(path);
            Files.createFile(path);
       // }
        parSys.remove(getParachuteSystemForRemove());
        for (int i = 0; i < parSys.size(); i++){
            //System.out.println(parSys);//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            Files.writeString(path,parSys.get(i).name+ "&" + parSys.get(i).speedDown + "&"
                    + parSys.get(i).speedHorizontal + "\n", StandardOpenOption.APPEND);
        }

    }

    int getParachuteSystemForRemove(){
        for (int i = 1; i <= parSys.size(); i++) {
            System.out.println(i + " - " + parSys.get(i - 1).name);
        }
        int indexForRemove = 0;
        while (true) {
            System.out.println("Выберите парашютную систему для удаления");
            Scanner scan = new Scanner(System.in);
            String value = scan.nextLine();
            if (isDigit(value) && Integer.parseInt(value) >= 1 && Integer.parseInt(value) <= parSys.size()){
            indexForRemove = Integer.parseInt(value) - 1; break;}
            else System.out.println("Введите ЦИФРУ выбора для удаления парашютной системы");
        }
        return indexForRemove;
    }


}
