class Course {
    private String title;
    private int duration;
    private String instructor;

    Course(String title, int duration, String instructor) {
        this.title = title;
        this.duration = duration;
        this.instructor = instructor;
    }

    String getTitle() {
        return title;
    }

    int getDuration() {
        return duration;
    }

    String getInstructor() {
        return instructor;
    }

    String getCourseInfo() {
        return title + " by " + instructor + " (" + duration + " hours)";
    }
}

class LiveCourse extends Course {
    private String scheduleTime;

    LiveCourse(String title, int duration, String instructor, String scheduleTime) {
        super(title, duration, instructor);
        this.scheduleTime = scheduleTime;
    }

    @Override
    String getCourseInfo() {
        return super.getCourseInfo() + " | Live session at " + scheduleTime;
    }
}

class RecordedCourse extends Course {
    private int videoCount;

    RecordedCourse(String title, int duration, String instructor, int videoCount) {
        super(title, duration, instructor);
        this.videoCount = videoCount;
    }

    @Override
    String getCourseInfo() {
        return super.getCourseInfo() + " | Contains " + videoCount + " recorded videos";
    }
}

public class CoursePortal {
    public static void main(String[] args) {
        Course[] courses = {
            new LiveCourse("Java Fundamentals", 20, "Mr. Bishal Khanal", "6:00 PM"),
            new RecordedCourse("Nepali Sign Language Basics", 15, "Ms. Anita Rai", 40)
        };

        for (Course course : courses) {
            System.out.println(course.getCourseInfo());
        }
    }
}
