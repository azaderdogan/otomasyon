package com.azaderdogan;

import javax.xml.crypto.Data;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Ogrenci ogrenci = new Ogrenci("Azad","Erdoğan","1212","12121212","12,23,34,45","3,4,2,4,5");
        Ogrenci ogrenci2 = new Ogrenci("halime","Akçin","1313","13131313","56,45,56,67","3,4,6,3,2");
        DataSource.getInstance().ogrenciEkle(ogrenci);
        DataSource.getInstance().ogrenciEkle(ogrenci2);
    String isim = "12,23,34,45,56,556" ;
     String [] karakter = isim.split(",");

        for(String not: karakter){
            System.out.println(not);

        }
        Scanner tara = new Scanner(System.in);
        System.out.println("no : ");
        String no = tara.nextLine();
        System.out.println("sifre : ");
        String sifre = tara.nextLine();

        Ogrenci ogrenci1 = (DataSource.getInstance().kayitlimi(no,sifre));
        System.out.println(ogrenci1.toString());


    }


}
