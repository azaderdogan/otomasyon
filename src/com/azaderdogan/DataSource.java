package com.azaderdogan;

import javax.xml.crypto.Data;
import java.sql.*;

public class DataSource {
    Connection baglanti = null;
    private String url = "jdbc:sqlite:ogrenci.db";
    private static DataSource instance = new DataSource();


    public static DataSource getInstance() {
        return instance;
    }
    private Connection baglan() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            System.out.println(" Bağlandı.");
        } catch (SQLException throwables) {
            System.out.println(" Bağlanmadı.");
            throwables.printStackTrace();
        }
        baglanti = connection;
        return baglanti;
    }

    private void baglantiyiKapat() {
        try {
            if (!baglanti.isClosed()) {
                System.out.println("Bağlantı kapatııldı.");
                baglanti.close();
            } else {
                System.out.println("Zaten kapalı.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void ogrenciEkle(Ogrenci ogrenci) {
        String sql = "INSERT INTO 'ogrenci' ('isim','soyad','numara','sifre') VALUES (?,?,?,?)";
        try (Connection connection = DataSource.getInstance().baglan();
             PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setString(1,ogrenci.getIsim());
            pst.setString(2,ogrenci.getSoyad());
            pst.setString(3,ogrenci.getNo());
            pst.setString(4,ogrenci.getSifre());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Ogrenci kayitlimi(String no,String sifre){

        Ogrenci ogrenci = null;
        String sql = "Select * from ogrenci";
        try (Connection connection = DataSource.getInstance().baglan();
             PreparedStatement pst = connection.prepareStatement(sql);
             ResultSet resultSet = pst.executeQuery();
             ) {

            while (resultSet.next()){
                if (no.equals(resultSet.getString(3)) && sifre.equals(resultSet.getString(4))){
                    System.out.println("Giriş doğrulandı");
                    ogrenci = new Ogrenci();
                    ogrenci.setIsim(resultSet.getString(1));
                    ogrenci.setSoyad(resultSet.getString(2));
                    ogrenci.setNo(no);
                    ogrenci.setSifre(sifre);
                    ogrenci.setNotlar(resultSet.getString(5));

                }else {

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ogrenci;
    }

    public void guncelle(Ogrenci ogrenci){


    }

    public void guncelle(String eskiSifre,String yeniSifre){


    }
}