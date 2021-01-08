package ru.vova777.data;

import java.io.IOException;


public class SectionAltitude {
    int windStrength;
    int azimuthWind;
    int time;

    public SectionAltitude(int time) throws IOException {
        this.time = time;
    }

    public void setWindStrength(int windStrength) {
        this.windStrength = windStrength;
    }

    public void setAzimuthWind(int azimuthWind) {
        this.azimuthWind = azimuthWind;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getWindStrength() {
        return windStrength;
    }

    public int getAzimuthWind() {
        return azimuthWind;
    }

    public int getTime() {
        return time;
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
