package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication

public class Application {



    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);


        // Understanding DI
        //Appraoch 1 : TIGHT COUPLING, NO POLYMORPHISM
//        EnglishWriter writer1 = new EnglishWriter();
//        writer1.write();
//
//        com.example.FrenchWriter writer2 = new com.example.FrenchWriter();
//        writer2.write();


        // Approach 2 : USING POLYMORPHISM ,
        // BUT OUR APPLICATION CLASS IS AWARE ABOUT WHICH WRITER OBJECT WILL WRITE,
        // SO WITH EVERY NEW WRITER CHANGES IN APPLICATION CLASS ARE REQUIRED
//        Writer writer1 = new EnglishWriter();
//        writer1.write();
//
//        Writer writer2 = FrenchWriter();
//        writer2.write();


        //Approach 3 : separating the code in a method , that is not aware of which writer will write
        //  com.example.Application class still aware of which writer is writing, code change requried everytime
        // only method code is isolated
//        invokeWriter(new EnglishWriter());
//        invokeWriter(new FrenchWriter());


        //Approach 4 : separating instiatation of object from the class that uses it (become unaware of actual onject)
        // we should find a way to isolate the whole class rather than just method,
        // right now object instantiation is happening within the same class that is using it,
        // this is tight coupling, so lets create com.example.WriterManager class as isolated class without having instantiation of object

//        WriterManager manager = new WriterManager(new EnglishWriter());
//        manager.invokeWrite();

        //Appraoch 5: lets move forward, and give thsi responsibilt to spring container to acreate beans for
        // us and ask Spring to inject that whereever we need it.

        WriterManager bean = context.getBean(WriterManager.class);
        bean.invokeWrite();
        bean.printName();


    }


    // isolated method, will not change with any writer, no code change required here,
    // but from some other point in this class , we should supply the actual object of writer,
    // so again code change required in the class
    public static void invokeWriter(Writer writer) {
        writer.write();
    }


}
