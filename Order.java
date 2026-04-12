public class Order {
    private String orderId;
    private Customer customer;
    private MenuItem[] items;
    private int jumlahItem;
    private String status;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new MenuItem[10];
        this.jumlahItem = 0;
        this.status = "MENUNGGU";
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getStatus() {
        return status;
    }

    public int getJumlahItem() {
        return jumlahItem;
    }

    public boolean tambahItem(MenuItem item) {
        if (!status.equals("MENUNGGU")) {
            System.out.println("Tidak Bisa Tambah Item");
            return false;
        }

        if (jumlahItem >= items.length) {
            System.out.println("Pesanan Penuh");
            return false;
        }

        if (!item.isAvailable()) {
            System.out.println("Stok Habis");
            return false;
        }

        items[jumlahItem++] = item;
        return true;
    }

    public double hitungTotal() {
        double total = 0;
        for (int i = 0; i < jumlahItem; i++) {
            total += items[i].getHarga();
        }
        return total;
    }

    public boolean prosesOrder() {
        if (!status.equals("MENUNGGU")) {
            return false;
        }

        double total = hitungTotal();

        if (!customer.bayar(total)) {
            return false;
        }

        for (int i = 0; i < jumlahItem; i++) {
            items[i].kurangiStok();
        }

        customer.tambahPoin(jumlahItem);
        status = "SELESAI";
        return true;
    }

    public void batalkanOrder() {
        if (status.equals("SELESAI")) {
            System.out.println("Tidak Bisa Dibatalkan");
        } else {
            status = "DIBATALKAN";
        }
    }

    public void displayOrder() {
        System.out.println("Order: " + orderId);
        System.out.println("Customer: " + customer.getNama());

        for (int i = 0; i < jumlahItem; i++) {
            System.out.println(items[i].getNama() + " - " + items[i].getHarga());
        }

        System.out.println("Total: " + hitungTotal());
        System.out.println("Status: " + status);
    }
}