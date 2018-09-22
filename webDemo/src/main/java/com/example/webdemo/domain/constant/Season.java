package com.example.webdemo.domain.constant;

public enum Season {
    SPRING(1,"봄"),
    SUMMER(2,"여름"),
    FALL(3,"가을"),
    WINTER(4,"겨울");

    private int num;
    private String name;

    Season(int num , String name){
        this.num = num;
        this.name = name;
    }

    public int getNum() { return num; }

    public String getName() { return name; }
}
