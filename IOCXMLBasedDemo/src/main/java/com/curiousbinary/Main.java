package com.curiousbinary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Doctor doctor = context.getBean(Doctor.class); //get the bean using class
        doctor.assist();
        System.out.println(doctor.getQualification());

        Nurse nurse = (Nurse) context.getBean("nurse"); //get the bean using id
        nurse.assist();
        System.out.println(nurse.getQualification());

        //decouple the application
        //create an interface and let the two classes implement the interface
        Staff staff = context.getBean(Doctor.class);
        staff.assist();

        staff = context.getBean(Nurse.class);
        staff.assist();

    }
}