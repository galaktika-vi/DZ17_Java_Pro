import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class MyLinkedList<T> {
        Node<T> head;

        public void add(T data) {
            Node<T> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        public void print() {
            Node<T> temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static class Database<K extends Number, V> {
        Map<K, V> map;

        public Database() {
            map = new HashMap<>();
        }

        public void add(K key, V value) {
            map.put(key, value);
        }

        public void print() {
            map.forEach((key, value) -> System.out.println("Ключ: " + key + ", Значение: " + value));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyLinkedList<String> myList = new MyLinkedList<>();
        Database<Integer, String> myDatabase = new Database<>();

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить элемент в MyLinkedList");
            System.out.println("2. Вывести MyLinkedList");
            System.out.println("3. Добавить элемент в Database");
            System.out.println("4. Вывести Database");
            System.out.println("5. Выход");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Введите строку для добавления в MyLinkedList:");
                    String element = scanner.next();
                    myList.add(element);
                    break;

                case 2:
                    System.out.println("Содержимое MyLinkedList:");
                    myList.print();
                    break;

                case 3:
                    System.out.println("Введите ключ (целое число) и значение (строку) через пробел:");
                    int key = scanner.nextInt();
                    String value = scanner.next();
                    myDatabase.add(key, value);
                    break;

                case 4:
                    System.out.println("Содержимое Database:");
                    myDatabase.print();
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
