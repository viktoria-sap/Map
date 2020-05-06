package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FileOpenManagerTest {

    FileOpenManager fileOpenManager = new FileOpenManager();

    @Test
    void getName() {
        fileOpenManager.register("Paint", "png");
        assertEquals("Paint", fileOpenManager.checkName("png"));
    }

    @Test
    void removeConnection() {
        fileOpenManager.register("Paint", "png");
        fileOpenManager.removeConnection("png");
        assertNull(fileOpenManager.checkName("png"));
    }

    @Test
    void getAllExtensions() {
        fileOpenManager.register("Paint", "png");
        fileOpenManager.register("AdobeReader", "pdf");
        List<String> actual = fileOpenManager.getAllExtensions();
        List<String> expected = new ArrayList<>();
        expected.add("pdf");
        expected.add("png");
        assertEquals(expected, actual);
    }

    @Test
    void getAllApps() {
        fileOpenManager.register("Excel", "xls");
        fileOpenManager.register("Paint", "png");
        fileOpenManager.register("AdobeReader", "pdf");
        fileOpenManager.register("InternetExplorer", "html");
        Set<String> actual = fileOpenManager.getAllApps();
        Set<String> expected = new HashSet<>();
        expected.add("Excel");
        expected.add("Paint");
        expected.add("AdobeReader");
        expected.add("InternetExplorer");
        assertEquals(expected, actual);
    }
}
