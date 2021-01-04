package main.java.ru.vova777;

public class ParachuteSystem {
    String name;
    int speedDown;
    int speedHorizontal;

    ParachuteSystem(String name, int speedDown, int speedHorizontal){
        this.name = name;
        this.speedDown = speedDown;
        this.speedHorizontal = speedHorizontal;
    }

    @Override
    public String toString() {
        return "ParachuteSystem{" +
                "name='" + name + '\'' +
                ", speedDown=" + speedDown +
                ", speedHorizontal=" + speedHorizontal +
                '}';
    }
}
