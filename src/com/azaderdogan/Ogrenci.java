package com.azaderdogan;

public class Ogrenci {
    private String isim;
    private String soyad;
    private String no;
    private String sifre;
    private String notlar ;
    private String devamsizliklar;
public Ogrenci(){}
    public Ogrenci(String isim, String soyad, String no, String sifre,String notlar,String devamsizliklar) {
        this.devamsizliklar = devamsizliklar;
        this.notlar = notlar;
        this.isim = isim;
        this.soyad = soyad;
        this.no = no;
        this.sifre = sifre;
    }

    public String getDevamsizliklar() {

        return devamsizliklar;
    }

    public void setDevamsizliklar(String devamsizliklar) {
        this.devamsizliklar = devamsizliklar;
    }

    public String getNotlar() {
        return notlar;
    }

    public void setNotlar(String notlar) {
        this.notlar = notlar;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "isim='" + isim + '\'' +
                ", soyad='" + soyad + '\'' +
                ", no='" + no + '\'' +
                ", sifre='" + sifre + '\'' +
                ", notlar='" + notlar + '\'' +
                '}';
    }
}
