package com.curiousbinary;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.curiousbinary")
@EnableAspectJAutoProxy
public class BeanConfig {
}
