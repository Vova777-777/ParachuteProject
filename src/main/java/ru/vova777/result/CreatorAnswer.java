package ru.vova777.result;

import ru.vova777.coordinatePlane.CoordinateQuarter;
import ru.vova777.parametersJump.CollectorParametersJump;

import java.util.Collections;
import java.util.Map;

public interface CreatorAnswer {


     Map<Double, CollectorParametersAnswer> createAllAnswers(CoordinateQuarter ccq, double trackParNotWind_x0,
                                                             double trackParNotWind_y0, double altitude);
}