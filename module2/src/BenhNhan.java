public class BenhNhan {
    private String soThuTuBenhAn;
    private String maBenhAn;
    private String maBenhNhan;
    private String tenBenhNhan;
    private String ngayNhapVien;
    private String ngayRaVien;
    private String lyDoNhapVien;

    public BenhNhan(String soThuTuBenhAn, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien) {
        this.soThuTuBenhAn = soThuTuBenhAn;
        this.maBenhAn = maBenhAn;
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.lyDoNhapVien = lyDoNhapVien;
    }

    // Getters and Setters
    public String getSoThuTuBenhAn() { return soThuTuBenhAn; }
    public void setSoThuTuBenhAn(String soThuTuBenhAn) { this.soThuTuBenhAn = soThuTuBenhAn; }

    public String getMaBenhAn() { return maBenhAn; }
    public void setMaBenhAn(String maBenhAn) { this.maBenhAn = maBenhAn; }

    public String getMaBenhNhan() { return maBenhNhan; }
    public void setMaBenhNhan(String maBenhNhan) { this.maBenhNhan = maBenhNhan; }

    public String getTenBenhNhan() { return tenBenhNhan; }
    public void setTenBenhNhan(String tenBenhNhan) { this.tenBenhNhan = tenBenhNhan; }

    public String getNgayNhapVien() { return ngayNhapVien; }
    public void setNgayNhapVien(String ngayNhapVien) { this.ngayNhapVien = ngayNhapVien; }

    public String getNgayRaVien() { return ngayRaVien; }
    public void setNgayRaVien(String ngayRaVien) { this.ngayRaVien = ngayRaVien; }

    public String getLyDoNhapVien() { return lyDoNhapVien; }
    public void setLyDoNhapVien(String lyDoNhapVien) { this.lyDoNhapVien = lyDoNhapVien; }

    @Override
    public String toString() {
        return "So thu tu benh an: " + soThuTuBenhAn +
               ", Ma benh an: " + maBenhAn +
               ", Ma benh nhan: " + maBenhNhan +
               ", Ten benh nhan: " + tenBenhNhan +
               ", Ngay nhap vien: " + ngayNhapVien +
               ", Ngay ra vien: " + ngayRaVien +
               ", Ly do nhap vien: " + lyDoNhapVien;
    }
}
