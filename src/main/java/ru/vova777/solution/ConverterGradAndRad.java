package ru.vova777.solution;

public class ConverterGradAndRad {
    double convertGradToRad (int grad){
       return (Math.PI * grad);
    }

    int convertRadToGrad (double rad){
        return (int) ((rad * 180) / Math.PI);
    }
}
