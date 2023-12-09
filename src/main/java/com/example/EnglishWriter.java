package com.example;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Component
//@Profile("qa")
public class EnglishWriter implements Writer{




    @Override
    public void write() {
        System.out.println("Hello");
    }
}
