package org.curiousbinary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        final ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Doctor bean = context.getBean(Doctor.class);
        bean.assist();
        bean.setQualification("MBBS");
        System.out.println(bean);
        
    }
}