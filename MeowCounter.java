package ru.okulova.lab5.cats;

public class MeowCounter implements Meowable {

    private Meowable wrapped;
    private Counter counter;

    public MeowCounter(Meowable wrapped, Counter counter) {
        this.wrapped = wrapped;
        this.counter = counter;
    }

    @Override
    public void meow() {
        wrapped.meow();       // настоящий кот мяукает
        counter.increment();  // счётчик считает
    }
}
