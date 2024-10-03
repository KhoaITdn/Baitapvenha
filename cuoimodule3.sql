CREATE DATABASE TComplexRentalManagement;

USE TComplexRentalManagement;

-- Bảng thông tin mặt bằng cho thuê
CREATE TABLE MatBang (
    MaMatBang varchar(50) primary key,
    TrangThai int,
    DienTich double,
    Tang int,
    LoaiMatBang int,
    GiaTien double,
    NgayBatDau DATE,
    NgayKetThuc DATE
);

INSERT INTO MatBang (MaMatBang, TrangThai, DienTich, Tang, LoaiMatBang, GiaTien, NgayBatDau, NgayKetThuc) 
VALUES 
('MB-01-01', 1, 55.5, 1, 1, 1500000, '2024-01-01', '2024-07-01'),
('MB-02-01', 2, 40.0, 2, 2, 2000000, '2024-02-01', '2024-08-01');




INSERT INTO MatBang (MaMatBang, TrangThai, DienTich, Tang, LoaiMatBang, GiaTien, NgayBatDau, NgayKetThuc) 
VALUES ('MB-07-01', 1, 65.5, 3, 1, 1700000, '2024-01-10', '?');

DELETE FROM MatBang 
WHERE MaMatBang = 'MB-07-01';





