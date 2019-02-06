package com.aqacourses.test.student;

import com.aqacourses.test.interfaces.ParseFileInterface;
import com.aqacourses.test.interfaces.WriteToDbInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class StudentPedin extends Student implements ParseFileInterface, WriteToDbInterface {
    private File file;
    private FileWriter fileWriter;

    @Override
    public List <String> parseFile(String pathToFile) throws IOException {
        List <String> dataFromFile = new ArrayList<String>();
        try{
            file = new File(pathToFile);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = null;
            while((line = reader.readLine()) != null){
                dataFromFile.add(line);
            }
        }
        catch (IOException e){
            System.out.println("Failed to parse file");
        }
        return dataFromFile;
    }

    @Override
    public void writeToDb(List<String> data) {
        try {
            openConnection();
            if (validateData(data)) {
                for (String datum : data) {
                    fileWriter.write(getDate() + " - " + datum + System.getProperty("line.separator"));
                }
                System.out.println("All data is written to Mongo DB");
                closeConnection();
            }
        } catch (IOException e) {
            System.err.println("Failed to open connection to Mongo DB");
            e.printStackTrace();
        }
    }

    /**
     * Open connection to Mongo DB
     */
    private void openConnection() throws IOException {
        String path = new File("src/Files/MongoDB-DB.txt").getAbsolutePath();
        fileWriter = new FileWriter(path);
    }

    /**
     * Close connection to Mongo DB
     */
    private void closeConnection() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Cannot close connection to Postgres DB");
            e.printStackTrace();
        }
        System.out.println("Close connection to Postgres DB");
    }

}
