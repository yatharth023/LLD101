package EX3;

public class AttendanceRule implements EligibilityRule {
    @Override
    public String check(StudentProfile s) {
        if (s.attendancePct < 75) return "Attendance below 75%";
        return null;
    }
}