package com.example.coba.gejala.Detection;

/**
 * Created by Owner on 08/05/2018.
 */

public class Pasien {
    String nama;
    int jk;
    int lokasi;
    int karakteristik;
    int skala;
    int durasi;
    int mhBerair;
    int diagnosaKedua;

    public Pasien(String nama, String jk, String lokasi, String karakteristik, String skala, String durasi, String mhBerair, String diagnosaKedua) {
    this.nama = nama;
    this.jk = _convert_jk(jk);
    this.lokasi = _convert_lokasi(lokasi);
    this.karakteristik = _convert_karakteristik(karakteristik);
    this.skala = _convert_skala(skala);
    this.durasi = _convert_durasi(durasi);
    this.mhBerair = _convert_yes_no(mhBerair);
    this.diagnosaKedua = _convert_diagnosaKedua(diagnosaKedua);
    }

    private int _convert_diagnosaKedua(String text){
        switch (text) {
            case  "Migren":
                return 0;
            case "Klaster":
                return 1;
            case "TTH":
                return  2;
            default:
                return -1;
        }
    }

    private int _convert_jk(String text){
        switch (text) {
            case  "P":
                return 0;
            case "L":
                return 1;
            default:
                return -1;
        }
    }

    private int _convert_lokasi(String text){
        switch (text) {
            case  "Unilateral":
                return 0;
            case "Bilateral":
                return 1;
            default:
                return -1;
        }
    }

    private int _convert_karakteristik(String text){
        switch (text) {
            case  "Berdenyut":
                return 0;
            case "Dibor":
                return 1;
            case "Tekan":
                return  2;
            default:
                return -1;
        }
    }

    private int _convert_skala(String text){
        switch (text) {
            case  "Ringan":
                return 0;
            case "Sedang":
                return 1;
            case "Berat":
                return  2;
            default:
                return -1;
        }
    }

    private int _convert_yes_no(String text){
        switch (text) {
            case  "Tidak":
                return 0;
            case "Ya":
                return 1;
            default:
                return -1;
        }
    }

    private int _convert_durasi(String text){
        switch (text) {
            case  "Pendek":
                return 0;
            case "Panjang":
                return 1;
            default:
                return -1;
        }
    }

    public int getJk() {
        return jk;
    }

    public int getLokasi() {
        return lokasi;
    }

    public int getKarakteristik() {
        return karakteristik;
    }

    public int getSkala() {
        return skala;
    }

    public int getDurasi() {
        return durasi;
    }

    public int getMhBerair() {
        return mhBerair;
    }

    public int getDiagnosaKedua() {
        return diagnosaKedua;
    }


}
