public class Employee {

    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    static class Department {

        private String name;
        private Employee head;

        public Department(String name) {
            this.name = name;
        }

        public void setHead(Employee head) {
            if (this.head != null) {
                throw new IllegalArgumentException("У отдела " + this.name + " уже есть начальник.");
            } else this.head = head;
        }

        public Employee getHead() {
            return head;
        }

        public String getName() {
            return name;
        }

    }

    private String getName() {
        return name;
    }

    public String toString() {
        if (this == department.getHead()) {
            return name + " начальник отдела " + department.getName();
        } else {
            return name + " работает в отделе " + department.getName() + ", начальник которого " + department.getHead().getName();
        }
    }

}