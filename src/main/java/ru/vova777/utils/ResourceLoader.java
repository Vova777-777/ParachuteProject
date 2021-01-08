package ru.vova777.utils;

import com.opensymphony.xwork2.util.ClassLoaderUtil;
import ru.vova777.CollectorParametersJump;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ResourceLoader {
    public static List<String> getInfoFromResource(String resourceName) throws URISyntaxException, IOException {
        Path path = getPathResource(resourceName);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }

    public static Path getPathResource(String resourceName) throws URISyntaxException {
        URL url = ClassLoaderUtil.getResource(resourceName, ResourceLoader.class);
        Path path = Paths.get(url.toURI());
        return path;
    }
}
