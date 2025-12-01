package ru.okulova.lab5.cats;

public class Cat implements Meowable {

    private String name;     // имя кота

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void meow() {
        System.out.println(name + ": мяу!");

    }

    @Override
    public String toString() {
        return "кот: " + name;
    }
}
