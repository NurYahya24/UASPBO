
public class transaksi {
    String nama, item, alamat, status;
    int qty, harga, id;

    public transaksi(String nama, String item, String alamat, String status, int qty, int harga, int id) {
        this.nama = nama;
        this.item = item;
        this.alamat = alamat;
        this.status = status;
        this.qty = qty;
        this.harga = harga;
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getTotal(){
        return getQty()*getHarga();
    }
}
