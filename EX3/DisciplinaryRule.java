package EX3;

import java.util.*;

public class DisciplinaryRule implements EligibilityRule {
    @Override
    public String check(StudentProfile s) {
        if (s.disciplinaryFlag != LegacyFlags.NONE) {
            return "disciplinary flag present";
        }
        return null;
    }
}