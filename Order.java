public class Order{
    private String orderId;
    private Customer customer;
    private MenuItem[] items;
    private int JumlahItem;
    private String status;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new MenuItem[10];
        this.JumlahItem = 0;
        this.status = "MENUNGGU";
    }
    public String getOrderId() {
        return orderId;
    }
    public Customer getCustomer() {
        return customer;
    }
    public String getStatus(){
        return status;
    }
    public int getJumlahItem(){
        return JumlahItem;
    }
    public boolean tambahItem(MenuItem item) {
    // cek status pakai equals - ini wajib
    if (!status.equals("MENUNGGU")) {
        System.out.println("Error: Status bukan MENUNGGU.");
        return false;
    }
    // cek array penuh
    if (JumlahItem >= items.length) {
        System.out.println("Error: Pesanan sudah penuh.");
        return false;
    }
    // isAvailable() sudah cek stok > 0, jadi boleh pakai ini
    if (!item.isAvailable()) {
        System.out.println("Error: Item tidak tersedia (stok = 0).");
        return false;
    }
    // WAJIB: simpan item ke array dan tambah counter
        items[JumlahItem] = item;
        JumlahItem++;
        return true;
    }
    public double hitungTotal() {
        double total = 0;
        for (int i = 0; i < JumlahItem; i++) {
            total += items[i].getHarga();
        }
        return total;
    }
}