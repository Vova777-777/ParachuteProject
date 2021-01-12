package ru.vova777.ControlParachute;

public class TrackParControlWithoutWind {
    int x0;
    int y0;

    public TrackParControlWithoutWind(int x0, int y0) {
        this.x0 = x0;
        this.y0 = y0;
    }

    int getLengthTrack(int altitude, double coefficient){
        return (int) ((altitude - 500) * coefficient);
    }

    int
}
