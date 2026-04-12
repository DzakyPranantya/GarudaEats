public class Customer{
    private String nama;
    private String nim;
    private double saldo;
    private int poin;
    
    public Customer(String nama, String nim){
        this.nama = nama;
        this.nim = nim;
        this.saldo = 0;
        this.poin = 0;
    }
    public Customer(String nama, String nim, double saldoAwal){
        this.nama = nama;
        this.nim = nim;
        this.saldo = saldoAwal;
        this.poin = 0;
    }
    public String getNama(){
        return nama;
    }
    public String getNim(){
        return nim;
    }
    public double getSaldo(){
        return saldo;
    }
    public int getPoin(){
        return poin;
    }
    public void topUpSaldo(double jumlah){
        if(jumlah <= 0){
            System.out.print("Nominal TopUp tidak valid");
        }
        }
    public boolean bayar(double jumlah){
        if(saldo < jumlah){
            System.out.println("Saldo tidak mencukupi");
            return false;
        }
        saldo -= jumlah;
        return true;
    }
    public void tambahPoin(int poin){
        if(poin < 0){
            System.out.println("Poin tidak valid");
        }else{
            this.poin += poin;
        }
        }
    public void displayInfo(){
        System.out.println("Nama: "+nama);
        System.out.println("NIM: "+nim);
        System.out.println("Saldo: "+saldo);
        System.out.println("Poin: "+poin);
       }

}