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
            case 13:
                out.println("Задание 1.3. Ввод имён.");

                Name name = new Name();
                out.println(name);
                break;

            case 22:
                out.println("Задание 2.2. Человек с именем.");

                Name name22_1 = new Name("Клеопатра");
                Human human22_1 = new Human(152, name22_1);
                out.println(human22_1);

                Name name22_2 = new Name("Александр", "Пушкин", "Сергеевич");
                Human human22_2 = new Human(167, name22_2);
                out.println(human22_2);

                Name name22_3 = new Name("Владимир", "Маяковский");
                Human human22_3 = new Human(189, name22_2);
                out.println(human22_3);

                break;

            case 23:
                out.println("Задание 2.3. Человек с родителями.");

                Name IvanName = new Name("Иван", "Чудов");
                Human Ivan = new Human(190, IvanName);

                Name PetrName = new Name("Петр", "Чудов");
                Human Petr = new Human(180, PetrName);

                Name BorisName = new Name("Борис");
                Human Boris = new Human(170, BorisName);

                Petr.setFather(Ivan);
                Boris.setFather(Petr);

                out.println(PetrName.getPatronymic());

                out.println(Ivan);
                out.println(Petr);
                out.println(Boris);

                break;

            case 33:
                out.println("Задание 3.3. Города");

                City a = new City("A");
                City b = new City("B");
                City c = new City("C");
                City d = new City("D");
                City e = new City("E");
                City f = new City("F");


                a.addRoute(b, 5);
                a.addRoute(f, 1);
                a.addRoute(d, 6);

                b.addRoute(c, 3);
                b.addRoute(a, 1);

                c.addRoute(d, 4);

                d.addRoute(e, 2);

                e.addRoute(f, 2);

                f.addRoute(e, 2);
                f.addRoute(b, 1);


                System.out.println(a);
                System.out.println(b);
                System.out.println(c);
                System.out.println(d);
                System.out.println(e);
                System.out.println(f);

                break;

            case 45:
                out.println("Задание 4.5. Ввод имён конкретным образом.");

                out.println("Создание имени: Клеопатра");
                Name name45_1 = new Name("Клеопатра");
                out.println(name45_1);

                out.println("\nСоздание имени: Александр Сергеевич Пушкин");
                Name name45_2 = new Name("Александр", "Пушкин", "Сергеевич");
                out.println(name45_2);

                out.println("\nСоздание имени: Владимир Маяковский");
                Name name45_3 = new Name("Владимир", "Маяковский");
                out.println(name45_3);

                out.println("\nСоздание имени: Христофор Бонифатьевич");
                Name name45_4 = new Name("Христофор", "Бонифатьевич");
                out.println(name45_4);
                break;
            case 52:
                out.println("Задание 5.2. Кот мяукает.");

                Cat Barsik = new Cat("Барсик");
                Barsik.meow();
                Barsik.meow(3);

                break;

            default:
                throw new IllegalStateException("Unexpected value: " + n);
        }

    }
}

