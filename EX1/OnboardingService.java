package EX1;

import java.util.*;

public class OnboardingService {

    private final OnboardingPrint printer;
    private final StudentParser parser;
    private final StudentRepository repo;
    private final StudentValidation validator;

    public OnboardingService(StudentRepository repo) {
        this.repo = repo;
        this.printer = new OnboardingPrint();
        this.parser = new StudentParser();
        this.validator = new StudentValidation();
    }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        Map<String, String> kv = parser.parse(raw);
        List<String> errors = validator.validate(kv);

        if (!errors.isEmpty()) {
            printer.printError(errors);
            return;
        }

        String id = IdUtil.nextStudentId(repo.count());
        StudentRecord rec = new StudentRecord(id, kv.get("name"), kv.get("email"), kv.get("phone"), kv.get("program"));
        repo.save(rec);
        printer.printSuccess(rec, repo.count());
    }
}