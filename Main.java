//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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
                Fraction.menu(check);
                break;
            }
            case(2): {
                Cat m = new Cat("Йося");

                FunsMeow.meowsCare(m);

                System.out.println("Кот мяукнул " + m.getMeowCount() + " раз");
                break;
            }
            case(3): {
                ArrayList<Integer> numbers = new ArrayList<>();
                numbers.add(5);
                numbers.add(3);
                numbers.add(7);
                numbers.add(5);
                numbers.add(3);
                numbers.add(9);

                System.out.println("Исходный список: " + numbers);

                ListTask3.keepFirstOccurrences(numbers);

                System.out.println("Список без повторов: " + numbers);
                break;
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
