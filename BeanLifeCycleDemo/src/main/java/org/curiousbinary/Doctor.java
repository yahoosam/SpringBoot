package org.curiousbinary;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(scopeName = "prototype")
public class Doctor implements Staff, BeanNameAware {
    private String qualification;

    public void assist() {
        System.out.println("Doctor is assisting...");
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "qualification='" + qualification + '\'' +
                '}';
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Doctor() {
        System.out.println("Bean instance created...");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("setBeanName method is called...");
    }

    //custom method - once the object is created, if we want to do any operation use @PostConstruct
    // from javax.annotation (pom.xml)
    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct method is called...");
    }

    //custom method - before destroying the bean, if some operation needs to be performed use @PreDestroy
    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy method is called...");
    }

}
