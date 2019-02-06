package com.aqacourses.test.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface ParseFileInterface {
    /**
     * Parsing path to file
     *
     * @param pathToFile
     * @return ArrayList
     */
    public List<String> parseFile (String pathToFile) throws IOException;
}
