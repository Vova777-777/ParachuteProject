package ru.vova777.solution;

public class CalculationSecondCoordinateQuarter {
    int x0;
    int y0;
    int length;
    int azimuth;
    ConverterGradAndRad converter = new ConverterGradAndRad();

    public CalculationSecondCoordinateQuarter(int x0, int y0, int length, int azimuth) {
        this.x0 = x0;
        this.y0 = y0;
        this.length = length;
        this.azimuth = azimuth;
    }

    public int getFinishSectionX() {
        int deltaX = (int) (Math.cos(converter.convertGradToRad(180 - azimuth)) * length);
        int x = x0 - deltaX;
        return x;
    }

    public int getFinishSectionY() {
        int deltaY = (int) (Math.sin(converter.convertGradToRad(180 - azimuth)) * length);
        int y = y0 + deltaY;
        return y;
    }
}
