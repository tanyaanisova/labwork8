package Object;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class NewStudyGroup implements Serializable {
    private BufferedReader commandReader;

    public NewStudyGroup(BufferedReader commandReader){
        this.commandReader = commandReader;
    }

    private String readStringNotNull() throws IOException {
        //System.out.print("Введите " + name +": ");
        String n = commandReader.readLine();
        if (n.equals("")) {
            //System.out.println("Поле не может быть null или пустой строкой ");
            return readStringNotNull();
        } else return n;
    }

    private Number readNumber(String format) throws IOException {
        String n = readStringNotNull();
        try {
            switch (format) {
                case "Float":
                    return Float.parseFloat(n);
                case "Integer":
                    return Integer.parseInt(n);
                case "Long":
                    return Long.parseLong(n);
                case "Double":
                    return Double.parseDouble(n);
                default:
                    return 0;
            }
        } catch (NumberFormatException ex) {
            //System.out.println("Аргумент не является значением типа " + format);
            return readNumber(format);
        }
    }

    private Semester readSemester() throws IOException {
        String n = readStringNotNull();
        n = n.toUpperCase();
        try {
            return Semester.valueOf(n);
        } catch (IllegalArgumentException ex) {
            //System.out.println("Значение поля неверное");
            return readSemester();
        }
    }

    public Person newPerson() throws IOException {
        //System.out.println("Введите groupAdmin: ");
        String name = readStringNotNull();
        Double height = (Double) readNumber("Double");
        while (height <= 0) {
            //System.out.println("Значение поля должно быть больше 0");
            height = (Double) readNumber("Double");
        }
        long weight = (long) readNumber("Long");
        while (weight <= 0) {
            //System.out.println("Значение поля должно быть больше 0");
            weight = (long) readNumber("Long");
        }
        //System.out.println("Введите location: ");
        Location location = newLocation();
        return new Person(name,height,weight,location);
    }

    private Location newLocation() throws IOException {
        double x = (double) readNumber("Double");
        long y = (long) readNumber("Long");
        Integer z = (Integer) readNumber("Integer");
        String name = readStringNotNull();
        return new Location(x,y,z,name);
    }

    /**
     * Получает значения элемента в коллекции
     */
    public StudyGroup newGroup() throws IOException {
        String name = readStringNotNull();
        //System.out.println("Введите coordinates: ");
        float x = (Float) readNumber("Float");
        Long y = (Long) readNumber("Long");
        int studentsCount = (int) readNumber("Integer");
        while (studentsCount <= 0) {
            //System.out.println("Значение поля должно быть больше 0");
            studentsCount = (int) readNumber("Integer");
        }
        long expelledStudents = (long) readNumber("Long");
        while (expelledStudents <= 0) {
            //System.out.println("Значение поля должно быть больше 0");
            expelledStudents = (long) readNumber("Long");
        }
        Float averageMark = (Float) readNumber("Float");
        while (averageMark <= 0) {
            //System.out.println("Значение поля должно быть больше 0");
            averageMark = (Float) readNumber("Float");
        }
        Semester semester = readSemester();
        Person admin = newPerson();

        int id = 0;
        ZonedDateTime creationDate = ZonedDateTime.now();
        //System.out.println("Все значения элемента успешно получены");
        //return null;
        return new StudyGroup(id, name, new Coordinates(x, y), creationDate, studentsCount, expelledStudents, averageMark, semester,admin, 1, Color.BLACK.toString());
    }

}
