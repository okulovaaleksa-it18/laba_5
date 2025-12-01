    package ru.okulova.lab5.main;
    import ru.okulova.lab5.cats.Counter;
    import ru.okulova.lab5.cats.MeowCounter;
    import ru.okulova.lab5.lists.ListTask3;
    import ru.okulova.lab5.lists.QueueTask6;
    import ru.okulova.lab5.lists.WordsChars;
    import ru.okulova.lab5.math.Fraction;
    import ru.okulova.lab5.math.FractionCashed;
    import ru.okulova.lab5.math.check;
    import ru.okulova.lab5.cats.Cat;
    import ru.okulova.lab5.cats.FunsMeow;
    import ru.okulova.lab5.lines.Point;
    import ru.okulova.lab5.lines.Polyline;
    import ru.okulova.lab5.people.Athlete;
    import ru.okulova.lab5.people.Person;
    import ru.okulova.lab5.people.PersonProcessor;
    
    import java.io.IOException;
    import java.util.*;
    import java.util.stream.Collectors;
    
    import static ru.okulova.lab5.lists.ListTask3.keepFirstOccurrences;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        check check = new check();

        System.out.print("""
                           ========================
                           ======СПИСОК ЗАДАЧ======
                           ========================
                           1. Задание 1. Шаблоны
                           2. Задание 2. Структурные шаблоны
                           3. Задание 3.10 Список
                           4. Задание 4.10 Мап
                           5. Задание 5.6 Сет
                           6. Задание 6.1 Очередь
                           7. Задание 7.1 Стрим
                           8. Задание 7.2 Стрим
                           """);
        int choice = check.inputNum("Выберите номер задачи: ");
        System.out.println("Задача №" + choice + ":");

        switch (choice) {
            case(1): {
                System.out.println("=== Обычная дробь ===");
                Fraction f1 = new Fraction(1, -2);
                Fraction f2 = new Fraction(-1, 2);

                System.out.println("f1 = " + f1);
                System.out.println("f2 = " + f2);

                System.out.println("f1 == f2 ? " + f1.equals(f2));
                System.out.println("Вещественное значение f1: " + f1.getValue());

                System.out.println("=== Дробь c кэшированием ===");
                FractionCashed f3 = new FractionCashed(3, 4);

                System.out.println("f3 = " + f3);
                System.out.println("Первый вызов: " + f3.getValue());  // вычисление
                System.out.println("Второй вызов: " + f3.getValue());  // берёт из кэша

                f3.setNumerator(6);
                System.out.println("Меняем числитель f3 = " + f3);
                System.out.println("После изменения числителя: " + f3.getValue());
                break;
            }
            case(2): {
                Cat cat = new Cat("Йося");

                // создаём внешний счётчик
                Counter counter = new Counter();

                // создаём обёртку, которая считает мяуканья
                MeowCounter wrappedCat = new MeowCounter(cat, counter);

                // запускаем механику мяуканья
                FunsMeow.meowsCare(wrappedCat);

                // выводим количество
                System.out.println("Кот мяукнул " + counter.getCount() + " раз");
                break;
            }
            case(3): {
                List<String> words = new ArrayList<>(Arrays.asList("apple", "banana", "apple", "orange", "banana"));
                System.out.println("Исходный список: " + words);
                keepFirstOccurrences(words);
                System.out.println("Список после: " + words);

                List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 1, 4));
                System.out.println("Исходный список: " + numbers);
                keepFirstOccurrences(numbers);
                System.out.println("Список после: " + numbers);

                break;
            }
            }
            case(4): {
                System.out.print("Введите количество спортсменов: ");
                int N = Integer.parseInt(scanner.nextLine());

                System.out.print("Введите количество видов спорта: ");
                int M = Integer.parseInt(scanner.nextLine());

                System.out.println("Введите данные о спортсменах в формате: Фамилия Имя балл1 балл2 ...");

                Map<String, int[]> athletesMap = Athlete.readAthletes(scanner, N, M);

                //Сортировка по сумме баллов
                List<Map.Entry<String, int[]>> sortedList = Athlete.sortByTotalPoints(athletesMap);

                //рейтинг
                Athlete.printRanking(sortedList);

                scanner.close();
                break;
            }
            case(5): {
                String fileName = "C:\\Users\\shark\\IdeaProjects\\laba5\\src\\text.txt"; // укажите ваш файл
                
                Set<Character> charsSet = WordsChars.getCharsFromEvenWords(fileName);
                
                WordsChars.printChars(charsSet);
                break;
            }
            case(6): {
                Queue<Integer> queue = QueueTask6.createSampleQueue();
                System.out.println("Исходная очередь: " + queue);
                
                QueueTask6.printQueueReversed(queue);
                break;
            }
            case(7): {
                List<Point> points = Arrays.asList(
                        new Point(3, -2),
                        new Point(1, 5),
                        new Point(3, -2),
                        new Point(2, -7),
                        new Point(0, 0)
                );

                //Стрим
                List<Point> processedPoints = points.stream()
                        .distinct() // Убираем точки с одинаковыми координатами
                        .map(p -> new Point(p.getX(), Math.abs(p.getY()))) // Отрицательные Y делаем положительными
                        .sorted(Comparator.comparingDouble(Point::getX)) // Сортируем точки по координате X
                        .collect(Collectors.toList()); // Собираем в список


                Polyline polyline = new Polyline(processedPoints);
                
                System.out.println("Итоговая ломаная линия:");
                System.out.println(polyline);
                break;
            }
            case(8): {
                PersonProcessor processor = new PersonProcessor();
                String filename = "C:\\Users\\shark\\IdeaProjects\\laba5\\src\\text2.txt"; 

                try {
                    System.out.println("Чтение файла.");

                    //читаем людей из файла
                    List<Person> people = processor.readPeople(filename);

                    //группируем
                    Map<Integer, List<String>> grouped =
                            processor.groupByNumber(people);
                    
                    System.out.println("\nРезультат:");
                    System.out.println(grouped);

                } catch (IOException e) {
                    System.out.println("Ошибка чтения файла: " + e.getMessage());
                }
                break;
            }
        }
    }
}
