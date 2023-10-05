import java.util.*;
import java.util.stream.Collectors;
import java.util.function.*;

public class Main {

    public static <T> T findMaxInList(List<T> list, Comparator<? super T> comparator) {
        return list.stream().max(comparator).orElse(null);
    }

    public static <T extends Comparable<T>> T findMaxInList(List<T> list) {
        return list.stream().max(T::compareTo).orElse(null);
    }

    public static <T> T findMaxInCollection(Collection<T> collection, Comparator<? super T> comparator) {
        return collection.stream().max(comparator).orElse(null);
    }

    public static <T extends Comparable<T>> T findMaxInCollection(Collection<T> collection) {
        return collection.stream().max(T::compareTo).orElse(null);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Найти максимум в List с компаратором");
            System.out.println("2. Найти максимум в List без компаратора");
            System.out.println("3. Найти максимум в Collection с компаратором");
            System.out.println("4. Найти максимум в Collection без компаратора");
            System.out.println("5. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            List<Integer> intList;
            Set<String> stringSet;

            switch (choice) {
                case 1:
                    System.out.println("Введите числа через запятую:");
                    String[] intInput = scanner.nextLine().split(",");
                    intList = Arrays.stream(intInput).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
                    System.out.println("Максимальное значение в List с компаратором: " +
                            findMaxInList(intList, Integer::compareTo));
                    break;

                case 2:
                    System.out.println("Введите числа через запятую:");
                    intInput = scanner.nextLine().split(",");
                    intList = Arrays.stream(intInput).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
                    System.out.println("Максимальное значение в List без компаратора: " +
                            findMaxInList(intList));
                    break;

                case 3:
                    System.out.println("Введите строки через запятую:");
                    String[] stringInput = scanner.nextLine().split(",");
                    stringSet = Arrays.stream(stringInput).map(String::trim).collect(Collectors.toSet());
                    System.out.println("Максимальное значение в Collection с компаратором: " +
                            findMaxInCollection(stringSet, String::compareTo));
                    break;

                case 4:
                    System.out.println("Введите строки через запятую:");
                    stringInput = scanner.nextLine().split(",");
                    stringSet = Arrays.stream(stringInput).map(String::trim).collect(Collectors.toSet());
                    System.out.println("Максимальное значение в Collection без компаратора: " +
                            findMaxInCollection(stringSet));
                    break;

                case 5:
                    System.out.println("Выход из программы.");
                    return;

                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
}
