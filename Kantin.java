public class Kantin {
    private String namaKantin;
    private MenuItem[] daftarMenu;
    private int jumlahMenu;
    private int totalOrderSelesai;

    public Kantin(String namaKantin) {
        this.namaKantin = namaKantin;
        this.daftarMenu = new MenuItem[50];
        this.jumlahMenu = 0;
        this.totalOrderSelesai = 0;
    }

    public String getNamaKantin() {
        return namaKantin;
    }

    public int getTotalOrderSelesai() {
        return totalOrderSelesai;
    }

    public void tambahMenu(MenuItem item) {
        if (jumlahMenu < daftarMenu.length) {
            daftarMenu[jumlahMenu++] = item;
        }
    }

    public void tampilkanMenuTersedia() {
        for (int i = 0; i < jumlahMenu; i++) {
            if (daftarMenu[i].getStok() > 0) {
                daftarMenu[i].displayInfo();
            }
        }
    }

    public void tampilkanMenuByKategori(String kategori) {
        for (int i = 0; i < jumlahMenu; i++) {
            if (daftarMenu[i].getKategori().equalsIgnoreCase(kategori)) {
                daftarMenu[i].displayInfo();
            }
        }
    }

    public MenuItem cariMenuByNama(String nama) {
        for (int i = 0; i < jumlahMenu; i++) {
            if (daftarMenu[i].getNama().equalsIgnoreCase(nama)) {
                return daftarMenu[i];
            }
        }
        return null;
    }

    public Order buatOrder(String orderId, Customer customer) {
        return new Order(orderId, customer);
    }

    public void selesaikanOrder(Order order) {
        if (order.prosesOrder()) {
            totalOrderSelesai++;
        }
    }

    public void tampilkanRekap() {
        System.out.println("Kantin: " + namaKantin);
        System.out.println("Total Menu: " + jumlahMenu);
        System.out.println("Order Selesai: " + totalOrderSelesai);
    }
}