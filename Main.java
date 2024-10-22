import static java.lang.System.out;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main m = new Main();

        out.println("Enter the number of the task: ");
        int n = in.nextInt();
        switch(n) {
            case 11:
                out.println("Enter the number: ");
                double n11 = in.nextDouble();
                double x11 = m.fraction(n11);
                out.printf("The integer part of that number: " + "%.6f", x11);
                break;
            case 13:
                out.println("Enter a non-negative single digit number (only the first number of the string will count): ");
                char n13 = in.next().charAt(0);
                int x13 = m.charToNum(n13);
                out.println("char n13 = " + n13);
                out.println("int x13 = " + x13);
                break;
            case 15:
                out.println("Enter the number: ");
                int n15 = in.nextInt();
                boolean x15 = m.is2Digits(n15);
                out.println("The number is 2 digits: " + x15);
                break;
            case 17:
                out.println("Enter the first border of the numeric range: ");
                int a17 = in.nextInt();
                out.println("Enter the second border of the numeric range: ");
                int b17 = in.nextInt();
                out.println("Enter the number: ");
                int num17 = in.nextInt();
                boolean x17 = m.isInRange(a17, b17, num17);
                out.println("The number is inside the needed numeric range: " + x17);
                break;
            case 19:
                out.println("Enter the first number: ");
                int a19 = in.nextInt();
                out.println("Enter the second number: ");
                int b19 = in.nextInt();
                out.println("Enter the third number: ");
                int c19 = in.nextInt();
                boolean x19 = m.isEqual(a19, b19, c19);
                out.println("All three numbers are equal: " + x19);
                break;
            case 21:
                out.println("Enter the number: ");
                int a21 = in.nextInt();
                int x21 = m.abs(a21);
                out.println("The number's module: " + x21);
                break;
            case 23:
                out.println("Enter the number: ");
                int a23 = in.nextInt();
                boolean x23 = m.is35(a23);
                out.println("The number is divided entirely by 3 but not by 5 OR The number is divided entirely by 5 but not by 3: " + x23);
                break;
            case 25:
                out.println("Enter the first number: ");
                int a25 = in.nextInt();
                out.println("Enter the second number: ");
                int b25 = in.nextInt();
                out.println("Enter the third number: ");
                int c25 = in.nextInt();
                int x25 = m.max3(a25, b25, c25);
                out.println("The biggest number: " + x25);
                break;
            case 27:
                out.println("Enter the first number: ");
                int a27 = in.nextInt();
                out.println("Enter the second number: ");
                int b27 = in.nextInt();
                int x27 = m.sum2(a27, b27);
                out.println("Sum: " + x27);
                break;
            case 29:
                out.println("Enter the number: ");
                int a29 = in.nextInt();
                String x29 = m.day(a29);
                out.println("Day of the week: " + x29);
                break;
            case 31:
                out.println("Enter the number (can't be negative): ");
                int n31 = in.nextInt();
                String x31 = m.listNums(n31);
                out.println("The numeric series from 0 to x: " + x31);
                break;
            case 33:
                out.println("Enter the number (can't be negative): ");
                int n33 = in.nextInt();
                String x33 = m.chet(n33);
                out.println("The numeric series from 0 to x that only contains even numbers: " + x33);
                break;
            case 35:
                out.println("Enter the number: ");
                int n35 = in.nextInt();
                int x35 = m.numLen(n35);
                out.println("The number of digits in the number: " + x35);
                break;
            case 37:
                out.println("Enter the number (can't be negative): ");
                int n37 = in.nextInt();
                m.square(n37);
                break;
            case 39:
                out.println("Enter the number (can't be negative): ");
                int n39 = in.nextInt();
                m.rightTriangle(n39);
                break;
            case 41:
                int[] arr41 = m.createArray();
                out.println("Enter the number that needs to be found: ");
                int n41 = in.nextInt();
                int x41 = m.findFirst(arr41, n41);
                out.println("Number's first index: " + x41);
                break;
            case 43:
                int[] arr43 = m.createArray();
                int x43 = m.maxAbs(arr43);
                out.println("The maximum number modulo: " + x43);
                break;
            case 45:
                int[] arr45 = m.createArray();
                out.println("Now create the second array: ");
                int[] ins45 = m.createArray();
                out.println("Enter the position at which the second array will be inserted into the first: ");
                int n45 = in.nextInt();
                int[] x45 = m.add(arr45, ins45, n45);
                out.print("The final array: ");
                for (int i = 0; i < x45.length; i++) {
                    out.print(x45[i] + " ");
                }
                break;
            case 47:
                int[] arr47 = m.createArray();
                int[] x47 = m.reverseBack(arr47);
                out.print("The reversed array: ");
                for (int i = 0; i < x47.length; i++) {
                    out.print(x47[i] + " ");
                }
                break;
            case 49:
                int[] arr49 = m.createArray();
                out.println("Enter the number that needs to be found: ");
                int n49 = in.nextInt();
                int[] x49 = m.findAll(arr49, n49);
                out.print("The array of indexes of all the entries of the number 'x': ");
                for (int i = 0; i < x49.length; i++) {
                    out.print(x49[i] + " ");
                }
                break;
            default: out.println("ERROR"); break;
        }

    }

    public void negative (int x) {
        if (x < 0) {
            out.println("ERROR: x can't be negative");
            System.exit(-3);
        }
    }

    public double fraction (double x) {
        int y = (int) x;
        if (x < 0)
            return -(x - y);
        else
            return x - y;
    }

    public int charToNum (char x) {
        int y = x - '0';
        if (y == -3) {
            out.println("ERROR: the number can't be negative");
            System.exit(-3);
        }
        return y;
    }

    public boolean is2Digits (int x) {
        int count = 0;
        while (x != 0) {
            x = x / 10;
            count += 1;
        }
        return count == 2;
    }
    public boolean isInRange (int a, int b, int num) {
        if ((num >= a && num <= b) | (num <= a && num >= b))
            return true;
        else
            return false;
    }

    public boolean isEqual(int a, int b, int c) {
        if ((a == b) && (b == c))
            return true;
        else
            return false;
    }

    public int abs (int x) {
        if (x < 0)
            return -x;
        else
            return x;
    }

    public boolean is35 (int x) {
        if (((x % 3 == 0) && (x % 5 != 0)) | ((x % 3 != 0) && (x % 5 == 0)))
            return true;
        else
            return false;
    }

    public int max3 (int x, int y, int z) {
        if ((x > y) && (x > z))
            return x;
        if ((y > x) && (y > z))
            return y;
        else
            return z;
    }

    public int sum2 (int x, int y) {
        int sum = x + y;
        if ((sum >= 10) && (sum <= 19))
            return 20;
        else
            return sum;
    }

    public String day (int x) {
        return switch (x) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Not a day of the week";
        };
    }

    public String listNums (int x) {
        Main m = new Main();
        m.negative(x);
        String numbers = "";
        for (int i = 0; i <= x; i++) {
            numbers += i + " ";
        }
        return numbers;
    }

    public String chet (int x) {
        Main m = new Main();
        m.negative(x);
        String numbers = "";
        for (int i = 0; i <= x; i+=2) {
            numbers += i + " ";
        }
        return numbers;
    }

    public int numLen (long x) {
        int count = 0;
        while (x != 0) {
            x /= 10;
            count++;
        }
        return count;
    }

    public void square (int x) {
        Main m = new Main();
        m.negative(x);
        String sqr = "";
        for (int i = 0; i < x; i++) {
            sqr += "*";
        }
        for (int i = 0; i < x; i++) {
            out.println(sqr);
        }
    }

    public void rightTriangle (int x) {
        Main m = new Main();
        m.negative(x);
        String triangle = "";
        String space = "";
        for (int i = 0; i < x; i++) {
            space = "";
            for (int y = i + 1; y < x; y++) {
                space += " ";
            }
            triangle += "*";
            out.println(space + triangle);
        }
    }

    public int[] createArray () {
        Scanner in = new Scanner(System.in);

        out.println("Enter the size of the array (must be more than 0):" );
        int arr_size = in.nextInt();
        if (arr_size <= 0) {
            out.println("ERROR: array size must be > 0");
            System.exit(-3);
        }

        int[] arr = new int[arr_size];
        out.println("Fill the created array: ");
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = in.nextInt();
        }

        out.println("Array: ");
        for (int i = 0; i < arr.length; i++) {
            out.print(arr[i] + " ");
        }
        out.println(" ");

        return arr;
    }

    public int findFirst (int[] arr, int x) {
        int counter = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                counter = i;
                return counter;
            }
        }
        return counter;
    }

    public int maxAbs (int[] arr) {
        int maximum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (abs(arr[i]) > abs(maximum)) {
                maximum = arr[i];
            }
        }
        return maximum;
    }

    public int[] add (int[] arr, int[] ins, int pos) {
        int[] arr2 = new int[arr.length + ins.length];
        int j = 0;
        int i = 0;

        while (j != arr2.length) {
            if (j == pos) {
                for (int k = 0; k < ins.length; k++) {
                    arr2[j] = ins[k];
                    j++;
                }
            }
            else {
                arr2[j] = arr[i];
                j++;
                i++;
            }
        }

        return arr2;
    }

    public int[] reverseBack (int[] arr) {
        int[] arr2 = new int[arr.length];
        int j = arr2.length - 1;

        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[j];
            j--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr2[i];
        }

        return arr2;
    }

    public int[] findAll (int[] arr, int x) {
        int x_count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                x_count++;
            }
        }

        int[] arr2 = new int[x_count];
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                arr2[counter] = i;
                counter++;
            }
        }

        return arr2;
    }

}