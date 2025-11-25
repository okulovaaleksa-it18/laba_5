import java.util.Scanner;


public class Fraction implements FractionOperations {
    private int numerator;         // числитель
    private int denominator;       // знаменатель
    private Double cachedValue = null; // кэш для вещественного значения

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        cachedValue = null;
    }

    //возвращает вещественное значение дроби
    @Override
    public double getDoubleValue() {
        if (cachedValue == null) {   // если значение не вычислялось, вычисляем
            cachedValue = (double) numerator / denominator;
        }
        return cachedValue;
    }

    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        cachedValue = null;
    }

    @Override
    public void setDenominator(int denominator) {
        if (denominator > 0) {
            this.denominator = denominator;
            cachedValue = null;
        } else {
            System.out.println("Ошибка! Знаменатель должен быть положительным.");
        }
    }
    
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Сравнение дробей
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fraction)) return false;
        Fraction other = (Fraction) obj;
        return this.numerator == other.numerator && this.denominator == other.denominator;
    }

    @Override
    public int hashCode() {
        return numerator * 31 + denominator;
    }


    public static void menu(check check) {
        Fraction fraction = null;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("""
            =====Меню====
            1. Создать дробь
            2. Изменить числитель
            3. Изменить знаменатель
            4. Показать дробь
            5. Показать вещественное значение
            6. Сравнить с другой дробью
            0. Выход
            """);

            int choice = check.inputNum("Выберите действиe: ");
            switch (choice) {
                case 1:
                    int num = check.inputNum("Введите числитель: ");
                    int den;
                    while (true) { 
                        den = check.inputNum("Введите знаменатель (>0): ");
                        if (den > 0) break;  // если знаменатель корректный, выходим
                        System.out.println("Знаменатель должен быть положительным!");
                    }
                    fraction = new Fraction(num, den);
                    System.out.println("Дробь создана: " + fraction);
                    break;
                case 2:
                    if (fraction != null) {
                        int newNum = check.inputNum("Введите новый числитель: ");
                        fraction.setNumerator(newNum);
                        System.out.println("Числитель изменен: " + fraction);
                    } else {
                        System.out.println("Сначала создайте дробь!");
                    }
                    break;
                case 3:
                    if (fraction != null) {
                        int newDen;
                        while (true) { // проверка на положительный знаменатель
                            newDen = check.inputNum("Введите новый знаменатель (>0): ");
                            if (newDen > 0) break;
                            System.out.println("Знаменатель должен быть положительным!");
                        }
                        fraction.setDenominator(newDen);
                        System.out.println("Знаменатель изменен: " + fraction);
                    } else {
                        System.out.println("Сначала создайте дробь!");
                    }
                    break;
                case 4:
                    if (fraction != null) {
                        System.out.println("Дробь: " + fraction);
                    } else {
                        System.out.println("Сначала создайте дробь!");
                    }
                    break;
                case 5:
                    if (fraction != null) {
                        System.out.println("Вещественное значение: " + fraction.getDoubleValue());
                    } else {
                        System.out.println("Сначала создайте дробь!");
                    }
                    break;
                case 6:
                    if (fraction != null) {
                        System.out.println("Введите другую дробь для сравнения:");
                        int otherNum = check.inputNum("Числитель: ");
                        int otherDen;
                        while (true) {
                            otherDen = check.inputNum("Знаменатель (>0): ");
                            if (otherDen > 0) break;
                            System.out.println("Знаменатель должен быть положительным!");
                        }
                        Fraction otherFraction = new Fraction(otherNum, otherDen);
                        if (fraction.equals(otherFraction)) {
                            System.out.println("Дроби равны: " + fraction + " = " + otherFraction);
                        } else {
                            System.out.println("Дроби не равны: " + fraction + " != " + otherFraction);
                        }
                    } else {
                        System.out.println("Сначала создайте дробь!");
                    }
                    break;
                case 0:

                    System.out.println("Выход");
                    return;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }
}
