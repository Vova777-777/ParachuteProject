import java.io.*;



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
