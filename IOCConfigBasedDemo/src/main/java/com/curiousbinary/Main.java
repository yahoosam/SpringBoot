package com.curiousbinary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        //ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        //here doctor class is annotated as a component
        Staff staff = context.getBean(Doctor.class);
        staff.assist();

        //nurse class is NOT annotated as a component BUT manually added as a bean in BeanConfig class
        staff = context.getBean(Nurse.class);
        staff.assist();

    }
}