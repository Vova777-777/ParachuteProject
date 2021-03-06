package ru.vova777.solution;

public class CalculationFirstCoordinateQuarter {
    int x0;
    int y0;
    int length;
    int azimuth;

    public CalculationFirstCoordinateQuarter(int x0, int y0, int length, int azimuth) {
        this.x0 = x0;
        this.y0 = y0;
        this.length = length;
        this.azimuth = azimuth;
    }

    ConverterGradAndRad converter = new ConverterGradAndRad();

    public int getFinishSectionX() {

        int deltaX = (int) (Math.cos(converter.convertGradToRad((azimuth)) * length));
        int x = x0 + deltaX;
        return x;
    }

    public int getFinishSectionY() {
        int deltaY = (int) (Math.sin(converter.convertGradToRad((azimuth)) * length));
        int y = x0 + deltaY;
        return y;
    }
}
