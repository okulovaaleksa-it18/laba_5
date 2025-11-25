public class Cat implements Meowable {

    private String name;     // имя кота
    private int meowCount = 0; // счетчик мяуканий

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
        meowCount++;
    }

    //кол-во мяуканья
    public int getMeowCount() {
        return meowCount;
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }
}
