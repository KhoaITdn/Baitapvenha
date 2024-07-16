package ArrayList.src;

import java.util.Objects;

public class SinhVien {
    private String maSinhVien;
    private String hoVaTen;
    private String namSinh;
    private String diemTrungBinh;

    public SinhVien(String maSinhVien, String hoVaTen, String namSinh, String diemTrungBinh) {
        this.maSinhVien = maSinhVien;
        this.hoVaTen = hoVaTen;
        this.namSinh = namSinh;
        this.diemTrungBinh = diemTrungBinh;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(String diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SinhVien sinhVien = (SinhVien) o;
        return Objects.equals(maSinhVien, sinhVien.maSinhVien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSinhVien);
    }

    public String convertToline() {
        return maSinhVien + "," + hoVaTen + "," + namSinh + "," + diemTrungBinh;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSinhVien='" + maSinhVien + '\'' +
                ", hoVaTen='" + hoVaTen + '\'' +
                ", namSinh='" + namSinh + '\'' +
                ", diemTrungBinh='" + diemTrungBinh + '\'' +
                '}';
    }
}
