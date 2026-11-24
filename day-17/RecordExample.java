record Employee(String name, int age, String department) {
}

public class RecordExample {

    public static void main(String[] args) {

        Employee employee = new Employee(
            "Kishore",
            22,
            "Engineering"
        );

        System.out.println("Name: " + employee.name());
        System.out.println("Age: " + employee.age());
        System.out.println("Department: " + employee.department());

        System.out.println(employee);
    }
}