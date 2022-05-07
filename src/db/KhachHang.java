/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class KhachHang {
    String MaKH, TenKH, NamSinh, GioiTinh, DiaChi, Email,SDT;

   

    public KhachHang() {
    }

    public KhachHang(String fullname, String NS, String gender, String DC, String email,String SDT) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(String NamSinh) {
        this.NamSinh = NamSinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    

    public KhachHang(String MaKH, String TenKH, String NamSinh, String GioiTinh, String DiaChi, String Email,String SDT) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.NamSinh = NamSinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.SDT = SDT;
    }

 

    @Override
    public String toString() {
        return "KhachHang{" + "MaKH=" + MaKH + ", TenKH=" + TenKH + ", NamSinh=" + NamSinh + ", GioiTinh=" + GioiTinh + ", DiaChi=" + DiaChi + ", Email=" + Email +",SDT="+SDT+ "}";
    }
    
    public void display() {
        System.out.println(this);
    }
    
    public void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap Ma Khach Hang :");
        MaKH = scan.nextLine();
        System.out.println("Nhap Ho va Ten Khach Hang :");
        TenKH = scan.nextLine();
        System.out.println("Nhap Ngay Sinh (YYYY-MM-DD) :");
        NamSinh = scan.nextLine();
        System.out.println("Nhap Gioi Tinh :");
        GioiTinh = scan.nextLine();
        System.out.println("Nhap Dia Chi : ");
        DiaChi = scan.nextLine();
        System.out.println("Nhap Email :");
        Email = scan.nextLine();
        System.out.println("Nhap SDT");
        SDT = scan.nextLine();
    }
}
