<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentList</title>
    <link href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap5.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div>
    <a href="?action=create" class="btn btn-success">Thêm mới mặt bằng</a>
</div>
<table id="mainTable" class="table table-bordered">
    <thead>
    <tr>
        <th>Mã MB</th>
        <th>Diện Tích</th>
        <th>Trạng Thái</th>
        <th>Tầng</th>
        <th>Loại văn phòng</th>
        <th>Giá cho thuê</th>
        <th>Ngày bắt đầu</th>
        <th>Ngày kết thúc</th>
        <th>Chức năng</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${not empty listMB}">
            <c:forEach items="${listMB}" var="s" varStatus="status">
                <tr>
                    <td>${s.maMb}</td>
                    <td>${s.dienTich}</td>
                    <td>
                        <c:choose>
                            <c:when test="${s.trThai == 1}">Trống</c:when>
                            <c:when test="${s.trThai == 2}">Hạ Tầng</c:when>
                            <c:otherwise>Đầy Đủ</c:otherwise>
                        </c:choose>
                    </td>
                    <td>${s.tang}</td>
                    <td>
                        <c:choose>
                            <c:when test="${s.loaiVp == 1}">Cho Thuê</c:when>
                            <c:otherwise>Trọn Gói</c:otherwise>
                        </c:choose>
                    </td>
                    <td>${s.giaThue}</td>
                    <td>${s.startDate}</td>
                    <td>${s.endDate}</td>
                    <td>
                        <div>
                            <button type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteModal" data-id="${s.maMb}">Xóa</button>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="10" class="text-center">Ko co</td>
            </tr>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>
<!-- Modal xác nhận action delete -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteModalLabel">Xác nhận xóa</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">X</button>
            </div>
            <div class="modal-body">
                Bạn có chắc chắn muốn Mã Mặt Bằng <span id="studentId"></span> không?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                <a id="confirmDelete" href="#" class="btn btn-danger">Xóa</a>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> <%-- link boot modal xóa --%>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function() {
        $('#mainTable').DataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5,
            "columnDefs": [
                {"orderable": false, "targets":5 }
            ]
        });
    });
</script>
<script>
    $('#deleteModal').on('show.bs.modal', function (event) {
        let button = $(event.relatedTarget); // Nút kích hoạt modal
        let maMb = button.data('id'); // Lấy giá trị ID từ nút
        let modal = $(this);
        let deleteUrl = "?action=delete&sid=" + maMb; // Tạo URL xóa
        modal.find('#studentId').text(maMb); // Cập nhật mã mặt bằng trong modal
        modal.find('#confirmDelete').attr('href', deleteUrl); // Cập nhật liên kết "Xóa" trong modal
    });
</script>

</body>
</html>