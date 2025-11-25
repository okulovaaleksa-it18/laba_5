import java.util.*;

public class Athlete {

    public static Map<String, int[]> readAthletes(Scanner sc, int N, int M) {
        Map<String, int[]> athletesMap = new LinkedHashMap<>();

        for (int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split(" ");
            String fullName = parts[0] + " " + parts[1];

            int[] scores = new int[M];
            for (int j = 0; j < M; j++) {
                scores[j] = Integer.parseInt(parts[2 + j]);
            }

            athletesMap.put(fullName, scores);
        }
        return athletesMap;
    }

    // сортировка по сумме баллов
    public static List<Map.Entry<String, int[]>> sortByTotalPoints(Map<String, int[]> athletesMap) {
        List<Map.Entry<String, int[]>> list = new ArrayList<>(athletesMap.entrySet());

        list.sort((a, b) -> {
            int sumA = Arrays.stream(a.getValue()).sum();
            int sumB = Arrays.stream(b.getValue()).sum();
            return Integer.compare(sumB, sumA);
        });

        return list;
    }

    public static void printRanking(List<Map.Entry<String, int[]>> sortedList) {
        System.out.println("\n=== Итоговый рейтинг ===");
        System.out.println("Фамилия Имя Баллы Место");

        int place = 1;
        for (int i = 0; i < sortedList.size(); i++) {
            int totalPoints = Arrays.stream(sortedList.get(i).getValue()).sum();

            // Если сумма равна предыдущему спортсмену, место не меняется
            if (i > 0 && totalPoints == Arrays.stream(sortedList.get(i - 1).getValue()).sum()) {
            } else {
                place = i + 1;
            }

            System.out.println(sortedList.get(i).getKey() + " " + totalPoints + " " + place);
        }
    }
}
