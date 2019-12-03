package com.uniyaz.rehber;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App 
{
  
    	static ArrayList<Kisi> rehber = new ArrayList<Kisi>();
    	
        public static void main(String[] args) {
    	// write your code here
     
            boolean cikis=false;
            Scanner tara =new Scanner(System.in);
            byte secim=-1;
            while (!cikis) {
                System.out.println("----- REHBER ------");
                System.out.println("0 - Yeni Kayıt Ekle \n1 - Kişi Güncelle \n2 - Kişi Ara \n3 - Kişi Sil \n4 - Listele\n5 - Çıkış");
                System.out.println(" \n Bir Seçenek Seçiniz : ");
                secim=tara.nextByte();
     
                switch (secim){
                    case 0:
                        yeniKayitEkle();
                        break;
                    case 1:
                        kisiGuncelle();
                        break;
                    case 2:
                        kisiAra();
                        break;
                    case 3:
                        kisiSil();
                        break;
                    case 4:
                        listele(rehber);
                        break;
                    default:
                        break;
     
                }
     
            }
     
        }
     
        private static void listele(ArrayList<Kisi> rehber)  {
     
            Iterator<Kisi> kisiIterator=rehber.listIterator();
            int sayac=-1;
            boolean firstTime=true;
            if(rehber.size()>0) {
                while (kisiIterator.hasNext()) {
                    sayac++;
                    Kisi kisi = kisiIterator.next();
     
                    if (firstTime) {
                        // Sadece Ekranın En Üst kısmına başlık olarak yazalım
                        System.out.println();
                        System.out.println(" \t\t\t\t TÜM KAYITLAR  \t\t\t\t");
                        System.out.println("\t\t ID \t\t ADI \t\t SOYAD \t\t\t NUMARA \t\t  ");
                        System.out.println("---------------------------------------------------------------");
                        System.out.println();
                        firstTime = false;
                    }
                    System.out.println("\t" +sayac + "\t\t" + kisi.getAd() +"\t\t" + kisi.getSoyad() + "\t\t\t" + kisi.getNumara());
     
     
                }
                System.out.println();
                System.out.println("Toplamda "+ rehber.size()+" Kayıt Listelendi !");
                
            }
            else
            {
                System.out.println("Listelenecek Herhangi bir Kayıt Bulunamadı");
            }
        }
     
        
     
   
        private static void kisiSil() {
            Scanner scanner=new Scanner(System.in);
            listele(rehber);
            System.out.println();
            System.out.println("Silinecek Kişinin sıra No 'sunu gir");
            byte secim=scanner.nextByte();
            for(Kisi kisi:rehber) {
            	rehber.remove(secim);
            }
            
            listele(rehber);
        }
     
        private static void kisiGuncelle() {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Lütfen Güncellemek İstediğiniz Kaydın sıra numarasını giriniz");
            int indexNo=scanner.nextByte();
            Kisi kisi=rehber.get(indexNo);
     
            System.out.println("----------  KAYIT GÜNCELLEME ------------");
            System.out.println("Lütfen Yeni İsim Bilgisi Girin");
            kisi.setAd(scanner.next());
            System.out.println("Lütfen Yeni soyad Bilgisi Girin");
            kisi.setSoyad(scanner.next());
            System.out.println("Lütfen Yeni Numara Bilgisi Girin");
            kisi.setNumara(scanner.next());
            listele(rehber);
        }
     
        private static void kisiAra() {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Aranacak Kelimeyi Söyleyin");
            String arancakKelime=scanner.next();
            Iterator<Kisi> kisiIterator=rehber.listIterator();
            ArrayList<Kisi> sonuclar=new ArrayList<Kisi>();
            while (kisiIterator.hasNext()){
     
                Kisi kisi=kisiIterator.next();
                if(kisi.getAd().contains(arancakKelime)){
                    sonuclar.add(kisi);
                }
            }
            listele(sonuclar);
     
        }
     
        private static void yeniKayitEkle() {
     
            Kisi kisi=new Kisi();
            Scanner scan=new Scanner(System.in);
            System.out.println("Yeni Kişini Adı : ");kisi.setAd(scan.nextLine());
            System.out.println("Yeni Kişini soyadı : ");kisi.setSoyad(scan.nextLine());
            System.out.println("Yeni Kişinin Telefonu : "); kisi.setNumara(scan.nextLine());
            if(rehber.add(kisi)){
                System.out.println("Rehbere Başarı 1 kayıt Eklendi");
            }
     
        }
    
    }

