package com.aqacourses.test.runner;

import com.aqacourses.test.student.StudentMogilyanka;
import com.aqacourses.test.student.StudentNki;
import com.aqacourses.test.student.StudentPedin;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Runner {


    public static void main(String[] args) throws IOException {

        //---Adding NKI student to BD ----
        StudentNki studentNki = new StudentNki();
        studentNki.openGui();
        List<String> data = studentNki.parseData();
        studentNki.writeToDb(data);
        data.clear();
        //---Adding Mohylanka student to BD----
        StudentMogilyanka studentMogilyanka = new StudentMogilyanka();
        studentMogilyanka.openGui();
        data = studentMogilyanka.parseData();
        studentMogilyanka.writeToDb(data);
        //---Adding Pedin student to BD----
        StudentPedin studentPedin = new StudentPedin();
        studentPedin.openGui();
        String pathToFile = new File("src/Files/forparsing.txt").getAbsolutePath();
        data = studentPedin.parseFile(pathToFile);
        studentPedin.writeToDb(data);
    }

}
