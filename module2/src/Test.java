import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachBenhNhan dsbn = new DanhSachBenhNhan();
        int luaChon;

        // Định dạng ngày
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // Đặt chế độ không khoan dung với định dạng ngày

        do {
            System.out.println("Menu----------------");
            System.out.println(
                    "Chon chuc nang theo so " +
                            "1. Them benh nhan vao danh sach\n" +
                            "2. In danh sach benh nhan ra man hinh\n" +
                            "3. Xoa mot benh nhan khoi danh sach dua tren ma benh an\n" +
                            "4. Cap nhat thong tin benh nhan\n" +
                            "5. Chinh sua thong tin benh nhan\n" +
                            "0. Thoat khoi chuong trinh");
            luaChon = sc.nextInt();
            sc.nextLine();

            if (luaChon == 1) {
                // 1. Them benh nhan vao danh sach
                String soThuTuBenhAn;
                do {
                    System.out.println("Nhap so thu tu benh an (chi bao gom cac so): ");
                    soThuTuBenhAn = sc.nextLine();
                    if (!soThuTuBenhAn.matches("\\d+")) {
                        System.out.println("So thu tu benh an khong hop le. Vui long nhap lai.");
                    }
                } while (!soThuTuBenhAn.matches("\\d+"));

                String maBenhAn;
                do {
                    System.out.println("Nhap ma benh an (phai co dinh dang BA-XXX): ");
                    maBenhAn = sc.nextLine();
                    if (!maBenhAn.matches("BA-\\d{3}")) {
                        System.out.println("Ma benh an khong hop le. Vui long nhap lai.");
                    }
                } while (!maBenhAn.matches("BA-\\d{3}"));

                String maBenhNhan;
                do {
                    System.out.println("Nhap ma benh nhan (phai co dinh dang BN-XXX): ");
                    maBenhNhan = sc.nextLine();
                    if (!maBenhNhan.matches("BN-\\d{3}")) {
                        System.out.println("Ma benh nhan khong hop le. Vui long nhap lai.");
                    }
                } while (!maBenhNhan.matches("BN-\\d{3}"));

                String tenBenhNhan;
                do {
                    System.out.println("Nhap ten benh nhan (chi bao gom chu cai): ");
                    tenBenhNhan = sc.nextLine();
                    if (!tenBenhNhan.matches("[a-zA-Z\\s]+")) {
                        System.out.println("Ten benh nhan khong hop le. Vui long nhap lai.");
                    }
                } while (!tenBenhNhan.matches("[a-zA-Z\\s]+"));

                Date ngayNhapVien = null;
                Date ngayRaVien = null;
                boolean validDate = false;

                while (!validDate) {
                    try {
                        System.out.println("Nhap ngay nhap vien (dinh dang dd/MM/yyyy): ");
                        ngayNhapVien = dateFormat.parse(sc.nextLine());
                        System.out.println("Nhap ngay ra vien (dinh dang dd/MM/yyyy): ");
                        ngayRaVien = dateFormat.parse(sc.nextLine());

                        if (ngayNhapVien.after(ngayRaVien)) {
                            System.out.println("Ngay nhap vien phai nho hon ngay ra vien. Vui long nhap lai.");
                        } else {
                            validDate = true;
                        }
                    } catch (ParseException e) {
                        System.out.println("Dinh dang ngay khong hop le. Vui long nhap lai.");
                    }
                }

                String lyDoNhapVien;
                System.out.println("Nhap ly do nhap vien: ");
                lyDoNhapVien = sc.nextLine();

                BenhNhan bn = new BenhNhan(soThuTuBenhAn, maBenhAn, maBenhNhan, tenBenhNhan,
                        dateFormat.format(ngayNhapVien), dateFormat.format(ngayRaVien), lyDoNhapVien);
                dsbn.themBenhNhan(bn);
            } else if (luaChon == 2) {
                // 2. In danh sach benh nhan ra man hinh
                dsbn.inDanhSachBenhNhan();
            } else if (luaChon == 3) {
                // 3. Xoa mot benh nhan khoi danh sach dua tren ma benh an
                System.out.println("Nhap ma benh an: ");
                String maBenhAn = sc.nextLine();
                BenhNhan bn = new BenhNhan("", maBenhAn, "", "", "", "", "");
                if (dsbn.xoaBenhNhan(bn)) {
                    System.out.println("Da xoa benh nhan");
                } else {
                    System.out.println("Khong tim thay benh nhan can xoa.");
                }
            } else if (luaChon == 4) {
                // 4. Cap nhat thong tin benh nhan
                System.out.println("Nhap ma benh an: ");
                String maBenhAn = sc.nextLine();
                System.out.println("Nhap ten benh nhan moi: ");
                String tenBenhNhan = sc.nextLine();
                System.out.println("Nhap ngay nhap vien moi (dinh dang dd/MM/yyyy): ");
                String ngayNhapVien = sc.nextLine();
                System.out.println("Nhap ngay ra vien moi (dinh dang dd/MM/yyyy): ");
                String ngayRaVien = sc.nextLine();
                System.out.println("Nhap ly do nhap vien moi: ");
                String lyDoNhapVien = sc.nextLine();
                BenhNhan bn = new BenhNhan("", maBenhAn, "", tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
                if (dsbn.capNhatBenhNhan(bn)) {
                    System.out.println("Da cap nhat thong tin benh nhan");
                } else {
                    System.out.println("Khong tim thay benh nhan can cap nhat.");
                }
            } else if (luaChon == 5) {
                // 5. Chinh sua thong tin benh nhan
                System.out.println("Nhap ma benh an can chinh sua: ");
                String maBenhAn = sc.nextLine();
                BenhNhan bn = dsbn.timBenhNhanTheoMa(maBenhAn);
                if (bn != null) {
                    System.out.println("Thong tin hien tai cua benh nhan: " + bn);
                    String tenBenhNhan;
                    do {
                        System.out.println("Nhap ten benh nhan moi (chi bao gom chu cai): ");
                        tenBenhNhan = sc.nextLine();
                        if (!tenBenhNhan.matches("[a-zA-Z\\s]+")) {
                            System.out.println("Ten benh nhan khong hop le. Vui long nhap lai.");
                        }
                    } while (!tenBenhNhan.matches("[a-zA-Z\\s]+"));

                    String ngayNhapVien;
                    System.out.println("Nhap ngay nhap vien moi (dinh dang dd/MM/yyyy): ");
                    ngayNhapVien = sc.nextLine();

                    String ngayRaVien;
                    System.out.println("Nhap ngay ra vien moi (dinh dang dd/MM/yyyy): ");
                    ngayRaVien = sc.nextLine();

                    String lyDoNhapVien;
                    System.out.println("Nhap ly do nhap vien moi: ");
                    lyDoNhapVien = sc.nextLine();

                    bn.setTenBenhNhan(tenBenhNhan);
                    bn.setNgayNhapVien(ngayNhapVien);
                    bn.setNgayRaVien(ngayRaVien);
                    bn.setLyDoNhapVien(lyDoNhapVien);
                    dsbn.capNhatBenhNhan(bn);
                    System.out.println("Da chinh sua thong tin benh nhan: " + bn);
                } else {
                    System.out.println("Khong tim thay benh nhan voi ma benh an: " + maBenhAn);
                }
            }
        } while (luaChon != 0);
        sc.close();
    }
}
