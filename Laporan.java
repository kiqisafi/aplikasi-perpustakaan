package perpus;
public class Laporan {

 public void laporan(Buku buku){
 int x=buku.getJmlBuku();
 System.out.println("\n============TABEL BUKU============");
 System.out.println("Nama Buku \tStok \t harga ");
 for (int i = 0; i < x; i++) {
 System.out.println(buku.getNamaBuku(i)+"\t"+ buku.getStok(i) +"\t"+ "Rp." + buku.getHarga(i));
 }
 }
 public void laporan(Siswa siswa){
 int x=siswa.getJmlSiswa();

 System.out.println();
 System.out.println("===========TABEL SISWA===========");
 System.out.println("Nama \tAlamat \t\tTelepon \tStatus");
 for (int i = 0; i < x; i++) {
 System.out.println(siswa.getNama(i)+"\t"+
 siswa.getAlamat(i)+"\t"+siswa.getTelepon(i)+"\t"+
 siswa.getStatus(i));
 }
 }

 public void laporan(Peminjaman peminjaman, Buku buku){
 int x=peminjaman.getJmlPeminjaman();

 System.out.println();
 System.out.println("=========LAPORAN PEMINJAMAN=========");
 System.out.println("Nama Buku\tQty \tHarga \t\tJumlah");

 int total=0;
 for (int i = 0; i < x; i++) {
 int jumlah=peminjaman.getBanyaknya(i)*buku.getHarga(peminjaman.getIdBuku(i));
 total+=jumlah;

System.out.println(buku.getNamaBuku(peminjaman.getIdBuku(i))+"\t"+

peminjaman.getBanyaknya(i)+"\t"+ "Rp." + buku.getHarga(peminjaman.getIdBuku(i))+"\t\t"
+"Rp." + jumlah);
 }
 System.out.println("Total Omset ="+total);
 
 }
}
