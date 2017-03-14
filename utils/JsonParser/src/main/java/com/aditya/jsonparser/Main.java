package com.aditya.jsonparser;

import com.aditya.jsonparser.entities.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by neo on 14-03-2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        InputStream inputStreamStArr = Thread.currentThread().getContextClassLoader().getResourceAsStream("students_array.json");
        InputStream inputStreamStObj = Thread.currentThread().getContextClassLoader().getResourceAsStream("students_object.json");

        ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

        try {

            ArrayList<Student> studentList = mapper.readValue(inputStreamStArr, new TypeReference<ArrayList<Student>>() {
            });
            Student student = mapper.readValue(inputStreamStObj, Student.class);

            System.out.println("Student Array: " + studentList);
            System.out.println("Student Object: " + student);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStreamStArr.close();
            inputStreamStObj.close();
        }

    }
}
