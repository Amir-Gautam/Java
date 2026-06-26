public class CourseEnrollmentManager {

    public static void enrollStudent(String studentId, String courseId, EligibilityRule rule) {
        System.out.println("Attempting to enroll " + studentId + " in " + courseId + "...");
        try {
            boolean eligible = rule.isEligible(studentId, courseId);
            if (eligible) {
                System.out.println("Enrollment successful for " + studentId + " in " + courseId + "! Happy learning!");
            } else {
                System.out.println("Enrollment failed for " + studentId + ": Not eligible for this course.");
            }
        } catch (EnrollmentDeniedException e) {
            System.out.println("Enrollment failed for " + studentId + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        EligibilityRule skillNepalRule = (studentId, courseId) -> {
            if (studentId.equals("SKILL999")) {
                throw new EnrollmentDeniedException("Student account suspended due to outstanding fees, Roshan!");
            }
            if (courseId.equals("JAVA101") && !studentId.startsWith("SKILL")) {
                throw new EnrollmentDeniedException("Invalid student ID format. Please use 'SKILL' prefix, Anisha!");
            }
            return studentId.startsWith("SKILL") && courseId.equals("JAVA101");
        };

        enrollStudent("SKILL123", "JAVA101", skillNepalRule);
        enrollStudent("SKILL999", "JAVA101", skillNepalRule);
        enrollStudent("STUDENT001", "JAVA101", skillNepalRule);
        enrollStudent("SKILL456", "PYTHON202", skillNepalRule);
    }
}
