package EX2;

import java.util.*;

public class PricingService {
    private final Map<String, MenuItem> menu;

    public PricingService(Map<String, MenuItem> menu) {
        this.menu = menu;
    }

    public double lineTotal(OrderLine l) {
        MenuItem item = menu.get(l.itemId);
        return item.price * l.qty;
    }   
}