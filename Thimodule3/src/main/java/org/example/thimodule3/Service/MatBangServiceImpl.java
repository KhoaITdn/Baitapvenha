package org.example.thimodule3.Service;




import org.example.thimodule3.Model.MatBang;
import org.example.thimodule3.Repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatBangServiceImpl implements IMatBangService {
    private final BaseRepository baseRepository = new BaseRepository();
    public MatBangServiceImpl() throws SQLException, ClassNotFoundException {
    }
    private static final String FIND_ALL = "SELECT * FROM MatBang;";
    private static final String DELETE_MB = "DELETE FROM MatBang WHERE MaMatBang = ?";
    private static final String INSERT_MB ="INSERT INTO MatBang (MaMatBang, TrangThai, DienTich, Tang, LoaiMatBang, GiaTien, NgayBatDau, NgayKetThuc)" +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public List<MatBang> findAll() {
        Connection connection = baseRepository.getConnection();
        List<MatBang> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String maMb = resultSet.getString("MaMatBang");
                int trThai = resultSet.getInt("TrangThai");
                double dienTich = resultSet.getDouble("DienTich");
                int tang = resultSet.getInt("Tang");
                int loaiVp = resultSet.getInt("LoaiMatBang");
                double giaThue = resultSet.getDouble("GiaTien");
                Date startDate = resultSet.getDate("NgayBatDau");
                Date endDate = resultSet.getDate("NgayKetThuc");
                list.add(new MatBang(maMb,dienTich,trThai,tang,loaiVp,giaThue,startDate,endDate));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void deleteMatBang(String maMb) {
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_MB);
            ps.setString(1, maMb);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addMatBang(MatBang matBang) {
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_MB);
            ps.setString(1, matBang.getMaMb());
            ps.setInt(2, matBang.getTrThai());
            ps.setDouble(3, matBang.getDienTich());
            ps.setInt(4, matBang.getTang());
            ps.setInt(5, matBang.getLoaiVp());
            ps.setDouble(6, matBang.getGiaThue());
            ps.setDate(7, new java.sql.Date(matBang.getStartDate().getTime()));
            ps.setDate(8, new java.sql.Date(matBang.getEndDate().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public boolean getMatBangByMaMb(String maMb) {
        return false;
    }


}
