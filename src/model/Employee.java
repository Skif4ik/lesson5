package model;

public class Employee {
    //такая инициализация полей синтаксически допустима она отрабатывает раньше конструкторов
    //такой инициализацией можно пользоваться как правило при полном отсутствии конструкторов
    //static поле создается в одном единственном экземпляре и существует все объектов
    //так как static поля существуют вне объектов то обращение к ним осуществляется через имя класса(Enployee.tax)
    //счетчик для присвоения уникальных id для каждого нового объекта
    private static int idCounter;
    private static double tax = 0.15;
    //public final static double TAX = 0.15; если считается, что налог программно не изменится
    private int id;
    private String name = "none";
    private double salary = 100;

    //static блок кода допускается единожды при прогрузке класса в память
    static {
        //можно использовать для инициализации статик полей либо описать код который
        // должен выполнится единожды при обращении к классу
        System.out.println("!!!");
        idCounter = 0;
    }

    //БЛОК КОДА. такой блок кода будет запускаться при создании обьекта этого класса
    {
        System.out.println("!");
        id = ++idCounter; // ++ спереди - сначала увеличивается счетчик, а потом присваивается значение
    }

    //this() - возможность внутри одного конструктора, осуществить вызов другого
    public Employee() {
        //вызов конструктора через this возможно только первой командой этого конструктора
        this("noname", 500);// -вызов конструктора с параметрами
        // name = "noname";
        // salary = 500;
        // this("noname",500); - ОШИБКА
    }

    public Employee(String name, double salary) {
        this.name = name;
        setSalary(salary);//что бы не писать аналогичную проверку вызовем сеттер с уже описанной проверкой
        //id = ++idCounter;//сначала увеличивается счетчик, а потом присваивается значение
        //нежелательно выполнять какие-либо действия кроме инициализации полей и проверок в конструкторе
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        //проверка, если пытаемся установить зп меньше 500 то сделать это не сможем
        if (salary >= 500) {
            this.salary = salary;
        } else {
            this.salary = 500;
        }
    }

    //для static полей необходимо создавать static сеттеры и геттеры
    //Static методы вызываются не для конкретных обьектов, а через имя класса
    //поэтому внутри статик методов нельзя обратится к this
    public static double getTax() {
        //this - ошибка
        return tax;
    }

    public static void setTax(double tax) {
        Employee.tax = tax;
    }

    public double netSalary() {
        double res = 0;
        res = (1 - tax) * salary;
        return res;
    }

    public void info() {
        System.out.println("id: "+ id +", Имя: " + name + ", зп: " + salary + ", с вычетом налогов: " + netSalary());
    }

    //метод расчета среднего арифмитического чистых зарплат двух работников
    //этот метод описан Static так как он должен работать не для одного конкретного объекта
    public static double avgNetSalary(Employee e1, Employee e2) {
        double res = 0;
        res = (e1.netSalary() + e2.netSalary()) / 2;
        return res;
    }
}
