package ArrayList.src.test;

import java.util.Scanner;
import ArrayList.src.DanhSachSinhVien;
import ArrayList.src.SinhVien;

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachSinhVien dssv = new DanhSachSinhVien();
        int luaChon = 0;
        do {
            System.out.println("Menu----------------");
            System.out.println(
                    "1. Them sinh vien vao danh sach\n" +
                    "2. In danh sach sinh vien ra man hinh\n" +
                    "3. Kiem tra danh sach co rong hay khong\n" +
                    "4. Lay ra so luong sinh vien trong danh sach\n" +
                    "5. Lam rong danh sach sinh vien\n" +
                    "6. Xoa mot sinh vien ra khoi danh sach dua tren ma sinh vien\n" +
                    "7. Kiem tra sinh vien co ton tai trong danh sach hay khong, dua tren ma sinh vien\n" +
                    "8. Tim kiem mot sinh vien dua tren Ten nhap tu ban phim\n" +
                    "9. Xuat ra danh sach sinh vien co diem tu cao den thap\n" +
                    "10. Cap nhat thong tin sinh vien\n" +
                    "0. Thoat khoi chuong trinh");
            luaChon = sc.nextInt();
            sc.nextLine();
            if (luaChon == 1) {
                // 1. Them sinh vien vao danh sach
                System.out.println("Nhap ma sinh vien: ");
                String maSinhVien = sc.nextLine();
                System.out.println("Nhap ho va ten: ");
                String hoVaTen = sc.nextLine();
                System.out.println("Nhap nam sinh: ");
                String namSinh = sc.nextLine();
                System.out.println("Nhap diem trung binh: ");
                String diemTrungBinh = sc.nextLine();
                SinhVien sv = new SinhVien(maSinhVien, hoVaTen, namSinh, diemTrungBinh);
                dssv.themSinhVien(sv);
            } else if (luaChon == 2) {
                // 2. In danh sach sinh vien ra man hinh
                dssv.inDanhSachSinhVien();
            } else if (luaChon == 3) {
                // 3. Kiem tra danh sach co rong hay khong
                System.out.println("Danh sach rong: " + dssv.kiemTraDanhSachRong());
            } else if (luaChon == 4) {
                // 4. Lay ra so luong sinh vien trong danh sach
                System.out.println("So luong sinh vien: " + dssv.laySoLuongSinhVien());
            } else if (luaChon == 5) {
                // 5. Lam rong danh sach sinh vien
                dssv.lamRongDanhSach();
            } else if (luaChon == 6) {
                // 6. Xoa mot sinh vien ra khoi danh sach dua tren ma sinh vien
                System.out.println("Nhap ma sinh vien: ");
                String maSinhVien = sc.nextLine();
                SinhVien sv = new SinhVien(maSinhVien, "", "", "");
                if (dssv.xoaSinhVien(sv)) {
                    System.out.println("Da xoa sinh vien");
                } else {
                    System.out.println("Khong tim thay sinh vien can xoa.");
                }
            } else if (luaChon == 7) {
                // 7. Kiem tra sinh vien co ton tai trong danh sach hay khong, dua tren ma sinh vien
                System.out.println("Nhap ma sinh vien: ");
                String maSinhVien = sc.nextLine();
                SinhVien sv = new SinhVien(maSinhVien, "", "", "");
                System.out.println("Ton tai sinh vien: " + dssv.kiemTraTonTai(sv));
            } else if (luaChon == 8) {
                // 8. Tim kiem mot sinh vien dua tren Ten nhap tu ban phim
                System.out.println("Nhap ten sinh vien: ");
                String ten = sc.nextLine();
                dssv.timSinhVien(ten);
            } else if (luaChon == 9) {
                // 9. Xuat ra danh sach sinh vien co diem tu cao den thap
                dssv.sapXepSinhVienGiamDan();
                dssv.inDanhSachSinhVien();
            } else if (luaChon == 10) {
                // 10. Cap nhat thong tin sinh vien
                System.out.println("Nhap ma sinh vien: ");
                String maSinhVien = sc.nextLine();
                System.out.println("Nhap ho va ten moi: ");
                String hoVaTen = sc.nextLine();
                System.out.println("Nhap nam sinh moi: ");
                String namSinh = sc.nextLine();
                System.out.println("Nhap diem trung binh moi: ");
                String diemTrungBinh = sc.nextLine();
                SinhVien sv = new SinhVien(maSinhVien, hoVaTen, namSinh, diemTrungBinh);
                if (dssv.capNhatSinhVien(sv)) {
                    System.out.println("Da cap nhat thong tin sinh vien");
                } else {
                    System.out.println("Khong tim thay sinh vien can cap nhat.");
                }
            }
        } while (luaChon != 0);
    }
}
