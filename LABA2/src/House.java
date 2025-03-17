import static java.lang.System.out;

public class House {

    private int numberOfFloors;

    public House(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    void checkFloors() {
        if (this.numberOfFloors <= 0) {
            throw new IllegalArgumentException("Количество этажей должно быть больше 0");
        }
    }

    void displayInfo() {
        if (this.numberOfFloors % 10 == 1) {
            out.println("Дом с " + this.numberOfFloors + " этажом");
        } else {
            out.println("Дом с " + this.numberOfFloors + " этажами");
        }
    }

}

