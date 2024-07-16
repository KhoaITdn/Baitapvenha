// 
package ArrayList.src.iostream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ArrayList.src.SinhVien;

public class BasicDemo {
    public static void main(String[] args) {
        String src = "ArrayList/src/iostream/demo1.txt";
        File file = new File(src);
        List<SinhVien> list = new ArrayList<>();
        SinhVien sinhvien = new SinhVien("1", "Huynh Anh Khoa", "123", "9.9");
        SinhVien sinhvien2 = new SinhVien("2", "Huynh Anh Khoa", "123", "9.9");
        list.add(sinhvien);
        list.add(sinhvien2);
        try (
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)

        ) {
            for (SinhVien s : list) {
                String data = s.convertToline();
                bufferedWriter.write(data);
                bufferedWriter.newLine();
            }
            // String data = sinhvien.getMaSinhVien() + "," + sinhvien.getHoVaTen() + "," +
            // sinhvien.getNamSinh() + ","
            // + sinhvien.getDiemTrungBinh();
            // String data2 = sinhvien2.getMaSinhVien() + "," + sinhvien2.getHoVaTen() + ","
            // + sinhvien2.getNamSinh() + ","
            // + sinhvien2.getDiemTrungBinh();
            // bufferedWriter.write(data);
            // bufferedWriter.newLine();
            // bufferedWriter.write(data2);

            // System.out.println(sinhVien);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
