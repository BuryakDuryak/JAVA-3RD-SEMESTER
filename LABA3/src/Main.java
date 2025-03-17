import static java.lang.System.out;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Main m = new Main();

        out.println("Введите номер задания: ");
        int n = in.nextInt();
        in.nextLine();
        switch (n) {
            case 17:
                out.println("Задание 1.7. Непустые имена.");

                Name name17 = new Name();

                break;

            case 18:
                out.println("Задание 1.8. Человек меняется.");

                Human human18 = new Human();

                break;

            case 22:
                out.println("Задание 2.2. Секреты.");

                Secret secret22_1 = new Secret("Алиса", "Этот прицел просто имба!");
                System.out.println(secret22_1);

                Secret secret22_2 = new Secret(secret22_1, "Роберт");

                System.out.println(secret22_2); // Вывод: Bob: это секрет!
                System.out.println(secret22_2.getKeeperCount()); // Вывод: 2
                System.out.println(secret22_2.getRemainingHolders()); // Вывод: 0
                System.out.println(secret22_2.getKeeperName(0));
                System.out.println(secret22_2.getKeeperName(1));// Вывод: Alice
                System.out.println(secret22_2.getDifferenceWithHolder(1)); // Вывод: 1 (разница в количестве символов между секретом Alice и Bob)

                break;

            case 43:
                out.println("Задание 4.3. Птицы.");

                Bird Sparrow = new Sparrow();
                Bird Cuckoo = new Cuckoo();
                Bird Parrot = new Parrot("Hello, world!");

                System.out.println("Воробей:");
                Sparrow.sing();

                System.out.println("Кукушка:");
                Cuckoo.sing();

                System.out.println("Попугай:");
                Parrot.sing();

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + n);
        }
    }
}
