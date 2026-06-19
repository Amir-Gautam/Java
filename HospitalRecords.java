class Patient {
    private String name;
    private int age;

    Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    String getTreatmentPlan() {
        return "General checkup recommended for " + name;
    }
}

class InPatient extends Patient {
    private String roomNumber;

    InPatient(String name, int age, String roomNumber) {
        super(name, age);
        this.roomNumber = roomNumber;
    }

    @Override
    String getTreatmentPlan() {
        return getName() + " is admitted in room " + roomNumber + " and will undergo a full treatment plan with daily monitoring.";
    }
}

class OutPatient extends Patient {
    private String appointmentDate;

    OutPatient(String name, int age, String appointmentDate) {
        super(name, age);
        this.appointmentDate = appointmentDate;
    }

    @Override
    String getTreatmentPlan() {
        return getName() + " has an outpatient appointment scheduled on " + appointmentDate + ".";
    }
}

public class HospitalRecords {
    public static void main(String[] args) {
        Patient[] patients = {
            new InPatient("Hari Bahadur Khadka", 45, "204B"),
            new OutPatient("Sabina Gurung", 30, "2026-07-10")
        };

        for (Patient patient : patients) {
            System.out.println(patient.getTreatmentPlan());
        }
    }
}
