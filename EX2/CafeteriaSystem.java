package EX2;

import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final PricingService pricing = new PricingService(menu);
    private final TaxPolicy taxPolicy = new TaxRules();
    private final DiscountPolicy discountPolicy = new DiscountRules();
    private final InvoiceFormatter invoiceFormatter = new InvoiceFormatter();
    private final InvoiceStore store = new FileStore();

    private int invoiceSeq = 1000;

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);

        double subtotal = 0.0;
        for (OrderLine l : lines) {
            subtotal += pricing.lineTotal(l);
        }

        double taxPct = taxPolicy.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);
        double discount = discountPolicy.discountAmount(customerType, subtotal, lines);
        double total = subtotal + tax - discount;

        String invoice = invoiceFormatter.format(invId, lines, menu, subtotal, taxPct, tax, discount, total);
        System.out.print(invoice);
        store.save(invId, invoice);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
