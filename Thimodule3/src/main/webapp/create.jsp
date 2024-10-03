<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mặt bằng</title>
</head>
<body>
<h2>Thêm mặt bằng mới</h2>
<form action="/matbang-servlet?action=create" method="post">
    <label for="maMb">Mã mặt bằng:</label>
    <input type="text" id="maMb" name="maMb"><br>

    <label for="trangThai">Trạng thái:</label>
    <input type="text" id="trangThai" name="trangThai"><br>

    <label for="dienTich">Diện tích:</label>
    <input type="text" id="dienTich" name="dienTich"><br>

    <label for="tang">Tầng:</label>
    <input type="text" id="tang" name="tang"><br>

    <label for="loaiVp">Loại văn phòng:</label>
    <input type="text" id="loaiVp" name="loaiVp"><br>

    <label for="giaThue">Giá thuê:</label>
    <input type="text" id="giaThue" name="giaThue"><br>

    <label for="ngayBatDau">Ngày bắt đầu:</label>
    <input type="date" id="ngayBatDau" name="ngayBatDau"><br>

    <label for="ngayKetThuc">Ngày kết thúc:</label>
    <input type="date" id="ngayKetThuc" name="ngayKetThuc"><br>

    <input type="submit" value="Thêm mặt bằng">
</form>
</body>
</html>
