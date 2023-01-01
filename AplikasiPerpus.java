package perpus;
import java.util.Scanner;

public class AplikasiPerpus {

    public static void main(String[] args) {
       Scanner myObj = new Scanner(System.in);
       int temp = 0;

       do {

          Buku buku = new Buku();
          Laporan laporan = new Laporan();
          Siswa siswa= new Siswa();
          Peminjaman peminjaman = new Peminjaman();
          laporan.laporan(buku);
          laporan.laporan(siswa);
          peminjaman.prosesPeminjaman(siswa, peminjaman, buku, laporan);
          laporan.laporan(peminjaman, buku);
          laporan.laporan(buku);
          laporan.laporan(siswa);
          System.out.print("\nJika ingin meminjam buku lagi pilih lanjutkan(1)!\nJika tidak end sistem(99)\nLanjutkan atau matikan 1 / 99      : ");


          temp = myObj.nextInt();
       }while (temp != 99 );

       System.exit(0);


    }
    
}
