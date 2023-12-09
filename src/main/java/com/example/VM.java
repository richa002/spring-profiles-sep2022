package com.example;

public class VM {
    private Writer obj; // HAS -A RELATIONSHIP

    public VM(Writer obj) {
        this.obj = obj;
    }

    public void invokeWrite(){
         obj.write();

    }
}
