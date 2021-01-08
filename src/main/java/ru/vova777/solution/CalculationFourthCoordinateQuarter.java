package ru.vova777.solution;

public class CalculationFourthCoordinateQuarter extends CalculationCoordinateQuarter {

    public CalculationFourthCoordinateQuarter(int x0, int y0, int length, int azimuth) {
        super(x0, y0, length, azimuth);
    }

    @Override
    public int getFinishSectionX() {
        return 0;
    }

    @Override
    public int getFinishSectionY() {
        return 0;
    }
}
