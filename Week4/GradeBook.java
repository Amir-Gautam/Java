class Student {
    private String name;
    private String rollNumber;
    private int[] marks;

    Student(String name, String rollNumber, int[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getRollNumber() {
        return rollNumber;
    }

    void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    int[] getMarks() {
        return marks;
    }

    void setMarks(int[] marks) {
        this.marks = marks;
    }

    double calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return marks.length == 0 ? 0 : (double) sum / marks.length;
    }
}

class GraduateStudent extends Student {
    private String thesisTopic;

    GraduateStudent(String name, String rollNumber, int[] marks, String thesisTopic) {
        super(name, rollNumber, marks);
        this.thesisTopic = thesisTopic;
    }

    void printThesisTitle() {
        System.out.println(getName() + "'s thesis topic: " + thesisTopic);
    }
}

public class GradeBook {
    public static void main(String[] args) {
        Student student = new Student("Priya Tamang", "R001", new int[]{85, 90, 78});
        GraduateStudent gradStudent = new GraduateStudent("Suresh Bhattarai", "G001", new int[]{92, 88, 95}, "Flood Forecasting in the Koshi River Basin");

        System.out.println(student.getName() + " average: " + student.calculateAverage());
        System.out.println(gradStudent.getName() + " average: " + gradStudent.calculateAverage());
        gradStudent.printThesisTitle();
    }
}
