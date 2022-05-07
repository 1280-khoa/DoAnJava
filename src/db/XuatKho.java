/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 *
 * @author PC
 */
public class XuatKho {
    String MaHD,MaKH,MaTB,GiaSanPham,SoLuong,TongTien ,NgayXuat;

    

    public String getMaHD() {
        return MaHD;
    }

    public String getGiaSanPham() {
        return GiaSanPham;
    }

    public void setGiaSanPham(String GiaSanPham) {
        this.GiaSanPham = GiaSanPham;
    }

    public XuatKho(String MaHD, String MaKH, String MaTB, String GiaSanPham, String SoLuong, String TongTien, String NgayXuat) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.MaTB = MaTB;
        this.GiaSanPham = GiaSanPham;
        this.SoLuong = SoLuong;
        this.TongTien = TongTien;
        this.NgayXuat = NgayXuat;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaTB() {
        return MaTB;
    }

    public void setMaTB(String MaTB) {
        this.MaTB = MaTB;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getTongTien() {
        return TongTien;
    }

    public void setTongTien(String TongTien) {
        this.TongTien = TongTien;
    }

    public String getNgayXuat() {
        return NgayXuat;
    }

    public void setNgayXuat(String NgayXuat) {
        this.NgayXuat = NgayXuat;
    }

    public XuatKho(String MaHD, String MaKH, String MaTB, String SoLuong, String TongTien, String NgayXuat) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.MaTB = MaTB;
        this.SoLuong = SoLuong;
        this.TongTien = TongTien;
        this.NgayXuat = NgayXuat;
    }

    public XuatKho() {
    }
}
