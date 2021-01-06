package main.java.ru.vova777;

import java.io.IOException;
import java.util.Queue;

public interface CreateAbleSectionsAltitude {
    public Queue<SectionAltitude> createSections(int verticalSizeHighestSection,
                                                 int countSections, int speedDown) throws IOException;
}
