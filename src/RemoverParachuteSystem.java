import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

public class RemoverParachuteSystem {
    List<ParachuteSystem> parSys;


    RemoverParachuteSystem(List<ParachuteSystem> parSys){
        this.parSys = parSys;

    }

    void removeParachuteSystem() throws IOException {
        Path path = Paths.get(".\\src\\NamesParachuteSystems");
        //if (parSys.size() == 1) {
            Files.delete(path);
            Files.createFile(path);
       // }
        parSys.remove(getParachuteSystemForRemove());
        for (int i = 0; i < parSys.size(); i++){
            //System.out.println(parSys);//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            Files.writeString(path,parSys.get(i).name+ " " + parSys.get(i).speedDown + " "
                    + parSys.get(i).speedHorizontal + "\n", StandardOpenOption.APPEND);
        }

    }

    int getParachuteSystemForRemove(){

        for (int i = 1; i <= parSys.size(); i++) {
            System.out.println(i + " - " + parSys.get(i - 1).name);
        }
        System.out.println("Выберите парашютную систему для удаления");
        Scanner scan = new Scanner(System.in);
        int numberFromConsole = scan.nextInt();
        int indexForRemove = numberFromConsole - 1;
        return indexForRemove;
    }
}
