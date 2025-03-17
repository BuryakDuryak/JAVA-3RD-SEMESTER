class Cat {
    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void meow() {
        System.out.println(name + ": мяу!");
    }

    public void meow(int amount) {
        System.out.print(name + ": ");
        for (int i = 1; i <= amount; i++) {
            if (i == amount) {
                System.out.println("мяу!");
            }
            else {
                System.out.print("мяу-");
            }
        }
    }


    public String toString() {
        return "Кот: " + name;
    }
}
