package ru.vova777.ControlParachute;

import java.util.List;
import java.util.Map;

public class ParachuteControl {
    public double speedDown;
    public double speedHorizontal;
    public  int azimuthParachuteControl;

    public ParachuteControl(double speedDown, double speedHorizontal) {
        this.speedDown = speedDown;
        this.speedHorizontal = speedHorizontal;
    }

    protected double getCoefficientParachute(){
        return (speedHorizontal / speedDown);
    }


}
