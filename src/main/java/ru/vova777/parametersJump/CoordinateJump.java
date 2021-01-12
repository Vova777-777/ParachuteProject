package ru.vova777.parametersJump;

import java.util.Scanner;

public class CoordinateJump implements CheckAbleIsDigit {
    Scanner scan = new Scanner(System.in);

    public int getX() {
        int x;
        while (true){
        System.out.println("Введите полную прямоуголную координату X");
        String str = scan.nextLine();
        if (isDigit(str)) return (x = Integer.parseInt(str));
        else System.out.println("Введите корректно (Цифрами)");
        }
    }

    public int getY() {
        int y;
        while (true){
            System.out.println("Введите полную прямоугольню координату У");
            String str = scan.nextLine();
            if (isDigit(str)) return (y = Integer.parseInt(str));
            else System.out.println("Введите корректно (Цифрами)");
        }
    }
}
