package deutsch;

class Invoice {
    public static String formatId(String oldId) {
        return oldId + "_Invoice";
    }
}

public class SalesInvoice extends Invoice{
    public static String formatId(String oldId) {
        return oldId + "_SalesInvoice";
    }

    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        System.out.println(invoice.formatId("1234"));

        Invoice invoice1 = new Invoice();
        //System.out.println((SalesInvoice)Invoice.formatId("1234"));
    }
}
