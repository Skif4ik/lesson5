import model.Employee;
import model.Student;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.info();
        Employee employee2 = new Employee("Vasay", 499);
        employee2.info();
        employee1.setName("Igor");
        employee1.setSalary(800);
        employee1.info();

        Employee.setTax(0.1);
        employee1.info();

        System.out.println("Средняя зп: "+ Employee.avgNetSalary(employee1, employee2));

        System.out.println("===========================================");

        Student student1 = new Student("Misha", 120);
        student1.greeting();
        Student student2 = new Student("Sasha", 0);
        student2.greeting(student1);

        System.out.println("Средняя стипендия: " + Student.avgGrants(student1, student2));

        Student student3 = new Student("Vitya", 55);
        System.out.println("Средняя стипендия трех: "+Student.avgGrants(student1, student2, student3));

        Student[] studentList ={
                student1,
                student2,
                student3,
                new Student("Vanya", 75)

        };

        System.out.println("Средняя степендия массива: "+ Student.avgGrants(studentList));

    }
}
