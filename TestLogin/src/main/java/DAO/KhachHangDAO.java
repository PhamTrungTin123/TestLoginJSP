package DAO;

import java.sql.ResultSet;

import Model.KhachHang;
import Model.MyConnectDB;

public class KhachHangDAO implements ObjectDAO {

    private MyConnectDB connectDB;

    public KhachHangDAO() {
        connectDB = new MyConnectDB();
    }

    @Override
    public boolean themTaiKhoan(Object obj) {
        KhachHang kh = (KhachHang) obj;
        try {
            connectDB.thucThiSQL("insert into DANGNHAP values('" + kh.getUserName() + "','" + kh.getPassWord() + "','" + kh.getName() + "')");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public KhachHang layThongTinTaiKhoan(String username) {
        try {
            ResultSet rs = connectDB.chonDuLieu("select * from DANGNHAP where UserName='" + username + "'");
            while (rs.next()) {
                String user = rs.getString(1);
                String pass = rs.getString(2);
                String name = rs.getString(3);
                return new KhachHang(user, pass, name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean kiemTraDangNhap(String username, String pass) {
        try {
            ResultSet rs = connectDB.chonDuLieu("select * from DANGNHAP where UserName='" + username + "' and PassWord='" + pass + "'");
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        KhachHang kh = new KhachHang("lephong", "abcd", "Phong");
        KhachHangDAO khachHangDAO = new KhachHangDAO();
        System.out.println(khachHangDAO.themTaiKhoan(kh));
        System.out.println(khachHangDAO.kiemTraDangNhap("lephong", "abcd"));
    }
}
