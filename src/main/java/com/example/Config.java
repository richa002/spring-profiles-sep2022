//package com.example;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//@Configuration
//public class Config {
//
//
//    @Bean
//    public Writer w1() {
//        return new FrenchWriter();
//    }
//
//    // Writer writer = new FrenchWriter();
//    @Bean
//    public Writer writer1() {
//        return new FrenchWriter();
//    }
//
//    @Bean
//    public WriterManager manager(Writer writer) {
//        WriterManager obj = new WriterManager();
//        obj.setWriter(writer);
//        return obj;
//    }
//
//    @Bean
//    public WriterManager manager2(@Qualifier("writer1") Writer writer) {
//        return new WriterManager(writer);
//    }
//
//
////    @Bean
////    public Writer w2(){
////        return new EnglishWriter();
////    }
//
//}
