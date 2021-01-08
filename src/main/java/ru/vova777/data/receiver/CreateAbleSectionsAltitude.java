package ru.vova777.data.receiver;

import ru.vova777.data.SectionAltitude;

import java.io.IOException;
import java.util.Queue;

public interface CreateAbleSectionsAltitude {
    public Queue<SectionAltitude> createSections(int verticalSizeHighestSection,
                                                 int countSections, int speedDown) throws IOException;
}
