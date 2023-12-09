package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassA {

    @Value("${x}")
    int x;
    // String e = "2+3";
    @Value("${myAge:3}")
    private  int age;


//    @Value("richa luthra")
//    private String name1;
    //@Value("#{'richa '+ 'luthra'}")
    @Value("${myName:'richaluthra'}")
    private String name;

    @Value("{${valuesMap}")
   private Map<Integer, String> valuesMap;
    @Value("${myList}")
    private char[] mylist;


    @Autowired
    private ClassB obj;

    @Autowired
    private ClassD objD;



    public void hello(){
       // obj.test();
        System.out.println("hello");
    }
}
