import java.util.Scanner;

public class csm2 {

    static Scanner sc = new Scanner(System.in);
    static int maks = 100;
    static String[] nama = new String[maks];
    static int[] NIM = new int[maks];
    static String[] prodi = new String[maks];
    static String[] perusahaan = new String[maks];
    static int[] semester = new int[maks];
    static String[] status = new String[maks];
    static int i = 0;

    static int JmlDiterima = 0;
    static int Jmlmenunggu = 0;
    static int Jmlditolak = 0;

    static void tampilan() {
        System.out.println();
        System.out.println("=== Sistem Pendaftaran Magang Mahasiswa ===");
        System.out.println("1. Tambah data magang");
        System.out.println("2. Tampilkan semua pendaftar magang");
        System.out.println("3. Cari pendaftar berdasarkan program study");
        System.out.println("4. Hitung jumlah pendaftar untuk setiap status");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu(1-5): ");
    }

    static void data(int i) {
        System.out.print("Nama mahasiswa: ");
        nama[i] = sc.nextLine();

        System.out.print("NIM: ");
        NIM[i] = sc.nextInt();
        sc.nextLine();

        System.out.print("Prodi: ");
        prodi[i] = sc.nextLine();

        System.out.print("Perusahaan tujuan magang: ");
        perusahaan[i] = sc.nextLine();

        System.out.print("Semester pengambilan magang: ");
        semester[i] = sc.nextInt();
        sc.nextLine();

        System.out.print("Status magang (diterima/menunggu/ditolak): ");
        status[i] = sc.nextLine();

        System.out.println("=================================================");
    }

    static void JumlahStatus(int j) {
        if (status[j].equalsIgnoreCase("diterima")) {
            JmlDiterima++;
        } else if (status[j].equalsIgnoreCase("menunggu")) {
            Jmlmenunggu++;
        } else if (status[j].equalsIgnoreCase("ditolak")) {
            Jmlditolak++;
        }
    }

    static void printSemua() {
        if (i == 0) {
            System.out.println("Belum ada pendaftar");
            return;
        }
        System.out.printf("%-4s %-20s %-13s %-20s %-20s %-10s %-10s%n",
                "No", "Nama", "NIM", "Prodi", "Perusahaan", "Semester", "Status");

        for (int j = 0; j < i; j++) {
            System.out.printf("%-4d %-20s %-13d %-20s %-20s %-10d %-10s%n",
                    (j + 1), nama[j], NIM[j], prodi[j], perusahaan[j], semester[j], status[j]);
        }
    }

    public static void main(String[] args) {
        do {
            tampilan();
            int a = sc.nextInt();
            sc.nextLine();

            if (a == 5) {
                break;
            } 
            else if (a == 1) {
                data(i);
                i++;
            } 
            else if (a == 2) {
                printSemua();
            } 
            else if (a == 3) {
                System.out.print("Masukkan prodi yang dicari: ");
                String cari = sc.nextLine();

                boolean ketemu = false;
                for (int j = 0; j < i; j++) {
                    if (prodi[j].equalsIgnoreCase(cari)) {
                        System.out.println("Nama: " + nama[j]);
                        System.out.println("NIM: " + NIM[j]);
                        System.out.println("Prodi: " + prodi[j]);
                        System.out.println("Perusahaan: " + perusahaan[j]);
                        System.out.println("Semester: " + semester[j]);
                        System.out.println("Status: " + status[j]);
                        System.out.println("-----------------------------------");
                        ketemu = true;
                    }
                }

                if (!ketemu) {
                    System.out.println("Tidak ada mahasiswa dari prodi tersebut.");
                }
            } 
            else if (a == 4) {

               
                JmlDiterima = 0;
                Jmlmenunggu = 0;
                Jmlditolak = 0;

                for (int j = 0; j < i; j++) {
                    JumlahStatus(j);
                }

                System.out.println("Jumlah mahasiswa diterima : " + JmlDiterima);
                System.out.println("Jumlah mahasiswa menunggu : " + Jmlmenunggu);
                System.out.println("Jumlah mahasiswa ditolak  : " + Jmlditolak);
            }

        } while (true);
    }
}
