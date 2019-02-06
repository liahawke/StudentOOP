package com.aqacourses.test.student;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;


public abstract class AbstractStudent {

    /**
     * Parse data from GUI
     *
     * @return list with student data
     */
    public List<String> parseData() {
        List<String> data = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter name of student:");
        String name = scanner.nextLine();
        if (isLineNotEmpty(name)) {
            data.add(name);
        }

        System.out.println("Please enter age of student:");
        String age = scanner.nextLine();
        if (isLineNotEmpty(age)) {
            data.add(age);
        }

        System.out.println("Please enter sex of student:");
        String sex = scanner.nextLine();
        if (isLineNotEmpty(sex)) {
            data.add(sex);
        }

        return data;
    }

    /**
     * Opens GUI
     */
    public void openGui() {
        System.out.println("Opened GUI");
    }

    /**
     * Verify that string is not empty
     *
     * @param line
     * @return
     */
    private boolean isLineNotEmpty(String line) {
        if (!line.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Get date
     *
     * @return string that represents current date and time
     */
    public String getDate() {
        return new SimpleDateFormat("YYYY-MM-dd HH:mm:ss")
                .format(Calendar.getInstance().getTime());
    }

    /**
     *
     * Validate input data
     *
     * @param data
     * @return true if validation was successful
     */

    public boolean validateInputData (List<String> data){
        String name = data.get(0).toString();
        int age = Integer.parseInt(data.get(1).toString());
        String sex = data.get(2).toString();
        if(data.get(1).toString().matches("[a-zA-Z]+")){
            System.out.println("Age should be a number!");
            return false;
        }
        if(!name.matches("[a-zA-Z]{2,10}\\s[a-zA-Z]{2,10}")){
            System.out.println("Your name or surname isn't correct!");
            return false;
        }
        if(age < 17 | age > 25){
            System.out.println("Age shouldn't be more than 25 or less than 17!");
            return false;
        }
        if(!sex.equals("male") & !sex.equals("female")){
            System.out.println("Sex should be male or female!");
            return false;
        }
        return true;
    }

}
