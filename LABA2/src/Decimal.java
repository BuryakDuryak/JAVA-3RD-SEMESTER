import java.util.Scanner;

import static java.lang.System.out;

class Decimal {

    private int numerator; //числитель
    private int denominator; //знаменатель
    Scanner in = new Scanner(System.in);

    public Decimal(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        if (this.denominator == 0)
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
    }

    public Decimal() {
        out.println("Введите числитель: ");
        this.numerator = in.nextInt();

        out.println("Введите знаменатель (не равен нулю): ");
        this.denominator = in.nextInt();

        if (this.denominator == 0)
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
    }


    public String getDecimal() {
        return numerator + "/" + denominator;
    }

    public Decimal sum(Decimal f) {
        out.print(this.numerator + "/" + this.denominator + " + " + f.numerator + "/" + f.denominator + " = ");

        int placeholderDenominator;
        int placeholderNumerator;

        if (this.denominator != f.denominator) {
            placeholderDenominator = this.denominator * f.denominator;
            placeholderNumerator = (this.denominator * f.numerator) + (f.denominator * this.numerator);

        } else {
            placeholderDenominator = this.denominator;
            placeholderNumerator = this.numerator + f.numerator;
        }

        out.println(placeholderNumerator + "/" + placeholderDenominator);
        return new Decimal(placeholderNumerator, placeholderDenominator);
    }

    public Decimal sum(int number) {
        Decimal f = new Decimal(number, 1);

        out.print(this.numerator + "/" + this.denominator + " + " + f.numerator + "/" + f.denominator + " = ");

        int placeholderDenominator;
        int placeholderNumerator;

        if (this.denominator != f.denominator) {
            placeholderDenominator = this.denominator * f.denominator;
            placeholderNumerator = (this.denominator * f.numerator) + (f.denominator * this.numerator);

        } else {
            placeholderDenominator = this.denominator;
            placeholderNumerator = this.numerator + f.numerator;
        }

        out.println(placeholderNumerator + "/" + placeholderDenominator);
        return new Decimal(placeholderNumerator, placeholderDenominator);
    }

    public Decimal minus(Decimal f) {
        out.print(this.numerator + "/" + this.denominator + " - " + f.numerator + "/" + f.denominator + " = ");

        int placeholderDenominator;
        int placeholderNumerator;

        if (this.denominator != f.denominator) {
            placeholderDenominator = this.denominator * f.denominator;
            placeholderNumerator = (f.denominator * this.numerator) - (this.denominator * f.numerator);

        } else {
            placeholderDenominator = this.denominator;
            placeholderNumerator = this.numerator - f.numerator;
        }

        out.println(placeholderNumerator + "/" + placeholderDenominator);
        return new Decimal(placeholderNumerator, placeholderDenominator);
    }

    public Decimal minus(int number) {
        Decimal f = new Decimal(number, 1);

        out.print(this.numerator + "/" + this.denominator + " - " + f.numerator + "/" + f.denominator + " = ");

        int placeholderDenominator;
        int placeholderNumerator;

        if (this.denominator != f.denominator) {
            placeholderDenominator = this.denominator * f.denominator;
            placeholderNumerator = (f.denominator * this.numerator) - (this.denominator * f.numerator);

        } else {
            placeholderDenominator = this.denominator;
            placeholderNumerator = this.numerator - f.numerator;
        }

        out.println(placeholderNumerator + "/" + placeholderDenominator);
        return new Decimal(placeholderNumerator, placeholderDenominator);
    }

    public Decimal mult(Decimal f) {
        out.print(this.numerator + "/" + this.denominator + " * " + f.numerator + "/" + f.denominator + " = ");

        int placeholderDenominator = this.denominator * f.denominator;
        int placeholderNumerator = this.numerator * f.numerator;

        out.println(placeholderNumerator + "/" + placeholderDenominator);
        return new Decimal(placeholderNumerator, placeholderDenominator);
    }

    public Decimal mult(int number) {
        Decimal f = new Decimal(number, 1);

        out.print(this.numerator + "/" + this.denominator + " * " + f.numerator + "/" + f.denominator + " = ");

        int placeholderDenominator = this.denominator * f.denominator;
        int placeholderNumerator = this.numerator * f.numerator;

        out.println(placeholderNumerator + "/" + placeholderDenominator);
        return new Decimal(placeholderNumerator, placeholderDenominator);
    }

    public Decimal div(Decimal f) {
        out.print(this.numerator + "/" + this.denominator + " / " + f.numerator + "/" + f.denominator + " = ");

        int placeholderDenominator = this.denominator * f.numerator;
        int placeholderNumerator = this.numerator * f.denominator;

        out.println(placeholderNumerator + "/" + placeholderDenominator);
        return new Decimal(placeholderNumerator, placeholderDenominator);
    }

    public Decimal div(int number) {
        Decimal f = new Decimal(number, 1);

        out.print(this.numerator + "/" + this.denominator + " / " + f.numerator + "/" + f.denominator + " = ");

        int placeholderDenominator = this.denominator * f.numerator;
        int placeholderNumerator = this.numerator * f.denominator;

        out.println(placeholderNumerator + "/" + placeholderDenominator);
        return new Decimal(placeholderNumerator, placeholderDenominator);
    }
}
