import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.out;

class Name {
    Scanner in = new Scanner(System.in);

    private String lastName;
    private final String firstName;
    private String patronymic;

    public Name(String firstName, String lastName, String patronymic) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;

        this.correctionCheck();
    }

    public Name(String firstName, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;

        this.correctionCheck();
    }

    public Name(String firstName) {
        this.firstName = firstName;

        this.correctionCheck();
    }

    public Name() {
        out.println("Введите имя: ");
        this.firstName = in.nextLine();

        out.println("Введите фамилию: ");
        this.lastName = in.nextLine();

        out.println("Введите отчество: ");
        this.patronymic = in.nextLine();

        this.correctionCheck();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    void setLastName(String lastName1) {
        lastName = lastName1;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    void setPatronymic(String patronymic1) {
        patronymic = patronymic1;
    }

    void correctionCheck() {
        if (Objects.equals(patronymic, "") && Objects.equals(firstName, "") && Objects.equals(lastName, ""))
            throw new IllegalArgumentException("Имя должно иметь хотя бы одно не пустое поле");
    }

    public String toString() {
        String name = "";

        if (!Objects.equals(lastName, "") && !Objects.equals(lastName, null)) {
            if (!lastName.matches("[а-яА-ЯёЁ]+")) {
                throw new IllegalArgumentException("Могут быть использованы только символы русского алфавита");
            }
            name += lastName + " ";
        }

        if (!Objects.equals(firstName, "") && !Objects.equals(firstName, null)) {
            if (!firstName.matches("[а-яА-ЯёЁ]+")) {
                throw new IllegalArgumentException("Могут быть использованы только символы русского алфавита");
            }
            name += firstName + " ";
        }

        if (!Objects.equals(patronymic, "") && !Objects.equals(patronymic, null)) {
            if (!patronymic.matches("[а-яА-ЯёЁ]+")) {
                throw new IllegalArgumentException("Могут быть использованы только символы русского алфавита");
            }
            name += patronymic;
        }

        return name;

    }
}
