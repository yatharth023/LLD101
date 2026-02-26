The original cafeteriaSystem class is responsible for multiple tasks such as tax calculation, discount logic, and invoice storage. This resulted in tightly coupled design that violates core oops principles such as SRP, OCP, and DIP.

So, to improve the maintainability, extensibility, and testability i created interfaces like TaxPolicy, DiscountPolicy, and InvoiceStore.

Talking about TaxPolicy interface -> In the original design the tax logic was hard coded and any change in tax logic required modifying existing code. Thus, with the introduction of TaxPolicy separates tax logic from billing and allows new tax rules to be added without modifying the system.

DiscountPolicy interface -> In the original design the discounts are implemented using conditional statements and adding a new discount required change in the existing code. Thus, with the DiscountPolicy interface it removes conditional logic and makes the system open for adding new discount rules.

InvoiceStore interface -> In the original design the system directly depended on FileStore and it was hard to test or change storage type. Thus, with the InvoiceStore it decouples persistence from the system and makes it depend on abstraction instead of a concrete class.

PricingService (Pricing) -> In the original design price calculation was mixed with printing and tax logic, so for that PricingService was introduced only for calculating item prices and subtotals.

InvoiceFormatter (formatter) -> In the original design string formatting was mixed with calculations, so for that InvoiceFormatter was introduced only for formatting the invoice output.