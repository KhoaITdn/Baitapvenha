import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DanhSachBenhNhan {
    private ArrayList<BenhNhan> danhSach;

    public DanhSachBenhNhan() {
        this.danhSach = new ArrayList<BenhNhan>();
    }

    public DanhSachBenhNhan(ArrayList<BenhNhan> danhSach) {
        this.danhSach = danhSach;
    }

    public void themBenhNhan(BenhNhan bn) {
        this.danhSach.add(bn);
        ghiDanhSachVaoFile("Ket Thuc Module2/module2/src/file.csv");
    }

    public void inDanhSachBenhNhan() {
        for (BenhNhan benhNhan : danhSach) {
            System.out.println(benhNhan);
        }
    }

    public boolean xoaBenhNhan(BenhNhan bn) {
        boolean isRemoved = this.danhSach.remove(bn);
        if (isRemoved) {
            ghiDanhSachVaoFile("Ket Thuc Module2/module2/src/file.csv");
        }
        return isRemoved;
    }

    public boolean capNhatBenhNhan(BenhNhan bn) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaBenhAn().equals(bn.getMaBenhAn())) {
                danhSach.set(i, bn);
                ghiDanhSachVaoFile("Ket Thuc Module2/module2/src/file.csv");
                return true;
            }
        }
        return false;
    }

    public void ghiDanhSachVaoFile(String src) {
        File file = new File(src);
        // Tạo thư mục nếu chưa tồn tại
        file.getParentFile().mkdirs();

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (BenhNhan bn : danhSach) {
                bufferedWriter.write(bn.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }

    public BenhNhan timBenhNhanTheoMa(String maBenhAn) {
        for (BenhNhan bn : danhSach) {
            if (bn.getMaBenhAn().equals(maBenhAn)) {
                return bn;
            }
        }
        return null;
    }
}
