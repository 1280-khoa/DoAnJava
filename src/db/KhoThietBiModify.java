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
public class KhoThietBiModify {
    static Scanner scan = new Scanner(System.in);
    public static List<KhoThietBi> connect() {
        List<KhoThietBi> khothietbilist  = new ArrayList<>();
        Connection conn = null;
        Statement stm = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoAnJava", "root", "123456a@");
            String mySql = "select * from NhapKhoThietBi";
            stm= conn.createStatement();
            ResultSet rs =  stm.executeQuery(mySql);
            while (rs.next()){
                KhoThietBi TB = new KhoThietBi(rs.getString("MaTB"),rs.getString("TenTB"),rs.getString("GiaMua"),
                        rs.getString("GiaBan"),rs.getString("SoLuong"),rs.getString("NgaySanXuat"),rs.getString("NgayNhap"),rs.getString("NhaCungCap"),rs.getString("TongTien"));
                 khothietbilist.add(TB);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return khothietbilist;
    }
     public static void insertTB(KhoThietBi TB) {
        Connection conn = null;
         PreparedStatement stm = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoAnJava", "root", "123456a@");
            String mySql = "insert into NhapKhoThietBi(MaTB,TenTB,GiaMua,GiaBan,SoLuong,NgaySanXuat,NgayNhap,NhaCungCap,TongTien)values (?,?,?,?,?,?,?,?,?)";
            stm = conn.prepareCall(mySql);
            stm.setString(1, TB.getMaTB());
            stm.setString(2, TB.getTenTB());
            stm.setString(3, TB.getGiaMua());
            stm.setString(4, TB.getGiaBan());
            stm.setString(5, TB.getSoLuong());
            stm.setString(6, TB.getNgaySanXuat());
            stm.setString(7, TB.getNgayNhap());
            stm.setString(8, TB.getNhaCungCap());
            stm.setString(9, TB.getTongtien());
            stm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
     }
        public static void updateKho( KhoThietBi TB) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            //B1. Tạo kết nối tới CSDL
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoAnJava", "root", "123456a@");
            
            //B2. Tạo 1 truy vấn tới CSDL
            //B2.1: Viết 1 lệnh sql lấy danh sách sinh viên
            String mysql = "update NhapKhoThietBi set TenTB = ?, GiaMua = ?, GiaBan = ?, SoLuong = ?, NgaySanXuat = ?,NgayNhap=?,NhaCungCap=?,TongTien=?"
                    + " where MaTB = ?";
            //B2.2: Viết API Java Trúy vấn CSDL
            statement = conn.prepareCall(mysql);
            statement.setString(1, TB.getTenTB());
            statement.setString(2, TB.getGiaMua());
            statement.setString(3, TB.getGiaMua());
            statement.setString(4, TB.getSoLuong());
            statement.setString(5, TB.getNgaySanXuat());
            statement.setString(6, TB.getNgayNhap());
            statement.setString(7, TB.getNhaCungCap());
            statement.setString(8, TB.getTongtien());
            statement.setString(9, TB.getMaTB());

            //B2.4: Lấy dữ liệu từ CSDL ra
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //B3. Close connection
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //Finish Show Students
    }
       public static void deleteTB(String MaTB) {
     
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            //B1. Tạo kết nối tới CSDL
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoAnJava", "root", "123456a@");
            
            
            String sql = "delete from nhapkhothietbi where MaTB = ?";
            
            statement = conn.prepareCall(sql);
            statement.setString(1, MaTB);
           
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //B3. Close connection
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //Finish Show Students
    }
        public static List<KhoThietBi> FindTB(String TenTB) {
        List<KhoThietBi> KhoThietBiList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoAnJava", "root", "123456a@");
            
            //query
            String sql = "select * from NhapKhoThietBi where TenTB like ? ";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+TenTB+"%" );
            
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                KhoThietBi tb = new KhoThietBi(resultSet.getString("MaTB"), 
                        resultSet.getString("TenTB"), resultSet.getString("GiaMua"), 
                        resultSet.getString("GiaBan"), resultSet.getString("SoLuong"), 
                        resultSet.getString("NgaySanXuat"),resultSet.getString("NgayNhap"),resultSet.getString("NhaCungCap"),resultSet.getString("TongTien"));
                KhoThietBiList.add(tb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return KhoThietBiList;
    }
    
    public static List<KhoThietBi> kiemke() {
        List<KhoThietBi> khothietbilist  = new ArrayList<>();
        Connection conn = null;
        Statement stm = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoAnJava", "root", "123456a@");
            String mySql = "select * from NhapKhoThietBi where SoLuong = 0";
            stm= conn.createStatement();
            ResultSet rs =  stm.executeQuery(mySql);
            while (rs.next()){
                KhoThietBi TB = new KhoThietBi(rs.getString("MaTB"),rs.getString("TenTB"),rs.getString("GiaMua"),
                        rs.getString("GiaBan"),rs.getString("SoLuong"),rs.getString("NgaySanXuat"),rs.getString("NgayNhap"),rs.getString("NhaCungCap"),rs.getString("TongTien"));
                 khothietbilist.add(TB);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return khothietbilist;
    }
    public static List<KhoThietBi> kiemke2() {
        List<KhoThietBi> khothietbilist  = new ArrayList<>();
        Connection conn = null;
        Statement stm = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoAnJava", "root", "123456a@");
            String mySql = "select * from NhapKhoThietBi where SoLuong != 0";
            stm= conn.createStatement();
            ResultSet rs =  stm.executeQuery(mySql);
            while (rs.next()){
                KhoThietBi TB = new KhoThietBi(rs.getString("MaTB"),rs.getString("TenTB"),rs.getString("GiaMua"),
                        rs.getString("GiaBan"),rs.getString("SoLuong"),rs.getString("NgaySanXuat"),rs.getString("NgayNhap"),rs.getString("NhaCungCap"),rs.getString("TongTien"));
                 khothietbilist.add(TB);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoThietBiModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return khothietbilist;
    }
    public static String updatetien() {
        List<KhoThietBi> KhoThietBiList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            //
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoAnJava", "root", "123456a@");
            
            //query
            String sql = "select SUM(TongTien) as TongTien from nhapkhothietbi  ";
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
