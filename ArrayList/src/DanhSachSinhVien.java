package ArrayList.src;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSinhVien {
    private ArrayList<SinhVien> danhSach;

    public DanhSachSinhVien() {
        this.danhSach = new ArrayList<SinhVien>();
    }

    public DanhSachSinhVien(ArrayList<SinhVien> danhSach) {
        this.danhSach = danhSach;
    }

    // 1. Thêm sinh viên vào danh sách
    public void themSinhVien(SinhVien sv) {
        this.danhSach.add(sv);
        ghiDanhSachVaoFile("ArrayList/src/iostream/demo1.txt");
    }

    // 2. In danh sách sinh viên ra màn hình
    public void inDanhSachSinhVien() {
        for (SinhVien sinhVien : danhSach) {
            System.out.println(sinhVien);
        }
    }

    // 3. Kiểm tra danh sách sinh viên có rỗng hay không
    public boolean kiemTraDanhSachRong() {
        return this.danhSach.isEmpty();
    }

    // 4. Lấy ra số lượng sinh viên trong danh sách
    public int laySoLuongSinhVien() {
        return this.danhSach.size();
    }

    // 5. Làm rỗng danh sách sinh viên
    public void lamRongDanhSach() {
        this.danhSach.clear();
        ghiDanhSachVaoFile("ArrayList/src/iostream/demo1.txt");
    }

    // 6. Kiểm tra sinh viên có tồn tại trong danh sách hay không dựa trên mã sinh
    // viên
    public boolean kiemTraTonTai(SinhVien sv) {
        return this.danhSach.contains(sv);
    }

    // 7. Xóa sinh viên dựa trên mã sinh viên
    public boolean xoaSinhVien(SinhVien sv) {
        boolean isRemoved = this.danhSach.remove(sv);
        if (isRemoved) {
            ghiDanhSachVaoFile("ArrayList/src/iostream/demo1.txt"); // Cập nhật file sau khi xóa
        }
        return isRemoved;
    }

    // 8. Tìm kiếm sinh viên dựa trên tên nhập từ bàn phím
    public void timSinhVien(String ten) {
        for (SinhVien sinhVien : danhSach) {
            if (sinhVien.getHoVaTen().contains(ten)) {
                System.out.println(sinhVien);
            }
        }
    }

    // 9. Sắp xếp sinh viên theo điểm từ cao đến thấp
    public void sapXepSinhVienGiamDan() {
        Collections.sort(danhSach, new Comparator<SinhVien>() {
            public int compare(SinhVien sv1, SinhVien sv2) {
                return Float.compare(Float.parseFloat(sv2.getDiemTrungBinh()),
                        Float.parseFloat(sv1.getDiemTrungBinh()));
            }
        });
    }

    // Cập nhật thông tin sinh viên
    public boolean capNhatSinhVien(SinhVien sv) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaSinhVien().equals(sv.getMaSinhVien())) {
                danhSach.set(i, sv);
                ghiDanhSachVaoFile("ArrayList/src/iostream/demo1.txt");
                return true;
            }
        }
        return false;
    }

    // Ghi danh sách sinh viên vào file
    public void ghiDanhSachVaoFile(String src) {
        try (FileWriter fileWriter = new FileWriter(new File(src));
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (SinhVien sv : danhSach) {
                bufferedWriter.write(sv.convertToline());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
