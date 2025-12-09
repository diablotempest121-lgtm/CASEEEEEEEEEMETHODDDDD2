import  java.util.Scanner;
public class csm2 {
  static Scanner sc=new Scanner(System.in);
  static int maks=100;
  static String[] nama= new String[maks];
  static int[] NIM= new int[maks];
  static String[] prodi= new String[maks];
  static String[] perusahaan= new String[maks];
  static int[] semester= new int[maks];
  static String[] status= new String[maks];
  static int i=0;
  static void tampilan(){
    System.out.println();
    System.out.println("=== Sistem Pendaftaran Magang Mahasiswa ===");
    System.out.println("1. Tambah data magang");
    System.out.println("2. Tampilkan semua pendaftar magang");
    System.out.println("3. Cari pendaftar berdasarkan program study");
    System.out.println("4. Hitung jumlah pendaftar untuk setiap status");
    System.out.println("5. Keluar");
    System.out.print("Pilih menu(1-5): " );
  }
  static void data(int i){
    System.out.print("Nama mahasiswa: ");
    nama[i]=sc.nextLine();
    System.out.print("NIM: ");
    NIM[i]=sc.nextInt();
    sc.nextLine();
    System.out.print("Prodi: ");
    prodi[i]=sc.nextLine();
    System.out.print("Perusahaan tujuan magang: ");
    perusahaan[i]=sc.nextLine();
    System.out.print("Semester pengambilan magang: ");
    semester[i]=sc.nextInt();
    sc.nextLine();
    System.out.print("Status magang(diterima/menunggu/ditolak): ");
    status[i]=sc.nextLine();
    System.out.println("=================================================");
  }
  static void printSemua(){
    if (i==0) {
      System.out.println("Belum ada pendaftar");
      return;
    }
    System.out.printf("%-4s %-20s %-13s %-25s %-20s %-10s %-10s%n", "No", "Nama", "NIM", "Prodi", "Perusahaan", "Semester", "status");
    for(int j=0; j<i; j++){
      System.out.printf("%-4d %-20s %-13d %-25s %-20s %-10d %-10s%n", (j+1), nama[j], NIM[j], prodi[j], perusahaan[j], semester[j], status[j]);
    }
  }
  public static void main(String[] args) {
    do {
      tampilan();
      int a=sc.nextInt();
      sc.nextLine();
      if (a==5) {
        break;
      }else if (a==1) {
        data(i);
        i++;
      }else if (a==2) {
        printSemua();
      }
    } while (true);
  }
}
