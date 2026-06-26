class Person {
    
    private String name;
    public void setName(String name) {
        this.name = name;
    }

    private final String id;

    Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    String getName() {
        return name;
    }

    String getId() {
        return id;
    }

    String getRoleDetails() {
        return name + " (ID: " + id + ") is a member of the university.";
    }
}

class Student extends Person {
    private final String program;

    Student(String name, String id, String program) {
        super(name, id);
        this.program = program;
    }

    @Override
    String getRoleDetails() {
        return getName() + " (ID: " + getId() + ") is enrolled in " + program + ".";
    }
}

class Teacher extends Person {
    private final String subject;

    Teacher(String name, String id, String subject) {
        super(name, id);
        this.subject = subject;
    }

    @Override
    String getRoleDetails() {
        return getName() + " (ID: " + getId() + ") teaches " + subject + ".";
    }
}

class Admin extends Person {
    private final String department;

    Admin(String name, String id, String department) {
        super(name, id);
        this.department = department;
    }

    @Override
    String getRoleDetails() {
        return getName() + " (ID: " + getId() + ") works in the " + department + " department.";
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        Person[] people = {
            new Student("Anjali Karki", "S100", "Computer Engineering"),
            new Teacher("Mr. Dipesh Sharma", "T200", "Mathematics"),
            new Admin("Mrs. Sita Gurung", "A300", "Registrar")
        };

        for (Person person : people) {
            System.out.println(person.getRoleDetails());
        }
    }
}
