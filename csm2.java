import java.util.Scanner;

public class csm2 {
  static Scanner sc = new Scanner(System.in);
  static String[][] dataa=new String[100][6];
  static int i = 0;
  static int JmlDiterima = 0;
  static int Jmlmenunggu = 0;
  static int Jmlditolak = 0;
  static String cari;

  static void tampilan() {
    System.out.println();
    System.out.println("=== SISTEM PENDAFTARAN MAGANG MAHASISWA ===");
    System.out.println("1. Tambah data magang");
    System.out.println("2. Tampilkan semua pendaftar magang");
    System.out.println("3. Cari pendaftar berdasarkan program study");
    System.out.println("4. Hitung jumlah pendaftar untuk setiap status");
    System.out.println("5. Keluar");
    System.out.print("Pilih menu(1-5): ");
  }

  static void data(int i) {
    System.out.print("Nama mahasiswa: ");
    dataa[i][0] = sc.nextLine();
    System.out.print("NIM: ");
    dataa[i][1] = sc.nextLine();
    System.out.print("Prodi: ");
    dataa[i][2] = sc.nextLine();
    System.out.print("Perusahaan tujuan magang: ");
    dataa[i][3] = sc.nextLine();
    System.out.print("Semester pengambilan magang(6 atau 7): ");
    dataa[i][4] = sc.nextLine();
    System.out.print("Status magang (diterima/menunggu/ditolak): ");
    dataa[i][5] = sc.nextLine();
    System.out.println("=================================================");
  }

  static void printSemua() {
    if (i == 0) {
      System.out.println("Belum ada pendaftar");
      return;
    }
    System.out.printf("%-4s %-20s %-13s %-20s %-20s %-10s %-10s%n", "No", "Nama", "NIM", "Prodi", "Perusahaan", "Semester", "Status");
    for (int j = 0; j < i; j++) {
      System.out.printf("%-4s %-20s %-13s %-20s %-20s %-10s %-10s%n", (j + 1), dataa[j][0], dataa[j][1], dataa[j][2], dataa[j][3],
        dataa[j][4], dataa[j][5]);
    }
  }

  static void cariProdi() {
    System.out.print("Masukkan prodi yang dicari: ");
    cari = sc.nextLine();
    System.out.printf("%-4s %-20s %-13s %-20s %-20s %-10s %-10s%n", "No", "Nama", "NIM", "Prodi", "Perusahaan","Semester", "Status");
    boolean ketemu = false;
    for (int k = 0; k < i; k++) {
      if (dataa[k][2].equalsIgnoreCase(cari)) {
        System.out.printf("%-4s %-20s %-13s %-20s %-20s %-10s %-10s%n", (k + 1), dataa[k][0], dataa[k][1], dataa[k][2],
            dataa[k][3], dataa[k][4], dataa[k][5]);
        ketemu = true;
      }
    }
    System.out
        .println("===============================================================================================");
    if (!ketemu) {
      System.out.println("Tidak ada mahasiswa dari prodi tersebut.");
    }
  }

  static void JumlahStatus(int j) {
    if (dataa[j][5].equalsIgnoreCase("diterima")) {
      JmlDiterima++;
    } else if (dataa[j][5].equalsIgnoreCase("menunggu")) {
      Jmlmenunggu++;
    } else if (dataa[j][5].equalsIgnoreCase("ditolak")) {
      Jmlditolak++;
    }
  }

  static void jmlStatus() {
    for (int j = 0; j < i; j++) {
      JumlahStatus(j);
    }
    System.out.println("Jumlah mahasiswa diterima : " + JmlDiterima);
    System.out.println("Jumlah mahasiswa menunggu : " + Jmlmenunggu);
    System.out.println("Jumlah mahasiswa ditolak  : " + Jmlditolak);
  }

  public static void main(String[] args) {
    do {
      tampilan();
      int a = sc.nextInt();
      sc.nextLine();
      if (a == 5) {
        break;
      } else if (a == 1) {
        data(i);
        i++;
      } else if (a == 2) {
        printSemua();
      } else if (a == 3) {
        cariProdi();
      } else if (a == 4) {
        jmlStatus();
      }
    } while (true);
  }
}
