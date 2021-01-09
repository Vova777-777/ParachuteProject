package ru.vova777;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class cl7777 {
    public void main1() throws IOException {

        File file = new File(getClass().getClassLoader().getResource("NamesParachuteSystems").getPath());

        String content = new String(Files.readAllBytes(file.toPath()));
        System.out.println(content);


    }

    public static void main(String[] args) throws IOException {
        new cl7777().main1();
    }
}
