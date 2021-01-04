package main.java.ru.vova777;

import java.io.IOException;


public class SectionAltitude {
    int windStrength;
    int azimuthWind;
    int time;

    public SectionAltitude(int time) throws IOException {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Section{" +
                "windStrength=" + windStrength +
                ", azimuthWind=" + azimuthWind +
                ", time=" + time +
                '}';
    }
}
