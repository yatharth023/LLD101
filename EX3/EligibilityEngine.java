package EX3;

import java.util.*;

public class EligibilityEngine {
    private final FakeEligibilityStore store;

    public EligibilityEngine(FakeEligibilityStore store) { this.store = store; }

    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s); // giant conditional inside
        p.print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<String> reasons = new ArrayList<>();

    }
}

