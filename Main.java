public class Main {
    public static void main(String[] args) {

        Kantin kantin = new Kantin("GarudaEats");

        MenuItem m1 = new MenuItem("Nasi Goreng", 15000, "Makanan", 5);
        MenuItem m2 = new MenuItem("Mie Ayam", 12000, "Makanan", 5);
        MenuItem m3 = new MenuItem("Es Teh", 5000, "Minuman", 5);
        MenuItem m4 = new MenuItem("Kopi", 8000, "Minuman", 5);
        MenuItem m5 = new MenuItem("Keripik", 3000, "Snack", 5);
        MenuItem m6 = new MenuItem("Coklat", 7000, "Snack", 5);

        kantin.tambahMenu(m1);
        kantin.tambahMenu(m2);
        kantin.tambahMenu(m3);
        kantin.tambahMenu(m4);
        kantin.tambahMenu(m5);
        kantin.tambahMenu(m6);

        Customer c1 = new Customer("Ujang", "001");
        Customer c2 = new Customer("Dudung", "002", 10000);

        c1.topUpSaldo(50000);

        System.out.println("\nMENU:");
        kantin.tampilkanMenuTersedia();

        System.out.println("\nCARI:");
        MenuItem cari = kantin.cariMenuByNama("Nasi Goreng");
        if (cari != null) cari.displayInfo();

        System.out.println("\nORDER 1:");
        Order o1 = kantin.buatOrder("ORD1", c1);
        o1.tambahItem(m1);
        o1.tambahItem(m2);
        kantin.selesaikanOrder(o1);
        o1.displayOrder();

        System.out.println("\nORDER 2:");
        Order o2 = kantin.buatOrder("ORD2", c2);
        o2.tambahItem(m1);
        o2.tambahItem(m2);
        kantin.selesaikanOrder(o2);
        o2.displayOrder();

        System.out.println("\nORDER 3:");
        Order o3 = kantin.buatOrder("ORD3", c1);
        o3.tambahItem(m3);
        o3.batalkanOrder();
        o3.displayOrder();

        System.out.println("\nREKAP:");
        kantin.tampilkanRekap();

        System.out.println("\nCUSTOMER:");
        c1.displayInfo();
        c2.displayInfo();
    }
}