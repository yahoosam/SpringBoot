package com.curiousbinary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.print.Doc;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        //here doctor class is annotated as a component
        Doctor doctor = context.getBean(Doctor.class);
        doctor.assist();
        doctor.setQualification("MBBS");
        System.out.println(doctor);

        Doctor doctor2 = context.getBean(Doctor.class);
        doctor2.setQualification("MD");
        System.out.println(doctor2);
    }
}