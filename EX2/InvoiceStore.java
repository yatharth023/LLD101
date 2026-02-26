package EX2;

public interface InvoiceStore {
    public void save(String name, String content);
    public int countLines(String name);
}
