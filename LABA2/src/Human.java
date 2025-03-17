import java.util.Objects;
import java.util.Scanner;

public class Human {
    Scanner in = new Scanner(System.in);

    Name name;
    int height;
    Human father;

    public Human() {
        System.out.println("Введите рост: ");
        this.height = in.nextInt();

        this.name = new Name();
    }

    public Human(int height, Name name) {
        this.height = height;
        this.name = name;
    }

    void setFather(Human father) {
        this.father = father;
    }

    public Human getFather() {
        return this.father;
    }

    public String toString() {
        if (!Objects.equals(this.getFather(),null)) {
            if (Objects.equals(name.getLastName(), "") || Objects.equals(name.getLastName(), null))
                name.setLastName(father.name.getLastName());


            if (Objects.equals(name.getPatronymic(), "") || Objects.equals(name.getPatronymic(), null))
                name.setPatronymic(father.name.getFirstName() + "ович");
        }

        return name + ", рост: " + height;
    }

}
