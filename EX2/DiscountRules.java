package EX2;

import java.util.List;

public class DiscountRules implements DiscountPolicy {
    public double discountAmount(String customerType, double subtotal, List<OrderLine> lines) {
        // hard-coded policy (smell)
        if ("student".equalsIgnoreCase(customerType)) {
            if (subtotal >= 180.0) return 10.0;
            return 0.0;
        }
        if ("staff".equalsIgnoreCase(customerType)) {
            if (lines.size() >= 3) return 15.0;
            return 5.0;
        }
        return 0.0;
    }
}
