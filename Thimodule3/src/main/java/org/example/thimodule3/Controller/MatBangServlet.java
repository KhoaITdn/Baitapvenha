package org.example.thimodule3.Controller;


import org.example.thimodule3.Model.MatBang;
import org.example.thimodule3.Service.IMatBangService;
import org.example.thimodule3.Service.MatBangServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static java.util.Date.*;
import static javax.xml.bind.DatatypeConverter.parseDate;

@WebServlet(name = "StudentServlet", value = "")

public class MatBangServlet extends HttpServlet {
    IMatBangService iMatBangService = new MatBangServiceImpl();

    public MatBangServlet() throws SQLException, ClassNotFoundException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addMatBang(request,response);
                break;
//
            case "delete":
                deleteMatBang(request, response);
                break;
            default:
                findAll(request,response);
        }

    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            case "create":
                addMatBang(request,response);
                break;
            default:
                findAll(request,response);
        }
    }


    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MatBang> list = iMatBangService.findAll();
        request.setAttribute("listCr", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(request, response);
    }


    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listMB", iMatBangService.findAll());
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    private void addMatBang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String maMb = request.getParameter("maMb");
            int trangThai = Integer.parseInt(request.getParameter("trangThai"));
            double dienTich = Double.parseDouble(request.getParameter("dienTich"));
            int tang = Integer.parseInt(request.getParameter("tang"));
            int loaiVp = Integer.parseInt(request.getParameter("loaiVp"));
            double giaThue = Double.parseDouble(request.getParameter("giaThue"));
            Date ngayBatDau = parseDate(request.getParameter("ngayBatDau")).getTime();
            Date ngayKetThuc = parseDate(request.getParameter("ngayKetThuc")).getTime();

            MatBang matBang = new MatBang(maMb, dienTich, trangThai, tang, loaiVp, giaThue, (java.sql.Date) ngayBatDau, (java.sql.Date) ngayKetThuc);
            iMatBangService.addMatBang(matBang);
            response.sendRedirect("/matbang-servlet");
        } catch (Exception e) {
            // Xử lý ngoại lệ và hiển thị thông báo lỗi cho người dùng
            e.printStackTrace();
            response.sendRedirect("/matbang-servlet?action=create&error=true");
        }
    }
    private void deleteMatBang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maMb = request.getParameter("sid");
        iMatBangService.deleteMatBang(maMb);
        response.sendRedirect("/");
    }

}