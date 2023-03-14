package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

// a totally isolated and loosely coupled class  , not aware of
// actual object that it will work with.
// THis class is having one dependency com.example.Writer, but will be set in it by the user of this class.
// Code in this class will never change. Somebody else will instantiate the object and
// inject in this class while using it. so loose coupling acheived by DI
@Component
//@PropertySource("classpath:custom.properties")

public class WriterManager {
  // @Value("${myName}")
    @Value("${myName:'default-value'}")
    private String myName;

    @Value("${listOfValues}")
    private String[] listOfValues;


    @Value("#{'${myName}'.toUpperCase()}")
    private String spel;

    @Value("#{${valuesMap}}")
    private Map<String, Integer> valuesMap;

    private Writer writer;
    // we will not do new com.example.Writer here, as that will make this class aware of the actual object,
    // and will make our code prone to tight coupling and also code change everytime when we
    // want to work with a new writer

    // we can use constructor or setter to set the com.example.Writer.

//    @Autowired
//    public  WriterManager(Writer writer){
//        this.writer = writer;
//    }

    @Autowired
    //First spring tries to do autowiring by type, if multiple found , looks for qualifying beans (@qualifier, @primary)
    // then if no such annotation used, tries to autowire by name, then throws exception if no qualifying bean found.
    // Spring uses the bean's name as a default qualifier value.
    // It will inspect the container and look for a bean with the exact name as the property to autowire it.
  // @Qualifier("frenchWriter")
    public void setWriter(Writer obj) {
        this.writer = obj;
    }

    public void invokeWrite(){
        writer.write();
    }
    public void printName(){
        System.out.println(myName);
        System.out.println(Arrays.toString(listOfValues));
        System.out.println(spel);
        System.out.println(valuesMap);
    }

}
