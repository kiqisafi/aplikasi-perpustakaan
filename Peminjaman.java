package perpus;
import java.util.ArrayList;
import java.util.Scanner;

public class Peminjaman {

    private ArrayList<Integer> idBuku = new ArrayList<Integer>();
    private ArrayList<Integer> banyak = new ArrayList<Integer>();
    private ArrayList<Integer> idSiswa= new ArrayList<Integer>();

    public Peminjaman() {
        this.idSiswa.add(0);
        this.idBuku.add(0);
        this.banyak.add(2);
        this.idSiswa.add(0);
        this.idBuku.add(1);
        this.banyak.add(3);
        this.idSiswa.add(1);
        this.idBuku.add(0);
        this.banyak.add(1);
        this.idSiswa.add(1);
        this.idBuku.add(2);
        this.banyak.add(2);
    }

    public void prosesPeminjaman(Siswa siswa, Peminjaman peminjaman, Buku buku, Laporan laporan) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("\n========SILAHKAN MEMINJAM BUKU========");
        System.out.print("Masukkan ID Siswa                 : ");
        int idSiswa = myObj.nextInt();
        System.out.println("Selamat datang " + siswa.getNama(idSiswa));
        ArrayList<Integer> idBuku = new ArrayList<Integer>();
        ArrayList<Integer> banyak = new ArrayList<Integer>();
        int i = 0;
        int temp = 0;
        do {
            System.out.print("Masukkan kode buku                : ");
            temp = myObj.nextInt();
            if (temp != 99) {
                idBuku.add(temp);
                System.out.print(buku.getNamaBuku(idBuku.get(i)) + " sebanyak              : ");
                banyak.add(myObj.nextInt());
                if (banyak.get(i) > buku.getStok(idBuku.get(i))) {
                    System.out.println("Sisa stok buku tidak mencukupi");
                    System.exit(0);
                }
                i++;
                i++;
            }
        } while (temp != 99);

        System.out.println("\n======Peminjaman Buku " + siswa.getNama(idSiswa) + " sebagai berikut======");
        System.out.println("Nama Buku \tQty \tHarga \tJumlah \t");

        int total = 0;
        int x = idBuku.size();
        for (int j = 0; j < x; j++) {
            int jumlah = banyak.get(j) * buku.getHarga(idBuku.get(j));
            total += jumlah;
            System.out.println(buku.getNamaBuku(idBuku.get(j)) + "\t"
                    + banyak.get(j) + "\t"
                    + "Rp." + buku.getHarga(idBuku.get(j)) + "\t"
                    + "Rp." + jumlah);
            peminjaman.setPeminjaman(buku, idSiswa, idBuku.get(j),
                    banyak.get(j));
        }

        System.out.println("\nTotal Peminjaman Buku             : " + "Rp." + total);
        siswa.editStatus(idSiswa, siswa.getStatus(idSiswa) == false);
        System.out.println("Status " +  siswa.getNama(idSiswa) + "                      : "+  siswa.getStatus(idSiswa));
        if(siswa.getStatus(idSiswa) == true){
            System.out.println("DAPAT MEMINJAM BUKU");
        } else{
            System.out.println("TIDAK BOLEH MEMINJAM BUKU LAGI!");
        }
        laporan.laporan(buku);
        //proses pengembalian buku
        System.out.print("\nApakah kamu mau mengembalikan buku?\n(yes/no)                          : ");
        String answer  = myObj.next();
        if("yes".equals(answer)){
           siswa.editStatus(idSiswa, true);
           System.out.println("Status " +  siswa.getNama(idSiswa) + "                      : "+  siswa.getStatus(idSiswa));
            for (int j = 0; j < x; j++) {
            peminjaman.setPengembalian(buku, idSiswa, idBuku.get(j), banyak.get(j));
            System.out.println("Dapat meminjam buku lagi");
        } 
        } else{
            System.out.println("ANDA BELUM MENGEMBALIKAN BUKU");
            laporan.laporan(buku);
            laporan.laporan(siswa);
            System.exit(0);          
        }
    }

    public void setPeminjaman(Buku buku, int idSiswa, int idBuku, int banyaknya) {
        this.idSiswa.add(idSiswa);
        this.idBuku.add(idBuku);
        this.banyak.add(banyaknya);
        buku.editStok(idBuku, buku.getStok(idBuku) - banyaknya);
    }
    
    public void setPengembalian(Buku buku, int idSiswa, int idBuku, int banyaknya){
        this.idSiswa.add(idSiswa);
        this.idBuku.add(idBuku);
        this.banyak.add(banyaknya);
        buku.editStok(idBuku, buku.getStok(idBuku) + banyaknya);
    }

    public int getIdBuku(int id) {
        return this.idBuku.get(id);
    }

    public int getBanyaknya(int id) {
        return this.banyak.get(id);
    }

    public int getIdSiswa(int id) {
        return this.idSiswa.get(id);
    }

    public int getJmlPeminjaman() {
        return this.idSiswa.size();
    }
}
