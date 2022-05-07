/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class KhachHangModify {
    
    static Scanner scan = new Scanner(System.in);
    public static List<KhachHang> connect() {
        List<KhachHang> khachHangList = new ArrayList<>();
        Connection conn = null;
        Statement stm = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoAnJava", "root", "123456a@");
            String mySql = "select * from KhachHang";
            stm= conn.createStatement();
            ResultSet rs =  stm.executeQuery(mySql);
            while (rs.next()){
                KhachHang KH = new KhachHang(rs.getString("MaKH"),rs.getString("TenKH"),rs.getString("NamSinh"),
                        rs.getString("GioiTinh"),rs.getString("DiaChi"),rs.getString("Email"),rs.getString("SDT"));
                 khachHangList.add(KH);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return khachHangList;
    }
   public static void insertKH(KhachHang KH) {
        Connection conn = null;
         PreparedStatement stm = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoAnJava", "root", "123456a@");
            String mySql = "insert into KhachHang(MaKH,TenKH,NamSinh,GioiTinh,DiaChi,Email,SDT)values (?,?,?,?,?,?,?)";
            stm = conn.prepareCall(mySql);
            stm.setString(1, KH.getMaKH());
            stm.setString(2, KH.getTenKH());
            stm.setString(3, KH.getNamSinh());
            stm.setString(4, KH.getGioiTinh());
            stm.setString(5, KH.getDiaChi());
            stm.setString(6, KH.getEmail());
            stm.setString(7, KH.getSDT());
            stm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    
    }
   public static void updateKH( KhachHang KH) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            //B1. Tạo kết nối tới CSDL
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoAnJava", "root", "123456a@");
            
            //B2. Tạo 1 truy vấn tới CSDL
            //B2.1: Viết 1 lệnh sql lấy danh sách sinh viên
            String mysql = "update KhachHang set TenKH = ?, NamSinh = ?, GioiTinh = ?, DiaChi = ?, Email = ?,SDT=?"
                    + " where MaKH = ?";
            //B2.2: Viết API Java Trúy vấn CSDL
            statement = conn.prepareCall(mysql);
            statement.setString(1, KH.getTenKH());
            statement.setString(2, KH.getNamSinh());
            statement.setString(3, KH.getGioiTinh());
            statement.setString(4, KH.getDiaChi());
            statement.setString(5, KH.getEmail());
            statement.setString(6, KH.getSDT());
            statement.setString(7, KH.getMaKH());
            //B2.4: Lấy dữ liệu từ CSDL ra
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //B3. Close connection
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //Finish Show Students
    }
   public static void deleteKH(String MaKH) {
     
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            //B1. Tạo kết nối tới CSDL
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoAnJava", "root", "123456a@");
            
            
            String sql = "delete from KhachHang where MaKH = ?";
            
            statement = conn.prepareCall(sql);
            statement.setString(1, MaKH);
           
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //B3. Close connection
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //Finish Show Students
    }

    public static List<KhachHang> FindKH(String TenKH) {
        List<KhachHang> KhachHangList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoAnJava", "root", "123456a@");
            
            //query
            String sql = "select * from KhachHang where TenKH like ? ";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+TenKH+"%" );
            
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                KhachHang std = new KhachHang(resultSet.getString("MaKH"), 
                        resultSet.getString("TenKH"), resultSet.getString("NamSinh"), 
                        resultSet.getString("GioiTinh"), resultSet.getString("DiaChi"), 
                        resultSet.getString("Email"),resultSet.getString("SDT"));
                KhachHangList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return KhachHangList;
    }

    
    public static void insert(KhachHang KH) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
