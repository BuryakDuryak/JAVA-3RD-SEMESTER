import java.util.Objects;
import java.util.Scanner;

public class Human {
    Scanner in = new Scanner(System.in);

    private Name name;
    private int height;
    private final Human father;

    public Human() {
        System.out.println("Введите рост: ");
        this.height = in.nextInt();

        this.name = new Name();

        father = null;

        this.correctionCheck();
    }

    public Human(int height, Name name) {
        this.height = height;
        this.name = name;
        father = null;

        this.correctionCheck();
    }

    public Human(int height, Name name, Human father) {
        this.height = height;
        this.name = name;
        this.father = father;

        this.correctionCheck();
    }

    public Human getFather() {
        return this.father;
    }

    public Name getName() {
        return this.name;
    }

    void setHeight(int height) {
        this.height = height;
    }

    void correctionCheck() {
        if (height > 500 || height < 0)
            throw new IllegalArgumentException("Недопустимое значение высоты");
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
