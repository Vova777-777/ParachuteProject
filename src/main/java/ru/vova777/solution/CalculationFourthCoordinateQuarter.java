package ru.vova777.solution;

public class CalculationFourthCoordinateQuarter extends CalculationCoordinateQuarter {

    public CalculationFourthCoordinateQuarter(int x0, int y0, int length, int azimuth) {
        super(x0, y0, length, azimuth);
    }
    ConverterGradAndRad converter = new ConverterGradAndRad();

    @Override
    public int getFinishSectionX() {
        int deltaX = (int) (Math.cos(converter.convertGradToRad(360 - azimuth)) * length);
        int x = x0 + deltaX;
        return x;
    }

    @Override
    public int getFinishSectionY() {
        int deltaY = (int) (Math.sin(converter.convertGradToRad(360 - azimuth)) * length);
        int y = y0 + deltaY;
        return y;
    }
}
