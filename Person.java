public class Person {

    private String name;
    private Integer number; // может быть null, если номера нет

    public Person(String name, Integer number) {
        this.name = normalizeName(name);
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    // Имя → первая буква заглавная, остальные строчные
    private String normalizeName(String name) {
        name = name.toLowerCase();
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    @Override
    public String toString() {
        return name + ":" + number;
    }
}
