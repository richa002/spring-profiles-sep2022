package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@SpringBootApplication
//@ComponentScan(basePackages = {})
// @Configuration , @AutoConfiguration , @ComponentScan
public class Application {

//@Autowired
//WriterManager manager;

    public static void main(String[] args) {


       ApplicationContext context = SpringApplication.run(Application.class, args);

        ClassA obj = context.getBean(ClassA.class);
        System.out.println(obj.x);

    }

//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("hello");
//    }


    // isolated method, will not change with any writer, no code change required here,
    // but from some other point in this class , we should supply the actual object of writer,
    // so again code change required in the class
//    public static void invokeWriter(Writer writer) {
//        writer.write();
//    }

//@Bean
//public ClassB bean1(){
//        return new ClassB();
//}


}
