public class Customer {
    private String nama;
    private String nim;
    private double saldo;
    private int poin;

    public Customer(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
        this.saldo = 0;
        this.poin = 0;
    }

    public Customer(String nama, String nim, double saldoAwal) {
        this.nama = nama;
        this.nim = nim;
        this.saldo = saldoAwal;
        this.poin = 0;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getPoin() {
        return poin;
    }

    public void topUpSaldo(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Nominal tidak valid");
        } else {
            saldo += jumlah;
        }
    }

    public boolean bayar(double jumlah) {
        if (saldo < jumlah) {
            System.out.println("Saldo Ga Cukup");
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    public void tambahPoin(int poin) {
        if (poin > 0) {
            this.poin += poin;
        }
    }

    public void displayInfo() {
        System.out.println(nama + " | " + nim + " | Saldo: " + saldo + " | Poin: " + poin);
    }
}