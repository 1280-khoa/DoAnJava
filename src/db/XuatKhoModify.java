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
import javax.swing.JOptionPane;
/**
 *
 * @author PC
 */
public class XuatKhoModify {
    static Scanner scan = new Scanner(System.in);
    public static List<XuatKho> connect() {
        List<XuatKho> xuatkhothietbilist  = new ArrayList<>();
        Connection conn = null;
        Statement stm = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoAnJava", "root", "123456a@");
            String mySql = "select * from XuatKhoThietBi";
            stm= conn.createStatement();
            ResultSet rs =  stm.executeQuery(mySql);
            while (rs.next()){
                XuatKho TB = new XuatKho(rs.getString("MaHD"),rs.getString("MaKH"),rs.getString("MaTB"),
                        rs.getString("GiaSanPham"),rs.getString("SoLuong"),rs.getString("TongTien"),rs.getString("NgayXuat"));
                 xuatkhothietbilist.add(TB);
            }
        } catch (SQLException ex) {
            Logger.getLogger(XuatKhoModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(XuatKhoModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(XuatKhoModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return xuatkhothietbilist;
    }
    public static void insertTB(XuatKho TB) {
        Connection conn = null;
         PreparedStatement stm = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoAnJava", "root", "123456a@");
            String mySql = "insert into XuatKhoThietBi(MaHD,MaKH,MaTB,GiaSanPham,SoLuong,TongTien,NgayXuat)values (?,?,?,?,?,?,?)";
            stm = conn.prepareCall(mySql);
            stm.setString(1, TB.getMaHD());
            stm.setString(2, TB.getMaKH());
            stm.setString(3, TB.getMaTB());
            stm.setString(4, TB.getGiaSanPham());
            stm.setString(5, TB.getSoLuong());
            stm.setString(6, TB.getTongTien());
            stm.setString(7, TB.getNgayXuat());
           
            stm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(XuatKhoModify.class.getName()).log(Level.SEVERE, null, ex);
           
        } finally {
            if(stm != null){
                try {
                    stm.close();
                   
                } catch (SQLException ex) {
                    Logger.getLogger(XuatKhoModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(XuatKhoModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
     }
    public static void updateKho( XuatKho TB) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            //B1. Tạo kết nối tới CSDL
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoAnJava", "root", "123456a@");
            
            //B2. Tạo 1 truy vấn tới CSDL
            //B2.1: Viết 1 lệnh sql lấy danh sách sinh viên
            String mysql = "update XuatKhoThietBi set MaKH = ?, MaTB = ?, GiaSanPham =?,SoLuong = ?, TongTien = ?, NgayXuat = ?"
                    + " where MaHD = ?";
            //B2.2: Viết API Java Trúy vấn CSDL
            statement = conn.prepareCall(mysql);
            statement.setString(1, TB.getMaKH());
            statement.setString(2, TB.getMaTB());
            statement.setString(3, TB.getGiaSanPham());
            statement.setString(4, TB.getSoLuong());
            statement.setString(5, TB.getTongTien());
            statement.setString(6, TB.getNgayXuat());
            statement.setString(7, TB.getMaHD());

            //B2.4: Lấy dữ liệu từ CSDL ra
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(XuatKhoModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //B3. Close connection
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(XuatKhoModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(XuatKhoModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //
    }
    public static void deleteHD(String MaHD) {
     
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            //B1. Tạo kết nối tới CSDL
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoAnJava", "root", "123456a@");
            
            
            String sql = "delete from xuatkhothietbi where MaHD = ?";
            
            statement = conn.prepareCall(sql);
            statement.setString(1, MaHD);
           
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(XuatKhoModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //B3. Close connection
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(XuatKhoModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(XuatKhoModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //Finish Show Students
    }
        public static List<XuatKho> FindTB(String MaHD) {
        List<XuatKho> XuatKhoThietBiList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            //
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoAnJava", "root", "123456a@");
            
            //query
            String sql = "select * from XuatKhoThietBi where MaHD like ? ";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+MaHD+"%" );
            
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                XuatKho tb = new XuatKho(resultSet.getString("MaHD"), 
                        resultSet.getString("MaKH"), resultSet.getString("MaTB"),resultSet.getString("GiaSanPham"), 
                        resultSet.getString("SoLuong"), resultSet.getString("TongTien"), 
                        resultSet.getString("NgayXuat"));
                XuatKhoThietBiList.add(tb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(XuatKhoModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(XuatKhoModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(XuatKhoModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return XuatKhoThietBiList;
    }
          public static String updatetien() {
        List<XuatKho> XuatKhoThietBiList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            //
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoAnJava", "root", "123456a@");
            
            //query
            String sql = "select SUM(TongTien) as TongTien from xuatkhothietbi  ";
            statement = connection.prepareCall(sql);
            
            
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                return String.valueOf(resultSet.getFloat("TongTien"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(XuatKhoModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(XuatKhoModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(XuatKhoModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return "";
    } 
      
    
}
