package com.aqacourses.test.runner;

import com.aqacourses.test.student.StudentMogilyanka;
import com.aqacourses.test.student.StudentNki;
import com.aqacourses.test.student.StudentPedin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {


    public static void main(String[] args) {

        //---Adding NKI student to BD ----
        StudentNki studentNki = new StudentNki();
        studentNki.openGui();
        List<String> data = studentNki.parseData();
        boolean valid = studentNki.validateInputData(data);
        if (valid) {
            studentNki.writeToDb(data);
        } else{
            System.out.println("Your input data isn't correct!");
        }
        data.clear();
        //---Adding Mohylanka student to BD----
        StudentMogilyanka studentMogilyanka = new StudentMogilyanka();
        studentMogilyanka.openGui();
        data = studentMogilyanka.parseData();
        valid = studentMogilyanka.validateInputData(data);
        if (valid) {
            studentMogilyanka.writeToDb(data);
        }else {
            System.out.println("Your input data isn't correct!");
        }
        data.clear();
        //---Adding Pedin student to BD----
        StudentPedin studentPedin = new StudentPedin();
        studentPedin.openGui();
        data = studentPedin.parseData();
        valid = studentPedin.validateInputData(data);
        if (valid) {
            studentPedin.writeToDb(data);
        }else {
            System.out.println("Your input data isn't correct!");
        }
        data.clear();
        //-----Parsing forparsing.txt------
        List<String> parsedFile = new ArrayList();
        String pathToFile = new File("src/Files/MongoDB-DB.txt").getAbsolutePath();
        try {
            parsedFile = studentPedin.parseFile(pathToFile);
        } catch (IOException e) {
            System.err.println("Unable to parse file");
        }
        System.out.println("Parsed file - " + parsedFile);

    }

}
